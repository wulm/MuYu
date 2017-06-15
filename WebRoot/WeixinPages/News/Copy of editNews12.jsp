<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.weixin.pojo.SNSUserInfo,java.lang.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<base href="<%=basePath%>">
<title>添加新闻</title>
	<meta http-equiv="Access-Control-Allow-Origin" content="*">
	<!-- 强制让文档的宽度与设备的宽度保持1:1，并且文档最大的宽度比例是1.0，且不允许用户点击屏幕放大浏览 -->
	<meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no, width=device-width, minimal-ui">
	<!-- iphone设备中的safari私有meta标签，它表示：允许全屏模式浏览 -->
	<meta name="apple-mobile-web-app-capable" content="yes">
<link rel="stylesheet" href="<%=basePath%>WeixinPages/common/richtext/css/style.css">
</head>
<body>
	<div style="width:320px;margin: 0 auto;">
		<div class="publish-article-title">
			<div class="title-tips">标题</div>
			<input type="text" id="title" class="w100" placeholder="文章标题">
		</div>
		<div class="publish-article-content">
			<div class="title-tips">正文</div>
			<div class="article-content" id="content">
			</div>
			<div class="footer-btn g-image-upload-box">
				<div class="upload-button">
					<span class="upload"><i class="upload-img"></i>插入图片</span>
					<input class="input-file" id="imageUpload" type="file" name="fileInput" capture="camera" accept="image/*" style="position:absolute;left:0;opacity:0;width:100%;">
				</div>
			</div>
		</div>
		<div>
			<!-- <a href="#" onClick="onCommit();">提交</a> -->
			 <button type="button" id="save" onClick="onCommit();">提交</button>
		</div>
	</div>
<script src="<%=basePath%>WeixinPages/common/richtext/js/jquery-1.11.2.js"></script>
<script src="<%=basePath%>WeixinPages/common/richtext/js/artEditor.min.js"></script>
<script src="<%=basePath%>WeixinPages/common/richtext/js/index.js"></script>
<script type="text/javascript">
	//接收参数
	var code = "${code}";
	var state = "${state}";
	//提交事件
	function onCommit(){
		  var title = $("#title").val().trim();
		  var content = $("#content").getValue();//jQuery("#content").val().trim();
		  console.log(title);
		  console.log(content);
		  var data = { 
					title:title,
					content:content,
					code:code,
					state:state
		  }
		  //请求添加数据
			$.ajax({
				type : "POST",
				url : 'http://d1a7069951.iask.in/MX_System/weixin!addNews.action',
				data : data,
				success : function(data) {
					if (data.success) {
						console.log("success");
						//resultPage("success");
/* 						$.messager.show({
							msg : data.message,
							title : '提示'
						}); */
					} else {
						console.log(type);
					/* 	parent.$.messager.alert("错误", data.message, "error", function() {
							return false;
						}); */
					}
				},
				error : function(e) {
					/* parent.$.messager.alert("提示", "操作失败，请联系管理员."); */
				}
			});
	}
</script>
</body>

