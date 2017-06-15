/*<script type="text/javascript">*/

 document.write("<script language=javascript src='./user_util.js'></script>");

/* ���˵���� */
$(".side-menu").on('click', 'li a', function(e) {
	var animationSpeed = 300;
	var $this = $(this);
	var checkElement = $this.next();
	if (checkElement.is('.menu-item-child') && checkElement.is(':visible')) {
		checkElement.slideUp(animationSpeed, function() {checkElement.removeClass('menu-open');});
	  	checkElement.parent("li").removeClass("active");
	}
	// ����˵��ǲ��ɼ���
	else if ((checkElement.is('.menu-item-child')) && (!checkElement.is(':visible'))) {
	  // ��ȡ�ϼ��˵�
	  var parent = $this.parents('ul').first();
	  // �Ӹ�����ʼ�����д򿪵Ĳ˵����ر�
	  var ul = parent.find('ul:visible').slideUp(animationSpeed);
	  // �ڸ������Ƴ�menu-open���
	  ul.removeClass('menu-open');
	  // ��ȡ����li
	  var parent_li = $this.parent("li");
	  // �򿪲˵�ʱ���menu-open���
	  checkElement.slideDown(animationSpeed, function() {
		  // �����ʽactive������li
		  checkElement.addClass('menu-open');
		  parent.find('li.active').removeClass('active');
		  parent_li.addClass('active');
	  });
	}
	// ��ֹ��������ת
	e.preventDefault();
	addIframe($this);
});

/* ���iframe */
function addIframe(cur){
	var $this = cur;
	var h = $this.attr("href"),
		m = $this.data("index"),
		label = $this.find("span").text(),
		isHas = false;
	if (h == "" || $.trim(h).length == 0) {
		return false;
	}
	var fullWidth = $(window).width();
	if(fullWidth >= 750){
		$(".layout-side").show();
	}else{
		$(".layout-side").hide();
	}
	
	$(".content-tab").each(function() {
		if ($(this).data("id") == h) {
			if (!$(this).hasClass("active")) {
				$(this).addClass("active").siblings(".content-tab").removeClass("active");
				addTab(this);
			}
		isHas = true;
		}
	});
	if(isHas){
		$(".body-iframe").each(function() {
			if ($(this).data("id") == h) {
				$(this).show().siblings(".body-iframe").hide();
			}
		});
	}
	if (!isHas) {
		var tab = "<a href='javascript:;' class='content-tab active' data-id='"+h+"'>"+ label +" <i class='icon-font'>&#xe617;</i></a>";
		$(".content-tab").removeClass("active");
		$(".tab-nav-content").append(tab);
		var iframe = "<iframe class='body-iframe' name='iframe"+ m +"' width='100%' height='99%' src='"+ h +"' frameborder='0' data-id='"+ h +"' seamless></iframe>";
		$(".layout-main-body").find("iframe.body-iframe").hide().parents(".layout-main-body").append(iframe);
		addTab($(".content-tab.active"));
	}
	return false;
}


/* ���tab */
function addTab(cur) {
	var prev_all = tabWidth($(cur).prevAll()),
		next_all = tabWidth($(cur).nextAll());
	var other_width =tabWidth($(".layout-main-tab").children().not(".tab-nav"));
	var navWidth = $(".layout-main-tab").outerWidth(true)-other_width;// ���ӿ��
	var hidewidth = 0;
	if ($(".tab-nav-content").width() < navWidth) {
		hidewidth = 0
	} else {
		if (next_all <= (navWidth - $(cur).outerWidth(true) - $(cur).next().outerWidth(true))) {
			if ((navWidth - $(cur).next().outerWidth(true)) > next_all) {
				hidewidth = prev_all;
				var m = cur;
				while ((hidewidth - $(m).outerWidth()) > ($(".tab-nav-content").outerWidth() - navWidth)) {
					hidewidth -= $(m).prev().outerWidth();
					m = $(m).prev();
				}
			}
		} else {
			if (prev_all > (navWidth - $(cur).outerWidth(true) - $(cur).prev().outerWidth(true))) {
				hidewidth = prev_all - $(cur).prev().outerWidth(true);
			}
		}
	}
	$(".tab-nav-content").animate({marginLeft: 0 - hidewidth + "px"},"fast");
}

