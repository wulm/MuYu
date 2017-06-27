<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<meta name="viewport" content="width=device-width, user-scalable=no">
<head>
<meta charset="UTF-8">
<title>编辑文章页面</title>

<!--标准mui.css-->
<link rel="stylesheet"
	href="<%=basePath%>WeixinPages/common/css/mui.min.css">

<style type="text/css">
.topBar{
	height:5%;
	min-height:40px;
	border:1px solid gray;
    margin-left:5px;
    margin-right:5px;
    text-align:center; /*水平居中*/
}
.rich{
    height:75%;
    border:1px solid gray;
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
			<input type="file" capture="camera"  accept="image/*"  name="logo" id="file" class="input-file-css">
		</div>
		<div class="SubBtn">
			<button class="mui-btn mui-btn-success "
					style="width:80%;height:35px;"
					onclick="saveArticleContent(${article.articleId});">发布文章</button>
		</div>
	<script src="<%=basePath%>WeixinPages/common/imgDeal/dist/lrz.bundle.js?v=09bcc24"></script>
	<script src="<%=basePath%>WeixinPages/common/js/jquery-1.11.2.js"></script>
	<script type="text/javascript">
	$('#articleContent').on('click', function(){ 
		//点击div光标定位
		var that=this;
		that.focus();
		}); 
	}); 
</script>

	<script type="text/javascript">
	document.querySelector('input[type=file]').addEventListener('change', function () {
		var that = this;
		lrz(that.files[0], {//先使用localResizeIMG压缩图片，再用ajax上传图片
	    	width: 500//设置压缩后图片的宽度
		}).then(function (rst) {/*rst为压缩后的完整base64图像，格式为：{origin: File, base64: "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD…iigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKAP/Z", base64Len: 1507}*/
	    $	.ajax({
            	url: 'article!UploadImage.action',
            	type: 'post',
            	data: {img: rst.base64},/*rst.base64为图片类型和图片编码数据，格式为：data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD…iigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKAP/Z*/
            	dataType: 'json',/* java后台使用rst.base64数据前必须将"data:image/jpeg;"去除，剩余部分转换为图片 */
            	timeout: 200000,
            	success: function (response) {
                        if (response.done == '0') {
                        	//document.getElementById("articleContent").value = response.msg+response.imgSrc;
                        	//var img=new Image(); 
                        	//img.src=response.imgSrc;
                        	//document.getElementById("articleContent").append(img);//div中显示图片"<image  src='XXXXX' />"
                        	document.getElementById("articleContent").innerHTML += "<image width="100%" src='"+response.imgSrc+"' />";
                        	//$("#divs").html(imageStr);
                            //alert('成功');
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
                        //alert(jqXHR.responseText);
                        //document.getElementById("mgs").innerHTML += jqXHR.responseText;
                    }
                });
	        }).catch(function (err) {
				alert("上传图片错误"+err);
            }).always(function () {//不管图片上传有没有成功，都执行清空input file操作
            	/* 更新input file控件内容，使选择同一个文件也会触发onchange函数*/
        		var nf = that.cloneNode(true);
        		nf.value=''; // 设计新控件value为空
        		that.parentNode.replaceChild(nf, that);
        		/* 更新input file控件内容，使选择同一个文件也会触发onchange函数*/
				
            });
	});
</script>
</body>
</html>

