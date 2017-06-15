/*@charset "utf-8";*/
/*����cookie*/
function setCookie(name, value, days){
	if(days == null || days == ''){
		days = 300;
	}
	var exp  = new Date();
	exp.setTime(exp.getTime() + days*24*60*60*1000);
	document.cookie = name + "="+ escape (value) + "; path=/;expires=" + exp.toGMTString();
}

/*��ȡcookie*/
function getCookie(name) {
	var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
	if(arr = document.cookie.match(reg))
		return unescape(arr[2]); 
	else 
		return null; 
}

/*ajax����*/
function ajax(url, param, datat, callback) {  
	$.ajax({  
		type: "post",  
		url: url,  
		data: param,
		dataType: datat,  
		success: function(data){
			callback;
		},  
		error: function () {  
			alert("ʧ��.."); 
		}
	});  
}  