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
<script src="<%=basePath%>WeixinPages/common/js/dialog.js"></script>
<script>
  	window.onload = function() {
  		$('#ArticleContent').setValue('${articleContent.articleContent}');//设置富文本框的内容
  	}
</script>
<style type="text/css">
.topBar{
	height:5%;
	min-height:40px;
	border:1px solid #0997F7;
    margin-left:5px;
    margin-right:5px;
    text-align:center; /*水平居中*/
}
.rich{
    height:75%;
    border:1px solid #0997F7;
    margin-left:5px;
    margin-right:5px;
    overflow: auto;
}
.rich:empty:before{
    content:attr(placeholder);
    font-size: 16px;
    color: #999;
}
.rich:focus:before{
    content:none;
}
.footer-btn {
  text-align: center;
  padding-top: 1px;
}
.footer-btn .upload-img {
  height: 8%;
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

.SubBtn{
	width:100%;
	height:10%;
	min-height:30px;
	text-align:center; /*水平居中*/
	
}
</style>
</head>
<body>
	<div class="topBar">正文内容</div>
	
	<!-- 文章正文编辑div  -->
	<div id="articleContent" class="rich" contentEditable="true"></div>
	<div class="footer-btn " >
		<!--img上传文件-->
			<span ><i class="mui-icon mui-icon-image"></i>插入图片</span> 
    <input  class="input-file-css" type="file" capture="camera" accept="image/*" name="imgFile" id="imgFile">
    </div>
   
    <div class="SubBtn">
			<button style="width:80%;height:35px;background:#98FB98;" class="mui-btn mui-btn-success"
					onclick="saveArticleContent(${articleContent.myArticle.articleId});">发布文章</button>
		</div>
     <script>
    $(function(){
        $('input[name=imgFile]').on('change', function(){
        	var d=dialog();//初始化上传中
        	d.showModal();
             lrz(this.files[0], {width: 1080})
                .then(function (rst) {
                    $.ajax({
                        url: 'article!UploadImage.action',
                        type: 'post',
                        data: {img: rst.base64},
                        dataType: 'json',
                        timeout: 200000,
                        success: function (response) {
                            if (response.done == '0') {
                            	d.close().remove();
                            	var divBuff=document.createElement("div");
                            	divBuff.setAttribute("style","text-align:center;");
                            	var bigImg = document.createElement("img");
                            	bigImg.setAttribute("src",response.imgSrc);  
                            	bigImg.setAttribute("style","width:80%;");  
                            	divBuff.appendChild(bigImg);
                            	//alert(response.imgSrc);
                            	document.getElementById("articleContent").appendChild(divBuff);
                            	
                                return true;
                            } else {
                                return alert(response.msg);
                            }
                        },

                        error: function (jqXHR, textStatus, errorThrown) {

                            if (textStatus == 'timeout') {
                                a_info_alert('请求超时');

                                return false;
                            }

                            alert(jqXHR.responseText);
                        }
                    });

                })
                .catch(function (err) {

                })
                .always(function () {

                });
        });
    });
    </script>
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
</body>

