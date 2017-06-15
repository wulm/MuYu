<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<s:actionmessage cssStyle="list-style-type:none;" escape="false"/> 
<head>
    <title>用户登录</title>  
    <link rel="stylesheet" href="Pages/common/css/pintuer.css">
    <link rel="stylesheet" href="Pages/common/css/admin.css">
    <script src="Pages/common/js/jquery.js"></script>
   
	<script type="text/javascript">
	function doLogin(){
		//alert("11111111111");
		var userName=document.getElementById('username').value;
		var pwd=document.getElementById('password').value;
		
		window.location.href = "userAction!login.action?username="
    		+userName+"&password="+pwd;
		
	}
	
	</script>
	
</head>

<body>
<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:150px;"></div>
            <div class="media media-y margin-big-bottom">           
            </div>         
            <form name="user">
            <div class="panel loginbox">
                <div class="text-center margin-big padding-big-top"><h1>后台管理中心</h1></div>
                <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:15px;">
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="text" class="input input-big" id="username" placeholder="登录账号" data-validate="required:请填写账号" />
                            <span class="icon icon-user margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="password" class="input input-big" id="password" placeholder="登录密码" data-validate="required:请填写密码" />
                            <span class="icon icon-key margin-small"></span>
                        </div>
                    </div>
                    
                </div>
                <div style="padding:30px;">
                <input type="button"  id="BTlogin" onclick="doLogin()" 
                class="button button-block bg-main text-big input-big" value="登录">
                </div>
            </div>
            </form>          
        </div>
    </div>
</div>

</body>
</html>