/** ��ȡ��� */
function tabWidth(tabarr) {
	var allwidth = 0;
	$(tabarr).each(function() {allwidth += $(this).outerWidth(true)});
	return allwidth;
}


/* ѡ��л��¼� */
$(".tab-nav-content").on("click", ".content-tab", navChange);
/* ѡ��ر��¼� */
$(".tab-nav-content").on("click", ".content-tab i", closePage);
/* ѡ�˫���ر��¼� */
$(".tab-nav-content").on("dblclick", ".content-tab", closePage);


/* ѡ��л����� */
function navChange() {
	if (!$(this).hasClass("active")) {
		var k = $(this).data("id");
		$(".body-iframe").each(function() {
			if ($(this).data("id") == k) {
				$(this).show().siblings(".body-iframe").hide();
				return false;
			}
		});
		$(this).addClass("active").siblings(".content-tab").removeClass("active");
		addTab(this);
	}
}

/* ѡ��رշ��� */
function closePage() {
	var url = $(this).parents(".content-tab").data("id");
	var cur_width = $(this).parents(".content-tab").width();
	if ($(this).parents(".content-tab").hasClass("active")) {
		if ($(this).parents(".content-tab").next(".content-tab").size()) {
			var next_url = $(this).parents(".content-tab").next(".content-tab:eq(0)").data("id");
			$(this).parents(".content-tab").next(".content-tab:eq(0)").addClass("active");
			$(".body-iframe").each(function() {
				if ($(this).data("id") == next_url) {
					$(this).show().siblings(".body-iframe").hide();
					return false;
				}
			});
			var n = parseInt($(".tab-nav-content").css("margin-left"));
			if (n < 0) {
				$(".tab-nav-content").animate({marginLeft: (n + cur_width) + "px"},"fast")
			}
			$(this).parents(".content-tab").remove();
			$(".body-iframe").each(function() {
				if ($(this).data("id") == url) {
					$(this).remove();
					return false;
				}
			});
		}
		if ($(this).parents(".content-tab").prev(".content-tab").size()) {
			var prev_url = $(this).parents(".content-tab").prev(".content-tab:last").data("id");
			$(this).parents(".content-tab").prev(".content-tab:last").addClass("active");
			$(".body-iframe").each(function() {
				if ($(this).data("id") == prev_url) {
					$(this).show().siblings(".body-iframe").hide();
					return false;
				}
			});
			$(this).parents(".content-tab").remove();
			$(".body-iframe").each(function() {
				if ($(this).data("id") == url) {
					$(this).remove();
					return false;
				}
			});
		}
	} else {
		$(this).parents(".content-tab").remove();
		$(".body-iframe").each(function() {
			if ($(this).data("id") == url) {
				$(this).remove();
				return false;
			}
		});
		addTab($(".content-tab.active"));
	}
	return false;
}


/* ͷ�������������Ƴ� */
$(document).on("mouseenter",".header-bar-nav",function(){
	$(this).addClass("open");
});
$(document).on("mouseleave",".header-bar-nav",function(){
	$(this).removeClass("open");
});

/* ���˵�չ���͹رհ� ť�¼� */
$(document).on("click",".layout-side-arrow",function(){
	if($(".layout-side").hasClass("close")){
		$(".layout-side").removeClass("close");
		$(".layout-main").removeClass("full-page");
		$(".layout-footer").removeClass("full-page");
		$(this).removeClass("close");
		$(".layout-side-arrow-icon").removeClass("close");
	}else{
		$(".layout-side").addClass("close");
		$(".layout-main").addClass("full-page");
		$(".layout-footer").addClass("full-page");
		$(this).addClass("close");
		$(".layout-side-arrow-icon").addClass("close");
	}
});

