$(function() {
    var scrollTop = 0;
    var scrollBottom = 0;
    var dch = getClientHeight();
    $(document).scroll(function() {
        scrollTop = getScrollTop();
        scrollBottom = document.body.scrollHeight - scrollTop;
        if (scrollTop >= 5) {
            $('.header').css('box-shadow', '0 0 10px 5px #ededed');
        } else {
            $('.header').css('box-shadow', 'none');
        }
    });
    editPosition();
    $(window).resize(editPosition);
    $('.headlink').hover(showheadtext, hideheadtext);
});

function showheadtext() {
    $('.headlink').html('更改头像');
}

function hideheadtext() {
    $('.headlink').html('');
}

function editPosition() {
    var dch = getClientHeight();
    var loginheight = parseFloat($('.loginpanel').css('height'));
    var registerheight = parseFloat($('.registerpanel').css('height'));
    var changepwdheight = parseFloat($('.changepwdpanel').css('height'));
    var changeuserheight = parseFloat($('.changeuserpanel').css('height'));
    var changeemailheight = parseFloat($('.changeemailpanel').css('height'));
    var forgetheight = parseFloat($('.forgetpanel').css('height'));
    var verifyemailheight = parseFloat($('.verifyemailpanel').css('height'));
    var changeheadheight = parseFloat($('.changeheadpanel').css('height'));
    var addlinkheight = parseFloat($('.addlinkpanel').css('height'));
    var addcategoryheight = parseFloat($('.addcategorypanel').css('height'));
    var updatelinkheight = parseFloat($('.updatelinkpanel').css('height'));
    var updatecateheight = parseFloat($('.updatecatepanel').css('height'));
    var editlinkcateheight = parseFloat($('.editlinkcatepanel').css('height'));
    var addfavheight = parseFloat($('.addfavpanel').css('height'));
    $('.loginpanel').css('top', (dch - loginheight) / 2);
    $('.registerpanel').css('top', (dch - registerheight) / 2);
    $('.changepwdpanel').css('top', (dch - changepwdheight) / 2);
    $('.changeuserpanel').css('top', (dch - changeuserheight) / 2);
    $('.changeemailpanel').css('top', (dch - changeemailheight) / 2);
    $('.forgetpanel').css('top', (dch - forgetheight) / 2);
    $('.verifyemailpanel').css('top', (dch - verifyemailheight) / 2);
    $('.changeheadpanel').css('top', (dch - changeheadheight) / 2);
    $('.addlinkpanel').css('top', (dch - addlinkheight) / 2);
    $('.addcategorypanel').css('top', (dch - addcategoryheight) / 2);
    $('.updatelinkpanel').css('top', (dch - updatelinkheight) / 2);
    $('.updatecatepanel').css('top', (dch - updatecateheight) / 2);
    $('.editlinkcatepanel').css('top', (dch - editlinkcateheight) / 2);
    $('.addfavpanel').css('top', (dch - addfavheight) / 2);
}

function getClientHeight() {
    var clientHeight = 0;
    if (document.body.clientHeight && document.documentElement.clientHeight) {
        clientHeight = (document.body.clientHeight < document.documentElement.clientHeight) ? document.body.clientHeight : document.documentElement.clientHeight;
    } else {
        clientHeight = (document.body.clientHeight > document.documentElement.clientHeight) ? document.body.clientHeight : document.documentElement.clientHeight;
    }
    return clientHeight;
}

function getScrollTop() {
    var scrollTop = 0;
    scrollTop = (document.body.scrollTop > document.documentElement.scrollTop) ? document.body.scrollTop : document.documentElement.scrollTop;
    return scrollTop;
}

function togglepanel() {
    $('.accountpanel').slideToggle(300);
}

function hideaccountbox() {
    $('.accountbox input').removeClass('error');
    $('.accountbox input').removeClass('valid');
    $('.errormsg').html('');
    $('.accountbox').hide();
}

function showlogin() {
    togglepanel();
    hideaccountbox();
    $('#loginform')[0].reset();
    $('.loginpanel').show();
}

function showregister() {
    togglepanel();
    hideaccountbox();
    $('#registerform')[0].reset();
    $('.registerpanel').show();
}

function showchangepwd() {
    hideaccountbox();
    $('#changepwdform')[0].reset();
    $('.changepwdpanel').show();
}


function showforgetpanel() {
    hideaccountbox();
    $('#forgetform')[0].reset();
    $('.forgetpanel').show();
}

function showforget2panel() {
    hideaccountbox();
    $('#forget2form')[0].reset();
    $('.forget2panel').show();
}

function showchangeuser() {
    hideaccountbox();
    $('#changeuserform')[0].reset();
    $('.changeuserpanel').show();
}

function showchangeemail() {
    hideaccountbox();
    $('#changeemailform')[0].reset();
    $('.changeemailpanel').show();
}

function showverifyemail() {
    hideaccountbox();
    $('#verifyemailform')[0].reset();
    $('.verifyemailpanel').show();
}

function showchangehead() {
    hideaccountbox();
    $('.changeheadpanel').show();
}

