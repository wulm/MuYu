<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>系统登录页面</title>
    <meta http-equiv="x-ua-compatible" content="IE=edge">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Pages/common/themes/gray/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>Pages/common/themes/icon.css">
	<script type="text/javascript" src="<%=basePath%>Pages/common/js/jquery.min.js"></script>
	<script type="text/javascript" charset="gbk" src="<%=basePath%>Pages/common/js/jquery.easyui.min.js"></script>
	<script type="text/javascript">
	function doLogin(){
		if($("#loginForm").form("validate")){
			
			var username=$("input#username").val();
			
			var password=$("input#password").val();
			
			window.location.href = "sysUser!login.action?username="
	    		+username+"&password="+password;
		} else{
			alert("信息输入有误！");
		}
	}
	
	
	</script>
  </head>
  
  <body style="background:#BFEFFF">
	<div style="position:absolute;top:15%;left:50%;margin:0px 0 0 -200px;">
	<form name="user" id="loginForm" method="post">
	<div class="easyui-panel" title="用户登录" style="width:100%;max-width:400px;padding:30px 60px;">
		<div style="margin-bottom:30px">
			<input id="username" class="easyui-textbox" 
			missingMessage="填写用户名" 
			style="width:100%;height:40px;padding:12px" 
			data-options="prompt:'用户名',iconCls:'icon-man',
			iconWidth:38,required:true,
			validType:'length[3,10]',
			validateOnCreate:true,err:err">
		</div>
		<div style="margin-bottom:20px">
			<input id="password" class="easyui-textbox"  
			missingMessage="输入密码" 
			type="password" style="width:100%;
			height:40px;padding:12px" 
			data-options="prompt:'请输入密码',
			iconCls:'icon-lock',iconWidth:38,
			required:true,
			validType:'length[5,10]',
			validateOnCreate:true,err:err">
		</div>
		<div style="margin-bottom:20px">
			<input type="checkbox" checked="checked">
			<span>记住密码</span>
		</div>
		<div>
			<input id="bt_login" onclick="doLogin();" type="button"  value="登录" class="easyui-linkbutton" style="padding:5px 0px;width:100%;">
			
		</div>
		</div>
		</form>
	</div>
	<style scoped="scoped">
		.tb{
			width:100%;
			margin:0;
			padding:5px 4px;
			border:1px solid #ccc;
			box-sizing:border-box;
		}
		.error-message{
			margin: 4px 0 0 0;
			padding: 0;
			color: red;
		}
	</style>
	<script type="text/javascript">
	function err(target, message){
		var t = $(target);
		if (t.hasClass('textbox-text')){
			t = t.parent();
		}
		var m = t.next('.error-message');
		if (!m.length){
			m = $('<div class="error-message"></div>').insertAfter(t);
		}
		m.html(message);
	}
	
	
	</script>
	
</body>
</html>
