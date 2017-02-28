$(function() {
    $.validator.addMethod("username", function(value, element) {
        var uname = /^[a-zA-Z0-9_]{5,45}$/;
        return this.optional(element) || (uname.test(value));
    }, "");
    $.validator.addMethod("userpwd", function(value, element) {
        var upwd = /^[\A-Za-z0-9\!\#\$\%\^\&\*\.\~]{5,32}$/;
        return this.optional(element) || (upwd.test(value));
    }, "");
    $.validator.addMethod("mobile", function(value, element) {
        var length = value.length;
        var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;
        return this.optional(element) || (length == 11 && mobile.test(value));
    }, "");

    // 登录表单验证
    $('#loginform').validate({
        event: 'keyup',
        rules: {
            user: { required: true, username: true },
            pwd: { required: true },
            code: { required: true }
        },
        messages: {
            user: { required: '用户名必填。', username: '用户名长度须为5-45，只可包括以下字符: 大写字母、小写字母、数字和下划线。' },
            pwd: { required: '密码必填。' },
            code: { required: '验证码必填。' }
        },
        errorPlacement: function(error, element) {
            $('.errormsg').html('');
            error.appendTo($('.loginpanel .errormsg'));
        },
        submitHandler: function(form) {
            $('.errormsg').html('');
            $('#pwd2').val($.md5($('#pwd').val()));
            $('#pwd').attr('disabled', true);
            $(form).ajaxSubmit({
                success: function(data) {
                    var result = data.split(':');
                    if (result[0] === 'ok') {
                        window.location.reload();
                    } else {
                        $('#pwd').attr('disabled', false);
                        $('#pwd,#pwd2,#code').val('');
                        $('.loginpanel .errormsg').html(result[1]);
                        changeverify();
                    }
                }
            });
        }
    });

    // 注册表单验证
    $('#registerform').validate({
        event: 'keyup',
        rules: {
            reguser: {
                required: true,
                username: true,
                remote: {
                    url: './Account/checkUser.action',
                    type: "post",
                    dataType: "json",
                    data: {
                        username: function() {
                            return $("#reguser").val();
                        }
                    }
                }
            },
            regpwd2: { required: true, userpwd: true },
            rregpwd2: { equalTo: '#regpwd2' },
            regemail: {
                required: true,
                email: true,
                remote: {
                    url: './Account/checkEmail.action',
                    type: "post",
                    dataType: "json",
                    data: {
                        email: function() {
                            return $("#regemail").val();
                        }
                    }
                }
            },
            regcode: { required: true }
        },
        messages: {
            reguser: { required: '用户名必填。', username: '用户名长度须为5-45，只可包括以下字符: 大写字母、小写字母、数字和下划线。', remote: '用户名已存在。' },
            regpwd2: { required: '密码必填。', userpwd: '密码长度须为5-32，只可包括以下字符: 大写字母、小写字母、数字和符号。' },
            rregpwd2: { equalTo: '密码不匹配' },
            regemail: { required: '安全邮箱必填。', email: '邮箱格式错误。', remote: '邮箱已被注册。' },
            regcode: { required: '验证码必填。' }
        },
        errorPlacement: function(error, element) {
            $('.errormsg').html('');
            error.appendTo($('.registerpanel .errormsg'));
        },
        submitHandler: function(form) {
            $('.errormsg').html('');
            $('#regpwd').val($.md5($('#regpwd2').val()));
            $('#rregpwd').val($.md5($('#rregpwd2').val()));
            $('#regpwd2,#rregpwd2').attr('disabled', true);
            $(form).ajaxSubmit({
                success: function(data) {
                    var result = data.split(':');
                    if (result[0] === 'ok') {
                        window.location.reload();
                    } else {
                        $('#regpwd2,#rregpwd2').attr('disabled', false);
                        $('#regcode,#regpwd,#rregpwd').val('');
                        $('.registerpanel .errormsg').html(result[1]);
                        changeverify();
                    }
                }
            });
        }
    });

    // 修改密码表单验证
    $('#changepwdform').validate({
        event: 'keyup',
        rules: {
            oldpwd2: { required: true },
            newpwd2: { required: true, userpwd: true },
            reppwd2: { equalTo: '#newpwd2' },
            code: { required: true }
        },
        messages: {
            oldpwd2: { required: '原密码必填。' },
            newpwd2: { required: '新密码必填。', userpwd: '密码长度须为5-32，只可包括以下字符: 大写字母、小写字母、数字和符号。' },
            reppwd2: { equalTo: '密码不匹配' },
            code: { required: '验证码必填。' }
        },
        errorPlacement: function(error, element) {
            $('.errormsg').html('');
            error.appendTo($('.changepwdpanel .errormsg'));
        },
        submitHandler: function(form) {
            $('.errormsg').html('');
            $('#oldpwd').val($.md5($('#oldpwd2').val()));
            $('#newpwd').val($.md5($('#newpwd2').val()));
            $('#reppwd').val($.md5($('#reppwd2').val()));
            $('#oldpwd2,#newpwd2,#reppwd2').attr('disabled', true);
            $(form).ajaxSubmit({
                success: function(data) {
                    var result = data.split(':');
                    if (result[0] === 'ok') {
                        alert(result[1]);
                        window.location.reload();
                    } else {
                        $('#oldpwd2,#newpwd2,#reppwd2').attr('disabled', false);
                        $('#code,#oldpwd,#newpwd,#reppwd,#reppwd2,#oldpwd2,#newpwd2').val('');
                        $('.changepwdpanel .errormsg').html(result[1]);
                        changeverify();
                    }
                }
            });
        }
    });

    // 修改用户名表单验证
    $('#changeuserform').validate({
        event: 'keyup',
        rules: {
            uname: {
                required: true,
                username: true,
                remote: {
                    url: './Account/checkUser.action',
                    type: "post",
                    dataType: "json",
                    data: {
                        username: function() {
                            return $("#uname").val();
                        }
                    }
                }
            },
            upwd2: { required: true },
            ucode: { required: true }
        },
        messages: {
            uname: { required: '用户名必填。', username: '用户名长度须为5-45，只可包括以下字符: 大写字母、小写字母、数字和下划线。', remote: '用户名已存在。' },
            upwd2: { required: '密码必填。' },
            ucode: { required: '验证码必填。' }
        },
        errorPlacement: function(error, element) {
            $('.errormsg').html('');
            error.appendTo($('.changeuserpanel .errormsg'));
        },
        submitHandler: function(form) {
            $('.errormsg').html('');
            $('#upwd').val($.md5($('#upwd2').val()));
            $('#upwd2').attr('disabled', true);
            $(form).ajaxSubmit({
                success: function(data) {
                    var result = data.split(':');
                    if (result[0] === 'ok') {
                        alert(result[1]);
                        window.location.reload();
                    } else {
                        $('#upwd2').attr('disabled', false);
                        $('#ucode,#upwd,#upwd2').val('');
                        $('.changeuserpanel .errormsg').html(result[1]);
                        changeverify();
                    }
                }
            });
        }
    });

    // 验证邮箱表单验证
    $('#verifyemailform').validate({
        event: 'keyup',
        rules: {
            vcode: { required: true }
        },
        messages: {
            vcode: { required: '验证码必填。' }
        },
        errorPlacement: function(error, element) {
            $('.errormsg').html('');
            error.appendTo($('.verifyemailpanel .errormsg'));
        },
        submitHandler: function(form) {
            $('.errormsg').html('');
            $(form).ajaxSubmit({
                success: function(data) {
                    var result = data.split(':');
                    if (result[0] === 'ok') {
                        alert(result[1]);
                        window.location.reload();
                    } else {
                        $('.verifyemailpanel .errormsg').html(result[1]);
                    }
                }
            });
        }
    });

    // 修改邮箱表单验证
    $('#changeemailform').validate({
        event: 'keyup',
        rules: {
            email: {
                required: true,
                email: true,
                remote: {
                    url: './Account/checkEmail.action',
                    type: "post",
                    dataType: "json",
                    data: {
                        email: function() {
                            return $("#email").val();
                        }
                    }
                }
            },
            epwd: { required: true },
            ecode: { required: true }
        },
        messages: {
            email: { required: '新邮箱必填。', email: '邮箱格式错误。', remote: '邮箱已被注册。' },
            epwd: { required: '密码必填。' },
            ecode: { required: '验证码必填。' }
        },
        errorPlacement: function(error, element) {
            $('.errormsg').html('');
            error.appendTo($('.changeemailpanel .errormsg'));
        },
        submitHandler: function(form) {
            $('.errormsg').html('');
            $('#epwd2').val($.md5($('#epwd').val()));
            $('#epwd').attr('disabled', true);
            $(form).ajaxSubmit({
                success: function(data) {
                    var result = data.split(':');
                    if (result[0] === 'ok') {
                        alert(result[1]);
                        window.location.reload();
                    } else {
                        $('#epwd').attr('disabled', false);
                        $('#ecode,#epwd,#epwd2').val('');
                        $('.changeemailpanel .errormsg').html(result[1]);
                        changeverify();
                    }
                }
            });
        }
    });

    // 添加收藏夹表单验证
    $('#addcategoryform').validate({
        event: 'keyup',
        rules: {
            category: {
                required: true,
                remote: {
                    url: './Category/checkCategory.action',
                    type: "post",
                    dataType: "json",
                    data: {
                        category: function() {
                            return $("#category").val();
                        }
                    }
                },
                maxlength: 25
            }
        },
        messages: {
            category: { required: '收藏夹名称必填。', remote: '收藏夹已存在。', maxlength: '收藏夹名称长度不能超过25个字节' }
        },
        errorPlacement: function(error, element) {
            $('.errormsg').html('');
            error.appendTo($('.addcategorypanel .errormsg'));
        },
        submitHandler: function(form) {
            $('.errormsg').html('');
            $(form).ajaxSubmit({
                success: function(data) {
                    var result = data.split(':');
                    if (result[0] === 'ok') {
                        window.location.reload();
                    } else {
                        $('.addcategorypanel .errormsg').html(result[1]);
                    }
                }
            });
        }
    });

    // 修改收藏夹表单验证
    $('#updatecateform').validate({
        event: 'keyup',
        rules: {
            ucategory: {
                required: true,
                remote: {
                    url: './Category/checkCateEcName.action',
                    type: "post",
                    dataType: "json",
                    data: {
                        ucategory: function() {
                            return $("#ucategory").val();
                        },
                        ucategory_id: function() {
                            return $("#ucategory_id").val();
                        }
                    }
                },
                maxlength: 25
            }
        },
        messages: {
            ucategory: { required: '收藏夹名称必填。', remote: '收藏夹已存在。', maxlength: '收藏夹名称长度不能超过25个字节' }
        },
        errorPlacement: function(error, element) {
            $('.errormsg').html('');
            error.appendTo($('.updatecatepanel .errormsg'));
        },
        submitHandler: function(form) {
            $('.errormsg').html('');
            $(form).ajaxSubmit({
                success: function(data) {
                    var id = $("#ucategory_id").val();
                    var name = $("#ucategory").val();
                    var result = data.split(':');
                    if (result[0] === 'ok') {
                        $('#category' + id).find('h4').text(name);
                        hideaccountbox();
                    } else {
                        $('.updatecatepanel .errormsg').html(result[1]);
                    }
                }
            });
        }
    });

    // 添加链接表单验证
    $('#addlinkform').validate({
        event: 'keyup',
        rules: {
            link_title: {
                required: true,
                remote: {
                    url: './Link/checkLink.action',
                    type: "post",
                    dataType: "json",
                    data: {
                        link_title: function() {
                            return $("#link_title").val();
                        },
                        category_id: function() {
                            return $("#link_category_id").val();
                        }
                    }
                }
            },
            link_url: { required: true, url: true }
        },
        messages: {
            link_title: { required: '标题必填。', remote: '标题已存在。' },
            link_url: { required: 'Url必填。', url: 'Url格式错误。' }
        },
        errorPlacement: function(error, element) {
            $('.errormsg').html('');
            error.appendTo($('.addlinkpanel .errormsg'));
        },
        submitHandler: function(form) {
            $('.errormsg').html('');
            $(form).ajaxSubmit({
                success: function(data) {
                    var result = data.split(':');
                    if (result[0] === 'ok') {
                        window.location.reload();
                    } else {
                        $('.addlinkpanel .errormsg').html(result[1]);
                    }
                }
            });
        }
    });

    // 修改链接表单验证
    $('#updatelinkform').validate({
        event: 'keyup',
        rules: {
            ulink_title: {
                required: true,
                remote: {
                    url: './Link/checkLinkEcTitle.action',
                    type: "post",
                    dataType: "json",
                    data: {
                        ulink_id: function() {
                            return $("#ulink_id").val();
                        },
                        ulink_title: function() {
                            return $("#ulink_title").val();
                        },
                        ulink_category: function() {
                            return $("#ulink_category_id").val();
                        }
                    }
                }
            },
            ulink_url: { required: true, url: true }
        },
        messages: {
            ulink_title: { required: '标题必填。', remote: '标题已存在。' },
            ulink_url: { required: 'Url必填。', url: 'Url格式错误。' }
        },
        errorPlacement: function(error, element) {
            $('.errormsg').html('');
            error.appendTo($('.updatelinkpanel .errormsg'));
        },
        submitHandler: function(form) {
            $('.errormsg').html('');
            $(form).ajaxSubmit({
                success: function(data) {
                    var id = $("#ulink_id").val();
                    var url = $("#ulink_url").val();
                    var title = $("#ulink_title").val();
                    var result = data.split(':');
                    if (result[0] === 'ok') {
                        $('#link' + id).html(title);
                        $('#link' + id).attr('href', url);
                        hideaccountbox();
                    } else {
                        $('.updatelinkpanel .errormsg').html(result[1]);
                    }
                    window.location.reload();
                }
            });
        }
    });

    // 修改链接收藏夹表单验证
    $('#editlinkcateform').validate({
        event: 'keyup',
        rules: {
            ecategory_id: { required: true }
        },
        messages: {
            ecategory_id: { required: "必须选择一项。" }
        },
        errorPlacement: function(error, element) {
            $('.errormsg').html('');
            error.appendTo($('.editlinkcatepanel .errormsg'));
        },
        submitHandler: function(form) {
            $('.errormsg').html('');
            $(form).ajaxSubmit({
                success: function(data) {
                    var result = data.split(':');
                    if (result[0] === 'ok') {
                        window.location.reload();
                    } else {
                        $('.editlinkcatepanel .errormsg').html(result[1]);
                    }
                }
            });
        }
    });

    // 添加最爱站点表单验证
    $('#addfavform').validate({
        event: 'keyup',
        rules: {
            fcategory_id: { required: true },
            flink_id: { required: true }
        },
        messages: {
            fcategory_id: { required: "必须选择收藏夹。" },
            flink_id: { required: "必须选择链接。" }
        },
        errorPlacement: function(error, element) {
            $('.errormsg').html('');
            error.appendTo($('.addfavpanel .errormsg'));
        },
        submitHandler: function(form) {
            $('.errormsg').html('');
            $(form).ajaxSubmit({
                success: function(data) {
                    var result = data.split(':');
                    if (result[0] === 'ok') {
                        window.location.reload();
                    } else {
                        $('.addfavpanel .errormsg').html(result[1]);
                    }
                }
            });
        }
    });

    // 忘记密码表单验证
    $('#forgetform').validate({
        event: 'keyup',
        rules: {
            fgname: { required: true },
            fgemail: { required: true, email: true },
            fgcode: { required: true }
        },
        messages: {
            fgname: { required: '用户名必填。' },
            fgemail: { required: '邮箱必填。', email: '邮箱格式错误。' },
            fgcode: { required: '验证码必填。' }
        },
        errorPlacement: function(error, element) {
            $('.errormsg').html('');
            error.appendTo($('.forgetpanel .errormsg'));
        },
        submitHandler: function(form) {
            $('.errormsg').html('');
            $(form).ajaxSubmit({
                success: function(data) {
                    var result = data.split(':');
                    if (result[0] === 'ok') {
                        showforget2panel();
                        $('#fguserid').val(result[1]);
                    } else {
                        $('.forgetpanel .errormsg').html(result[1]);
                        changeverify();
                    }
                }
            });
        }
    });

    // 重置密码表单验证
    $('#forget2form').validate({
        event: 'keyup',
        rules: {
            fgcode2: { required: true },
            fgnewpwd2: { required: true, userpwd: true },
            fgreppwd2: { equalTo: '#fgnewpwd2' }
        },
        messages: {
            fgcode2: { required: '验证码必填。' },
            fgnewpwd2: { required: '新密码必填。', userpwd: '密码长度须为5-32，只可包括以下字符: 大写字母、小写字母、数字和符号。' },
            fgreppwd2: { equalTo: '密码不匹配' }
        },
        errorPlacement: function(error, element) {
            $('.errormsg').html('');
            error.appendTo($('.forget2panel .errormsg'));
        },
        submitHandler: function(form) {
            $('.errormsg').html('');
            $('#fgnewpwd').val($.md5($('#fgnewpwd2').val()));
            $('#fgreppwd').val($.md5($('#fgreppwd2').val()));
            $('#fgnewpwd2,#fgreppwd2').attr('disabled', true);
            $(form).ajaxSubmit({
                success: function(data) {
                    var result = data.split(':');
                    if (result[0] === 'ok') {
                        alert(result[1]);
                        window.location.reload();
                    } else {
                        $('.forget2panel .errormsg').html(result[1]);
                        $('#fgnewpwd2,#fgreppwd2').attr('disabled', false);
                        $('#fgnewpwd,#fgreppwd,#fgnewpwd2,#fgreppwd2').val('');
                    }
                }
            });
        }
    });
});