/* ͷ���˵���ť����¼� */
$(".header-menu-btn").click(function(){
	$(".layout-side").removeClass("close");
	$(".layout-main").removeClass("full-page");
	$(".layout-footer").removeClass("full-page");
	$(".layout-side-arrow").removeClass("close");
	$(".layout-side-arrow-icon").removeClass("close");
	$(".layout-side").slideToggle();
});

/* ���˵���Ӧʽ */
$(window).resize(function() {  
	var width = $(this).width();  
	if(width >= 750){
		$(".layout-side").show();
	}else{
		$(".layout-side").hide();
	}
});

/* Ƥ��ѡ�� */
$(".dropdown-skin li a").click(function(){
	var v = $(this).attr("data-val");
	var hrefStr=$("#layout-skin").attr("href");
	var hrefRes=hrefStr.substring(0,hrefStr.lastIndexOf('skin/'))+'skin/'+v+'/skin.css';
	$(window.frames.document).contents().find("#layout-skin").attr("href",hrefRes);
	setCookie("scclui-skin", v);
});

/* ��ȡcookie�е�Ƥ�� */
function getSkinByCookie(){
	var v = getCookie("scclui-skin");
	var hrefStr=$("#layout-skin").attr("href");
	if(v == null || v == ""){
		v="qingxin";
	}
	if(hrefStr != undefined){
		var hrefRes=hrefStr.substring(0,hrefStr.lastIndexOf('skin/'))+'skin/'+v+'/skin.css';
		$("#skin").attr("href",hrefRes);
	}
}

/* ѭ���˵� */
function initMenu(menu,parent){
	for(var i=0; i<menu.length; i++){   
		var item = menu[i];
		var str = "";
		try{
			if(item.isHeader == "1"){
				str = "<li class='menu-header'>"+item.name+"</li>";
				$(parent).append(str);
				if(item.childMenus != ""){
					initMenu(item.childMenus,parent);
				}
			}else{
				item.icon == "" ? item.icon = "&#xe610" : item.icon = item.icon;
				if(item.childMenus == ""){
					str = "<li><a href='"+item.url+"'><i class='icon-font'>"+item.icon+"</i><span>"+item.name+"</span></a></li>";
					$(parent).append(str);
				}else{
					str = "<li><a href='"+item.url+"'><i class='icon-font '>"+item.icon+"</i><span>"+item.name
						+"</span><i class='icon-font icon-right'>&#xe60b;</i></a>";
					str +="<ul class='menu-item-child' id='menu-child-"+item.id+"'></ul></li>";
					$(parent).append(str);
					var childParent = $("#menu-child-"+item.id);
					initMenu(item.childMenus,childParent);
				}
			}
		}catch(e){}
	}
}

/* ��ʼ������*/
$(function(){
	/* �� ȡƤ��*/
	getSkinByCookie();
	/* �˵�json */
	var menu = [{"id":"1","name":"���˵�","parentId":"0","url":"","icon":"","order":"1","isHeader":"1","childMenus":[
	        {"id":"3","name":"��Ʒ����","parentId":"1","url":"","icon":"&#xe604;","order":"1","isHeader":"0","childMenus":[
	        {"id":"4","name":"Ʒ�ƹ���","parentId":"3","url":"test1.html","icon":"","order":"1","isHeader":"0","childMenus":""},
	        {"id":"5","name":"�������","parentId":"3","url":"test2.html","icon":"","order":"1","isHeader":"0","childMenus":""}]},
			{"id":"6","name":"��������","parentId":"1","url":"","icon":"&#xe602;","order":"1","isHeader":"0","childMenus":[
			{"id":"8","name":"δ����","parentId":"6","url":"home4.html","icon":"","order":"1","isHeader":"0","childMenus":""}]}]}];
	initMenu(menu,$(".side-menu"));
	$(".side-menu > li").addClass("menu-item");
	/* ��ȡ�˵�icon���ɫ */
	getMathColor();
});

/*</script>*/
