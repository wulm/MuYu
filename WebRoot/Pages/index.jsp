<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>系统主页</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Pages/common/themes/gray/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Pages/common/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>Pages/common/css/admin.css">
<script type="text/javascript"
	src="<%=basePath%>Pages/common/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>Pages/common/js/jquery.easyui.min.js"></script>



<script type="text/javascript">
$(function () {
	$("#fileList").click(function(){
		  var name= $(this).attr("name");
		  $("#mainContent").attr("src",name).ready();
	});
	$("#fileAdd").click(function(){
		  var name= $(this).attr("name");
		  $("#mainContent").attr("src",name).ready();
	});
	$("#userList").click(function(){
		  var name= $(this).attr("name");
		  $("#mainContent").attr("src",name).ready();
	});
	$("#userPower").click(function(){
		  var name= $(this).attr("name");
		  $("#mainContent").attr("src",name).ready();
	});
	
});


</script>
</head>
<body class="easyui-layout">
	<div id="topNav" data-options="region:'north',border:false">
	顶部栏
	</div>
	<div id="SysOption" data-options="iconCls:'icon-help',region:'west',title:'系统选项'">
		<div id="fileNav" class="easyui-accordion" >
			<div class="manageTitle" title="案卷管理" data-options="iconCls:'icon-lock'" >
				<hr class="hr0"></hr>
				<a id="fileList" href="javascript:void(0)" name="Pages/file_List.jsp" class="easyui-linkbutton" plain="true" iconCls="icon-ok">
					案卷列表</a>
				<hr class="hr0"></hr>
				<a id="fileAdd" href="javascript:void(0)" name="Pages/file_Add.jsp" class="easyui-linkbutton" plain="true" iconCls="icon-ok" >
					新建案卷</a>
				<hr class="hr0"></hr>
			</div>
			<div class="manageTitle" title="用户管理" data-options="iconCls:'icon-man'"
				style="padding:0px;">
				<hr class="hr0"></hr>
				<a id="userList" href="javascript:void(0)" name="Pages/user_List.jsp" class="easyui-linkbutton" plain="true" iconCls="icon-ok" >
					用户列表</a>
				<hr class="hr0"></hr>
				<a id="userPower" href="javascript:void(0)" name="Pages/user_Power.jsp" class="easyui-linkbutton" plain="true" iconCls="icon-ok" >
					权限分配</a>
				<hr class="hr0"></hr>
			</div>
			<div class="manageTitle" title="文件管理" data-options="iconCls:'icon-edit'">
				<hr class="hr0"></hr>
				<ul class="easyui-tree">
					<li><span>卷宗文件</span>
						<ul>
							<li>立案呈批表</li>
							<li>调查报告</li>
							<li>案件讨论</li>
							<li>行政处罚告知书</li>
							<li>行政处罚决定书</li>
							<li>没收财物清单</li>
							<li>结案呈批表</li>
							<li>宗地情况说明</li>
							<li>规划情况说明</li>
						</ul>
					</li>
				</ul>
				<hr class="hr0"></hr>
			</div>
		</div>

	</div>
	<div data-options="region:'center'">
		<iframe id="mainContent" scrolling="auto" style="height:99%;" frameborder=0
			src="Pages/user_List.jsp" width="99%" height="100%">
		</iframe>
	</div>
	<div id="tooter" data-options="region:'south',border:false"
		style="height:18px;background:#BFEFFF;padding:0px;" align="center">
		Copyright ©飞客软件工作室 版权所有</div>

	</body>
</html>
