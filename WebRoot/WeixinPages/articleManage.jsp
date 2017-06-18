<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<script src="<%=basePath%>WeixinPages/common/js/jquery-1.11.2.js"></script>
	<!--列表js-->
	<script>
	mui.init({
		swipeBack: false //启用右滑关闭功能
	});
	</script>
	<script type="text/javascript">
		function showIframe(articleType){
			//alert("dddd");
			var url="http://mingxin.imwork.net/MuYu/article!gotoArticleEditList.action?articleType="+articleType;
			$("#mainContent").attr("src",url).ready();
			//alert("dddd");
		}
	</script>
  </head>
  
  <body>
  <header id="header" class="mui-bar mui-bar-nav">
			<a class="mui-action-back mui-icon mui-icon-left-nav"></a>
			<h1 class="mui-title">文章管理</h1>
			<button class="mui-btn mui-btn-blue mui-btn-link mui-pull-right">新增</button>
		</header>
		<nav class="mui-bar mui-bar-tab ">
			<a class="mui-tab-item" href="#Popover_0">木羽梦札</a>
			<a class="mui-tab-item" href="#Popover_1">一饮一啄</a>
			<a class="mui-tab-item" href="#Popover_2">木羽杂记</a>
		</nav>
		<div id="Popover_0" style="width:30%;" class="mui-popover mui-bar-popover">
			<ul style="background:#BFEFFF;" class="mui-table-view">
				<li class="mui-table-view-cell"><a href="javascript:void(0)" onclick="showIframe(1);">2016年</a>
				</li>
				<li class="mui-table-view-cell"><a href="javascript:void(0)" onclick="showIframe(2);">2017年</a>
				</li>
			</ul>
		</div>
		<div id="Popover_1" style="width:30%;" class="mui-popover mui-bar-popover">
			<ul style="background:#BFEFFF;" class="mui-table-view">
				<li class="mui-table-view-cell"><a href="javascript:void(0)" onclick="showIframe(3);">一饮一啄</a>
				</li>
			</ul>
		</div>
		<div id="Popover_2" style="width:30%;" class="mui-popover mui-bar-popover">
			<ul style="background:#BFEFFF;" class="mui-table-view">
				<li class="mui-table-view-cell"><a href="javascript:void(0)" onclick="showIframe(4);">木羽杂记</a>
				</li>
			</ul>
		</div>
    <div class="mui-content">
    	<iframe style="width:100%;height:100%;" id="mainContent" src="http://mingxin.imwork.net/MuYu/article!gotoArticleEditList.action?articleType=1"/>
	</div>
  </body>
</html>
