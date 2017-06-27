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
<script
	src="<%=basePath%>WeixinPages/common/richtext/js/artEditor.min.js"></script>
<!--标准mui.css-->
<link rel="stylesheet"
	href="<%=basePath%>WeixinPages/common/css/mui.min.css">
<!--App自定义的css-->
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>WeixinPages/common/css/app.css" />
<script src="<%=basePath%>WeixinPages/common/js/mui.min.js"></script>
<link rel="stylesheet"
	href="<%=basePath%>WeixinPages/common/richtext/css/style.css">
<script type="text/javascript"
	src="<%=basePath%>WeixinPages/common/js/ajaxfileupload.js"></script>
<script src="<%=basePath%>WeixinPages/common/js/dialog.js"></script>
<script>
  	window.onload = function() {
  		$('#ArticleContent').setValue('${articleContent.articleContent}');//设置富文本框的内容
  	}
  	</script>

</head>
<body>
	<div style="width:100%;margin: 0 auto;">

		<div class="publish-article-content" style="height:100%;">
			<div class="title-tips">
				文章正文
				<div style="float:right;">
					<a href="javascript:void(0)" onclick="setTxtIndent();">段落首行缩进</a>
				</div>
			</div>
			<div class="article-content" id="ArticleContent"
				name="ArticleContent" style="height:350px;"></div>
			<div class="footer-btn g-image-upload-box" style="height:75px;">
					<div class="upload-button">
						<span class="upload"><i class="upload-img"></i>插入图片</span> 
						<input class="input-file" id="imageUpload" type="file"
							name="imageUpload" id="imageUpload" capture="camera" accept="image/*"
							style="position:absolute;left:0;opacity:0;width:100%;">


					</div>
					<br>
				<button class="mui-btn mui-btn-success"
					style="width:80%;height:35px;"
					onclick="saveArticleContent(${article.articleId});">发布文章</button>

			</div>
		</div>

	</div>
	<script>
	function saveArticleContent(articleId){
            var d = dialog({
                content: '确定发布文章？',
                okValue: '确 定',
                ok: function() {
                	//window.opener.location.href=window.opener.location.href; 
                	var txt='<div>'+$("#ArticleContent").getValue()+'</div>';//获取富文本框输入的内容
  					//var txtEncode=encodeURI(txt);
  					var txtEncode=encodeURI(txt); //对文本框内容进行编码
  					//txtEncode=encodeURI(txt); //对文本框内容进行编码
  					//alert(txtEncode);
  					var url="article!DoSaveArticleContent.action?articleId="+articleId+"&articleContent="+txtEncode;
        			window.location.href=url;
                	dialog().showModal();
                },
                cancelValue: '取消',
                cancel: function() {}
            });

            d.showModal();
        }
    </script>

	<script>
	function saveArticleBuff(articleId){
		//$('#ArticleContent').setValue('<div></div>');//设置富文本框的内容
		var txt='<div>'+$("#ArticleContent").getValue()+'</div>';//获取富文本框输入的内容
		
		alert(txt);
	}
	</script>
	<script>
	function setTxtIndent(){
		alert("vvvvv");
		$div = $('#ArticleContent').children('div');
		$div.each(
			function(){
				$div.style.text-indent='2em';
			//这里可以对每一个div进行操作
			}
		);
		}
	</script>

	<script>
		$(function() {
			$('#ArticleContent').artEditor({
				imgTar: '#imageUpload',
			    limitSize: 5,   // 兆
			    showServer: false,
			    uploadUrl: '',
			    data: {},
			    uploadField: 'image',
			    placeholader: '<p>请输入文章正文内容</p>',
			    validHtml: ["br"]
			
		});
	</script>


	<script>
	function uploadFile(obj) {
		var d = dialog({
            content: '确定插入图片？',
            okValue: '确 定',
            ok: function() {
				$.ajaxFileUpload({
					url : "article!UploadImage.action",
					secureuri : false,// 一般设置为false
					fileElementId : "imageUpload",// 文件上传表单的id <input type="file" id="fileUpload" name="file" />
					dataType : 'json',// 返回值类型 一般设置为json
					data: {},
			
					success : function(data, status) // 服务器成功响应处理函数
					{
						alert(data.message);
						alert(data.imgUrl);
						document.getElementById("ArticleContent").innerHTML += "<img style='width:90%;' src='"+data.imgUrl+"'>"
							+ "<br />";
	                },
					error : function(data)// 服务器响应失败处理函数
					{
						console.log("服务器异常");
					}
				});
            },
            cancelValue: '取消',
            cancel: function() {}
        });

        d.showModal();
        //return false;
	}
	</script>
</body>
</html>


