<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>



</head>
<body>
	<!--后台接收的Base64码，这里需要注意的是生成的Base64码前面带有一个头信息，这个头信息需要进行手工处理-->
	<input type="text" name="fileBase64" id="fileBase64" value="">
	<!--file上传文件-->
	<input type="file" capture="camera" accept="image/*" name="logo"
		id="file">
	<!--用于显示图片内容-->
	<div id="imgView"></div>
	<script
		src="<%=basePath%>WeixinPages/common/imgDeal/dist/lrz.bundle.js?v=09bcc24"></script>
	<script type="text/javascript">
		document.querySelector('input[type=file]').addEventListener('change', function () {
	    var that = this;
	    lrz(that.files[0], {
	        width: 800
	    })
	        .then(function (rst) {
	        	//如果是ajax请求到后台的话，代码也在这里写，具体写法请参考自带的例子，
	        	//这里是通过submit将数据统一提交，所以只保存到隐藏域中即可
	        	
				var imgView = document.getElementById("imgView");
				img = new Image(),
	                div = document.createElement('div'),
	                p = document.createElement('p'),
	                sourceSize = toFixed2(that.files[0].size / 1024),
	                resultSize = toFixed2(rst.fileLen / 1024),
	                scale = parseInt(100 - (resultSize / sourceSize * 100));
				imgView.innerHTML = "";//先清空原先数值
				 p.style.fontSize = 13 + 'px';
				 p.innerHTML      = '源文件大小：<span>' +
	                sourceSize + 'KB' +
	                '</span> <br />' +
	                '压缩后大小：<span>' +
	                resultSize + 'KB (省' + scale + '%)' +
	                '</span> ';
				 div.className = '';		
				 div.appendChild(img);
				 div.appendChild(p);
				img.onload = function () {
					
	                document.querySelector('#imgView').appendChild(div);
	            };
	            img.src = rst.base64;
	            
	            //保存到隐藏域中。
	           	document.getElementById("fileBase64").value = rst.base64;
	            return rst;
	        });
	});
	
	function toFixed2 (num) {
	    return parseFloat(+num.toFixed(2));
	}	
	
</script>
</body>
</html>
=======
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<meta name="viewport" content="width=device-width, user-scalable=no">
<head>
    <meta charset="UTF-8">
    <title>上传下载组建</title>
</head>
<body>
	<!--后台接收的Base64码，这里需要注意的是生成的Base64码前面带有一个头信息，这个头信息需要进行手工处理-->
	<input type="text" name="fileBase64" id="fileBase64" value=""> 
	<!--file上传文件-->
    <input type="file" capture="camera" accept="image/*" name="logo" id="file">
     <!--用于显示图片内容-->
    <div id="imgView"></div>
    <image id="img" src=""></image>
    <textarea rows="10" id="mgs" cols=""></textarea> 
<script src="<%=basePath%>WeixinPages/common/imgDeal/dist/lrz.bundle.js?v=09bcc24"></script>
<script src="<%=basePath%>WeixinPages/common/js/jquery-1.11.2.js"></script>
<script type="text/javascript">
		document.querySelector('input[type=file]').addEventListener('change', function () {
	    var that = this;
	    lrz(that.files[0], {
	        width: 500
	    }).then(function (rst) {
	    	//alert(rst.base64);
	    	//var jsonObj=JSON.stringify({img:rst.base64});//将压缩后的图像base64数据转为json
	    	//document.getElementById("mgs").value = jsonObj;
	    	//var imge=new Image(rst.base64);
	    	document.getElementById("img").src = rst.base64;
	        	$.ajax({
                    url: 'article!UploadImage.action',
                    type: 'post',
                    data: {img: rst.base64},
                    dataType: 'json',
                    timeout: 200000,
                    success: function (response) {
                    	document.getElementById("mgs").value = "成功";
                        if (response.ecd == '0') {
                            alert('成功');
                            return true;
                        } else {
                            return alert(response.msg);
                        }
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                    	document.getElementById("mgs").value = "失败";
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
            }).always(function () {
				//错没错误总会执行
            });
		
	});
</script>
</body>
</html>
>>>>>>> 2857931bc6415482a588bf47930bce650b6c88e1
