<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
    <title>文章编辑</title>
   <!--标准mui.css-->
	<link rel="stylesheet" href="<%=basePath%>WeixinPages/common/css/mui.min.css">
	<!--App自定义的css-->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>WeixinPages/common/css/app.css" />
	<script src="<%=basePath%>WeixinPages/common/js/mui.min.js"></script>
	
  	<script>
  	mui.init();
  	window.onload = function() { 
  		var select=document.getElementById("articleType");
  	    for(var i=0; i<select.options.length; i++){  
  	     	if(select.options[i].value == '${article.articleType}'){  
  	     		select.options[i].selected = true;  
  	     	 } 
  	    }
  	}; 
  	</script>
  	<script type="text/javascript">
  	var url;
  	if(${article.articleId}==null){
			url = "article!DoAddArticle.action";
		}else{
			url = "article!DoUpdateArticle.action";
		}
  	$.ajax({
        type: "POST",
        url:url,
        data:$('#articleEdit').serialize(),// 序列化表单值
        async: false,
        error: function(request) {
            alert("Connection error");
        },
        success: function(data) {
            window.location.href="跳转页面"
        }
    });
  	
  	</script>
  	
  <script type="text/javascript" src="<%=basePath%>WeixinPages/common/js/jquery-1.11.2.js"></script>
  
  </head>
  
  <body>
  	<div style="width:100%;" class="mui-content">
		<div class="mui-content-padded">
			<form class="mui-input-group" id="articleEdit" method="post" name="articleEdit">
				<input id="articleId" type="hidden" value="${article.articleId}"/>
				<input id="articleTitleImageUrl" type="hidden" value="${article.articleTitleImageUrl}"/>
				<input id="createDate" type="hidden" value="${article.createDate}"/>
				<div class="mui-input-row">
					<label>类别</label>
					<select id="articleType" >
						<option value="0">请选择</option>
						<option value="2">2017年木羽梦札</option>
						<option value="1">2016年木羽梦札</option>
						<option value="3">一饮一啄</option>
						<option value="4">木羽杂记</option>
					</select>
				</div>

				<div class="mui-input-row">
					<label>标题</label>
					<input id="articleTitle" type="text" class="mui-input-clear" placeholder="输入文章标题"
						 value="${article.articleTitle}">
				</div>
				
				<div class="mui-input-row">
					<label>作者</label>
					<input id="writerName" type="text" class="mui-input-clear" placeholder="输入笔名" value="${article.writerName}">
				</div>
				<h4 class="mui-content-padded">引言</h4>
				<div class="mui-input-row" style="margin: 10px 5px;height:160px;">
					<textarea id="articleLeadText" rows="5" placeholder="输入文章引言" >${article.articleLeadText}</textarea>
				</div>
				<button type="submit" class="mui-btn mui-btn-primary mui-btn-block" onclick="saveAndGotoContent();">保存并编辑正文</button>
				
			</form>
		</div>
    </div>
  </body>
</html>
