<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ page import ="com.bean.SysUsers"%>
<% SysUsers currentUser=(SysUsers)session.getAttribute("currentUser"); %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>系统主页</title>
<link rel="stylesheet"
	href="<%=basePath%>/Pages/common/css/pintuer.css">
<link rel="stylesheet" href="<%=basePath%>/Pages/common/css/admin.css">
<script src="<%=basePath%>/Pages/common/js/jquery.js"></script>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
</head>
<body style="background-color:#f2f9fd;">
	<div class="header bg-main">
		<div class="logo margin-big-left fadein-top">
			<h1>
				<img src="<%=basePath%>/Pages/common/images/y.jpg"
					class="radius-circle rotate-hover" height="50" alt="" />
					后台管理中心
			</h1>
		</div>
		
		<div class="head-l">
		
			<a class="button button-little bg-green"  style="padding:5px 10px" href="userLogin!logOut.action">
			<span class="icon-power-off"></span> 退出登录</a>
		</div>
		
		<div class="head-l">
		<h3>当前登录：<font color="white"><%=currentUser.getUserName() %></font></h3></div>
	</div>
	<div class="leftnav">
		<h2>
			<span class="icon-pencil-square-o"></span>案卷管理
		</h2>
		<ul style="display:block">
			<li><a href="Pages/file_List.jsp" target="right"><span
					class="icon-caret-right"></span>案卷列表</a></li>
			<li><a href="Pages/file_AddEdit.jsp" target="right"><span
					class="icon-caret-right"></span>新建案卷</a></li>
		</ul>
		
		
		<%if(currentUser.getUserType()==0){ %>
		<h2>
			<span class="icon-user"></span>用户管理
		</h2>
		<ul style="display:block">
			<li><a href="Pages/user_List.jsp" target="right"><span
					class="icon-caret-right"></span>用户列表</a></li>
			<li><a href="Pages/error.jsp" target="right"><span
					class="icon-caret-right"></span>权限分配</a>
			</li>
			
		</ul>
			
		<h2>
			<span class="icon-wrench"></span>系统管理
		</h2>
		<ul style="display:block">
			<li><a href="Pages/error.jsp" target="right"><span
					class="icon-caret-right"></span>运行数据</a></li>
			<li><a href="Pages/error.jsp" target="right"><span
					class="icon-caret-right"></span>关闭系统</a></li>
		</ul>
		 <%} %>
		 
	</div>
	<%--<div class="leftnav-hideBtn"><!-- 隐藏树控件按钮 --></div>
	--%><%-- <ul class="bread">
		<li>
		<%if(currentUser.getUserType()==0){ %>
		<a href="Pages/user_List.jsp" target="right" class="icon-home"> 
		回到首页</a>
		<%}else{ %>
		<a href="userList.action" target="right" class="icon-home"> 
		回到首页</a>
		<%} %>
		</li>
	</ul> --%>
	<div class="admin">
	<%if(currentUser.getUserType()==0){ %>
		<iframe scrolling="auto" style="height:99%;" rameborder="0" src="Pages/user_List.jsp" name="right"
			width="100%" height="100%"></iframe> 
	<%}else{ %>
		<iframe scrolling="auto" style="height:99%;" rameborder="0" src="Pages/error.jsp" name="right"
			width="100%" height="100%"></iframe>
	<%} %>
	</div>
	
</body>
</html>
