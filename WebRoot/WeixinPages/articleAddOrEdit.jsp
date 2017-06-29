<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
    <title>文章编辑</title>
   <!--标准mui.css-->
	<link rel="stylesheet" href="<%=basePath%>WeixinPages/common/css/mui.min.css">
  	<script type="text/javascript" src="<%=basePath%>WeixinPages/common/js/jquery-1.11.2.js"></script>
	<script src="<%=basePath%>WeixinPages/common/imgDeal/dist/lrz.bundle.js?v=09bcc24"></script>
	<script src="<%=basePath%>WeixinPages/common/js/dialog.js"></script>
  	<script type="text/javascript">
    $(function(){
         $("#articleType").val(${article.articleType});//设置默认选中的类别
         <c:choose>
         <c:when test="${fn:trim(article.articleTitleImageUrl) != ''}">
         	$("#articleIcon").attr('src','${article.articleTitleImageUrl}');//设置文章图标
         </c:when>  
         <c:otherwise> 
         	$("#articleIcon").attr('src','/MuYu/WeixinPages/uploadImg/articleIcon/nofound.jpg');//设置文章图标
         </c:otherwise> 
         </c:choose>
         $('input[name=articleTitleImageUrl]').on('change', function(){
        	 var d=dialog();//初始化上传中
         	 d.showModal();//显示加载框
        	 lrz(this.files[0], {width: 120})
             .then(function (rst) {
                 $.ajax({
                     url: 'article!UploadIcon.action',
                     type: 'post',
                     data: {img: rst.base64},
                     dataType: 'json',
                     timeout: 200000,
                     success: function (response) {
                         if (response.done == '0') {
                        	 d.close().remove();
                        	 document.getElementById('articleTitleImageUrl').value=response.imgSrc;
                         	 document.getElementById('articleIcon').src = response.imgSrc;
                         	
                             return true;
                         } else {
                        	 d.close().remove();
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
	
<style type="text/css">
.footer-btn {
	height:70px;
	width:200px;
	text-align: left;
	padding-top: 20px;
	display: inline-block;
}

.input-file-css {
	position: absolute;
	left: 0;
	opacity: 0;
	width: 100%;
}
</style>

</head>
  
  <body onload="loadPage();">
  	<div style="width:100%;" class="mui-content">
		<div class="mui-content-padded">
			<form class="mui-input-group" id="articleEdit" name="articleEdit" method = 'post' action ='article!DoSaveArticle.action' >
				<input id="articleId" name="articleId" type="hidden" value="${article.articleId}"/>
				<input id="articleTitleImageUrl" name="articleTitleImageUrl" type="hidden" value="${article.articleTitleImageUrl}"/>
				<input id="createDate" name="createDate" type="hidden" value="${article.createDate}"/>
				<div class="mui-input-row">
					<label>类别</label>
					<select id="articleType" name="articleType">
						<option value="0">请选择</option>
						<option value="2">2017年木羽梦札</option>
						<option value="1">2016年木羽梦札</option>
						<option value="3">一饮一啄</option>
						<option value="4">木羽杂记</option>
					</select>
				</div>
				<div class="mui-input-row" style="height:70px;">
					<label  >
						<img id="articleIcon" name="articleIcon" style="width:50px;height:50px;"/>
					</label>
					<div class="footer-btn ">
						<span ><i class="mui-icon mui-icon-image"></i>选择文章小图标</span>
						<input id="articleTitleImageUrl" name="articleTitleImageUrl"  class="input-file-css" type="file" capture="camera" accept="image/*">
					</div>
				</div>
				<div class="mui-input-row">
					<label>标题</label>
					<input name="articleTitle" id="articleTitle" type="text" class="mui-input-clear" placeholder="输入文章标题"
						 value="${article.articleTitle}">
				</div>
				
				<div class="mui-input-row">
					<label>作者</label>
					<input id="writerName" name="writerName" type="text" class="mui-input-clear" placeholder="输入笔名" value="${article.writerName}">
				</div>
				<h4 class="mui-content-padded">引言</h4>
				<div class="mui-input-row" style="margin: 10px 5px;height:160px;">
					<textarea id="articleLeadText" name="articleLeadText" rows="5" placeholder="输入文章引言" >${article.articleLeadText}</textarea>
				</div>
				<input  type="submit"  style="background-color:#63B8FF;width:100%;height:50px;" class="mui-btn mui-btn-success" value="保存并编辑正文">
				
			</form>
		</div>
    </div>
</body>
</html>
