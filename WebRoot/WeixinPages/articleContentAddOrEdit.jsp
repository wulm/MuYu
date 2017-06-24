<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>artEditor</title>
<meta http-equiv="Access-Control-Allow-Origin" content="*">
<!-- 强制让文档的宽度与设备的宽度保持1:1，并且文档最大的宽度比例是1.0，且不允许用户点击屏幕放大浏览 -->
<meta name="viewport"
	content="initial-scale=1, maximum-scale=1, user-scalable=no, width=device-width, minimal-ui">
<!-- iphone设备中的safari私有meta标签，它表示：允许全屏模式浏览 -->
<meta name="apple-mobile-web-app-capable" content="yes">
<script src="<%=basePath%>WeixinPages/common/js/jquery-1.11.2.js"></script>
<script
	src="<%=basePath%>WeixinPages/common/richtext/js/artEditor.min.js"></script>
<link rel="stylesheet"
	href="<%=basePath%>WeixinPages/common/richtext/css/style.css">
</head>
<body>
	<div style="width:100%;margin: 0 auto;">
		
		<div class="publish-article-content" style="height:100%;">
			<div class="title-tips">正文</div>
			<input type="hidden" id="target">
			<div class="article-content" id="ArticleContent" name="ArticleContent" style="height:350px;">
			</div>
			<div class="footer-btn g-image-upload-box" style="height:65px;">
				<div class="upload-button">
					<span class="upload"><i class="upload-img"></i>插入图片</span>
					<input class="input-file" id="imageUpload" type="file" 
						name="imageUpload" capture="camera" accept="image/*" 
						style="position:absolute;left:0;opacity:0;width:100%;">
				</div>
				</br>
			
				<button style="float:left;width:50%;height:35px;" onclick="saveArticleBuff();">保存草稿</button>
				<button style="float:left;width:50%;height:35px;" onclick="savePublishArticle();">发布文章</button>
			</div>
		</div>
	</div>
	<script>
	function saveArticleBuff(){
		var txt=$("#content").getValue();
		alert(txt);
	}
	</script>
	<script>
		$(function() {
			"use strict";
			$('#ArticleContent').artEditor({
				imgTar: '#imageUpload',
				limitSize: 5,   // 图片不超过2兆
				showServer: true,//这里改成true
				uploadUrl: 'article!UploadImage.action',//图片上传方法
				data: {},
				uploadField: 'image',
				placeholader: '<p>请输入文章正文内容</p>',
				validHtml: ["br"],
				uploadSuccess: function(res) {
					//$("#demon").apppend("<img src="'+res.Date.Url+'">");//此处作为接收路径
					alert(res.path);
					return res.path;
				},
				uploadError: function(res) {
					console.log(res);
				}
			});
		});
	</script>
</body>
</html>


