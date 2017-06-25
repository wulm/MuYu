// 鎵╁睍鍚庣画鐨刯s妯″潡
(function (window) {

	// 娉ㄦ剰锛�涓笅鍒掔嚎
	window.___E_mod = function (fn) {
		var E = window.___E;
		if (E == null) {
			// 璇存槑涓�紑濮嬬殑楠岃瘉娌℃湁閫氳繃锛岀洿鎺ヨ繑鍥炲嵆鍙�			return;
		}

		// 鎵ц浼犲叆鐨�fn 鍑芥暟
		fn(E, window.Zepto);
	};


})(window);
// 妫�祴鍚勪釜鏀寔椤规槸鍚﹀瓨鍦�(function (window) {

	var $ = window.Zepto,
		E = window.___E,
		gitlink = 'github.com/wangfupeng1988/wangEditor-mobile';

	// 楠岃瘉鏄惁閲嶅寮曠敤
	if(E != null) {
		if (E.gitlink === gitlink) {
			// 閲嶅寮曠敤锛屾彁绀猴紝骞堕�鍑�			alert('涓嶅緱閲嶅寮曠敤wangEditor鐨刯s鏂囦欢');
			return;
		}
		if (!E.gitlink || E.gitlink !== gitlink) {
			// 灞炴�鍚嶅凡琚崰鐢�			alert('window.___E 灞炴�鍚嶅凡缁忚鍏朵粬绋嬪簭鍗犵敤銆倃angEditor-mobile寮曠敤澶辫触');
			return;
		}
	}

	// 楠岃瘉 zepto 鏄惁寮曠敤
	if ($ == null) {
		alert('wangEditor-mobile渚濊禆浜巣epto锛岃鍏堝紩鐢▃epto.js');
		return;
	}

	// 楠岃瘉娴忚鍣ㄥrange鐨勬敮鎸�	if (!document.createRange || typeof  document.createRange !== 'function') {
		alert('褰撳墠娴忚鍣ㄤ笉鏀寔document.createRange锛屼笉鑳界敓鎴愬瘜鏂囨湰缂栬緫鍣�);
		return;
	}

})(window);
// 鏋勯�鍑芥暟
(function (window, $){

	// 鏍囪
	var gitlink = 'github.com/wangfupeng1988/wangEditor-mobile';

	// 瀹氫箟鏋勯�鍑芥暟
	var E = function (textareaId) {
		var self = this;

		self.$body = $('body');

		// textarea
		var $textarea = $('#' + textareaId);
		self.$textarea = $textarea;

		// 璁板綍姣忎竴涓猼ap浜嬩欢鐨勬椂闂达紝闃叉鐭椂闂村唴閲嶅tap
		self.checkTapTime = function (e, info) {
			//E.log('checkTapTime', info);

			var type = e.type.toLowerCase();
			var currentElem;
			var $currentElem;
			var result = true;

			if (type.indexOf('tap') < 0) {
				// 鍙拡瀵�tap锛屽叾浠栫殑涓嶇
				return result;
			}

			if (e) {
				// 浼犲叆 event 瀵硅薄锛屽垯涓烘瘡涓猠vent瀵硅薄鍒嗛厤浜嬩欢
				currentElem = e.currentTarget || e.target;
				$currentElem = $(currentElem);
			} else {
				// 鏈紶鍏ワ紝鍒欓兘鐢╞ody
				$currentElem = self.$body;
			}

			if ($currentElem.data('tapTime') == null) {
				// 绗竴娆★紝鐩存帴閫氳繃
				$currentElem.data('tapTime', Date.now().toString());
				result = true;
			} else {
				if (Date.now() - parseInt($currentElem.data('tapTime')) < 100) {
					// 濡傛灉褰撳墠鏃堕棿鍜屼笂涓�tapTime鐩稿樊 **ms 涔嬪唴锛�					// 鍒欒涓烘棤鏁堬紝骞堕樆姝㈠啋娉″拰榛樿琛屼负
					e.preventDefault();
					e.stopPropagation();
					result = false;
				} else {
					// 鍚﹀垯灏辩户缁苟鏇存柊tapTime
					$currentElem.data('tapTime', Date.now().toString());
					result = true;
				}
			}

			return result;
		};

		// ---------鎺ヤ笅鏉ュ嵆鍒濆鍖栧悇涓粍浠堕厤缃�---------

		// 鍒濆鍖栫紪杈戝櫒瀵硅薄鐨勯粯璁ら厤缃�		self.initDefaultConfig();

		// 鍒濆鍖栫紪杈戝尯鍩熺殑閰嶇疆
		self.addTxt();

		// 鍒濆鍖栬彍鍗曢厤缃�		self.addMenus();
	};

	// 鍘熷瀷 alias
	E.fn = E.prototype;

	// 鍋氫竴涓爣璁帮紝鐢ㄦ潵鍒ゆ柇鏄惁閲嶅寮曠敤
	E.fn.gitlink = gitlink;

	// console.log 鍑芥暟
	E.log = function (a, b) {
		if (window.console) {
			if (b) { console.log(a, b); } else { console.log(a); }
		} else {
			alert(a);
			if (b) { alert(b); }
		}
	};
	// console.warn 鍑芥暟
	E.warn = function (a, b) {
		if (window.console) {
			if (b) { console.warn(a, b); } else { console.warn(a); }
		} else {
			alert(a);
			if (b) { alert(b); }
		}
	};

	// 鏆撮湶鍏ㄥ眬鍑芥暟
	window.___E = E;

})(window, window.Zepto);
// 鑷畾涔塧lert
window.___E_mod(function (E, $) {


});
// userAgent
window.___E_mod(function (E, $) {

	var agent = window.navigator.userAgent.toLowerCase();

	E.isAndroid = agent.indexOf('android') > 0;

	E.isUC = agent.indexOf('ucbrowser') > 0;

	E.agent = agent;

});
// 鍒濆鍖栭潤鎬侀厤缃枃浠�window.___E_mod(function (E, $) {

	// 鍏ㄥ眬閰嶇疆
	E.config = {
		
		// 鑿滃崟鏍忎腑鐨�color 鎸夐挳鐐瑰嚮鏃剁殑棰滆壊鍊硷紙鍗砪ss涓殑棰滆壊鍊硷級
		menuColorValue: 'red',

		// 鑿滃崟鏍忎腑鐨�quote 鎸夐挳鐐瑰嚮鏃剁殑鏍峰紡
		menuQuoteStyle: {
			'display': 'block',
			'border-left': '5px solid #d0e5f2',
			'padding': '4px 0 4px 10px',
			'background-color': '#f1f1f1',
			'margin': '4px 0'
		},

		// 鑿滃崟閰嶇疆
		menus: [
			'head',
			'bold',
			'color',
			'quote',
			'list',
			'img',
			'happy',
			'check'
		],

		// 琛ㄦ儏鍥炬爣閰嶇疆
		happy: [
			'http://wangeditor.github.io/expressions/1.gif',
			'http://wangeditor.github.io/expressions/2.gif',
			'http://wangeditor.github.io/expressions/3.gif',
			'http://wangeditor.github.io/expressions/4.gif',
			'http://wangeditor.github.io/expressions/5.gif',
			'http://wangeditor.github.io/expressions/6.gif',
			'http://wangeditor.github.io/expressions/7.gif',
			'http://wangeditor.github.io/expressions/8.gif',
			'http://wangeditor.github.io/expressions/9.gif',
			'http://wangeditor.github.io/expressions/10.gif',
			'http://wangeditor.github.io/expressions/11.gif',
			'http://wangeditor.github.io/expressions/12.gif',
			'http://wangeditor.github.io/expressions/13.gif',
			'http://wangeditor.github.io/expressions/14.gif',
			'http://wangeditor.github.io/expressions/15.gif',
			'http://wangeditor.github.io/expressions/16.gif',
			'http://wangeditor.github.io/expressions/17.gif',
			'http://wangeditor.github.io/expressions/18.gif',
			'http://wangeditor.github.io/expressions/19.gif',
			'http://wangeditor.github.io/expressions/20.gif'
		],

		// 涓婁紶鍥剧墖
		uploadImgUrl: '',

		// 涓婁紶鏂囦欢鐨勮秴鏃舵椂闂达紙榛樿 10s锛�		uploadTimeout: 10 * 1000,

		// 娴嬭瘯鍦板潃锛堝湪娴嬭瘯鍦板潃锛岀紪杈戝櫒浼氫富鍔ㄨ緭鍑轰竴浜沜onsole.log淇℃伅锛�		testHostname: 'localhost',

		// 涓婁紶鍥剧墖鏃讹紝濡傛灉娴忚鍣ㄤ笉鏀寔棰勮鍥剧墖锛屽垯鐢ㄤ互涓嬪浘鐗囦唬鏇�		loadingImg: 'http://images2015.cnblogs.com/blog/138012/201512/138012-20151208194759027-506651939.gif',
	};
	
});
// 鍒濆鍖栧璞￠厤缃�window.___E_mod(function (E, $) {

	E.fn.initDefaultConfig = function () {
		var self = this;
		var globalConfig = E.config;
		// 浠庡叏灞�厤缃嫹璐濆埌瀵硅薄閰嶇疆
		var objConfig = $.extend({}, globalConfig);
		
		// 璧嬪�鍒板璞′腑
		self.config = objConfig;
	};
	
});
// 涓婁紶鍥剧墖
window.___E_mod(function (E, $) {

	var isAndroid = E.isAndroid;
	var isUC = E.isUC;


	

});
// 鍒濆鍖栫紪杈戝尯鍩熺殑鏁版嵁瀵硅薄
window.___E_mod(function (E, $) {

	E.fn.addTxt = function () {
		var self = this;
		var $textarea = self.$textarea;
		var val = $.trim($textarea.val());

		// 缂栬緫鍖哄煙锛堝皢textarea鐨勫�锛岀洿鎺ュ鍒惰繃鏉ワ級
		var $txt = $(
			'<div contentEditable="true" class="wangEditor-mobile-txt">' + 
			val + 
			'</div>'
		);

		// modal container
		var $modalContainer = $('<div class="wangEditor-mobile-modal-container"></div>');

		// 璁板綍鍒板璞′腑
		self.$txt = $txt;
		self.$modalContainer = $modalContainer;

		// 鏈�悗鎻掑叆涓�釜绌鸿
		self.insertEmpltyLink();
	};
	
});
// 澧炲姞鑷甫鐨勮彍鍗曟暟鎹璞�window.___E_mod(function (E, $) {

	E.fn.addMenus = function () {
		var self = this;

		// ------------- menus container  
		var $menuContainer = $('<div class="wangEditor-mobile-menu-container" contentEditable="false"></div>');
		var $menuItemContainer = $('<div class="item-container"></div>');
		var $menuContainerTip = $('<div class="tip"></div>');  // 涓夎褰�
		// 澧炲姞灏忎笁瑙�tip
		$menuContainer.append($menuContainerTip);

		// 鑿滃崟椤圭殑瀹瑰櫒
		$menuContainer.append($menuItemContainer);

		// 娣诲姞鍒版暟鎹璞�		self.$menuContainer = $menuContainer;
		self.$menuItemContainer = $menuItemContainer;

		// ------------- menus 鏁版嵁闆嗗悎 ------------- 
		self.menus = {};		
		self.addMenuBold('bold');
		self.addMenuHead('head');
		self.addMenuColor('color');
		self.addMenuQuote('quote');
		self.addMenuList('list');
		self.addMenuCheck('check');
		self.addMenuHappy('happy');
		self.addMenuImg('img');
	};

});
// bold
window.___E_mod(function (E, $) {

	E.fn.addMenuBold = function (menuId) {
		var self = this;
		var menus = self.menus;

		menus[menuId] = {

			// 鏄惁澶勪簬閫変腑鐘舵�
			selected: false,

			// 瑙﹀彂鍣�			$trigger: $('<div><i class="icon-wangEditor-m-bold"></i></div>'),
			// 鍖呰９瑙﹀彂鍣ㄧ殑瀹瑰櫒
			$wrap: $('<div class="item"></div>'),

			// 缁戝畾瑙﹀彂鍣ㄤ簨浠�			bindEvent: function (editor) {
				var menuData = this;
				menuData.$trigger.on('singleTap', function (e) {
					if (self.checkTapTime(e, 'bold') === false) {
						return;
					}

					self.command('bold', false, undefined, e);

				});
			},

			// 鏇存柊鏍峰紡
			updateStyle: function (editor) {
				var menuData = this;
				var $trigger = menuData.$trigger;

				if ( document.queryCommandState('bold') ) {
					menuData.selected = true;
					$trigger.addClass('selected');
				} else {
					menuData.selected = false;
					$trigger.removeClass('selected');
				}
			}
		};
	};

});
// head
window.___E_mod(function (E, $) {

	E.fn.addMenuHead = function (menuId) {
		var self = this;
		var menus = self.menus;

		menus[menuId] = {
			// 鏄惁澶勪簬閫変腑鐘舵�
			selected: false,

			// 瑙﹀彂鍣�			$trigger: $('<div><i class="icon-wangEditor-m-header"></i></div>'),
			// 鍖呰９瑙﹀彂鍣ㄧ殑瀹瑰櫒
			$wrap: $('<div class="item"></div>'),

			// 缁戝畾瑙﹀彂鍣ㄤ簨浠�			bindEvent: function (editor) {
				var menuData = this;
				menuData.$trigger.on('singleTap', function (e) {
					if (self.checkTapTime(e, 'head') === false) {
						return;
					}

					// 鎵ц鍛戒护
					if (menuData.selected) {
						self.command('formatblock', false, 'p', e);
					} else {
						self.command('formatblock', false, 'h3', e);
					}
				});
			},

			// 鏇存柊鏍峰紡
			updateStyle: function (editor) {
				var menuData = this;
				var $trigger = menuData.$trigger;
				var	value = document.queryCommandValue('formatblock');

				if ( /^h\d{1}$/i.test(value) ) {
					menuData.selected = true;
					$trigger.addClass('selected');
				} else {
					menuData.selected = false;
					$trigger.removeClass('selected');
				}
			}
		};
	};
	
});
// color
window.___E_mod(function (E, $) {

	E.fn.addMenuColor = function (menuId) {
		var self = this;
		var menus = self.menus;
		var configColor = self.config.menuColorValue;

		menus[menuId] = {
			// 鏄惁澶勪簬閫変腑鐘舵�
			selected: false,

			// 瑙﹀彂鍣�			$trigger: $('<div><i class="icon-wangEditor-m-brush"></i></div>'),
			// 鍖呰９瑙﹀彂鍣ㄧ殑瀹瑰櫒
			$wrap: $('<div class="item"></div>'),

			// 缁戝畾瑙﹀彂鍣ㄤ簨浠�			bindEvent: function (editor) {
				var menuDate = this;
				var $trigger = menuDate.$trigger;

				$trigger.on('singleTap', function (e) {
					if (self.checkTapTime(e, 'color') === false) {
						return;
					}

					var color = configColor;

					if (menuDate.selected) {
						color = '#000';
					}
					self.command('forecolor', false, color, e);
				});
			},

			// 鏇存柊鏍峰紡
			updateStyle: function (editor) {
				var menuDate = this;
				var $trigger = menuDate.$trigger;
				var foreColor = document.queryCommandValue('forecolor');
				if (foreColor !== 'rgb(0, 0, 0)') {
					menuDate.selected = true;
					$trigger.addClass('selected');
				} else {
					menuDate.selected = false;
					$trigger.removeClass('selected');
				}
			}
		};
	};

});
// quote
window.___E_mod(function (E, $) {

	E.fn.addMenuQuote = function (menuId) {
		var self = this;
		var menus = self.menus;
		var $txt = self.$txt;
		var configQuoteStyle = self.config.menuQuoteStyle;

		menus[menuId] = {
			// 鏄惁澶勪簬閫変腑鐘舵�
			selected: false,

			// 瑙﹀彂鍣�			$trigger: $('<div><i class="icon-wangEditor-m-quote-left"></i></div>'),
			// 鍖呰９瑙﹀彂鍣ㄧ殑瀹瑰櫒
			$wrap: $('<div class="item"></div>'),

			// 缁戝畾瑙﹀彂鍣ㄤ簨浠�			bindEvent: function (editor) {
				var menuData = this;
				menuData.$trigger.on('singleTap', function (e) {
					if (self.checkTapTime(e, 'quote') === false) {
						return;
					}

					// 鎵ц鍛戒护
					var $focusElem = self.$focusElem;
					var $quoteElem;
					var text;
					var commandFn;
					if (menuData.selected) {
						// 姝ゆ椂宸茬粡鏄�quote 鐘舵�锛屾鏃剁偣鍑伙紝搴旇鎭㈠涓烘櫘閫氭枃瀛�						
						// 鑾峰彇褰撳墠鐨�quote 鍏冪礌
						if ($focusElem.get(0).nodeName === 'BLOCKQUOTE') {
							$quoteElem = $focusElem;
						} else {
							$quoteElem = $focusElem.closest('blockquote');
						}

						if ($quoteElem.length === 0) {
							// 娌℃湁鎵惧埌 blockquote 鍏冪礌
							return;
						}

						// 鑾峰彇鏂囨湰
						text = $quoteElem.text();

						// 瀹氫箟涓�釜鑷畾涔夌殑鍛戒护浜嬩欢
						commandFn = function () {
							var $p = $('<p>' + text + '</p>');
							$quoteElem.after($p);
							$quoteElem.remove();
						};

						// 鎵ц鐩栬嚜瀹氫箟浜嬩欢
						self.customCommand(false, commandFn, e);

					} else {
						// 褰撳墠涓嶆槸quote鐘舵�

						// 鎵ц鍛戒护锛屽皢娈佃惤璁剧疆涓簈uote
						self.command('formatblock', false, 'blockquote', e);

						// 璁剧疆quote鏍峰紡锛堝垰鍒氳璁剧疆涓簈uote锛�						self.$txt.find('blockquote').each(function(key, node){
							// 閬嶅巻缂栬緫鍖哄煙鎵�湁鐨剄uote
							var $quote = $(node),
								styleKey = 'w_editor_quote_style',
								hasStyle = $quote.attr(styleKey);

							// 濡傛灉娌℃湁鏍囪锛屽垯璁剧疆鏍峰紡骞惰褰曟爣璁�							if(hasStyle == null){
								// configQuoteStyle 鏄厤缃殑鏍峰紡锛屽彲鍦�editor.config 涓慨鏀�								$quote.css(configQuoteStyle);
								$quote.attr(styleKey, '1');
							}
						});

					} // else
				});
			},

			// 鏇存柊鏍峰紡
			updateStyle: function (editor) {
				var menuData = this;
				var $trigger = menuData.$trigger;
				var value = document.queryCommandValue('formatblock');

				if ( /^blockquote$/i.test(value) ) {
					menuData.selected = true;
					$trigger.addClass('selected');
				} else {
					menuData.selected = false;
					$trigger.removeClass('selected');
				}
			}
		};
	};

});
// list
window.___E_mod(function (E, $) {

	E.fn.addMenuList = function (menuId) {
		var self = this;
		var menus = self.menus;

		menus[menuId] = {
			// 鏄惁澶勪簬閫変腑鐘舵�
			selected: false,

			// 瑙﹀彂鍣�			$trigger: $('<div><i class="icon-wangEditor-m-list-ul"></i></div>'),
			// 鍖呰９瑙﹀彂鍣ㄧ殑瀹瑰櫒
			$wrap: $('<div class="item"></div>'),

			// 缁戝畾瑙﹀彂鍣ㄤ簨浠�			bindEvent: function (editor) {
				var menuData = this;
				menuData.$trigger.on('singleTap', function (e) {
					if (self.checkTapTime(e, 'list') === false) {
						return;
					}

					if (!menuData.selected) {
						// 濡傛灉褰撳墠鐘舵�涓嶆槸list
						// 鎵ц鍛戒护鍓嶏紝鍏堝幓鎺�focus 鐨勬牱寮�						self.$focusElem.removeClass('focus-elem');
					}

					// 鎵ц鍛戒护
					self.command('InsertUnorderedList', false, undefined, e);
					
				});
			},

			// 鏇存柊鏍峰紡
			updateStyle: function (editor) {
				var menuData = this;
				var $trigger = menuData.$trigger;

				if ( document.queryCommandState('InsertUnorderedList') ) {
					menuData.selected = true;
					$trigger.addClass('selected');
				} else {
					menuData.selected = false;
					$trigger.removeClass('selected');
				}
			}
		};
	};

});
// check
window.___E_mod(function (E, $) {

	E.fn.addMenuCheck = function (menuId) {
		var self = this;
		var menus = self.menus;

		menus[menuId] = {
			// 鏄惁澶勪簬閫変腑鐘舵�
			selected: false,

			// 瑙﹀彂鍣�			$trigger: $('<div><i class="icon-wangEditor-m-checkbox-checked"></i></div>'),
			// 鍖呰９瑙﹀彂鍣ㄧ殑瀹瑰櫒
			$wrap: $('<div class="item"></div>'),

			// 缁戝畾瑙﹀彂鍣ㄤ簨浠�			bindEvent: function (editor) {
				var tapTime = Date.now();
				var menuData = this;
				menuData.$trigger.on('singleTap', function (e) {
					if (self.checkTapTime(e, 'check') === false) {
						return;
					}

					// 鏋勫缓dom缁撴瀯
					var $checkbox = $('<input type="checkbox"/>');
					var $content = $('<p></p>');
					$content.append($checkbox).append('&nbsp;&nbsp;');

					// 鍒濆鍖�checkbox 浜嬩欢
					$checkbox.on('singleTap', function (e) {
						// 鏌愪簺鎯呭喌涓嬶紝娴忚鍣ㄧ殑tap浜嬩欢浼氳杩炵画瑙﹀彂涓ゆ锛屽湪姝ゅ鐞�						if (Date.now() - tapTime < 50) {
							return;
						} else {
							tapTime = Date.now();
						}

						var $checkbox = $(e.target);
						var checked = $checkbox.is(':checked');
						$checkbox.prop('checked', !checked);

						// 鏈�悗涓嶈蹇樿闃绘鍐掓场
						e.preventDefault();
						e.stopPropagation();
					});

					// 鎵ц鍛戒护
					var fn = function () {
						self.$focusElem.after($content);
					};
					self.customCommand(false, fn, e);
				});
			},

			// 鏇存柊鏍峰紡
			updateStyle: function (editor) {
				// 鏆傛椂涓嶉渶瑕�			}
		};
	};

});
// 琛ㄦ儏鑿滃崟
window.___E_mod(function (E, $) {

	E.fn.addMenuHappy = function (menuId) {
		var self = this;
		var $body = self.$body;
		var menus = self.menus;
		var happyUrlArr = self.config.happy;
		var $txt = self.$txt;

		// 鎻愰啋锛屼笉瑕佷娇鐢ㄧ紪杈戝櫒鑷甫鐨勮〃鎯�		if (happyUrlArr.length > 0) {
			if (happyUrlArr[0].indexOf('http://wangeditor.github.io/expressions') === 0) {
				E.warn('姝ｅ湪浣跨敤wangEdior鎻愪緵鐨勫厤璐硅〃鎯呭浘鏍囷紝瀹冧滑灏嗕粠 github 涓嬭浇锛岄�搴﹀緢鎱紒锛侊紒寤鸿灏嗚〃鎯呭浘鏍囬噸鏂伴厤缃紝璇峰弬瑙佹枃妗ｈ鏄�);
			}
		}

		menus[menuId] = {
			// 閫変腑鐘舵�
			selected: false,

			// 瑙﹀彂鍣�			$trigger: $('<div><i class="icon-wangEditor-m-happy"></i></div>'),
			// 鍖呰９瑙﹀彂鍣ㄧ殑瀹瑰櫒
			$wrap: $('<div class="item"</div>'),

			// $modal 
			$modal: $('<div class="wangEditor-mobile-modal"></div>'),

			// 娓叉煋 $modal
			renderModal: function () {
				var menuData = this;
				var $modal = menuData.$modal;
				var itemTpl = '<span class="command-link" commandValue="#{imgUrl}"><img src="#{imgUrl}"/></span>';
				var contentHtmlArr = [];

				// 鎷兼帴鏁版嵁
				$.each(happyUrlArr, function (key, value) {
					contentHtmlArr.push(
						itemTpl.replace(/#{imgUrl}/ig, value)
					);
				});
				$modal.append(contentHtmlArr.join(''));

				// 娓叉煋鍒伴〉闈腑
				$body.append($modal);

				// 瀹氫綅
				var width = $modal.width();
				$modal.css('margin-left', (0 - width)/2);

				// 缁戝畾琛ㄦ儏鍥炬爣鐨勪簨浠�				$modal.on('click', '.command-link', function (e) {
					// 灞忚斀click浜嬩欢鐨勯粯璁よ涓�					e.preventDefault();
				});
				$modal.on('singleTap', '.command-link', function (e) {
					if (self.checkTapTime(e, 'happy command-link') === false) {
						return;
					}

					var $commandLink = $(e.currentTarget);
					var commandValue = $commandLink.attr('commandValue');

					// 鎵ц鍛戒护
					self.command('InsertImage', false, commandValue, e);

					// 闅愯棌 modal
					menuData.hideModal();
				});
			},

			// 鏄剧ず $modal
			showModal: function () {
				var menuData = this;
				var $modal = menuData.$modal;
				var scrollTop = $body.get(0).scrollTop;

				// 鏄剧ず modal
				$modal.show();

				// 纭畾 modal 浣嶇疆
				$modal.css({
					'margin-top': (scrollTop + 50) + 'px'
				});

				// 鐐瑰嚮缂栬緫鍖哄煙闅愯棌modal
				var hideModalFn = function (e) {
					menuData.hideModal();

					// 闅愯棌modal涔嬪悗锛屾帴鐫�彇娑堜簨浠剁粦瀹�					$txt.off('singleTap', hideModalFn);
				};

				// 缁戝畾浜嬩欢
				$txt.on('singleTap', hideModalFn);
			},

			// 闅愯棌 $modal
			hideModal: function () {
				this.$modal.hide();
			},

			// 缁戝畾浜嬩欢
			bindEvent: function (editor) {
				var menuData = this;
				var $trigger = menuData.$trigger;
				var $modal = menuData.$modal;

				function commandFnForOneEvent() {
					menuData.renderModal();
					menuData.showModal();
				}

				function commandFnForOnEvent() {
					menuData.showModal();
				}

				// one缁戝畾鐨勬柟娉曞彧鎵ц涓�
				// 鐢ㄤ簬娓叉煋 modal 鍏冪礌骞舵樉绀�				$trigger.one('singleTap', function (e) {
					if (self.checkTapTime(e, 'happy one') === false) {
						return;
					}

					// 娓叉煋modal骞舵樉绀�					self.customCommand(true, commandFnForOneEvent, e);
				});

				// on 缁戝畾鐨勬柟娉曟瘡娆￠兘鎵ц
				// 鐢ㄤ簬姣忔鏄剧ず鍜岄殣钘弇odal
				$trigger.on('singleTap', function (e) {
					if (self.checkTapTime(e, 'happy on') === false) {
						return;
					}

					// 鏄剧ずmodal
					self.customCommand(true, commandFnForOnEvent, e);
				});
			},

			// 鏇存柊鏍峰紡
			updateStyle: function () {
				// 鏆傛椂涓嶉渶瑕�			}
		};	
	};

});
// 涓婁紶鍥剧墖
window.___E_mod(function (E, $) {
	E.fn.addMenuImg = function (menuId) {
		var self = this;
		var $body = self.$body;
		var $txt = self.$txt;
		var menus = self.menus;

		var isAndroid = E.isAndroid;
		var isUC = E.isUC;

		var idDebugger = false;  // 榛樿涓�false锛屼笅鏂囧彲鑳戒慨鏀�
		// 閽堝 test 鍦板潃锛屾墦鍗颁俊鎭�		function log(info) {
			if (!idDebugger) {
				return;
			}
			E.log(info);
		}

		// 鐢ㄩ殢鏈烘暟鐢熸垚input 鐨�id
		var inputFileId = 'inputfile' + Math.random().toString().slice(2);

		menus[menuId] = {
			// 閫変腑鐘舵�
			selected: false,

			// 瑙﹀彂鍣�			$trigger: (function () {
				// 涓嶅悓os銆佷笉鍚宐rowser鐨勬儏鍐典笉涓�牱
				if (isAndroid || isUC) {
					return $('<div><i class="icon-wangEditor-m-picture"></i></div>');
				} else {
					return $('<label for="' + inputFileId + '"><i class="icon-wangEditor-m-picture"></i></label>');
				}
			})(),
			
			// 鍖呰９瑙﹀彂鍣ㄧ殑瀹瑰櫒
			$wrap: $('<div class="item"</div>'),

			// 娓叉煋 form
			renderForm: function () {
				var fromHtml = [
					'<form',
					'    enctype="multipart/form-data"',
					'    method="post">',
					'    <input id="' + inputFileId + '" type="file" accept="image/*">',
					'</form>'
				].join('');

				var $container = $('<div style="display:none;"></div>');
				// var $container = $('<div></div>');
				$container.html(fromHtml);

				// 娓叉煋鍒伴〉闈腑
				$body.append($container);
			},


			// 缁戝畾鑿滃崟浜嬩欢
			bindEvent: function (editor) {
				var menuData = this;
				var $trigger = menuData.$trigger;

				// 灏�form 娓叉煋鍒伴〉闈笂
				menuData.renderForm();

				// 鑾峰彇 form input-file 瀵硅薄
				var $inputFlie = $('#' + inputFileId);

				// 灏嗕互base64鐨勫浘鐗噓rl鏁版嵁杞崲涓築lob
				function convertBase64UrlToBlob(urlData, filetype){
		    		//鍘绘帀url鐨勫ご锛屽苟杞崲涓篵yte
				    var bytes=window.atob(urlData.split(',')[1]);
				    
				    //澶勭悊寮傚父,灏哸scii鐮佸皬浜�鐨勮浆鎹负澶т簬0
				    var ab = new ArrayBuffer(bytes.length);
				    var ia = new Uint8Array(ab);
				    for (var i = 0; i < bytes.length; i++) {
				        ia[i] = bytes.charCodeAt(i);
				    }

				    // 绫诲瀷
				    if (filetype === '' || !filetype) {
				    	filetype = 'image/png';
				    }

				    return new Blob([ab], {type : filetype});
				}

				// input 鏈夋枃浠堕�涓椂锛屾樉绀洪瑙堝浘锛屾彁浜�form
				$inputFlie.on('change', function (e) {

					// 鑾峰彇閰嶇疆椤瑰唴瀹�					var config = self.config;
					var uploadImgUrl = config.uploadImgUrl || '';
					var testHostname = config.testHostname || 'localhost';
					var loadingImgUrl = config.loadingImg;
					var timeout = config.uploadTimeout || 10000;

					idDebugger = testHostname === window.location.hostname;

					// 鍒ゆ柇鏀规祻瑙堝櫒鏄惁鏀寔 FormData 鍜�fileReader
					if (!window.FileReader || !window.FormData) {
						alert('褰撳墠娴忚鍣ㄤ笉鏀寔html5涓殑 FileReader 鍜�FormData锛屾棤娉曚笂浼犲浘鐗�);
						return;
					}

					if (uploadImgUrl === '') {
						// 娌℃湁閰嶇疆涓婁紶鍥剧墖鐨剈rl
						alert(
							'娌℃湁閰嶇疆 uploadImgUrl 锛寃angEditor 灏嗘棤娉曚笂浼犲浘鐗囥�\n\n' + 
							'鎯宠閰嶇疆涓婁紶鍥剧墖锛岃鍙傝鏂囨。璇存槑銆俓n\n' + 
							'涓嶆兂瑕佸浘鐗囦笂浼狅紝鍙�杩囬厤缃�menus 闅愯棌璇ュ姛鑳姐�'
						);
						return;
					}

					var files = $inputFlie[0].files || [];
					if (files.length === 0) {
						return;
					}
					var file = files[0];
					var fileType = file.type || '';
					var reader = new FileReader();
					var $focusElem = self.$focusElem;

					log('閫変腑鐨勬枃浠朵负锛� + file.name);
					log('鏈嶅姟鍣ㄧ涓婁紶鍦板潃涓猴細' + uploadImgUrl);

					reader.onload = function(e){
						var base64 = e.target.result || this.result,
							prevImgSrc,
							prveImgContainerId = 'div' + Math.random().toString().slice(2),
							prevImgInfoId = 'info' +  Math.random().toString().slice(2),
							xhr,
							formData,
							timeoutId;

						// ---------- 鏄剧ず棰勮 ----------
						if (window.URL && window.URL.createObjectURL) {
							// 濡傛灉娴忚鍣ㄦ敮鎸侀瑙堟湰鍦板浘鐗囧姛鑳斤紝鍒欓瑙堟湰鍦板浘鐗�							prevImgSrc = window.URL.createObjectURL(file);

							// 鐢熸垚棰勮鍥剧墖锛岃缃崐閫忔槑
							$focusElem.after(
								'<div class="previmg-container" id="' + prveImgContainerId + '">' + 
								'   <p class="info" id="' + prevImgInfoId + '">涓婁紶涓�..</p>' +
								'	<img src="' + prevImgSrc + '" style="opacity:0.2; max-width:100%;"/>' + 
								'</div>'
							);
						} else {
							// 濡傛灉娴忚鍣ㄤ笉鏀寔棰勮鏈湴鍥剧墖锛屽垯澶嶅埗涓轰竴涓厤缃殑鍥剧墖鍦板潃
							prevImgSrc = loadingImgUrl;

							// 鐢熸垚棰勮鍥剧墖
							$focusElem.after(
								'<div class="previmg-container" id="' + prveImgContainerId + '">' + 
								'	<img src="' + prevImgSrc + '" style="max-width:100%;"/>' + 
								'</div>'
							);
						}
						log('鐢熸垚棰勮鍥剧墖锛宻rc鏄細' + prevImgSrc);

						// ---------- 涓婁紶鍒版湇鍔″櫒 ----------
						xhr = new XMLHttpRequest();
			            formData = new FormData();

			            // 璁块棶瓒呮椂
			            function timeoutCallback() {
			            	log('璁块棶瓒呮椂锛堥厤缃殑瓒呮椂浜嬩欢鏄細'+ timeout +'锛�);

			            	var $prevImgContainer = $('#' + prveImgContainerId);
			            	$prevImgContainer.remove();
	
			            	if (xhr.abort) {
			            		xhr.abort();
			            	}
			            	
			            	alert('涓婁紶瓒呮椂锛岃閲嶈瘯');

			            	if (location.hostname.toLowerCase() === 'wangeditor.github.io') {
			            		// 瀹樼綉demo鐨勭壒娈婃彁绀�			            		alert('鎻愮ず锛歸angEditor瀹樼綉demo娌℃湁鍚庡彴鏈嶅姟锛屽洜姝よ秴鏃讹紙璇lert鍦ㄥ疄闄呴」鐩腑涓嶄細鍑虹幇锛�);
			            	}
			            }

			            log('鍑嗗涓婁紶鏂囦欢...');
			            xhr.open('POST', uploadImgUrl, true);

			            // 璁℃椂寮�
			            timeoutId = setTimeout(timeoutCallback, timeout);
			            
			            xhr.onload = function () {
			            	// 寰楀埌娑堟伅涔嬪悗锛屾竻闄よ鏃�			            	clearTimeout(timeoutId);

			            	var resultSrc = xhr.responseText; //鏈嶅姟鍣ㄧ瑕佽繑鍥炲浘鐗噓rl鍦板潃
			            	var erroInfo;
			            	var $prevImgContainer = $('#' + prveImgContainerId);
			            	var loadImg;
			            	var $loadImg;

			            	log('鏈嶅姟鍣ㄧ鐨勮繑鍥炴暟鎹负锛� + resultSrc);

			            	// 杩斿洖鏁版嵁閿欒
			            	if (resultSrc.indexOf('error|') === 0) {
			            		erroInfo = resultSrc.split('|')[1];
			            		log('寰堥仐鎲撅紝鍚庡彴杩斿洖error锛岄敊璇俊鎭负锛� + erroInfo);
			            		
			            		// 鎻愮ず閿欒
			            		alert('涓婁紶鍥剧墖閿欒: \n' + erroInfo);

			            		// 绉婚櫎棰勮鍥剧墖
			            		$prevImgContainer.remove();

			            	} else {
			            		// 杩斿洖姝ｇ‘鐨勫浘鐗囧湴鍧�
			            		log('璇风‘璁や互涓婂浘鐗囨槸鍚︽湁鏁堬紝鏃犳晥灏嗘棤娉曟樉绀哄湪椤甸潰涓�);
			            		log('鍑嗗涓嬭浇璇ュ浘鐗�..');
			            		
			            		// 涓嬭浇鍥剧墖锛屼笅杞藉畬鎴愬悗璧嬪�鍒扮紪杈戝櫒涓�			            		$('#' + prevImgInfoId).text('鍔犺浇涓�..');
			
			            		loadImg = document.createElement('img');
			            		loadImg.src = resultSrc;
			            		loadImg.onload = function () {
			            			log('涓嬭浇瀹屾垚锛屾寮忓憟鐜板湪缂栬緫鍖哄煙');
		
									$loadImg = $(loadImg);
									$loadImg.css('max-width', '100%');
			            			$prevImgContainer.after($loadImg);
			            			$prevImgContainer.remove();

			            			// 淇濆瓨鍐呭
			            			self.saveSourceCode();
			            		};
			            		loadImg.onerror = function () {
			            			log('鍥剧墖鍔犺浇澶辫触锛岃纭畾杩欎釜url鏄惁鑳芥垚鍔熷緱鍒板浘鐗囷細' + resultSrc);
			            			
			            			alert('鍥剧墖鍔犺浇澶辫触');
			            			$prevImgContainer.remove();

			            			// 淇濆瓨鍐呭
			            			self.saveSourceCode();
			            		};
			            	}
			            };

			            // 娣诲姞鍥剧墖鏁版嵁
			            // 1. 鍥剧墖鏁版嵁瑕佺粡杩�convertBase64UrlToBlob 杞崲
			            // 2. wangEditorMobileFile 瑕佸拰鍚庡彴涓�嚧
			            //formData.append('wangEditorMobileFile', convertBase64UrlToBlob(base64, fileType));
			            formData.append('wangEditorMobileFile', base64);
			            xhr.send(formData);
					};

					//璇诲彇鏂囦欢
					reader.readAsDataURL(file);
				});

				// 鐐瑰嚮鑿滃崟锛岃Е鍙�input 浜嬩欢
				$trigger.on('singleTap', function (e) {
					// singleTap闇�楠岃瘉
					if (self.checkTapTime(e, 'img') === false) {
						return;
					}

					function fn() {
						$inputFlie.trigger('click');
					}

					self.customCommand(true, fn, e);
				});
			},


			// 鏇存柊鏍峰紡
			updateStyle: function () {
				// 鏆傛椂涓嶉渶瑕�			}
		};
	};
});
// 娓叉煋缂栬緫鍣ㄥ尯鍩�window.___E_mod(function (E, $) {

	E.fn.renderTxt = function () {
		var self = this;
		var $textarea = self.$textarea;
		var $txt = self.$txt;
		var $modalContainer = self.$modalContainer;
		var $body = self.$body;

		$textarea.after($txt);
		$textarea.hide();

		$body.append($modalContainer);
	};

});
// 娓叉煋鑿滃崟鏍�window.___E_mod(function (E, $) {

	E.fn.renderMenu = function () {
		var self = this;
		var menus = self.menus;
		var $menuContainer = self.$menuContainer;
		var $menuItemContainer = self.$menuItemContainer;
		var $txt = self.$txt;
		var $gap = $('<div class="gap"></div>');
		var $body = self.$body;

		// 閰嶇疆鏂囦欢涓殑鑿滃崟閰嶇疆
		var configMenus = self.config.menus;

		// 閬嶅巻鑿滃崟閰嶇疆闆嗗悎锛屾覆鏌撹彍鍗�		$.each(configMenus, function (key, menuId) {
			var menu = menus[menuId];
			if (menu == null) {
				return;
			}

			var $trigger = menu.$trigger;
			var $wrap = menu.$wrap;

			if ($trigger) {
				// 娓叉煋鑿滃崟
				if ($wrap) {
					$wrap.append($trigger);
					$menuItemContainer.append($wrap);
				} else {
					$menuItemContainer.append($trigger);
				}
				
				// 鑿滃崟涔嬮棿鐨勯棿闅�				// 涔嬫墍浠ラ渶瑕佸姞 clone 鏄洜涓�append 鐢变竴绉嶃�鍗曚緥绉诲姩銆忕殑鐗规�锛侊紒闇�敞鎰忥紒锛�				$menuItemContainer.append($gap.clone());
			}
		});

		// 鍒犻櫎鏈�悗涓�釜闂撮殭锛堝嵆鏈�悗涓�釜瀛愬厓绱狅級
		$menuItemContainer.children().last().remove();

		// 榛樿闅愯棌
		$menuContainer.hide();
		
		// 鍙橀噺璁板綍鑿滃崟瀹瑰櫒鐨勬樉绀轰笌闅愯棌
		self.menuDisplayShow = false;
		$body.append($menuContainer);
	};

});
// 缁戝畾document浜嬩欢
window.___E_mod(function (E, $) {

	E.fn.bindDocumentEvent = function () {
		var $document = $(document);
		var self = this;
		var $txt = self.$txt;
		var srollTime = Date.now();

		// 婊氬姩鏃堕殣钘忚彍鍗曟爮
		$document.on('scroll', function (e) {
			// 缁欐粴鍔ㄤ簨浠跺鍔犱竴涓椂闂撮棿闅旂殑闄愬埗
			if (Date.now() - srollTime <= 50) {
				return;
			} else {
				srollTime = Date.now();
			}

			// 闅愯棌鑿滃崟
			self.hideMenuContainer();

		});
	};

});
// 缁戝畾缂栬緫鍖哄煙浜嬩欢
window.___E_mod(function (E, $) {

	E.fn.bindTxtEvent = function () {
		var self = this;
		var $txt = self.$txt;
		var $menuContainer = self.$menuContainer;
		var menuContainer = $menuContainer.get(0);
		var srollTime = Date.now();

		// 澶勭悊鐐瑰嚮 $txt 鐨勯�鍖�		// $txt 鐨�tap 浜嬩欢涓皟鐢�		function selectionHeadle () {
			var focusElem;
			var $focusElem;

			// 淇濆瓨閫変腑鍖哄煙
			self.saveSelection();

			// 鑾峰彇褰撳墠閫変腑鐨勫厓绱狅紝骞惰缃竴涓珮浜牱寮�			focusElem = self.getWrapRangeElem();
			if (focusElem) {
				$focusElem = $(focusElem);
				// 澧炲姞鏍峰紡
				$focusElem.addClass('focus-elem');
				self.$focusElem = $focusElem;
			}

			// 鏇存柊鑿滃崟鏍峰紡
			self.updateMenuStyle();

		} // 澶勭悊鐐瑰嚮 $txt 鐨勯�鍖�
		// tap鏃讹紝璁板綍閫夊尯锛屽苟鏄剧ず鑿滃崟
		$txt.on('focus', function () {
			// 璁板綍缂栬緫鍣ㄥ尯鍩熷凡缁廸ocus
			self.isFocus = true;
		});
		$txt.on('singleTap', function (e) {
			if (self.checkTapTime(e, '$txt') === false) {
				return;
			}

			// 濡傛灉褰撳墠涓嶆槸focus鐘舵�锛屽垯杩斿洖
			if (!self.isFocus) {
				return;
			}

			// 鑾峰彇 target 骞朵繚瀛�			var $target = $(e.target);
			self.eventTarget($target);

			if ($target.hasClass('focus-elem')) {
				// 濡傛灉褰撳墠鐐瑰嚮鐨勫氨鏄笂涓�鐐瑰嚮鐨勫厓绱狅紝鍒欓殣钘忚彍鍗曟爮锛岃繑鍥�				self.hideMenuContainer();
				return;
			}

			if ($target.get(0).nodeName === 'IMG') {
				// 鐐瑰嚮鍥剧墖鏃讹紝闅愯棌鑿滃崟锛岃繑鍥�				self.hideMenuContainer();
				return;
			}

			if ($target.get(0) === $txt.get(0)) {
				// 濡傛灉褰撳墠閫変腑鐨勭紪杈戝尯鍩燂紝鍒欓殣钘忚彍鍗曪紝杩斿洖
				self.hideMenuContainer();
				return;
			}

			// 鏍规嵁鐐瑰嚮鐨勪綅缃紝瀵硅彍鍗曟爮杩涜瀹氫綅
			self.setMenuContainerPosition();

			// 濡傛灉鏈変笂涓�閫変腑鐨勫厓绱狅紝鍒欐竻闄ゆ牱寮�			var $focusElem = self.$focusElem;
			if ($focusElem) {
				$focusElem.removeClass('focus-elem');
			}
			
			// 绛夊緟 xxx ms    澶勭悊鐐瑰嚮 $txt 鐨勯�鍖�			setTimeout(selectionHeadle, self.txtTapDelay);
			self.txtTapDelay = 100;

			// 鏈�悗锛岄樆姝㈠啋娉★紝闃绘document鎺ユ敹鍒帮紙document鐨則ap浜嬩欢瑕侀殣钘忚彍鍗曪級
			e.stopPropagation();
		});

		// 婊氬姩鏃堕殣钘忚彍鍗曟爮
		$txt.on('scroll', function (e) {

			// 缁欐粴鍔ㄤ簨浠跺鍔犱竴涓椂闂撮棿闅旂殑闄愬埗
			if (Date.now() - srollTime <= 50) {
				return;
			} else {
				srollTime = Date.now();
			}

			// 闅愯棌鑿滃崟
			self.hideMenuContainer();

			// 闃绘鍐掓场
			e.stopPropagation();
		});

		// 鎵撳瓧鏃堕殣钘忚彍鍗曟爮
		$txt.on('keydown', function (e) {
			// 闅愯棌鑿滃崟
			self.hideMenuContainer();

			// 鍒犻櫎骞朵笖娌℃湁鍐呭鐨勬椂鍊欙紝灏辩姝㈠啀鍒犻櫎浜�			var html = $txt.html();
			if (e.keyCode === 8 && /^<(\w+)[^<>]*><br><\/\1>$/.test(html)) {
				e.preventDefault();
			}
		});

		// longtap doubletap 闅愯棌鑿滃崟
		$txt.on('longTap, doubleTap', function () {
			// 闅愯棌鑿滃崟
			self.hideMenuContainer();
		});

		// blur鏃讹紝闅愯棌鑿滃崟鏍�		// 瀛樺偍婧愪唬鐮�		$txt.on('blur', function (e) {

			// 璁板綍缂栬緫鍖哄煙宸茬粡 blur
			self.isFocus = false;

			var explicitOriginalTarget = e.explicitOriginalTarget;
			if (menuContainer.contains(explicitOriginalTarget)) {
				// firefox 涓紝鐐瑰嚮鑿滃崟浼氬鑷�$txt blur
				// e.explicitOriginalTarget 鏈夊�锛屽苟涓斿寘鍚湪鑿滃崟瀹瑰櫒涓紝璇佹槑鏄�ff 鐐瑰嚮鑿滃崟鎵�嚧鐨�blur
				
				e.preventDefault();
				return;

			} else {
				// 鍏朵粬娴忚鍣紝鐐瑰嚮鑿滃崟锛岄兘涓嶄細鍑虹幇 blur 鐨勬儏鍐�				// 杩欐槸姝ｅ父鎯呭喌涓嬬殑 blur

				// 瀛樺偍婧愮爜浠ｇ爜
				self.saveSourceCode();

				// 闅愯棌鑿滃崟 fn
				self.hideMenuContainer();
			}
		}); // $txt-blur end
	};

});
// 缁戝畾鑿滃崟瀹瑰櫒浜嬩欢
window.___E_mod(function (E, $) {

	// ----------------- 缁戝畾menucontiner浜嬩欢
	E.fn.bindMenuContainerEvent = function () {
		
		// tap鏃秄ocus $text
		var self = this;
		var $menuContainer = self.$menuContainer;

		//tap鏃讹紝闃绘鍐掓场锛屽洜涓轰笂灞傜殑 $txt 浼氱洃娴�tap 浜嬩欢
		$menuContainer.on('tap', function (e) {
			e.preventDefault();
			e.stopPropagation();
		});
	};

});
// 缁戝畾鑿滃崟鎸夐挳鐨勪簨浠�window.___E_mod(function (E, $) {

	E.fn.bindMenuBtnEvent = function () {
		var self = this;
		var menus = self.menus;


		// 閬嶅巻鑿滃崟閰嶇疆椤癸紝鎵цbindEvent浜嬩欢
		$.each(menus, function (key, menu) {
			var bindEvent = menu.bindEvent;
			if (bindEvent && typeof bindEvent === 'function') {
				bindEvent.call(menu, self);
			}
		});
	};

});
// $txt api
window.___E_mod(function (E, $) {

	// focus API 
	// 鏆傛椂娌′汉鐢�	// E.fn.focusTxt = function () {
	// 	var self = this;
	// 	var $txt = self.$txt;

	// 	if (!self.isFocus) {
	// 		$txt.focus();
	// 	}
	// };

	// 淇濆瓨銆佽幏鍙�$txt tap鏃秂vent瀵硅薄鐨則arget鍏冪礌
	E.fn.eventTarget = function ($elem) {
		var self = this;
		if ($elem == null) {
			return self.$eventTargetElem;
		} else {
			self.$eventTargetElem = $elem;
		}
	};

	// 淇濆瓨婧愪唬鐮�	E.fn.saveSourceCode = function () {
		var self = this;
		var $txt = self.$txt;
		var $textarea = self.$textarea;
		var sourceCode = '';

		var $txtClone = $txt.clone();
		var $focusElem1 = $txtClone.find('.focus-elem');

		// 灏嗗綋鍓嶇殑 $focusElem 娓呴櫎鏍峰紡
		$focusElem1.removeClass('focus-elem');

		// 鑾峰彇婧愮爜
		sourceCode = $txtClone.html();
		sourceCode = sourceCode.replace(/\s?class=""/g, '');
		$textarea.val(sourceCode);
	};

	// 鍦ㄧ紪杈戝尯鍩熸渶鍚庢彃鍏ョ┖琛�	E.fn.insertEmpltyLink = function () {
		var self = this;
		var $txt = self.$txt;
		var $children = $txt.children();

		if ($children.length === 0) {
			$txt.append($('<p><br></p>'));
			return;
		}

		if ($children.last().html() !== '<br>') {
			$txt.append($('<p><br></p>'));
		}
	};

});
// menucontainer api
window.___E_mod(function (E, $) {

	var positionFirst = true;  // 绗竴娆¤绠椾綅缃�	var firstTop = 0;
	// -------------------璁＄畻鑿滃崟鐨勪綅缃紝鏄剧ず鑿滃崟-------------------
	E.fn.setMenuContainerPosition = function () {
		var self = this;

		// 鐩爣鍏冪礌
		var $targetElem = self.eventTarget();
		var targetElemTop = $targetElem.offset().top;

		// 缂栬緫鍖哄煙
		var $txt = self.$txt;
		var txtTop = $txt.offset().top;
		var txtLeft = $txt.offset().left;

		// 鑿滃崟
		var $menuContainer = self.$menuContainer;
		var menuHeight = $menuContainer.height();

		// 璁＄畻 top 缁撴灉
		var top = targetElemTop;
		if (top < txtTop) {
			// 鍋滈潬鍦ㄧ紪杈戝櫒鍖哄煙涓婃柟
			top = txtTop;
		}
		top = top - 55;  // 涓婄Щ 55px 鍗宠彍鍗曟爮鐨勯珮搴�

		// 璁剧疆鑿滃崟鐨勬牱寮忥紝瀹氫綅
		$menuContainer.css({
			'top': top,
			'left': txtLeft + 2
		}); 

		// 鏄剧ずmenucontainer
		self.showMenuContainer();
	};

	// -------------------鏄剧ず鑿滃崟-------------------
	E.fn.showMenuContainer = function () {
		var self = this;
		var $menuContainer = self.$menuContainer;

		if (self.menuDisplayShow === false) {
			$menuContainer.show();
			$menuContainer.css('opacity', '0.9');   // 姝ゅ瑕佸姩鐢绘晥鏋�
			// 璁板綍鐘舵�
			self.menuDisplayShow = true;
		}
	};

	// -------------------闅愯棌鑿滃崟-------------------
	E.fn.hideMenuContainer = function () {
		var self = this;
		var $menuContainer = self.$menuContainer;
		var $txt = self.$txt;
		
		var $focusElem = self.$focusElem;
		var $otherFocusElem = $txt.find('.focus-elem'); // 寰楅噸鏂版煡鎵撅紝鍙兘鍙戠敓鍙樺寲

		if (self.menuDisplayShow) {

			$menuContainer.hide();
			// 姝ゅ闅愯棌涔嬪悗锛屽湪璁剧疆閫忔槑搴︺�涓嶈鍔ㄧ敾鏁堟灉浜嗭紝鏁堟灉涓嶅ソ
			$menuContainer.css('opacity', '0');

			// 璁板綍鐘舵�
			self.menuDisplayShow = false;

			// 闅愯棌 focuselem
			if ($focusElem) {
				$focusElem.removeClass('focus-elem');
				$otherFocusElem.removeClass('focus-elem');
			}
		}
	};
});
// menus api
window.___E_mod(function (E, $) {
	
	// 鏇存柊鑿滃崟鏍峰紡
	E.fn.updateMenuStyle = function () {
		var self = this;
		var menus = self.menus;

		// 閬嶅巻鎵�湁鑿滃崟锛屾洿鏂颁粬浠殑鏍峰紡
		$.each(menus, function (key, menu) {
			var fn = menu.updateStyle;
			if (fn) {
				fn.call(menu);
			}
		});
	};

});
// 缂栬緫鍣ㄧ殑鍛戒护浜嬩欢
window.___E_mod(function (E, $) {

	// 绗﹀悎杩欎釜姝ｅ垯琛ㄨ揪寮忕殑鍛戒护锛屾仮澶嶉�鍖烘椂锛屼笉瑕佹仮澶嶅鍥撮�鍖猴紙濡傛彃鍏ュ浘鐗囷級
	var regRestoreNoWrapSelection = /insertimage/i;

	// 浼犵粺浜嬩欢
	E.fn.command = function (commandName, bool, commandValue, e, callback) {
		var self = this;

		// 楠岃瘉璇ュ懡浠ゆ槸鍚︿笉鑳芥仮澶嶅鍥撮�鍖猴紝灏嗕紶鍏ュ埌 customCommand 涓�		var regResult = regRestoreNoWrapSelection.test(commandName);

		var fn = function () {
			document.execCommand(commandName, !!bool, commandValue);
		};

		// 鎵ц浜嬩欢
		self.customCommand(regResult, fn, e, callback);
	};

	// 鑷畾涔変簨浠�	E.fn.customCommand = function (isRestoreNoWrapSelection, fn, e, callback) {
		var self = this;
		var currentRange = self.currentRange();
		var currentWrapRange = self.currentWrapRange();
		var $txt = self.$txt;

		/*
			isRestoreNoWrapSelection 鍙傛暟鐨勪綔鐢細
			1. 鏈変簺 command 鏄渶瑕侀�涓暣涓鍥撮�鍖哄啀杩涜鎿嶄綔鐨勶紝涓�埇鏄慨鏀规牱寮忥紝渚嬪鍔犵矖銆�			   閽堝鍔犵矖杩欑鏍峰紡鎿嶄綔锛屽鏋滀笉榛樿閫変腑涓�釜閫夊尯锛屾槸鐪嬩笉鍒颁换浣曟晥鏋滅殑銆�			2. 浣嗘槸鏈変簺 command 涓�畾涓嶈兘閫変腑澶栧洿閫夊尯锛屼竴鑸槸鎻掑叆鎿嶄綔锛屼緥濡傛彃鍏ュ浘鐗囥�
			   濡傛灉閫変腑浜嗕竴娈靛尯鍩燂紝鍐嶆墽琛屾彃鍏ュ浘鐗囷紝鎻掑叆鍥剧墖涔嬪悗锛屽垰鎵嶇殑閭ｆ閫夊尯灏辨病鏈変簡銆�
			鍥犳锛宨sRestoreNoWrapSelection 鐨勪綔鐢ㄥ氨鏄潵鍒ゆ柇锛屾槸鍚﹁閫変腑澶栧洿閫夊尯銆�		*/
		if (isRestoreNoWrapSelection) {
			// 鎭㈠閫夊尯锛堥潪鏁翠釜澶栧洿閫夊尯锛�			self.restoreSelection(currentRange);
		} else {
			// 鎭㈠閫夊尯锛堟暣涓鍥撮�鍖猴級
			self.restoreSelection(currentWrapRange);
		}

		// 鎵ц鍛戒护
		fn();

		// 濡傛灉 $txt 鏈�悗娌℃湁绌鸿锛屽垯澧炲姞涓�釜
		self.insertEmpltyLink();

		// 閲嶆柊淇濆瓨閫夊尯锛屽洜涓洪儴鍒嗘祻瑙堝櫒浼氳嚜鍔ㄦ竻绌洪�鍖�		self.saveSelection();

		// 鎭㈠閫夊尯锛堥潪澶栧洿閫夊尯锛�		self.restoreSelection(currentRange);

		// 闃绘榛樿琛屼负锛岄樆姝㈠啋娉�		if (e) {
			e.preventDefault();
			e.stopPropagation();
		}

		// 鍥炶皟鍑芥暟
		if (callback) {
			callback.call(self);
		}

		// 闅愯棌鑿滃崟鏍�		self.hideMenuContainer();
	};
});
// range selection 鐨勭浉鍏虫搷浣�window.___E_mod(function (E, $) {

	// 璁剧疆鎴栬鍙栧綋鍓嶇殑range
	E.fn.currentRange = function (cr){
		if (cr) {
			this.currentRangeData = cr;
		} else {
			return this.currentRangeData;
		}
	};

	// 璁剧疆鎴栬鍙栧綋鍓峳ange鐨剋rapRange
	E.fn.currentWrapRange = function (cwr){
		if (cwr) {
			this.currentWrapRangeData = cwr;
		} else {
			return this.currentWrapRangeData;
		}
	};

	// 鑾峰彇 wrapRange 鐨勫厓绱狅紙涓嶈兘鏄痶ext绫诲瀷锛�
	E.fn.getWrapRangeElem = function () {
		var self = this;
		var $txt = self.$txt;
		var txtClass = $txt.attr('class');     // 鑾峰彇缂栬緫鍖哄煙鐨刢lass

		var wrapRange = this.currentWrapRange();
		var elem;
		var resultElem;

		var eventTargetElem = self.eventTarget().get(0);

		if (wrapRange == null) {
			return;
		}

		// 鑾峰彇 range 鐨勫寘鍚厓绱�		elem = wrapRange.commonAncestorContainer;

		if (elem.nodeType === 3) {
			// text绫诲瀷锛岃幏鍙栫埗鍏冪礌
			resultElem = elem.parentNode;
		} else {
			// 涓嶆槸 text 绫诲瀷
			resultElem = elem;
		}

		// 鍒ゆ柇 resultElem 鏄笉鏄�$txt 锛堥�杩�class 鍒ゆ柇锛�		if (resultElem.className === txtClass) {
			// 濡傛灉 resultElem 姝ｅソ鏄�$txt
			// 鍒欏皢 resultElem 璇曞浘璁剧疆涓�$txt 鏈�悗涓�釜瀛愬厓绱�			resultElem = $txt.children().last().get(0) || resultElem;
		}

		// 杩斿洖
		return resultElem;
	};

	// 淇濆瓨閫夋嫨鍖哄煙
	E.fn.saveSelection = function (range) {
		var self = this,
			_parentElem,
			selection,
			wrapRange,
			txt = self.$txt.get(0);

		if (range) {
			_parentElem = range.commonAncestorContainer;
		} else {
			selection = document.getSelection();
            if (selection.getRangeAt && selection.rangeCount) {
                range = document.getSelection().getRangeAt(0);
                _parentElem = range.commonAncestorContainer;
            }
		}

		// 纭畾鐖跺厓绱犱竴瀹氳鍖呭惈鍦ㄧ紪杈戝櫒鍖哄煙鍐�		if (_parentElem && (txt.contains(_parentElem) || txt === _parentElem) ) {

			// 淇濆瓨閫夋嫨鍖哄煙
			self.currentRange(range);

			// 淇濆瓨 wrapRange
			wrapRange = document.getSelection().getRangeAt(0);
			wrapRange.selectNodeContents(_parentElem);
			self.currentWrapRange(wrapRange);
		}
	};

	// 鎭㈠閫変腑鍖哄煙
	E.fn.restoreSelection = function (range){
		var selection;

		if (!range) {
			return;
		}

		selection = document.getSelection();
		selection.removeAllRanges();
		selection.addRange(range);
	};

});
// editor API 瀵瑰寮�斁鐨勬帴鍙�window.___E_mod(function (E, $) {

	

});
// 鍒濆鍖栫紪杈戝櫒瀵硅薄
window.___E_mod(function (E, $) {

	E.fn.init = function () {
		var self = this;

		// 娓叉煋缂栬緫鍖哄煙 
		self.renderTxt();

		// 娓叉煋鑿滃崟鏍�
		self.renderMenu();

		// 缁戝畾浜嬩欢
		self.bindDocumentEvent();
		self.bindTxtEvent();
		self.bindMenuBtnEvent();
		self.bindMenuContainerEvent();
	};

});