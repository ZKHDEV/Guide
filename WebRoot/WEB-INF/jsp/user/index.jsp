<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>个人中心 - Macro 导航</title>
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath }/img/web.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/font-awesome.min.css">
    <!--[if IE 7]>
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/font-awesome-ie7.min.css">
    <![endif]-->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/jquery.Jcrop.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/uploadify.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/app.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/upload.css">
</head>

<body>
    <div class="header">
        <div class="container">
            <div class="col-md-2 col-md-offset-1 col-sm-1 col-xs-12 hidden-xs">
                <a href="./"><img class="banner" src="${pageContext.request.contextPath }/img/logo-png.png" alt=""></a>
            </div>
            <div class="col-md-7 col-sm-10 col-xs-10">
                <div class="search">
                    <form action="http://cn.bing.com/search" method="GET" target="_blank">
                        <button type="submit"><i class="icon-search"></i></button>
                        <div class="searchdiv"><input type="search" name="q" placeholder="Search..." autocomplete="off"></div>
                    </form>
                </div>
            </div>
            <div class="col-md-1 col-sm-1 col-xs-2">
                <div class="settingdiv">
                    <a href="${pageContext.request.contextPath }/index.action" class="settingbtn"><i class="icon-home"></i></a>
                </div>
            </div>
        </div>
    </div>
    <div class="container content">
        <div class="col-md-12 perheader">
            <div class="headdiv">
            	<c:choose>
                	<c:when test="${extuser.extuserHead==null }">
                		<img class="headimg" src="${pageContext.request.contextPath }/img/mystery.png" alt="头像">
                	</c:when>
                	<c:otherwise>
                		<img class="headimg" src="${pageContext.request.contextPath }/upload/Avatar/${extuser.extuserHead }" alt="头像">
                	</c:otherwise>
                </c:choose>
                <a class="headlink" href="javascript:void(0)" onclick="showchangehead()"></a>
            </div>
            <p>${user.userName}</p>
            <hr>
        </div>
        <div class="row">
            <div class="col-md-10 col-md-offset-1 percard">
                <form id="persionalform" action="${pageContext.request.contextPath }/updateUser.action" method="post" autocomplete="off">
                    <input type="hidden" name="extuserId" value="${extuser.extuserId}">
                    <input type="hidden" name="extuserHead" value="${extuser.extuserHead}">
                    <input type="hidden" name="extuserLikenum" value="${extuser.extuserLikenum}">
                    <h3>个人资料
                        <a class="editlink" href="javascript:void(0)" onclick="toggleextedit(this)">编辑</a>
                        <a class="editlink hidden" href="javascript:void(0)" onclick="toggleextedit(this)">取消</a>
                        <a class="editlink hidden" href="javascript:void(0)" onclick="submitextuser()">保存</a>
                    </h3>
                    <hr>
                    <table>
                        <tr>
                            <td>姓名：</td>
                            <td class="extshow">${extuser.extuserName}</td>
                            <td class="extedit hidden"><input type="text" name="extuserName" value="${extuser.extuserName}"></td>
                        </tr>
                        <tr>
                            <td>年龄：</td>
                            <td class="extshow">${extuser.extuserAge}</td>
                            <td class="extedit hidden"><input type="number" name="extuserAge" value="${extuser.extuserAge}"></td>
                        </tr>
                        <tr>
                            <td>性别：</td>
                            <td class="extshow">${extuser.extuserSex}</td>
                            <td class="extedit hidden"><input type="text" name="extuserSex" value="${extuser.extuserSex}"></td>
                        </tr>
                        <tr>
                            <td>国家：</td>
                            <td class="extshow">${extuser.extuserCountry}</td>
                            <td class="extedit hidden"><input type="text" name="extuserCountry" value="${extuser.extuserCountry}"></td>
                        </tr>
                        <tr>
                            <td>城市：</td>
                            <td class="extshow">${extuser.extuserCity}</td>
                            <td class="extedit hidden"><input type="text" name="extuserCity" value="${extuser.extuserCity}"></td>
                        </tr>
                        <tr>
                            <td>职位：</td>
                            <td class="extshow">${extuser.extuserPost}</td>
                            <td class="extedit hidden"><input type="text" name="extuserPost" value="${extuser.extuserPost}"></td>
                        </tr>
                        <tr>
                            <td>邮箱：</td>
                            <td class="extshow">${extuser.extuserEmail}</td>
                            <td class="extedit hidden"><input type="text" name="extuserEmail" value="${extuser.extuserEmail}"></td>
                        </tr>
                        <tr>
                            <td>手机：</td>
                            <td class="extshow">${extuser.extuserPhone}</td>
                            <td class="extedit hidden"><input type="text" name="extuserPhone" value="${extuser.extuserPhone}"></td>
                        </tr>
                        <tr>
                            <td>爱好：</td>
                            <td class="extshow">${extuser.extuserHobby}</td>
                            <td class="extedit hidden"><input type="text" name="extuserHobby" value="${extuser.extuserHobby}"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="row">
            <div class="col-md-10 col-md-offset-1 percard">
                <h3>账户信息</h3>
                <hr>
                <table>
                    <tr>
                        <td>用户名：</td>
                        <td>${user.userName}<a href="javascript:void(0)" onclick="showchangeuser()" title="修改用户名"><i class="icon-pencil"></i></a>
                            <a href="javascript:void(0)" onclick="showchangepwd()" title="修改密码"><i class="icon-key"></i></a>
                        </td>
                    </tr>
                    <tr>
                        <td>注册邮箱：</td>
                        <td>${user.userEmail}
                        	<c:if test="${user.userState == 0 }">
                        		<a href="javascript:void(0)" onclick="showverifyemail()" style="color:red">未验证</a>                     
                        	</c:if>
                            <a href="javascript:void(0)" onclick="showchangeemail()" title="修改邮箱"><i class="icon-pencil"></i></a>
                        </td>
                    </tr>
                    <tr>
                        <td>创建时间：</td>
                        <td>${user.userSubtime}</td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <a class="logoutbtn" href="javascript:void(0)" onclick="confirm('确定要注销吗？')?logout('${pageContext.request.contextPath }/logout.action','${pageContext.request.contextPath }/index.action'):false" title="注销">
                    <i class="icon-signout"></i>
                </a>
            </div>
        </div>
    </div>

    <div class="clear"></div>
    <div class="row footer">
        <div class="container">
            <div class="col-md-2 col-md-offset-1">&copy; 2016 Macro</div>
            <div class="col-md-5 col-md-offset-4">
                <ul class="list help">
                    <li><a href="#">关于</a></li>
                    <li><a href="#">联系</a></li>
                    <li><a href="#">广告</a></li>
                    <li><a href="#">帮助</a></li>
                    <li><a href="#">反馈</a></li>
                </ul>
            </div>
        </div>
    </div>

    <div class="accountbox changepwdpanel">
        <div class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3">
            <form id="changepwdform" action="${pageContext.request.contextPath }/Account/changePwd.action" method="post" autocomplete="off">
                <h3>修改密码</h3><br>
                <div class="col-md-6 col-sm-6">
                    <input type="hidden" name="oldpwd" id="oldpwd">
                    <input type="hidden" name="newpwd" id="newpwd">
                    <input type="hidden" name="reppwd" id="reppwd">
                    <p>原密码</p>
                    <input type="password" name="oldpwd2" id="oldpwd2">
                    <p>新密码</p>
                    <input type="password" name="newpwd2" id="newpwd2">
                    <p>确认密码</p>
                    <input type="password" name="reppwd2" id="reppwd2">
                    <p>验证码</p>
                    <input type="text" name="code" id="code">
                    <img class="verifyimg" src="${pageContext.request.contextPath }/verifyImg.action" onclick="changeverify()" alt="验证码">
                </div>
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <p class="error errormsg"></p><br>
                        <ul class="list">
                            <li><button type="submit" class="accountbtn confirmbtn">确定</button></li>
                            <li><button type="button" onclick="hideaccountbox()" class="accountbtn cancelbtn">取消</button></li>
                        </ul>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="accountbox changeemailpanel">
        <div class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3">
            <form id="changeemailform" action="${pageContext.request.contextPath }/Account/changeEmail.action" method="post" autocomplete="off">
                <h3>修改邮箱</h3><br>
                <div class="col-md-6 col-sm-6">
                    <input type="hidden" name="epwd2" id="epwd2">
                    <p>新邮箱</p>
                    <input type="text" name="email" id="email">
                    <p>密码</p>
                    <input type="password" name="epwd" id="epwd">
                    <p>验证码</p>
                    <input type="text" name="ecode" id="ecode">
                    <img class="verifyimg" src="${pageContext.request.contextPath }/verifyImg.action" onclick="changeverify()" alt="验证码">
                </div>
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <p class="error errormsg"></p><br>
                        <ul class="list">
                            <li><button type="submit" class="accountbtn confirmbtn">确定</button></li>
                            <li><button type="button" onclick="hideaccountbox()" class="accountbtn cancelbtn">取消</button></li>
                        </ul>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="accountbox changeuserpanel">
        <div class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3">
            <form id="changeuserform" action="${pageContext.request.contextPath }/Account/changeUser.action" method="post" autocomplete="off">
                <h3>修改用户名</h3><br>
                <div class="col-md-6 col-sm-6">
                    <input type="hidden" name="upwd" id="upwd">
                    <p>新用户名</p>
                    <input type="text" name="uname" id="uname">
                    <p>密码</p>
                    <input type="password" name="upwd2" id="upwd2">
                    <p>验证码</p>
                    <input type="text" name="ucode" id="ucode">
                    <img class="verifyimg" src="${pageContext.request.contextPath }/verifyImg.action" onclick="changeverify()" alt="验证码">
                </div>
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <p class="error errormsg"></p><br>
                        <ul class="list">
                            <li><button type="submit" class="accountbtn confirmbtn">确定</button></li>
                            <li><button type="button" onclick="hideaccountbox()" class="accountbtn cancelbtn">取消</button></li>
                        </ul>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="accountbox verifyemailpanel">
        <div class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3">
            <form id="verifyemailform" action="${pageContext.request.contextPath }/Account/verifyEmail.action" method="post" autocomplete="off">
                <h3>验证邮箱</h3><br>
                <div class="col-md-6 col-sm-6">
                    <p>输入收到的验证码</p>
                    <input type="text" name="vcode" id="vcode">
                    <a id="verifylink" class="error" href="javascript:void(0)" onclick="sendverifycode('${pageContext.request.contextPath }/Account/sendVerify.action')">再发送一次验证码</a>
                </div>
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <p class="error errormsg"></p><br>
                        <ul class="list">
                            <li><button type="submit" class="accountbtn confirmbtn">确定</button></li>
                            <li><button type="button" onclick="hideaccountbox()" class="accountbtn cancelbtn">取消</button></li>
                        </ul>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="accountbox changeheadpanel">
        <div class="col-md-8 col-md-offset-4 col-sm-8 col-sm-offset-2 col-xs-11 col-xs-offset-1">
            <form action="${pageContext.request.contextPath }/User/cropImg.action" method="post" id="pic" class="update-pic cf">
                <div class="upload-area">
                    <input type="file" id="user-pic" name="file">
                    <div class="file-tips">仅支持JPG，图片小于1MB，尺寸不小于100*100,真实高清头像更受欢迎！</div>
                    <div class="preview hidden" id="preview-hidden"></div>
                </div>
                <div class="preview-area">
                    <input type="hidden" id="x" name="x" />
                    <input type="hidden" id="y" name="y" />
                    <input type="hidden" id="w" name="w" />
                    <input type="hidden" id="h" name="h" />
                    <input type="hidden" id='img_src' name='src' />
                    <div class="tcrop">头像预览</div>
                    <div class="crop crop100"><img id="crop-preview-100" src="" alt=""></div>
                    <div class="crop crop60"><img id="crop-preview-60" src="" alt=""></div>
                    <a class="uppic-btn save-pic" href="javascript:;">保存</a>
                    <a href="javascript:void(0)" onclick="hideaccountbox()" class="uppic-btn canupload">取消</a>
                    <a class="uppic-btn reupload-img" href="javascript:$('#user-pic').uploadify('cancel','*');">重新上传</a>
                </div>
            </form>
        </div>
    </div>
    <script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery.md5.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery.form.js"></script>
    <script src="${pageContext.request.contextPath }/js/form.js"></script>
    <script src="${pageContext.request.contextPath }/js/migrate.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery.uploadify-3.1.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery.Jcrop.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery.ThinkBox.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/upload.js"></script>
    <script src="${pageContext.request.contextPath }/js/app.js"></script>
</body>

</html>