<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.weixin.pojo.SNSUserInfo,java.lang.*"%>
<%  String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title>返回结果</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="green">
<script src="<%=basePath%>WeixinPages/common/js/mui.min.js"></script>
<script src="<%=basePath%>WeixinPages/common/js/jquery.min.js"></script>
<link href="<%=basePath%>WeixinPages/common/css/mui.min.css" rel="stylesheet" />

<!-- <script type="text/javascript">
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
</script> -->
</head>
<body>
	<div class="mui-button-row">
	    <div id="res"></div>
        <div id="show">  
		 	 将倒计时10秒后关闭当前窗口，返回微信公众号窗口
		</div>
		<button type="button" id="re" class="mui-btn mui-btn-primary" >手动返回公众号</button>
	</div>
	<script>
	   $.noConflict();// 此句含义避免冲突   后面需要用到jquery $ 符号的地方
	   var result = localStorage.getItem("result");
	   if(result == 'success'){
	      result = "操作成功";
	      
	   }else if(result == 'false'){
	   	  result = "操作失败";
	   }
	   jQuery("#res").append(result);
	   
	   	/**********************按钮事件************************/
		var btn = document.getElementById("re");//jQuery("#re")
		//监听点击事件
		btn.addEventListener("tap",function () {
			WeixinJSBridge.call('closeWindow');
		});
		//触发submit按钮的点击事件
		//mui.trigger(btn,'tap');
		/***************************按钮事件************************/
		jQuery(function(){
			closeWindow();
		});
		
		/***************************返回公众号事件************************/
		var time=5;  
		function closeWindow(){  
			window.setTimeout('closeWindow()',1000);  
			if(time>0){  
				document.getElementById("show").innerHTML=" 将倒计时<font color=red>"+time+"</font>秒后关闭当前窗口,返回微信公众号窗口";  
				time--;  
		    }else{  
				WeixinJSBridge.call('closeWindow');
			//this.window.opener=null; //关闭窗口时不出现提示窗口  
			//window.close();  
			}
		};
		/***************************返回公众号事件************************/
	</script>
</body>
</html>
