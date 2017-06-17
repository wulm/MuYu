<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>文章管理页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<!--标准mui.css-->
	<link rel="stylesheet" href="<%=basePath%>WeixinPages/common/css/mui.min.css">
	<!--App自定义的css-->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>WeixinPages/common/css/app.css" />
	<script src="<%=basePath%>WeixinPages/common/js/mui.min.js"></script>
	
	<!--列表js-->
	<script>
	mui.init({
		swipeBack: false //启用右滑关闭功能
	});
	
	function deleteConfirm(articleId){
		mui.confirm('确认删除吗？','删除',new Array('取消','确认'),function(e){
			if(e.index == 1){
				window.location.href = "article!deleteArticle.action?articleId="+articleId;
				mui.toast('已删除');
			}else{
				mui.toast('取消');
			}
		});
	}
	
	function gotoAddArticle(){
		window.location.href = "article!gotoAddArticle.action";
	}
	
	function gotoEditArticle(articleId){
		window.location.href = "article!gotoEditArticle.action?articleId="+articleId;
	}
	</script>
  </head>
  
  <body>
  <header id="header" class="mui-bar mui-bar-nav">
			<a class="mui-action-back mui-icon mui-icon-left-nav"></a>
			<h1 class="mui-title">文章管理</h1>
			<button class="mui-btn mui-btn-blue mui-btn-link mui-pull-right">新增</button>
		</header>
    <div class="mui-content">
    	<ul id="OA_task_2" class="mui-table-view">
    		<c:if
				test="${sessionScope.articleList==null || fn:length(sessionScope.articleList) == 0}">
				<li>暂无数据</li>
			</c:if>
			<c:forEach items="${sessionScope.articleList}" var="item">
				<li class="mui-table-view-cell">
					<div class="mui-slider-right mui-disabled">
						<button id='editBtn' type="button" onclick="gotoEditArticle(${item.articleId});" class="mui-btn mui-btn-green ">修改</button>
						<button id='deleteBtn' type="button" onclick="deleteConfirm(${item.articleId});" class="mui-btn mui-btn-red ">删除</button>
					</div>
					<div class="mui-slider-handle">
						<div class="mui-table-cell mui-col-xs-10">
		                    <h4 class="mui-ellipsis">${item.articleTitle}</h4>
		                    <p class="mui-h6 mui-ellipsis">${item.articleLeadText}</p>
		                </div>
					</div>
				</li>
			</c:forEach>
		</ul>
    </div>
  </body>
</html>
