<%@ page import="java.net.URL"%>
<%@ page import="java.util.List"%>
<%@ page import="com.zkh.guide.po.GuideLink"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>Macro 导航</title>
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath }/img/web.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/animate.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/font-awesome.min.css">
    <!--[if IE 7]>
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/font-awesome-ie7.min.css">
    <![endif]-->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/app.css">
</head>

<body>
    <div class="header">
        <div class="col-md-2 col-md-offset-1 col-sm-1 col-xs-12 hidden-xs">
            <a href="${pageContext.request.contextPath }/index.action"><img class="banner" src="${pageContext.request.contextPath }/img/logo-png.png" alt=""></a>
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

                <div class="accountpanel">
                	<c:choose>
                		<c:when test="${user==null }">
                			<a href="javascript:void(0)" onclick="showlogin()">登 录</a>
                        	<a href="javascript:void(0)" onclick="showregister()">注 册</a>
                		</c:when>
                		<c:otherwise>
                			<c:choose>
                				<c:when test="${extuser.extuserHead==null }">
                					<img class="head" src="${pageContext.request.contextPath }/img/mystery.png" alt="头像">
                				</c:when>
                				<c:otherwise>
                					<img class="head" src="${pageContext.request.contextPath }/upload/Avatar/${extuser.extuserHead }" alt="头像">
                				</c:otherwise>
                			</c:choose>
                			<h3>${user.userName }</h3>
                        	<hr>
                        	<a href="./user.action">个人中心</a>
                        	<a href="javascript:void(0)" onclick="toggleedit(this)">编辑页面</a>
                		</c:otherwise>
                	</c:choose>
                </div>
                <a href="javascript:void(0)" class="settingbtn" onclick="togglepanel()"><i class="icon-cog"></i></a>
            </div>
        </div>
    </div>
    <div class="container content">
        <div class="row">
            <p class="title">最爱站点</p>
            <ul class="list favsite">
            	<c:choose>
            		<c:when test="${favlinks != null}">
            			<%
            				for(GuideLink link:(List<GuideLink>)request.getAttribute("favlinks")){
            					URL url = new URL(link.getLinkUrl());
            					String icoUrl = url.getProtocol()+"://"+url.getHost()+"/favicon.ico";	
            			 %>
                        	<li>
                            	<a href="<%=link.getLinkUrl() %>" title="<%=link.getLinkTitle() %>" target="_blank">
                             		<img src="<%=icoUrl %>" onerror="this.src='${pageContext.request.contextPath }/img/web.ico'"/>           
                                	<hr>
                                	<p>
                                    	<nobr><%=link.getLinkTitle() %></nobr>
                                	</p>
                            	</a>
                            	<a class="removefav editlabel" href="javascript:void(0)" onclick="confirm('确定要删除吗？')?delfavlink(<%=link.getLinkId() %>,this):false"><i class="icon-trash"></i></a>
                        	</li>
                		<%} %>
            		</c:when>
            		<c:otherwise>
            			<li>
                            <a href="http://u.ctrip.com/union/CtripRedirect.aspx?ocid=msnnavtopsite&TypeID=2&Allianceid=349539&sid=832632&OUID=&jumpUrl=http%3A%2F%2Fwww.ctrip.com%2F%3FAllianceid%3D349539%26sid%3D832632%26OUID%3D%26MultiUnionSupport%3Dtrue" title="携程" target="_blank">
                             	<img src="http://u.ctrip.com/favicon.ico" onerror="this.src='${pageContext.request.contextPath }/img/web.ico'"/>           
                                <hr>
                                <p>
                                    <nobr>携程</nobr>
                                </p>
                            </a>
                        </li>
            			<li>
                            <a href="https://www.taobao.com" title="淘宝" target="_blank">
                             	<img src="https://www.taobao.com/favicon.ico" onerror="this.src='${pageContext.request.contextPath }/img/web.ico'"/>           
                                <hr>
                                <p>
                                    <nobr>淘宝</nobr>
                                </p>
                            </a>
                        </li>
            			<li>
                            <a href="https://www.jd.com" title="京东" target="_blank">
                             	<img src="https://www.jd.com/favicon.ico" onerror="this.src='${pageContext.request.contextPath }/img/web.ico'"/>           
                                <hr>
                                <p>
                                    <nobr>京东</nobr>
                                </p>
                            </a>
                        </li>
            			<li>
                            <a href="http://www.iqiyi.com" title="爱奇艺" target="_blank">
                             	<img src="http://www.iqiyi.com/favicon.ico" onerror="this.src='${pageContext.request.contextPath }/img/web.ico'"/>           
                                <hr>
                                <p>
                                    <nobr>爱奇艺</nobr>
                                </p>
                            </a>
                        </li>
            			<li>
                            <a href="http://news.sina.com.cn/?ocid=msnnavtopsite" title="新浪" target="_blank">
                             	<img src="http://news.sina.com.cn/favicon.ico" onerror="this.src='${pageContext.request.contextPath }/img/web.ico'"/>           
                                <hr>
                                <p>
                                    <nobr>新浪</nobr>
                                </p>
                            </a>
                        </li>
            			<li>
                            <a href="https://www.tmall.com" title="天猫" target="_blank">
                             	<img src="https://www.tmall.com/favicon.ico" onerror="this.src='${pageContext.request.contextPath }/img/web.ico'"/>           
                                <hr>
                                <p>
                                    <nobr>天猫</nobr>
                                </p>
                            </a>
                        </li>
            			<li>
                            <a href="https://outlook.live.com" title="Outlook" target="_blank">
                             	<img src="https://outlook.live.com/favicon.ico" onerror="this.src='${pageContext.request.contextPath }/img/web.ico'"/>           
                                <hr>
                                <p>
                                    <nobr>Outlook</nobr>
                                </p>
                            </a>
                        </li>
            		</c:otherwise>
            	</c:choose>
                
                <li class="editlabel">
                    <a href="javascript:void(0)" onclick="showaddfav()" class="addfavbtn">
                        <i class="icon-plus-sign"></i>
                    </a>
                </li>
            </ul>
        </div>
        <div class="row">
            <hr>
            <ul class="list category">
            <c:choose>
            	<c:when test="${categories != null}">
            		<c:forEach items="${categories }" var="ca">
                    <li>
                        <div class="item" id="category${ca.categoryId}">
                            <div class="itemhead">
                                <h4>${ca.categoryName}</h4>
                                <a class="editlabel" href="javascript:void(0)" onclick="showupdatecate(${ca.categoryId})"><i class="icon-pencil"></i></a>
                                <a class="editlabel" href="javascript:void(0)" onclick="confirm('确定要删除吗？（收藏夹下的链接也将被删除）')?delcatebyid(${ca.categoryId},this):false"><i class="icon-remove-sign"></i></a>
                                <a class="editlabel" href="javascript:void(0)" onclick="showaddlink(${ca.categoryId})"><i class="icon-plus-sign"></i>&nbsp;添加</a>
                            </div>
                            <hr>
                            <ul class="list link">
                                <c:forEach items="${links }" var="li">
                                	<c:if test="${li.linkCategoryId == ca.categoryId }">
                                		<li>
                                            <a id="link${li.linkId}" href="${li.linkUrl }" target="_blank" title="${li.linkTitle}">
                                                <nobr>${li.linkTitle}</nobr>
                                            </a>
                                            <a class="editbtn editlabel" href="javascript:void(0)" onclick="showmovelink(${ca.categoryId},${li.linkId})"><i class="icon-move"></i></a>
                                            <a class="editbtn editlabel" href="javascript:void(0)" onclick="confirm('确定要删除此站点吗？')?dellinkbyid(${li.linkId},this):false"><i class="icon-remove-sign"></i></a>
                                            <a class="editbtn editlabel" href="javascript:void(0)" onclick="showupdatelink(${ca.categoryId},${li.linkId})"><i class="icon-pencil"></i></a>
                                        </li>
                                	</c:if>
                                </c:forEach>
                            </ul>
                        </div>
                    </li>
                </c:forEach>
                <li class="addgroupitem editlabel">
                    <a href="javascript:void(0)" onclick="showaddcategory()">
                        <i class="icon-plus-sign"></i>
                    </a>
                </li>
            	</c:when>
            	<c:otherwise>
            		<li>
                        <div class="item">
                            <div class="itemhead">
                                <h4>视频</h4>
                            </div>
                            <hr>
                            <ul class="list link">
                                <li>
                                	<a href="http://www.youku.com/?ocid=msnnavlinkgroup" target="_blank" title="优酷网">
                                    	<nobr>优酷网</nobr>
                                    </a>
                                </li>
                                <li>
                                	<a href="https://c.duomai.com/track.php?site_id=223050&aid=3720&euid=topsite&t=http%3A%2F%2Fvip.iqiyi.com%2F" target="_blank" title="爱奇艺">
                                    	<nobr>爱奇艺</nobr>
                                    </a>
                                </li>
                                <li>
                                	<a href="http://v.qq.com/?ocid=msnnavlinkgroup" target="_blank" title="腾讯视频">
                                    	<nobr>腾讯视频</nobr>
                                    </a>
                                </li>
                                <li>
                                	<a href="http://tv.sohu.com/?ocid=msnnavlinkgroup" target="_blank" title="搜狐视频">
                                    	<nobr>搜狐视频</nobr>
                                    </a>
                                </li>
                                <li>
                                	<a href="http://www.mgtv.com/" target="_blank" title="芒果TV">
                                    	<nobr>芒果TV</nobr>
                                    </a>
                                </li>
                                <li>
                                	<a href="http://www.bilibili.com/?ocid=msnnavlinkgroup" target="_blank" title="哔哩哔哩">
                                    	<nobr>哔哩哔哩</nobr>
                                    </a>
                                </li>
                                <li>
                                	<a href="http://www.huya.com/?ocid=msnnavlinkgroup" target="_blank" title="虎牙直播">
                                    	<nobr>虎牙直播</nobr>
                                    </a>
                                </li>
                                <li>
                                	<a href="https://www.douyu.com/?ocid=msnnavlinkgroup" target="_blank" title="斗鱼直播">
                                    	<nobr>斗鱼直播</nobr>
                                    </a>
                                </li>
                                <li>
                                	<a href="http://www.panda.tv/?ocid=msnnavlinkgroup" target="_blank" title="熊猫直播">
                                    	<nobr>熊猫直播</nobr>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <div class="item">
                            <div class="itemhead">
                                <h4>新闻</h4>
                            </div>
                            <hr>
                            <ul class="list link">
                                <li>
                                	<a href="http://news.sina.com.cn/" target="_blank" title="新浪新闻">
                                    	<nobr>新浪新闻</nobr>
                                    </a>
                                </li>
                                <li>
                                	<a href="http://www.ifeng.com/" target="_blank" title="凤凰网">
                                    	<nobr>凤凰网</nobr>
                                    </a>
                                </li>
                                <li>
                                	<a href="http://news.qq.com/" target="_blank" title="腾讯新闻">
                                    	<nobr>腾讯新闻</nobr>
                                    </a>
                                </li>
                                <li>
                                	<a href="http://www.people.com.cn/" target="_blank" title="人民网">
                                    	<nobr>人民网</nobr>
                                    </a>
                                </li>
                                <li>
                                	<a href="http://www.xinhuanet.com/" target="_blank" title="新华网">
                                    	<nobr>新华网</nobr>
                                    </a>
                                </li>
                                <li>
                                	<a href="http://www.ynet.com/" target="_blank" title="北青网">
                                    	<nobr>北青网</nobr>
                                    </a>
                                </li>
                                <li>
                                	<a href="http://news.163.com/" target="_blank" title="网易新闻">
                                    	<nobr>网易新闻</nobr>
                                    </a>
                                </li>
                                <li>
                                	<a href="http://news.sohu.com/" target="_blank" title="搜狐新闻">
                                    	<nobr>搜狐新闻</nobr>
                                    </a>
                                </li>
                                <li>
                                	<a href="http://weibo.com/" target="_blank" title="微博">
                                    	<nobr>微博</nobr>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <div class="item">
                            <div class="itemhead">
                                <h4>旅游</h4>
                            </div>
                            <hr>
                            <ul class="list link">
                                <li>
                                	<a href="http://u.ctrip.com/union/CtripRedirect.aspx?TypeID=2&Allianceid=349539&sid=832632&OUID=&app=0101F00&jumpUrl=http://www.ctrip.com" target="_blank" title="携程网">
                                    	<nobr>携程网</nobr>
                                    </a>
                                </li>
                                <li>
                                	<a href="https://c.duomai.com/track.php?k=wRHdo1Ddm0DZpVXZmITO5ETPklWYmATNwMjMy0DZp9VZ0l2cmYiJGJTJrVnLvNmLy92cpZHZhBXayRnL3d3dGJTJGJTJBNTJ" target="_blank" title="猫途鹰旅行">
                                    	<nobr>猫途鹰旅行</nobr>
                                    </a>
                                </li>
                                <li>
                                	<a href="https://c.duomai.com/track.php?site_id=223050&aid=3985&euid=&t=https%3A%2F%2Fssl.hotels.cn%2F" target="_blank" title="Hotels.com">
                                    	<nobr>Hotels.com</nobr>
                                    </a>
                                </li>
                                <li>
                                	<a href="http://p.yiqifa.com/07hwJ" target="_blank" title="艺龙网">
                                    	<nobr>艺龙网</nobr>
                                    </a>
                                </li>
                                <li>
                                	<a href="http://www.12306.cn/" target="_blank" title="12306">
                                    	<nobr>12306</nobr>
                                    </a>
                                </li>
                                <li>
                                	<a href="http://p.yiqifa.com/07hwK" target="_blank" title="遨游网">
                                    	<nobr>遨游网</nobr>
                                    </a>
                                </li>
                                <li>
                                	<a href="https://c.duomai.com/track.php?site_id=223050&aid=552&euid=linkgroup&t=http%3A%2F%2Fdujia.qunar.com%3Fex_track%3Dauto_52b3f121" target="_blank" title="去哪儿网">
                                    	<nobr>去哪儿网</nobr>
                                    </a>
                                </li>
                                <li>
                                	<a href="http://www.ly.com/?refid=224010082" target="_blank" title="同程旅游">
                                    	<nobr>同程旅游</nobr>
                                    </a>
                                </li>
                                <li>
                                	<a href="https://union.lvmama.com/tnt_cps/cps/newRedirect2.do?source=27877&keyword=7A6E4FAA4EC9F17333D3A9166FA19221F8D6B9DF5F085A160A124718237B4FF402A608B98AA4DFA6787F9501610DFB2BD8ACB284174406909BD73E986315E43175AFB8ECC6F3FF3DF1DBA1137D30C6F3B367A367A5B741CB6B4CC0DC3E19DC9E" target="_blank" title="驴妈妈旅行">
                                    	<nobr>驴妈妈旅行</nobr>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </li>
            	</c:otherwise>
            </c:choose>
                
            </ul>
        </div>
    </div>

    <div class="clear"></div>
    <div class="row footer">
        <div class="container">
            <div class="col-md-2 col-md-offset-1 col-xs-12">&copy; 2016 Macro</div>
            <div class="col-md-5 col-md-offset-4 col-xs-12">
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

    <div class="accountbox loginpanel">
        <div class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3">
            <form id="loginform" action="${pageContext.request.contextPath }/Account/login.action" method="post">
                <h3>登录</h3><br>
                <div class="col-md-6 col-sm-6">
                    <input type="hidden" name="password" id="pwd2">
                    <p>用户名</p>
                    <input type="text" name="username" id="user" maxlength="45">
                    <p>密码</p>
                    <input type="password" name="pwd" id="pwd" maxlength="32">
                    <p>验证码</p>
                    <input type="text" name="vcode" id="code" autocomplete="off">
                    <img class="verifyimg" src="${pageContext.request.contextPath }/Account/verifyImg.action" onclick="changeverify()" alt="验证码">
                </div>
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <p class="error errormsg"></p><br>
                        <ul class="list">
                            <li><button type="submit" class="accountbtn loginbtn">登录</button></li>
                            <li><button type="button" onclick="hideaccountbox()" class="accountbtn cancelbtn">取消</button></li>
                            <li><button type="button" onclick="showforgetpanel()" class="accountbtn forgetbtn">忘记密码</button></li>
                        </ul>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="accountbox forgetpanel">
        <div class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3">
            <form id="forgetform" action="${pageContext.request.contextPath }/Account/forgetPwd.action" method="post" autocomplete="off">
                <h3>忘记密码</h3><br>
                <div class="col-md-6 col-sm-6">
                    <p>用户名</p>
                    <input type="text" name="fgname" id="fgname">
                    <p>安全邮箱</p>
                    <input type="text" name="fgemail" id="fgemail">
                    <p>验证码</p>
                    <input type="text" name="fgcode" id="fgcode">
                    <img class="verifyimg" src="${pageContext.request.contextPath }/Account/verifyImg.action" onclick="changeverify()" alt="验证码">
                </div>
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <p class="error errormsg"></p><br>
                        <ul class="list">
                            <li><button type="submit" class="accountbtn forgetbtn2">确定</button></li>
                            <li><button type="button" onclick="hideaccountbox()" class="accountbtn cancelbtn">取消</button></li>
                        </ul>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="accountbox forget2panel">
        <div class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3">
            <form id="forget2form" action="${pageContext.request.contextPath }/Account/resetPwd.action" method="post" autocomplete="off">
                <h3>重置密码</h3><br>
                <div class="col-md-6 col-sm-6">
                    <input type="hidden" name="fguserid" id="fguserid">
                    <input type="hidden" name="fgnewpwd" id="fgnewpwd">
                    <input type="hidden" name="fgreppwd" id="fgreppwd">
                    <p>收到的验证码</p>
                    <input type="text" name="fgcode2" id="fgcode2">
                    <p>新密码</p>
                    <input type="password" name="fgnewpwd2" id="fgnewpwd2">
                    <p>确认密码</p>
                    <input type="password" name="fgreppwd2" id="fgreppwd2">
                </div>
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <p class="error errormsg"></p><br>
                        <ul class="list">
                            <li><button type="submit" class="accountbtn forgetbtn2">确定</button></li>
                            <li><button type="button" onclick="hideaccountbox()" class="accountbtn cancelbtn">取消</button></li>
                        </ul>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="accountbox addlinkpanel">
        <div class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3">
            <form id="addlinkform" action="${pageContext.request.contextPath }/Link/createLink.action" method="post">
                <h3>添加站点</h3><br>
                <div class="col-md-6 col-sm-6">
                    <input type="hidden" name="category_id" id="link_category_id">
                    <p>标题</p>
                    <input type="text" name="link_title" id="link_title" maxlength="60">
                    <p>Url</p>
                    <input type="text" name="link_url" id="link_url" placeholder="http://">
                </div>
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <p class="error errormsg"></p><br>
                        <ul class="list">
                            <li><button type="submit" class="accountbtn addlinkbtn">确定</button></li>
                            <li><button type="button" onclick="hideaccountbox()" class="accountbtn cancelbtn">取消</button></li>
                        </ul>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="accountbox updatelinkpanel">
        <div class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3">
            <form id="updatelinkform" action="${pageContext.request.contextPath }/Link/updateLink.action" method="post">
                <h3>修改站点</h3><br>
                <div class="col-md-6 col-sm-6">
                    <input type="hidden" name="ucategory_id" id="ulink_category_id">
                    <input type="hidden" name="ulink_id" id="ulink_id">
                    <p>标题</p>
                    <input type="text" name="ulink_title" id="ulink_title" maxlength="100">
                    <p>Url</p>
                    <input type="text" name="ulink_url" id="ulink_url">
                </div>
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <p class="error errormsg"></p><br>
                        <ul class="list">
                            <li><button type="submit" class="accountbtn updatelinkbtn">确定</button></li>
                            <li><button type="button" onclick="hideaccountbox()" class="accountbtn cancelbtn">取消</button></li>
                        </ul>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="accountbox addcategorypanel">
        <div class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3">
            <form id="addcategoryform" action="${pageContext.request.contextPath }/Category/createCategory.action" method="post">
                <h3>添加收藏夹</h3><br>
                <div class="col-md-6 col-sm-6">
                    <p>收藏夹名称</p>
                    <input type="text" name="category" id="category" maxlength="50">
                </div>
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <p class="error errormsg"></p><br>
                        <ul class="list">
                            <li><button type="submit" class="accountbtn addcategorybtn">确定</button></li>
                            <li><button type="button" onclick="hideaccountbox()" class="accountbtn cancelbtn">取消</button></li>
                        </ul>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="accountbox updatecatepanel">
        <div class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3">
            <form id="updatecateform" action="${pageContext.request.contextPath }/Category/updateCategory.action" method="post">
                <h3>修改收藏夹</h3><br>
                <div class="col-md-6 col-sm-6">
                    <p>收藏夹名称</p>
                    <input type="text" name="ucategory" id="ucategory" maxlength="50">
                    <input type="hidden" name="ucategory_id" id="ucategory_id">
                </div>
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <p class="error errormsg"></p><br>
                        <ul class="list">
                            <li><button type="submit" class="accountbtn updatecatebtn">确定</button></li>
                            <li><button type="button" onclick="hideaccountbox()" class="accountbtn cancelbtn">取消</button></li>
                        </ul>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="accountbox editlinkcatepanel">
        <div class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3">
            <form id="editlinkcateform" action="${pageContext.request.contextPath }/Link/editLinkCategory.action" method="post">
                <h3>移动到</h3><br>
                <div class="col-md-6 col-sm-6">
                    <p>收藏夹</p>
                    <select name="ecategory_id" id="ecategory_id">
                        <option value=""></option>
                        <c:forEach items="${categories }" var="c">
                            <option value="${c.categoryId }">${c.categoryName }</option>
                        </c:forEach>
                    </select>
                    <input type="hidden" name="elink_id" id="elink_id">
                </div>
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <p class="error errormsg"></p><br>
                        <ul class="list">
                            <li><button type="submit" class="accountbtn editlinkcatebtn">确定</button></li>
                            <li><button type="button" onclick="hideaccountbox()" class="accountbtn cancelbtn">取消</button></li>
                        </ul>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="accountbox addfavpanel">
        <div class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3">
            <form id="addfavform" action="${pageContext.request.contextPath }/Link/addFavLink.action" method="post">
                <h3>添加最爱站点</h3><br>
                <div class="col-md-6 col-sm-6">
                    <p>收藏夹</p>
                    <select name="fcategory_id" id="fcategory_id" onchange="getlinks(this)">
                        <option value=""></option>
                        <c:forEach items="${categories }" var="c">
                            <option value="${c.categoryId }">${c.categoryName }</option>
                        </c:forEach>
                    </select>
                    <p>站点</p>
                    <select name="flink_id" id="flink_id">
                        <option value=""></option>
                    </select>
                </div>
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <p class="error errormsg"></p><br>
                        <ul class="list">
                            <li><button type="submit" class="accountbtn addfavbtn">确定</button></li>
                            <li><button type="button" onclick="hideaccountbox()" class="accountbtn cancelbtn">取消</button></li>
                        </ul>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="accountbox registerpanel">
        <div class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3">
            <form id="registerform" action="${pageContext.request.contextPath }/Account/register.action" method="post" autocomplete="off">
                <h3>注册</h3><br>
                <div class="col-md-6 col-sm-6">
                    <input type="hidden" name="regpwd" id="regpwd">
                    <input type="hidden" name="rregpwd" id="rregpwd">
                    <p>用户名</p>
                    <input type="text" name="reguser" id="reguser">
                    <p>密码</p>
                    <input type="password" name="regpwd2" id="regpwd2">
                    <p>再次输入密码</p>
                    <input type="password" name="rregpwd2" id="rregpwd2">
                    <p>安全邮箱</p>
                    <input type="text" name="regemail" id="regemail">
                    <p>验证码</p>
                    <input type="text" name="regcode" id="regcode">
                    <img class="verifyimg" src="${pageContext.request.contextPath }/Account/verifyImg.action" onclick="changeverify()" alt="验证码">
                </div>
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <p class="error errormsg"></p><br>
                        <ul class="list">
                            <li><button type="submit" class="accountbtn registerbtn">注册</button></li>
                            <li><button type="button" onclick="hideaccountbox()" class="accountbtn cancelbtn">取消</button></li>
                        </ul>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery.md5.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery.form.js"></script>
    <script src="${pageContext.request.contextPath }/js/app.js"></script>
    <script src="${pageContext.request.contextPath }/js/form.js"></script>
</body>

</html>