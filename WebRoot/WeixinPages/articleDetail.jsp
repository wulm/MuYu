<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<base href="<%=basePath%>">
<title>
	<c:if test="${sessionScope.article==null}"></c:if>
	${sessionScope.article.articleTitle}
</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="green">
<script src="<%=basePath%>WeixinPages/common/js/mui.min.js"></script>
<link href="<%=basePath%>WeixinPages/common/css/mui.min.css"
	rel="stylesheet" />
<script>
		mui.init({
			swipeBack:false //启用右滑关闭功能
		});
	</script>
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


</head>

<body>
	<div class="mui-content mui-card" style="margin-bottom: 15px;">

		<ul class="mui-table-view">
			<c:if
				test="${sessionScope.article==null}">
				<li>暂无数据</li>
			</c:if>
			<div class="mui-media-body">
				${sessionScope.article.articleContent}</div>
	</div>
</body>
</html>
