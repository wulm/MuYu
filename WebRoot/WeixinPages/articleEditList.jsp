<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
    <script src="<%=basePath%>WeixinPages/common/js/dialog.js"></script>
	<!--列表js-->
	<script>
	mui.init({
		swipeBack: false //启用右滑关闭功能
	});
	
	function gotoAddArticle(){
		window.location.href = "article!gotoAddArticle.action";
	}
	
	function gotoEditArticle(articleId){
		 parent.location.reload();
		 parent.location.href="article!gotoEditArticle.action?articleId="+articleId;
		//self.opener.location.reload(); 
		//window.opener.location.href="article!gotoEditArticle.action?articleId="+articleId; 
		//window.location.href = "article!gotoEditArticle.action?articleId="+articleId;
	}
	</script>
	<script>
	function DeleteArticle(articleId,articleType){
            var d = dialog({
                content: '确定删除？',
                okValue: '确 定',
                ok: function() {
                	//window.opener.location.href=window.opener.location.href; 
                	window.location.href = "article!deleteArticle.action?articleId="+articleId+"&articleType="+articleType;
                	dialog()
                    .showModal();
                },
                cancelValue: '取消',
                cancel: function() {}
            });

            d.showModal();
        }
    </script>
  </head>
  
  <body>
    <div class="mui-content">
    	<ul id="OA_task_2" class="mui-table-view">
    	<s:if test="%{#articleList=null}">
				<li>暂无数据</li>
		</s:if>
			<s:iterator value="articleList" id="articleCell">
				<li class="mui-table-view-cell mui-media">
					<div class="mui-slider-left mui-disabled">
						<button id='editBtn'  type="button" onclick="gotoEditArticle(<s:property value="#articleCell.articleId" />,<s:property value="#articleCell.articleType" />);" class="mui-btn mui-btn-green ">修改</button>
						<button id='deleteBtn'  type="button" onclick="DeleteArticle(<s:property value="#articleCell.articleId" />,<s:property value="#articleCell.articleType" />);" class="mui-btn mui-btn-red ">删除</button>
					</div>
					<div class="mui-slider-handle">
						<div class="mui-table-cell mui-col-xs-10">
		                    <s:property value="#articleCell.articleTitle" />
		                    <p class="mui-h6 mui-ellipsis" style="color:#87CEFA">
		                    	<s:property value="#articleCell.articleLeadText" />
		                    </p>
		                </div>
					</div>
				</li>
			</s:iterator>
		</ul>
    </div>
  </body>
</html>
