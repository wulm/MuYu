<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Pages/common/themes/material/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Pages/common/themes/icon.css">
	<script type="text/javascript" src="<%=basePath%>Pages/common/js/jquery.min.js"></script>
	<script type="text/javascript" charset="gbk" src="<%=basePath%>Pages/common/js/jquery.easyui.min.js"></script>
	<script type="text/javascript"><%--
	$("#test").click(function () {
		alert(255455);
		//$("#test").val("dddddddd");
    });
	
	--%></script>
  </head>
  
  <body>
    <div>
			<input id="test" type="button" onclick="alert(55555)" value="测试"/>
		</div>
  </body>
</html>
