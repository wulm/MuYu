<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.weixin.pojo.SNSUserInfo,java.lang.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 
        // 获取由OAuthServlet中传入的参数
        SNSUserInfo user = (SNSUserInfo)request.getAttribute("snsUserInfo"); 
        String state=request.getAttribute("state").toString();
        if(null != user) {
    %>
<html>
<head>
<base href="<%=basePath%>">
<title>鸣心文化</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="green">
<script src="<%=basePath%>WeixinPages/common/js/mui.min.js"></script>
<link href="<%=basePath%>WeixinPages/common/css/mui.min.css"
	rel="stylesheet" />
<script>
		mui.init({
			swipeBack:true //启用右滑关闭功能
		});
		var slider = mui("#slider");
		slider.slider({
			interval: 2000
		});
		
	</script>
</head>
<body>



<%--

	<table width="100%" cellspacing="0" cellpadding="0">
		<tr>
			<td width="20%">属性</td>
			<td width="80%">值</td>
		</tr>
		<tr>
			<td>OpenID</td>
			<td><%=user.getOpenId()%></td>
		</tr>
		<tr>
			<td>昵称</td>
			<td><%=user.getNickname()%></td>
		</tr>
		<tr>
			<td>性别</td>
			<td><%=user.getSex()%></td>
		</tr>
		<tr>
			<td>国家</td>
			<td><%=user.getCountry()%></td>
		</tr>
		<tr>
			<td>省份</td>
			<td><%=user.getProvince()%></td>
		</tr>
		<tr>
			<td>城市</td>
			<td><%=user.getCity()%></td>
		</tr>
		<tr>
			<td>头像</td>
			<td><%=user.getHeadImgUrl()%></td>
		</tr>
		<tr>
			<td>特权</td>
			<td><%=user.getPrivilegeList()%></td>
		</tr>
		<tr>
			<td>state:</td>
			<td><%=state%></td>
		</tr>
	</table>
	<%
        }
        else 
            out.print("用户不同意授权,未获取到用户信息！");
    %>



--%>


</body>
</html>
