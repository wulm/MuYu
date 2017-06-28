<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<meta name="viewport" content="width=device-width, user-scalable=no">
<meta http-equiv="Access-Control-Allow-Origin" content="*">
<!-- 强制让文档的宽度与设备的宽度保持1:1，并且文档最大的宽度比例是1.0，且不允许用户点击屏幕放大浏览 -->
<meta name="viewport"
	content="initial-scale=1, maximum-scale=1, user-scalable=no, width=device-width, minimal-ui">
<!-- iphone设备中的safari私有meta标签，它表示：允许全屏模式浏览 -->
<meta name="apple-mobile-web-app-capable" content="yes">
<head>
<title>编辑文章页面</title>
<!--标准mui.css-->
<link rel="stylesheet"
	href="<%=basePath%>WeixinPages/common/css/mui.min.css">
<script src="<%=basePath%>WeixinPages/common/imgDeal/dist/lrz.bundle.js?v=09bcc24"></script>
	<script src="<%=basePath%>WeixinPages/common/js/jquery-1.11.2.js"></script>
<script type="text/javascript">
function test(){
	alert(1111);
}
$("#imgBtn").change(function(){ 
	alert(222);
})
</script>
<style type="text/css">

.footer-btn {
  text-align: center;
  padding-top: 1px;
}
.footer-btn .upload-img {
  height: 5%;
  min-height:25px;
  display: inline-block;
  vertical-align: bottom;
  width: 25px;
  margin-right: 10px;
  background-size: 100%;
}
.input-file-css{
	position:absolute;
	left:0;
	opacity:0;
	width:100%;
}

</style>
</head>
<body>
	
	
		
	
		<div class="footer-btn " >
		<!--img上传文件-->
			<span ><i class="mui-icon mui-icon-image"></i>插入图片</span> 
			<input type="file" id="imgBtn" onchange="test2();" capture="camera"  accept="image/*"  name="logo" id="file" class="input-file-css">
		</div>
		<div class="SubBtn">
			<button class="mui-btn mui-btn-success"
					style="width:80%;height:35px;"
					onclick="test();">发布文章</button>
		</div>
	
</body>
</html>

