<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="<%=basePath%>/Pages/common/css/pintuer.css">
<link rel="stylesheet" href="<%=basePath%>/Pages/common/css/admin.css">
<script src="<%=basePath%>/Pages/common/js/jquery.js"></script>
<script src="<%=basePath%>/Pages/common/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o">
  </span>新增用户</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="">  
        <div class="form-group">
        
       	<div style="width:100%">
          <div class="label" style="float:left">
            <label>用户类型：</label>
          </div>
           <div class="field" style="float:left;width:400px">
            <select name="cid" class="input w50">
              <option value="">--请选择--</option>
              <option value="0">系统管理员</option>
              <option value="1">普通用户</option>
            </select>
          </div>
        </div>
        
        
          <div class="label">
            <label>登录名：</label>
          </div>
          <div class="field" >
          <input type="text" class="input w50" value="" name="title" data-validate="required:请输入登录名" />
          <div class="tips"></div>
        </div>
          <div class="label">
            <label>登录密码：</label>
          </div>
          <div class="field">
          <input type="password" class="input w50" value="" name="title" data-validate="required:请输入登录密码" />
          <div class="tips"></div>
          </div>
          <div class="label">
            <label>重复密码：</label>
          </div>
          <div class="field">
          <input type="password" class="input w50" value="" name="title" data-validate="required:重复密码" />
          <div class="tips"></div>
          </div>
          
          <div class="label">
            <label>姓名：</label>
          </div>
          <div class="field">
          <input type="text" class="input w50" value="" name="title" data-validate="required:输入姓名" />
          <div class="tips"></div>
          </div>
          
          <div class="label">
            <label>手机号：</label>
          </div>
          <div class="field">
          <input type="text" class="input w50" value="" name="title" data-validate="required:输入手机号" />
          <div class="tips"></div>
          </div>
          
          
          <div class="label">
            <label>电子邮箱：</label>
          </div>
          <div class="field">
          <input type="text" class="input w50" value="" name="title" data-validate="required:输入电子邮箱" />
          <div class="tips"></div>
          </div>
          
        </div>
       
     		<a class="button border-main icon-plus-square-o" href="userList!AddUser.action"> 
        		添加用户</a>
        		
      
    </form>
  </div>
</div>

</body></html>