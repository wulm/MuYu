<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>WeixinPages/common/css/wangEditor-mobile.css">
<script type="text/javascript"
	src="<%=basePath%>WeixinPages/common/js/zepto.js"></script>
<script type="text/javascript"
	src="<%=basePath%>WeixinPages/common/js/zepto.touch.js"></script>
<script type="text/javascript"
	src="<%=basePath%>WeixinPages/common/js/wangEditor-mobile.js"></script>
<!--标准mui.css-->
<link rel="stylesheet"
	href="<%=basePath%>WeixinPages/common/css/mui.min.css">
<!--App自定义的css-->
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>WeixinPages/common/css/app.css" />
<script src="<%=basePath%>WeixinPages/common/js/mui.min.js"></script>

<script type="text/javascript"
	src="<%=basePath%>WeixinPages/common/js/ajaxfileupload.js"></script>
</head>
<body>
	<div class="mui-content" >

		<form method="post" enctype="multipart/form-data"
			onsubmit="return toVaild()">
			<ul class="mui-table-view">
				<li class="mui-table-view-cell mui-collapse">
				<span>正文</span>
				</li>
				</ul>

			<div class="mui-input-row" style="height:400px;">
				<textarea id="ArticleContent" name="ArticleContent" rows="10"
					placeholder="输入文章" style="width:100%;height:80%;"></textarea>
			</div>
			<div style="height:65px;align:center;">


				<button type="button"
					class="mui-btn mui-btn-danger mui-btn-outlined">
					<span class="mui-icon mui-icon-trash"></span> 插入图片
				</button>
				<input id="imageUpload" type="file" 
					name="imageUpload" id="imageUpload" capture="camera"
					accept="image/*"
					style="position:absolute;left:0;opacity:0;width:100%;"><%-- onchange="uploadImg(this)"
					--%><input class="mui-btn mui-btn-primary" type="submit" value="保存草稿" />
					<input class="mui-btn mui-btn-primary" type="submit" value="发布文章" />
			</div>
		</form>
	</div>

	</div>
	<script>
		mui.init({
			swipeBack : false
		//启用右滑关闭功能
		});
	</script>
	<script type="text/javascript">
		$(function() {

			// 全局配置
			// ___E.config.menus = ['bold', 'color', 'quote'];

			// 生成编辑器
			var editor = new ___E('ArticleContent');

			// 自定义配置
			editor.config.uploadImgUrl = 'article!UploadImage.action';//article!UploadImage.action

			editor.config.data=$('#yourformid').serialize(),// 你的formid
			
			//editor.config.uploadTimeout=30000;//设置图片上传超时时间为30s

			editor.config.menus = [ 'img','bold', 'color', 'quote', 'list' ];//选择菜单按钮，默认显示所有

			// 初始化
			editor.init();

			console.log(editor.$txt);
		});
	</script>

	<script type="text/javascript">
		function test(){
			alert("dfsjdkg");
		}
	</script>

	<script>
		function uploadImg(obj) {

			$.ajaxFileUpload({
						url : "article!UploadImage.action",
						secureuri : false,// 一般设置为false
						fileElementId : "imageUpload",// 文件上传表单的id <input type="file" id="fileUpload" name="file" />
						dataType : 'json',// 返回值类型 一般设置为json
						data : {},

						success : function(data, status) // 服务器成功响应处理函数
						{
							//alert(data.message);
							//alert(data.imgUrl);
							var txt=document.getElementById("ArticleContent")
							var img=document.createElement("IMG");
							img.src=data.imgUrl;
							txt.appendChild(o);
							//document.getElementById("ArticleContent").innerHTML += "<img style='width:80%;' src='"
							//		+ data.imgUrl + "'>" + "<br />";
						},
						error : function(data)// 服务器响应失败处理函数
						{
							console.log("服务器异常");
						}
					});
			return false;
		}
	</script>
</body>
</html>


