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

				<div class="LUploader" id="demo1">
					<div class="LUploader-container">
						<input data-LUploader='demo1' data-form-file='basestr'
							data-upload-type='front' type="file" />
						<ul class="LUploader-list"></ul>
					</div>
					<div>
						<div class="icon icon-camera font20"></div>
						<p>单击上传</p>
					</div>
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
				placeholader: '<p>请输入文章正文内容</p>'
		});
	</script>


	<script>
	function uploadFile(obj) {
		var that=obj;
		var d = dialog({
            content: '确定插入图片？',
            okValue: '确 定',
            ok: function() {
				new LUploader(that, {
            		url: 'http://182.254.140.92/DancingAngel/lisihua/Qq_Cooperation/Qq_Cooperation/yii-advanced-app-2.0.6/frontend/web/index.php?r=yuanbao/verify/ajax-upload-pic',//post请求地址
            		multiple: false,//是否一次上传多个文件 默认false
            		maxsize: 102400,//忽略压缩操作的文件体积上限 默认100kb
            		accept: 'image/jpg,image/jpeg,image/png',//可上传的图片类型
            		quality: 0.2,//压缩比 默认0.1  范围0.1-1.0 越小压缩率越大
            		showsize:false//是否显示原始文件大小 默认false
        		});
				
         	},
            cancelValue: '取消',
            cancel: function() {}
        });
		var nf = obj.cloneNode(true);
		nf.value=''; // 设计新控件value为空
  		obj.parentNode.replaceChild(nf, obj);
  		
        d.showModal();
        //return false;
	}
	</script>
</body>
</html>


