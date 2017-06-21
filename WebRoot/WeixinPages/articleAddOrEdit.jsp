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
	<link href="<%=basePath%>WeixinPages/common/css/mui.picker.css" rel="stylesheet" />
	<link href="<%=basePath%>WeixinPages/common/css/mui.poppicker.css" rel="stylesheet" />
	
  </head>
  
  <body>
  		
			<div style="width:100%;height:100%;" class="mui-content">
		<div class="mui-content-padded">
			<form class="mui-input-group">

				<div class="mui-input-row">
					<label>类别</label>
					<select >
						<option value="item-1">2016年木羽梦札</option>
						<option value="item-2">2017年木羽梦札</option>
						<option value="item-3">一饮一啄</option>
						<option value="item-4">木羽杂记</option>
					</select>
				</div>

				<div class="mui-input-row">
					<label>标题</label>
					<input type="text" class="mui-input-clear" placeholder="输入文章标题">
				</div>
				
				<div class="mui-input-row">
					<label>作者</label>
					<input type="text" class="mui-input-clear" placeholder="输入笔名">
				</div>
				
				<div class="mui-input-row" style="margin: 10px 5px;height:150px;">
					<textarea id="textarea" rows="5" placeholder="文章引言"></textarea>
				</div>
				
			</form>
		</div>
    	</div>
  </body>
</html>
