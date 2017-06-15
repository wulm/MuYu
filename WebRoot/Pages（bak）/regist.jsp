<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<!-- HTTP

标题信息(HTTP-EQUIV) -->
<title>用户注册页面</title>

<link type="text/css" rel="stylesheet" href="./css/register.css">
<!--引入外部定义好的register.css文件 -->

<script type="text/javascript" src="./js/register.js"></script>
<!--引入外部定义好的register.js文件 -->

</head>
<body>
	<form action="" method="" onsubmit="">
		<!-- 当触发提交事件时调用validateForm()方法  -->
		<table border="26" align="center" width="80%">
			<caption>用户注册</caption>
			<tr>
				<td align="right"><sup><font color="red">*</font>
				</sup>登录名 ：</td>
				<td><input type="text" name="username" id="username"
					class="input_class" onblur="checkUsername(this)" />
					<span
					id="username_span">用户名由3-5个字符组成</span>
				</td>
			</tr>

			<tr>
				<td align="right"><sup><font color="red">*</font>
				</sup>密码：</td>
				<td><input type="password" name="password" id="password"
					class="input_class" onblur="checkPassword(this)" /><span
					id="password_span"> 请输入8-12位密码</span>
				</td>
			</tr>

			<tr>
				<td align="right"><sup><font color="red">*</font>
				</sup>确认密 码：</td>
				<td><input type="password" name="rePassword" id="rePassword"
					class="input_class" onblur="checkRePassword(this)" /><span
					id="rePassword_span">两次密码不一致</span>
				</td>
			</tr>

			<tr>
				<td align="right"><sup><font color="red">*</font>
				</sup>Email ：</td>
				<td><input type="text" name="Email" id="Email"
					class="input_class" onblur="checkEmail(this)" /><span
					id="Email_span">例:xxxxxxxx@163.com</span>
				</td>
			</tr>

			<tr>
				<td align="right"><sup><font color="red">*</font>
				</sup>真实姓名：</td>
				<td><input type="text" name="realName" id="realName"
					class="input_class" onblur="checkName(this)" /><span
					id="realName_span">由2-5 个中文组成</span>
				</td>
			</tr>
			
			<tr>
				<td align="right"><sup><font color="red">*</font>
				</sup>电话号码：</td>
				<td><input type="text" name="phoneNum" id="phoneNum"
					class="input_class" onblur="checkPhoneNum(this)" /><span
					id="phoneNum_span">由11个数字组成</span>
				</td>
			</tr>

			<tr>
				<td align="center" colspan="2">
					<!-- 合并两列 --> 
					<input type="submit" class="aaa" value="注册" /> 
					<input type="reset" class="aaa" value="重置" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>


