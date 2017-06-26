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
<link rel="stylesheet"
	href="<%=basePath%>WeixinPages/common/richtext/css/style.css">
<script type="text/javascript"
	src="<%=basePath%>WeixinPages/common/js/ajaxfileupload.js"></script>
<script src="<%=basePath%>WeixinPages/common/js/dialog.js"></script>

<script src="<%=basePath%>WeixinPages/common/js/lrz.bundle.js"></script>
<%--<script src="<%=basePath%>WeixinPages/common/js/imgDeal.js"></script>

--%>
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
				<form method="post" enctype="multipart/form-data" id="myForm" name="myForm">
					<div class="upload-button">
						<span class="upload"><i class="upload-img"></i>插入图片</span> 
						<input
							class="input-file" id="imageUpload" type="file"
							 onchange="uploadFile(this)" name="imageUpload" id="imageUpload"
							capture="camera" accept="image/*"
							style="position:absolute;left:0;opacity:0;width:100%;">
					</div>
					<br>
				</form>
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
  					var txtEncode=encodeURI(txt); 
  					txtEncode=encodeURI(txt); 
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
		$(function() {
			$('#ArticleContent').artEditor({
				placeholader: '<p>请输入文章正文内容</p>',
			});
		});
	</script>


	<script>
	function uploadFile(obj){
		
            	alert(obj.files[0]);
            	// this.files[0] 是用户选择的文件
                lrz(this.files[0], {width: 800})
                    .then(function (rst) {
                    	alert("1111");
                        // 把处理的好的图片给用户看看呗
                        var img = new Image();
                        img.src = rst.base64;
                        alert("222");
                       // img.onload = function () {
                        	//document.getElementById("ArticleContent").innerHTML += "<img style='width:90%;' src='"+data.imgUrl+"'>";
                        document.getElementById("ArticleContent").appendChild(img);
                            //document.body.appendChild(img);
                       // };
                        return rst;
                    })
                    .then(function (rst) {
                        // 这里该上传给后端啦
                        /* ==================================================== */
                        // 原生ajax上传代码，所以看起来特别多 ╮(╯_╰)╭，但绝对能用
                        // 其他框架，例如jQuery处理formData略有不同，请自行google，baidu。
                        var xhr = new XMLHttpRequest();
                        xhr.open('POST', 'article!UploadImage.action');
                        xhr.onload = function () {
                            if (xhr.status === 200) {
                                // 上传成功
                            } else {
                                // 处理其他情况
                            }
                        };
                        xhr.onerror = function () {
                            // 处理错误
                        };
                        xhr.upload.onprogress = function (e) {
                            // 上传进度
                            var percentComplete = ((e.loaded / e.total) || 0) * 100;
                        };
                        // 添加参数
                        rst.formData.append('fileLen', rst.fileLen);
                        //rst.formData.append('xxx', '我是其他参数');
                        // 触发上传
                        xhr.send(rst.formData);
                        /* ==================================================== */
                        return rst;
                    })
                    .catch(function (err) {
                        // 万一出错了，这里可以捕捉到错误信息
                        // 而且以上的then都不会执行
                        alert(err);
                    })
                    .always(function () {
                        // 不管是成功失败，这里都会执行
                    });
            
		/* 更新input file控件内容，使选择同一个文件也会触发onchange函数*/
		var nf = obj.cloneNode(true);
		nf.value=''; // 设计新控件value为空
		obj.parentNode.replaceChild(nf, obj);
		/* 更新input file控件内容，使选择同一个文件也会触发onchange函数*/
        p.showModal();
	}
	</script>
</body>
</html>


