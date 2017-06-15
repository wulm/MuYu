<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>系统主页</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
-->
<link rel="stylesheet" href="jqueryui/style.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://jqueryui.com/resources/demos/style.css">
<script type="text/javascript"
	src="<%=basePath%>Pages/common/js/admin.js"></script>
<link rel="stylesheet" href="<%=basePath%>Pages/common/css/admin.css">
</head>
<%--使用jqueryUi中做左边功能导航
	折叠面板-自定义图标-非自动高度-当悬停时打开
		菜单 Menu
	
			
		
--%>
<body>
	<div id="headDiv"></div>
	<div id="left-menu">
		<div id="accordion">
			<div style="font-weight:bold;">案卷管理</div>
			<div id="left-menu-li">
			
				<a href="#"><span class="ui-icon ui-icon-play"></span>案卷列表</a>
				
				<a href="#"><span class="ui-icon ui-icon-play"></span>新建案卷</a>
				
			</div>

			<div>用户管理</div>
			<div>666</div>
			<div>系统管理</div>
			<div>
				888
				<ul>
					<li>List item one</li>
					<li>List item two</li>
					<li>List item three</li>
				</ul>
			</div>

		</div>
	</div>
	<div id="hide-button"></div>
	<div id="main-content">555555</div>
	<div id="footer-copyright">wulm</div>
</body>
</html>
