<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <!-- 最上方div -->
    <div class="ui-layout-north" style="height: 60px;">
        <div class="toppanne">
            <div class="logo"></div>
            <div class="logstatbar">
                <font color="red"><c:out value="${currentUser.username}"></c:out>
                </font> ， 您好，欢迎光临！ <a href="javascript:modifyPassword();" onclick="">修改密码</a>
                | <a href="questions_reply.jsp" target="pageIfm">帮助</a> | <a
                    href="javascript:isclose();">退出</a>
            </div>
        </div>
    </div>


    <!-- IFRAME as layout-pane -->
    <div class="ui-layout-center">
        <div class="header">
            <div class="header_r"></div>

            <!-- 显示全屏的按钮 -->
            <div class="header_l">
                <a href="javascript:void(0);" onclick="ItoggleScreenMode()"
                    id="ScreenModeBar" class="togglefullscreen"></a>
            </div>
            <div class="clear"></div>
        </div>
        <!-- 显示加载完成 -->
        <iframe src="about:blank" width="100%" name="pageIfm" id="pageIfm"
            class="ui-layout-content" onload="aIfmLoadOk();" height="100%"
            frameborder="0" scrolling="yes"></iframe>
        <div class="footer" align="center">&nbsp;</div>
    </div>

    <!-- 页面左侧 -->
    <div class="ui-layout-west">
        <div class="header"></div>
        <div class="subhead"></div>
        <div class="ui-layout-content">
            <div id="left_menu">
                <div id="img"></div>
            </div>
            <div id="treeboxbox_tree">
                <!-- 此处显示dwr发送请求之后从服务器传来的menu -->
            </div>
            <div id="tree_down"></div>
            <div>
                <div id="help_top"></div>
                <div id="helpbox"></div>
                <div id="help_down"></div>
            </div>
        </div>
        <div class="footer"></div>

    </div>
    <div id="returnMsgbox"></div>
</body>
</html>
