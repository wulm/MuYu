<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<base href="<%=basePath%>">
<title>鸣心--
<c:if test="${sessionScope.activitiesType eq '1' }">校友会</c:if>
<c:if test="${sessionScope.activitiesType eq '2' }">毕业季</c:if>
<c:if test="${sessionScope.activitiesType eq '3' }">素质拓展</c:if>
<c:if test="${sessionScope.activitiesType eq '4' }">亲子活动</c:if>
</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="green">
<script src="<%=basePath%>WeixinPages/common/js/mui.min.js"></script>
<link href="<%=basePath%>WeixinPages/common/css/mui.min.css"
	rel="stylesheet" />
<script type="text/javascript">
	// 对浏览器的UserAgent进行正则匹配，不含有微信独有标识的则为其他浏览器
	var useragent = navigator.userAgent;
	if (useragent.match(/MicroMessenger/i) != 'MicroMessenger') {
		// 这里警告框会阻塞当前页面继续加载
		alert('已禁止本次访问：您必须使用微信内置浏览器访问本页面！');
		// 以下代码是用javascript强行关闭当前页面
		var opened = window.open('about:blank', '_self');
		opened.opener = null;
		opened.close();
	}
</script>
<script>
	mui.init({
		swipeBack : false
	//启用右滑关闭功能
	});
</script>
</head>

<body>
	<div class="mui-content mui-card" style="margin-bottom: 15px;" >

		<ul class="mui-table-view">
			<c:if
				test="${sessionScope.activitiesPublicityList==null || fn:length(sessionScope.activitiesPublicityList) == 0}">
				<li>暂无数据</li>
			</c:if>
			<c:forEach items="${sessionScope.activitiesPublicityList}" var="item">
				<li class="mui-table-view-cell mui-media">
					<a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=${sessionScope.appID}&redirect_uri=http://mingxin.imwork.net/MX_System/activitiesPublicity!gotoActivitiesDetail.action?publicityDataId=${item.publicityDataId}&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect">
						<img class="mui-media-object mui-pull-left"  src="${item.coverImageUrl}">
						<div class="mui-media-body" style="color:black" >
							${item.articleTitle}
							<p class="mui-ellipsis" style="color:#87CEFA" >${item.articleAbstract}</p>
						</div> 
					</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>
