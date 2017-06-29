<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>
		<s:if test="#request.articleType==1">2016年-木羽梦札</s:if>
		<s:if test="#request.articleType==2">2017年-木羽梦札</s:if>
		<s:if test="#request.articleType==3">一饮一啄</s:if>
		<s:if test="#request.articleType==4">木羽杂记</s:if>
	</title>
	<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
    <script src="<%=basePath%>WeixinPages/common/js/mui.min.js"></script>
	<link href="<%=basePath%>WeixinPages/common/css/mui.min.css"
		rel="stylesheet" />
	
	<script type="text/javascript">
	// 对浏览器的UserAgent进行正则匹配，不含有微信独有标识的则为其他浏览器
	var useragent = navigator.userAgent;
	if (useragent.match(/MicroMessenger/i) != 'MicroMessenger') {
		// 这里警告框会阻塞当前页面继续加载
		alert('已禁止本次访问：您必须使用微信内置浏览器访问本页面！');
		// 以下代码是用javascript强行关闭当前页面
		var opened = window.open('about:blank', '_self');
		opened.opener = null;
		opened.close();
	}
	</script>
	<script>
		mui.init({
		swipeBack : false//启用右滑关闭功能
	});
	</script>

  </head>
  
  <body>
	<div class="mui-content " >

		<ul class="mui-table-view">
			<s:if test="%{#articleList=null}">
				<li>暂无数据</li>
			</s:if>
			<s:iterator value="articleList" id="articleCell">
				<li  class="mui-table-view-cell mui-media">
					<a href="article!gotoArticleUserContent.action?articleId=<s:property value="#articleCell.articleId" />">
						<img  class="mui-media-object mui-pull-left"  src="<s:property value="#articleCell.articleTitleImageUrl" />">
						<div class="mui-media-body" style="color:black" >
							<s:property value="#articleCell.articleTitle" />
							<p class="mui-ellipsis" style="color:#87CEFA" ><s:property value="#articleCell.articleLeadText" /></p>
						</div>
					</a>
				</li>
			</s:iterator>
		</ul>
	</div>
</body>
</html>
