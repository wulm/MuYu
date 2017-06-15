<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.bean.SysUsers"%>
<%@ page import="com.bean.PageBean"%>
<%@ page import="java.util.*"%>
<%@page isELIgnored="false"%>
<% 
   PageBean<SysUsers> pageBean=(PageBean)session.getAttribute("pageBean");
   List<SysUsers> usersList=pageBean.getList(); 
   int pageCounts =pageBean.getTotalPage(); 
   int pageCurrent =pageBean.getCurrentPage(); 
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="<%=basePath%>/Pages/common/css/pintuer.css">
<link rel="stylesheet" href="<%=basePath%>/Pages/common/css/admin.css">
<script src="<%=basePath%>/Pages/common/js/jquery.js"></script>
<script src="<%=basePath%>/Pages/common/js/pintuer.js"></script>


<script type="text/javascript">
//页面加载时执行
var pageNow=<%=pageCurrent%>;//js全局变量pageNow
//页面加载时执行
$(document).ready(function(){
	//alert("<%=pageCurrent%>");
	
	$(".pagelist").children().each(function(){
		//alert("<%=pageCurrent%>");
		if(($(this).text())==pageNow){
			//alert(pageNow);
			$(this).addClass("current");
			$(this).removeAttr("href")
		}
  	});
  	//top.location.reload();
});

</script>

</head>
<body>
	<form name="userList" action="userList.action" method="post">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> <a
					href="user!updateUserPage.action">刷新用户列表</a> </strong>
			</div>
			<div class="padding border-bottom">
				<ul class="search" style="padding-left:10px;">
					<li style="float:left;"><a
						class="button border-main icon-plus-square-o"
						style="padding:5px 10px;" href="userList!gotoAddUser.action">
							添加用户</a> <a href="" class="button border-red icon-plus-square-o"
						style="padding:5px 10px;" onclick="DelSelect()"> 批量删除</a></li>

					<!-- <div style="float:right;"> -->
					<li style="float:right;">类型 
					<select id="s_userType" name="s_userType" class="input"
						style="padding:3px 8px;width:100px; line-height:17px;display:inline-block">
							<option value="-1">不限</option>
							<option value="0">管理员</option>
							<option value="1">用户</option>
					</select> 
					<input type="text" id="i_userName" placeholder="输入姓名查询"
						name="keywords" class="input"
						style="padding:4px 10px;width:150px; line-height:17px;display:inline-block" />
						<a class="button border-main icon-search" style="padding:5px 10px"
						id="u_search" href="javascript:void(0);"> 搜索</a> <!-- </div> --></li>
				</ul>
			</div>
			<table id="users_table" class="table table-hover text-center">
				<tr>
					<td style="width:10%"><input type="checkbox" id="checkall" />全选
					</td>
					<td style="width:10%">登录名</td>
					<td style="width:10%">姓名</td>
					<td style="width:15%">手机号</td>
					<td style="width:20%">E-mail</td>
					<td style="width:10%">类型</td>
					<td style="width:25%">操作</td>
				</tr>
			<!-- </table>
			<table id="users_table" class="table table-hover text-center"
				style="TABLE-LAYOUT: fixed"> -->
				<%for(SysUsers user:usersList){ %>
				<tr>
					<td><input type="checkbox" name="chk_list" />
						<%=user.getUserId()%></td>
					<td><%=user.getUserLoginName() %></td>
					<td><%=user.getUserName()%></td>
					<td><%=user.getUserPhoneNum()%></td>
					<td><%=user.getUserEmail()%></td>
					<td><%=user.getUserType()==0?"管理员":"用户"%></td>
					<td>
						<div class="button-group">
							<a class="button border-main" style="padding:3px 6px"
								id="user_edit" href="javascript:void(0);"> <span
								class="icon-edit"></span> 修改</a> <a class="button border-red"
								style="padding:3px 6px" id="user_delete"
								href="javascript:void(0);"> <span class="icon-trash-o"></span>
								删除</a>
						</div></td>
				</tr>
				<%} %>
			</table>
			<table class="table table-hover text-center">
				<tr>
					<td colspan="8">
						<div class="pagelist" id="pageNum">
							页码：&nbsp;&nbsp;
							<%for(int i=1;i<=pageCounts;i++){ %>
							<a href="" class="" style="padding:3px 9px" id="pageNum"><%=i %></a>
							<%-- <span class="current"><%=i %></span> --%>
							<%} %>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共<%=pageBean.getAllRow()%>条数据
						</div>
					</td>
				</tr>
			</table>
		</div>
	</form>



