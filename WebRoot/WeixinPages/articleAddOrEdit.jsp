<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'articleEdit.jsp' starting page</title>
   <!--标准mui.css-->
	<link rel="stylesheet" href="<%=basePath%>WeixinPages/common/css/mui.min.css">
	<!--App自定义的css-->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>WeixinPages/common/css/app.css" />
	<script src="<%=basePath%>WeixinPages/common/js/mui.min.js"></script>

  </head>
  
  <body>
  		
			
		
			<form class="mui-input-group">
				<div class="mui-input-row">
					<label>缩略图</label>
					<input type="text" class="mui-input-clear" placeholder="输入图片url">
				</div>
			
				<div class="mui-input-row">
					<label>类型</label>
					<input type="text" class="mui-input-clear" placeholder="输入文章类型">
				</div>
				
				<div class="mui-input-row">
					<label>标题</label>
					<input type="text" class="mui-input-clear" placeholder="输入文章标题">
				</div>
				
				<div class="mui-input-row">
					<label>作者</label>
					<input type="text" class="mui-input-clear" placeholder="输入笔名">
				</div>
				
				<div class="mui-input-row" style="margin: 10px 5px;">
					<textarea id="textarea" rows="5" placeholder="文章引言"></textarea>
				</div>
				
				<div class="mui-input-row">
					<label>其他</label>
					<input type="text" class="mui-input-clear" placeholder="输入其他文章描述">
				</div>
				
			</form>
		
    	
  </body>
</html>
