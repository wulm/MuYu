<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>登录页面</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />

<meta http-equiv="x-ua-compatible" content="IE=edge">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">

<link href="<%=basePath%>WeixinPages/common/css/mui.min.css"
	rel="stylesheet" />
<link href="<%=basePath%>WeixinPages/common/css/style.css"
	rel="stylesheet" />

<script src="<%=basePath%>WeixinPages/common/js/mui.min.js"></script>
<script src="<%=basePath%>WeixinPages/common/js/mui.enterfocus.js"></script>
<script src="<%=basePath%>WeixinPages/common/js/app.js"></script>
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
	(function($, doc) {
		$.init({
			statusBarBackground : '#f7f7f7'
		});
		
	}(mui, document));
</script>
<script type="text/javascript">
	function doLogin(){
		var username=document.getElementById("account").value;
		var password=document.getElementById("password").value;
		//alert(username+password);
		if((username !== null || username !== undefined || username !== '')&&(password !== null || password !== undefined || password !== '')){
			window.location.href = "sysUser!login.action?username="
	    		+username+"&password="+password;
		} else{
			alert("账号或密码未输入！");
		}
	}
</script>
<style>
.area {
	margin: 20px auto 0px auto;
}

.mui-input-group {
	margin-top: 10px;
}

.mui-input-group:first-child {
	margin-top: 20px;
}

.mui-input-group label {
	width: 22%;
}

.mui-input-row label  ~input,.mui-input-row label  ~select,.mui-input-row label
	 ~textarea {
	width: 78%;
}

.mui-checkbox input[type=checkbox],.mui-radio input[type=radio] {
	top: 6px;
}

.mui-content-padded {
	margin-top: 25px;
}

.mui-btn {
	padding: 10px;
}

.link-area {
	display: block;
	margin-top: 25px;
	text-align: center;
}

.spliter {
	color: #bbb;
	padding: 0px 8px;
}

.oauth-area {
	position: absolute;
	bottom: 20px;
	left: 0px;
	text-align: center;
	width: 100%;
	padding: 0px;
	margin: 0px;
}

.oauth-area .oauth-btn {
	display: inline-block;
	width: 50px;
	height: 50px;
	background-size: 30px 30px;
	background-position: center center;
	background-repeat: no-repeat;
	margin: 0px 20px;
	/*-webkit-filter: grayscale(100%); */
	border: solid 1px #ddd;
	border-radius: 25px;
}

.oauth-area .oauth-btn:active {
	border: solid 1px #aaa;
}

.oauth-area .oauth-btn.disabled {
	background-color: #ddd;
}
</style>

</head>

<body>
	<header class="mui-bar mui-bar-nav">
	<h1 class="mui-title">管理员登录</h1>
	</header>
	
	<div class="mui-content">
		<form id='login-form' class="mui-input-group" method="post">
			<div class="mui-input-row">
				<label>账号</label> <input id='account' type="text"
					class="mui-input-clear mui-input" placeholder="请输入账号">
			</div>
			<div class="mui-input-row">
				<label>密码</label> <input id='password' type="password"
					class="mui-input-clear mui-input" placeholder="请输入密码">
			</div>
		</form>
		<div class="mui-content-padded">
			<button id='login'  onclick="doLogin();" class="mui-btn mui-btn-block mui-btn-primary">登录</button>		
		</div>
		<div class="mui-content-padded oauth-area"></div>
	</div>


</body>
</html>