<script type="text/javascript">
	//单个编辑
	$("[id=user_edit]").click(function(){
		var userId = $(this).parent().parent().parent().find("td:eq(0)").text();
		window.location.href = "userList!gotoEditUser.action?userId="
			+userId; 
	});
	
	
	//单个删除
	$("[id=user_delete]").click(function(){
		if(confirm("您确定要删除吗?")){
			var userId = $(this).parent().parent().parent().find("td:eq(0)").text();
			
			window.location.href = "userList!DeleteUser.action?userId="
	    	+userId;
			
		}
	});

//点击页码
$("#pageNum a").click(function(){
	 var pageNum=$(this).text();
	 if(pageNow==pageNum){return false;}
	 var userName=$("#i_userName").val()+"";
	 var userType = $("#s_userType ").val();
	 var url = "user!updateUserTable.action?pageNum=" + pageNow;
	 if(userName==""){
		 url=url+"&userType="+userType;
	 }else{
		 url=url+"&userName="
			  + userName+"&userType="+userType;
	 }
	 alert(url);
	 doAjaxPost(url);
	  
});

//点击搜索按钮
$("#u_search").click(function(){
	var userName=$("#i_userName").val()+"";
	var userType = $("#s_userType ").val();
	var url = "user!updateUserTable.action?";
	if(userName==""){
		url=url+"userType="+userType;
	}else{
		url=url+"userName="
			+ userName+"&userType="+userType;
			
	}
	alert(url);
	doAjaxPost(url);
});

//发送ajax请求到后台，局部刷新表格数据
function doAjaxPost(url){
	$.ajax( {
		type : "POST",
		url : url,
		data :{},//传给后台的参数
		dataType : "JSON",
		success :rebuildUserTable,//成功回调函数
		error:function(){
			alert("失败");
		}
	});
	
}


//根据json数据更新用户列表users_table
function rebuildUserTable(jsonData){
	alert(jsonData);
	var list=eval(jsonData.list);
	$("#users_table  tr:not(:first)").html("");//清空用户表格
	for(var n=0;n<list.length;n++){
	 		var userId=list[n].userId;
	 		var userLoginName=list[n].userLoginName;
	 		var userName=list[n].userName;
	 		var userPhoneNum=list[n].userPhoneNum;
	 		var userEmail=list[n].userEmail;
	 		var userType=list[n].userType=="0"?"管理员":"用户";
	 		//刷新用户列表
	 		$("#users_table").append(
	 				 '<tr><td><input type="checkbox" name="chk_list" />'
	 				+userId+'</td><td>'+userLoginName+'</td><td>'
	 				+userName+'</td><td>'+userPhoneNum+'</td><td>'
	 				+userEmail+'</td><td>'+userType+'</td><td><div class="button-group">'
					+'<a class="button border-main"style="padding:3px 6px" id="user_edit" href="javascript:void(0);">' 
					+'<span class="icon-edit"></span> 修改</a> '
					+'<a class="button border-red" style="padding:3px 6px" id="user_delete" href=""> '
					+'<span class="icon-trash-o"></span>删除</a></div></td></tr>'
	 		);
	}
	//alert(4);
	var allRow=eval(jsonData.allRow);//获取总记录数
	var totalPage=eval(jsonData.totalPage);//获取总页数
	var currentPage=eval(jsonData.currentPage);//获取当前页值
	//alert(currentPage);
	//此处刷新设置页码数量和属性
	$("#pageNum").empty();//清空页码数量
	
	$("#pageNum").append('页码:&nbsp;');
	for(var ii=1;ii<=totalPage;ii++){
		$("#pageNum").append('<a href="" class="" style="padding:3px 9px" id="pageNum">'+ii+'</a>');
	}
	
	$("#pageNum").append('&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共'+allRow+'条数据');
	
	$("#pageNum a").each(function(){
		  if ($(this).text()==currentPage) {
		  	$(this).attr("class", "current");
			$(this).removeAttr("href");
		  }
		  else {
			 $(this).attr("class", "");
			 $(this).attr("href","");
		  }
	});
	
};

//全选
$("#checkall").click(function(){ 
  $("input[name='chk_list']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
});



//批量删除
function DelSelect(){
	var deleteUserList=new Array();
	var count=0;
	if(confirm("您确认要删除选中的内容吗？")){
    	$("input[name=chk_list]").each(function(i,d){
    		if(d.checked){
    			deleteUserList.push(d.value);
    			//window.alert(d.value); 
    			count++;
    		}
    	})
    	if(count<=0){window.alert("请选择要删除的用户！"); return false;}
    	//var usersIdsJson=window.JSON.stringify(deleteUserList);
    	var str="";
    	for(var i=0;i<count;i++){str=str+deleteUserList[i]+",";}
    	//window.alert(str);
    	//window.alert(usersIdsJson); 
    	window.location.href = "userList!DeleteUserByIds.action?usersIds="
    	+str;
	}else{
		return false;
	}

}

</script>
</body>
</html>