function showaddlink(categoryid) {
    hideaccountbox();
    $('#addlinkform')[0].reset();
    $('#link_category_id').val(categoryid);
    $('#link_url').val();
    $('.addlinkpanel').show();
}

function showaddcategory() {
    hideaccountbox();
    $('#addcategoryform')[0].reset();
    $('.addcategorypanel').show();
}

function showaddfav() {
    hideaccountbox();
    $('#addfavform')[0].reset();
    $('#flink_id').empty();
    $('.addfavpanel').show();
}

function showupdatelink(cateid, id) {
    hideaccountbox();
    $('#updatelinkform')[0].reset();
    $("#ulink_title,#ulink_url").removeData("previousValue");

    var title = $('#link' + id + ' nobr').html();
    var url = $('#link' + id).attr('href');
    $('#ulink_category_id').val(cateid);
    $('#ulink_id').val(id);
    $('#ulink_title').val(title);
    $('#ulink_url').val(url);
    $('.updatelinkpanel').show();
}

function showupdatecate(id) {
    hideaccountbox();
    var name = $('#category' + id).find('h4').text();
    $('#updatecateform')[0].reset();
    $("#ucategory").removeData("previousValue");
    $('#ucategory_id').val(id);
    $('#ucategory').val(name);
    $('.updatecatepanel').show();
}

function showmovelink(categoryid, linkid) {
    hideaccountbox();
    $('#editlinkcateform')[0].reset();
    $('#ecategory_id option').show();
    $('#ecategory_id option[value=' + categoryid + ']').hide();
    $('#elink_id').val(linkid);
    $('.editlinkcatepanel').show();
}

function changeverify() {
    $('.verifyimg').attr('src', $('.verifyimg').attr('src') + '?' + Math.random());
}


function submitregister(url) {
    $.post({
        url: url + '/checkUser',
        data: $('#reguser').val()
    });
}

function logout(url,turnto) {
    $.get({
        url: url,
        success: function(data) {
            if (data === 'ok') {
                window.location.href = turnto;
            }
        }
    });
}

function toggleextedit() {
    $('.extshow,.extedit,.editlink').toggleClass('hidden');
}

function submitextuser() {
    $('#persionalform').ajaxSubmit({
        success: function(data) {
            var result = data.split(':');
            if (result[0] === 'ok') {
                window.location.reload();
            } else {
                alert(result[1]);
            }
        }
    });
}

function delcatebyid(id, obj) {
    $.get('./Category/deleteCategory.action', { 'id': id }, function(data) {
        if (data === 'ok') {
            $(obj).parent().parent().parent().remove();
        } else {
            alert('删除失败，请重试。');
        }
    });
}

function dellinkbyid(id, obj) {
    $.get('./Link/deleteLink.action', { 'id': id }, function(data) {
        if (data === 'ok') {
            $(obj).parent().remove();
        } else {
            alert('删除失败，请重试。');
        }
    });
}

function delfavlink(id, obj) {
    $.get('./Link/delFavLink.action', { 'id': id }, function(data) {
        var result = data.split(':');
        if (result[0] === 'ok') {
            $(obj).parent().remove();
        } else {
            alert('删除失败，请重试。');
        }
    });
}

function getlinks(obj) {
    var categoryid = $(obj).val();
    $.get('./Link/getLinkByCate.action', { 'id': categoryid }, function(data) {
        $('#flink_id').empty();
        $.each(data, function(k, v) {
            var item = "<option value='" + v.linkId + "'>" + v.linkTitle + "</option>";
            $('#flink_id').append(item);
        });
    });
}

function toggleedit(obj) {
    $('.content .editlabel').toggle();
    $('.link>li>a:first-child').toggleClass('sortlink');
    if ($(obj).html() === '编辑页面') {
        $(obj).html('退出编辑');
    } else {
        $(obj).html('编辑页面');
    }
    togglepanel();
}

function sendverifycode(url) {
    $.get(url, function(data) {
        var result = data.split(':');
        if (result[0] === 'ok') {
            RemainTime();
        }
    });
}

var iTime = 59;
var Account;

function RemainTime() {
    document.getElementById('verifylink').setAttribute("disabled", "disabled");
    document.getElementById('verifylink').setAttribute("onclick", "");
    if (iTime >= 0) {
        iSecond = parseInt(iTime % 60);
        iMinute = parseInt(iTime / 60);
        if (iSecond >= 0) {
            if (iMinute > 0) {
                sSecond = iMinute + "分" + iSecond + "秒后可重新发送";
            } else {
                sSecond = iSecond + "秒后可重新发送";
            }
        }
        sTime = sSecond;
        if (iTime == 0) {
            clearTimeout(Account);
            sTime = '再发送一次验证码';
            iTime = 59;
            document.getElementById('verifylink').setAttribute("disabled", false);
            document.getElementById('verifylink').setAttribute("onclick", "sendverifycode()");
        } else {
            Account = setTimeout("RemainTime()", 1000);
            iTime = iTime - 1;
        }
    } else {
        sTime = '没有倒计时';
    }
    document.getElementById('verifylink').innerHTML = sTime;
}