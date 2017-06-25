// ��չ������jsģ��
(function (window) {

	// ע�⣺3���»���
	window.___E_mod = function (fn) {
		var E = window.___E;
		if (E == null) {
			// ˵��һ��ʼ����֤û��ͨ����ֱ�ӷ��ؼ���
			return;
		}

		// ִ�д���� fn ����
		fn(E, window.Zepto);
	};


})(window);
// ������֧�����Ƿ����
(function (window) {

	var $ = window.Zepto,
		E = window.___E,
		gitlink = 'github.com/wangfupeng1988/wangEditor-mobile';

	// ��֤�Ƿ��ظ�����
	if(E != null) {
		if (E.gitlink === gitlink) {
			// �ظ����ã���ʾ�����˳�
			alert('�����ظ�����wangEditor��js�ļ�');
			return;
		}
		if (!E.gitlink || E.gitlink !== gitlink) {
			// �������ѱ�ռ��
			alert('window.___E �������Ѿ�����������ռ�á�wangEditor-mobile����ʧ��');
			return;
		}
	}

	// ��֤ zepto �Ƿ�����
	if ($ == null) {
		alert('wangEditor-mobile������zepto����������zepto.js');
		return;
	}

	// ��֤�������range��֧��
	if (!document.createRange || typeof  document.createRange !== 'function') {
		alert('��ǰ�������֧��document.createRange���������ɸ��ı��༭��');
		return;
	}

})(window);
// ���캯��
(function (window, $){

	// ���
	var gitlink = 'github.com/wangfupeng1988/wangEditor-mobile';

	// ���幹�캯��
	var E = function (textareaId) {
		var self = this;

		self.$body = $('body');

		// textarea
		var $textarea = $('#' + textareaId);
		self.$textarea = $textarea;

		// ��¼ÿһ��tap�¼���ʱ�䣬��ֹ��ʱ�����ظ�tap
		self.checkTapTime = function (e, info) {
			//E.log('checkTapTime', info);

			var type = e.type.toLowerCase();
			var currentElem;
			var $currentElem;
			var result = true;

			if (type.indexOf('tap') < 0) {
				// ֻ��� tap�������Ĳ���
				return result;
			}

			if (e) {
				// ���� event ������Ϊÿ��event��������¼�
				currentElem = e.currentTarget || e.target;
				$currentElem = $(currentElem);
			} else {
				// δ���룬����body
				$currentElem = self.$body;
			}

			if ($currentElem.data('tapTime') == null) {
				// ��һ�Σ�ֱ��ͨ��
				$currentElem.data('tapTime', Date.now().toString());
				result = true;
			} else {
				if (Date.now() - parseInt($currentElem.data('tapTime')) < 100) {
					// �����ǰʱ�����һ��tapTime��� **ms ֮�ڣ�
					// ����Ϊ��Ч������ֹð�ݺ�Ĭ����Ϊ
					e.preventDefault();
					e.stopPropagation();
					result = false;
				} else {
					// ����ͼ���������tapTime
					$currentElem.data('tapTime', Date.now().toString());
					result = true;
				}
			}

			return result;
		};

		// ---------����������ʼ�������������----------

		// ��ʼ���༭�������Ĭ������
		self.initDefaultConfig();

		// ��ʼ���༭���������
		self.addTxt();

		// ��ʼ���˵�����
		self.addMenus();
	};

	// ԭ�� alias
	E.fn = E.prototype;

	// ��һ����ǣ������ж��Ƿ��ظ�����
	E.fn.gitlink = gitlink;

	// console.log ����
	E.log = function (a, b) {
		if (window.console) {
			if (b) { console.log(a, b); } else { console.log(a); }
		} else {
			alert(a);
			if (b) { alert(b); }
		}
	};
	// console.warn ����
	E.warn = function (a, b) {
		if (window.console) {
			if (b) { console.warn(a, b); } else { console.warn(a); }
		} else {
			alert(a);
			if (b) { alert(b); }
		}
	};

	// ��¶ȫ�ֺ���
	window.___E = E;

})(window, window.Zepto);
// �Զ���alert
window.___E_mod(function (E, $) {


});
// userAgent
window.___E_mod(function (E, $) {

	var agent = window.navigator.userAgent.toLowerCase();

	E.isAndroid = agent.indexOf('android') > 0;

	E.isUC = agent.indexOf('ucbrowser') > 0;

	E.agent = agent;

});
// ��ʼ����̬�����ļ�
window.___E_mod(function (E, $) {

	// ȫ������
	E.config = {
		
		// �˵����е� color ��ť���ʱ����ɫֵ����css�е���ɫֵ��
		menuColorValue: 'red',

		// �˵����е� quote ��ť���ʱ����ʽ
		menuQuoteStyle: {
			'display': 'block',
			'border-left': '5px solid #d0e5f2',
			'padding': '4px 0 4px 10px',
			'background-color': '#f1f1f1',
			'margin': '4px 0'
		},

		// �˵�����
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

		// ����ͼ������
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

		// �ϴ�ͼƬ
		uploadImgUrl: '',

		// �ϴ��ļ��ĳ�ʱʱ�䣨Ĭ�� 10s��
		uploadTimeout: 10 * 1000,

		// ���Ե�ַ���ڲ��Ե�ַ���༭�����������һЩconsole.log��Ϣ��
		testHostname: 'localhost',

		// �ϴ�ͼƬʱ������������֧��Ԥ��ͼƬ����������ͼƬ����
		loadingImg: 'http://images2015.cnblogs.com/blog/138012/201512/138012-20151208194759027-506651939.gif',
	};
	
});
// ��ʼ����������
window.___E_mod(function (E, $) {

	E.fn.initDefaultConfig = function () {
		var self = this;
		var globalConfig = E.config;
		// ��ȫ�����ÿ�������������
		var objConfig = $.extend({}, globalConfig);
		
		// ��ֵ��������
		self.config = objConfig;
	};
	
});
// �ϴ�ͼƬ
window.___E_mod(function (E, $) {

	var isAndroid = E.isAndroid;
	var isUC = E.isUC;


	

});
// ��ʼ���༭��������ݶ���
window.___E_mod(function (E, $) {

	E.fn.addTxt = function () {
		var self = this;
		var $textarea = self.$textarea;
		var val = $.trim($textarea.val());

		// �༭���򣨽�textarea��ֵ��ֱ�Ӹ��ƹ�����
		var $txt = $(
			'<div contentEditable="true" class="wangEditor-mobile-txt">' + 
			val + 
			'</div>'
		);

		// modal container
		var $modalContainer = $('<div class="wangEditor-mobile-modal-container"></div>');

		// ��¼��������
		self.$txt = $txt;
		self.$modalContainer = $modalContainer;

		// ������һ������
		self.insertEmpltyLink();
	};
	
});
// �����Դ��Ĳ˵����ݶ���
window.___E_mod(function (E, $) {

	E.fn.addMenus = function () {
		var self = this;

		// ------------- menus container  
		var $menuContainer = $('<div class="wangEditor-mobile-menu-container" contentEditable="false"></div>');
		var $menuItemContainer = $('<div class="item-container"></div>');
		var $menuContainerTip = $('<div class="tip"></div>');  // ������

		// ����С���� tip
		$menuContainer.append($menuContainerTip);

		// �˵��������
		$menuContainer.append($menuItemContainer);

		// ��ӵ����ݶ���
		self.$menuContainer = $menuContainer;
		self.$menuItemContainer = $menuItemContainer;

		// ------------- menus ���ݼ��� ------------- 
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

			// �Ƿ���ѡ��״̬
			selected: false,

			// ������
			$trigger: $('<div><i class="icon-wangEditor-m-bold"></i></div>'),
			// ����������������
			$wrap: $('<div class="item"></div>'),

			// �󶨴������¼�
			bindEvent: function (editor) {
				var menuData = this;
				menuData.$trigger.on('singleTap', function (e) {
					if (self.checkTapTime(e, 'bold') === false) {
						return;
					}

					self.command('bold', false, undefined, e);

				});
			},

			// ������ʽ
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
			// �Ƿ���ѡ��״̬
			selected: false,

			// ������
			$trigger: $('<div><i class="icon-wangEditor-m-header"></i></div>'),
			// ����������������
			$wrap: $('<div class="item"></div>'),

			// �󶨴������¼�
			bindEvent: function (editor) {
				var menuData = this;
				menuData.$trigger.on('singleTap', function (e) {
					if (self.checkTapTime(e, 'head') === false) {
						return;
					}

					// ִ������
					if (menuData.selected) {
						self.command('formatblock', false, 'p', e);
					} else {
						self.command('formatblock', false, 'h3', e);
					}
				});
			},

			// ������ʽ
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
			// �Ƿ���ѡ��״̬
			selected: false,

			// ������
			$trigger: $('<div><i class="icon-wangEditor-m-brush"></i></div>'),
			// ����������������
			$wrap: $('<div class="item"></div>'),

			// �󶨴������¼�
			bindEvent: function (editor) {
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

			// ������ʽ
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
			// �Ƿ���ѡ��״̬
			selected: false,

			// ������
			$trigger: $('<div><i class="icon-wangEditor-m-quote-left"></i></div>'),
			// ����������������
			$wrap: $('<div class="item"></div>'),

			// �󶨴������¼�
			bindEvent: function (editor) {
				var menuData = this;
				menuData.$trigger.on('singleTap', function (e) {
					if (self.checkTapTime(e, 'quote') === false) {
						return;
					}

					// ִ������
					var $focusElem = self.$focusElem;
					var $quoteElem;
					var text;
					var commandFn;
					if (menuData.selected) {
						// ��ʱ�Ѿ��� quote ״̬����ʱ�����Ӧ�ûָ�Ϊ��ͨ����
						
						// ��ȡ��ǰ�� quote Ԫ��
						if ($focusElem.get(0).nodeName === 'BLOCKQUOTE') {
							$quoteElem = $focusElem;
						} else {
							$quoteElem = $focusElem.closest('blockquote');
						}

						if ($quoteElem.length === 0) {
							// û���ҵ� blockquote Ԫ��
							return;
						}

						// ��ȡ�ı�
						text = $quoteElem.text();

						// ����һ���Զ���������¼�
						commandFn = function () {
							var $p = $('<p>' + text + '</p>');
							$quoteElem.after($p);
							$quoteElem.remove();
						};

						// ִ�и��Զ����¼�
						self.customCommand(false, commandFn, e);

					} else {
						// ��ǰ����quote״̬

						// ִ���������������Ϊquote
						self.command('formatblock', false, 'blockquote', e);

						// ����quote��ʽ���ոձ�����Ϊquote��
						self.$txt.find('blockquote').each(function(key, node){
							// �����༭�������е�quote
							var $quote = $(node),
								styleKey = 'w_editor_quote_style',
								hasStyle = $quote.attr(styleKey);

							// ���û�б�ǣ���������ʽ����¼���
							if(hasStyle == null){
								// configQuoteStyle �����õ���ʽ������ editor.config ���޸�
								$quote.css(configQuoteStyle);
								$quote.attr(styleKey, '1');
							}
						});

					} // else
				});
			},

			// ������ʽ
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
			// �Ƿ���ѡ��״̬
			selected: false,

			// ������
			$trigger: $('<div><i class="icon-wangEditor-m-list-ul"></i></div>'),
			// ����������������
			$wrap: $('<div class="item"></div>'),

			// �󶨴������¼�
			bindEvent: function (editor) {
				var menuData = this;
				menuData.$trigger.on('singleTap', function (e) {
					if (self.checkTapTime(e, 'list') === false) {
						return;
					}

					if (!menuData.selected) {
						// �����ǰ״̬����list
						// ִ������ǰ����ȥ�� focus ����ʽ
						self.$focusElem.removeClass('focus-elem');
					}

					// ִ������
					self.command('InsertUnorderedList', false, undefined, e);
					
				});
			},

			// ������ʽ
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
			// �Ƿ���ѡ��״̬
			selected: false,

			// ������
			$trigger: $('<div><i class="icon-wangEditor-m-checkbox-checked"></i></div>'),
			// ����������������
			$wrap: $('<div class="item"></div>'),

			// �󶨴������¼�
			bindEvent: function (editor) {
				var tapTime = Date.now();
				var menuData = this;
				menuData.$trigger.on('singleTap', function (e) {
					if (self.checkTapTime(e, 'check') === false) {
						return;
					}

					// ����dom�ṹ
					var $checkbox = $('<input type="checkbox"/>');
					var $content = $('<p></p>');
					$content.append($checkbox).append('&nbsp;&nbsp;');

					// ��ʼ�� checkbox �¼�
					$checkbox.on('singleTap', function (e) {
						// ĳЩ����£��������tap�¼��ᱻ�����������Σ��ڴ˴���
						if (Date.now() - tapTime < 50) {
							return;
						} else {
							tapTime = Date.now();
						}

						var $checkbox = $(e.target);
						var checked = $checkbox.is(':checked');
						$checkbox.prop('checked', !checked);

						// ���Ҫ������ֹð��
						e.preventDefault();
						e.stopPropagation();
					});

					// ִ������
					var fn = function () {
						self.$focusElem.after($content);
					};
					self.customCommand(false, fn, e);
				});
			},

			// ������ʽ
			updateStyle: function (editor) {
				// ��ʱ����Ҫ
			}
		};
	};

});
// ����˵�
window.___E_mod(function (E, $) {

	E.fn.addMenuHappy = function (menuId) {
		var self = this;
		var $body = self.$body;
		var menus = self.menus;
		var happyUrlArr = self.config.happy;
		var $txt = self.$txt;

		// ���ѣ���Ҫʹ�ñ༭���Դ��ı���
		if (happyUrlArr.length > 0) {
			if (happyUrlArr[0].indexOf('http://wangeditor.github.io/expressions') === 0) {
				E.warn('����ʹ��wangEdior�ṩ����ѱ���ͼ�꣬���ǽ��� github ���أ��ٶȺ������������齫����ͼ���������ã���μ��ĵ�˵��');
			}
		}

		menus[menuId] = {
			// ѡ��״̬
			selected: false,

			// ������
			$trigger: $('<div><i class="icon-wangEditor-m-happy"></i></div>'),
			// ����������������
			$wrap: $('<div class="item"</div>'),

			// $modal 
			$modal: $('<div class="wangEditor-mobile-modal"></div>'),

			// ��Ⱦ $modal
			renderModal: function () {
				var menuData = this;
				var $modal = menuData.$modal;
				var itemTpl = '<span class="command-link" commandValue="#{imgUrl}"><img src="#{imgUrl}"/></span>';
				var contentHtmlArr = [];

				// ƴ������
				$.each(happyUrlArr, function (key, value) {
					contentHtmlArr.push(
						itemTpl.replace(/#{imgUrl}/ig, value)
					);
				});
				$modal.append(contentHtmlArr.join(''));

				// ��Ⱦ��ҳ����
				$body.append($modal);

				// ��λ
				var width = $modal.width();
				$modal.css('margin-left', (0 - width)/2);

				// �󶨱���ͼ����¼�
				$modal.on('click', '.command-link', function (e) {
					// ����click�¼���Ĭ����Ϊ
					e.preventDefault();
				});
				$modal.on('singleTap', '.command-link', function (e) {
					if (self.checkTapTime(e, 'happy command-link') === false) {
						return;
					}

					var $commandLink = $(e.currentTarget);
					var commandValue = $commandLink.attr('commandValue');

					// ִ������
					self.command('InsertImage', false, commandValue, e);

					// ���� modal
					menuData.hideModal();
				});
			},

			// ��ʾ $modal
			showModal: function () {
				var menuData = this;
				var $modal = menuData.$modal;
				var scrollTop = $body.get(0).scrollTop;

				// ��ʾ modal
				$modal.show();

				// ȷ�� modal λ��
				$modal.css({
					'margin-top': (scrollTop + 50) + 'px'
				});

				// ����༭��������modal
				var hideModalFn = function (e) {
					menuData.hideModal();

					// ����modal֮�󣬽���ȡ���¼���
					$txt.off('singleTap', hideModalFn);
				};

				// ���¼�
				$txt.on('singleTap', hideModalFn);
			},

			// ���� $modal
			hideModal: function () {
				this.$modal.hide();
			},

			// ���¼�
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

				// one�󶨵ķ���ִֻ��һ��
				// ������Ⱦ modal Ԫ�ز���ʾ
				$trigger.one('singleTap', function (e) {
					if (self.checkTapTime(e, 'happy one') === false) {
						return;
					}

					// ��Ⱦmodal����ʾ
					self.customCommand(true, commandFnForOneEvent, e);
				});

				// on �󶨵ķ���ÿ�ζ�ִ��
				// ����ÿ����ʾ������modal
				$trigger.on('singleTap', function (e) {
					if (self.checkTapTime(e, 'happy on') === false) {
						return;
					}

					// ��ʾmodal
					self.customCommand(true, commandFnForOnEvent, e);
				});
			},

			// ������ʽ
			updateStyle: function () {
				// ��ʱ����Ҫ
			}
		};	
	};

});
// �ϴ�ͼƬ
window.___E_mod(function (E, $) {
	E.fn.addMenuImg = function (menuId) {
		var self = this;
		var $body = self.$body;
		var $txt = self.$txt;
		var menus = self.menus;

		var isAndroid = E.isAndroid;
		var isUC = E.isUC;

		var idDebugger = false;  // Ĭ��Ϊ false�����Ŀ����޸�

		// ��� test ��ַ����ӡ��Ϣ
		function log(info) {
			if (!idDebugger) {
				return;
			}
			E.log(info);
		}

		// �����������input �� id
		var inputFileId = 'inputfile' + Math.random().toString().slice(2);

		menus[menuId] = {
			// ѡ��״̬
			selected: false,

			// ������
			$trigger: (function () {
				// ��ͬos����ͬbrowser�������һ��
				if (isAndroid || isUC) {
					return $('<div><i class="icon-wangEditor-m-picture"></i></div>');
				} else {
					return $('<label for="' + inputFileId + '"><i class="icon-wangEditor-m-picture"></i></label>');
				}
			})(),
			
			// ����������������
			$wrap: $('<div class="item"</div>'),

			// ��Ⱦ form
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

				// ��Ⱦ��ҳ����
				$body.append($container);
			},


			// �󶨲˵��¼�
			bindEvent: function (editor) {
				var menuData = this;
				var $trigger = menuData.$trigger;

				// �� form ��Ⱦ��ҳ����
				menuData.renderForm();

				// ��ȡ form input-file ����
				var $inputFlie = $('#' + inputFileId);

				// ����base64��ͼƬurl����ת��ΪBlob
				function convertBase64UrlToBlob(urlData, filetype){
		    		//ȥ��url��ͷ����ת��Ϊbyte
				    var bytes=window.atob(urlData.split(',')[1]);
				    
				    //�����쳣,��ascii��С��0��ת��Ϊ����0
				    var ab = new ArrayBuffer(bytes.length);
				    var ia = new Uint8Array(ab);
				    for (var i = 0; i < bytes.length; i++) {
				        ia[i] = bytes.charCodeAt(i);
				    }

				    // ����
				    if (filetype === '' || !filetype) {
				    	filetype = 'image/png';
				    }

				    return new Blob([ab], {type : filetype});
				}

				// input ���ļ�ѡ��ʱ����ʾԤ��ͼ���ύ form
				$inputFlie.on('change', function (e) {

					// ��ȡ����������
					var config = self.config;
					var uploadImgUrl = config.uploadImgUrl || '';
					var testHostname = config.testHostname || 'localhost';
					var loadingImgUrl = config.loadingImg;
					var timeout = config.uploadTimeout || 10000;

					idDebugger = testHostname === window.location.hostname;

					// �жϸ�������Ƿ�֧�� FormData �� fileReader
					if (!window.FileReader || !window.FormData) {
						alert('��ǰ�������֧��html5�е� FileReader �� FormData���޷��ϴ�ͼƬ');
						return;
					}

					if (uploadImgUrl === '') {
						// û�������ϴ�ͼƬ��url
						alert(
							'û������ uploadImgUrl ��wangEditor ���޷��ϴ�ͼƬ��\n\n' + 
							'��Ҫ�����ϴ�ͼƬ����μ��ĵ�˵����\n\n' + 
							'����ҪͼƬ�ϴ�����ͨ������ menus ���ظù��ܡ�'
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

					log('ѡ�е��ļ�Ϊ��' + file.name);
					log('���������ϴ���ַΪ��' + uploadImgUrl);

					reader.onload = function(e){
						var base64 = e.target.result || this.result,
							prevImgSrc,
							prveImgContainerId = 'div' + Math.random().toString().slice(2),
							prevImgInfoId = 'info' +  Math.random().toString().slice(2),
							xhr,
							formData,
							timeoutId;

						// ---------- ��ʾԤ�� ----------
						if (window.URL && window.URL.createObjectURL) {
							// ��������֧��Ԥ������ͼƬ���ܣ���Ԥ������ͼƬ
							prevImgSrc = window.URL.createObjectURL(file);

							// ����Ԥ��ͼƬ�����ð�͸��
							$focusElem.after(
								'<div class="previmg-container" id="' + prveImgContainerId + '">' + 
								'   <p class="info" id="' + prevImgInfoId + '">�ϴ���...</p>' +
								'	<img src="' + prevImgSrc + '" style="opacity:0.2; max-width:100%;"/>' + 
								'</div>'
							);
						} else {
							// ����������֧��Ԥ������ͼƬ������Ϊһ�����õ�ͼƬ��ַ
							prevImgSrc = loadingImgUrl;

							// ����Ԥ��ͼƬ
							$focusElem.after(
								'<div class="previmg-container" id="' + prveImgContainerId + '">' + 
								'	<img src="' + prevImgSrc + '" style="max-width:100%;"/>' + 
								'</div>'
							);
						}
						log('����Ԥ��ͼƬ��src�ǣ�' + prevImgSrc);

						// ---------- �ϴ��������� ----------
						xhr = new XMLHttpRequest();
			            formData = new FormData();

			            // ���ʳ�ʱ
			            function timeoutCallback() {
			            	log('���ʳ�ʱ�����õĳ�ʱ�¼��ǣ�'+ timeout +'��');

			            	var $prevImgContainer = $('#' + prveImgContainerId);
			            	$prevImgContainer.remove();
	
			            	if (xhr.abort) {
			            		xhr.abort();
			            	}
			            	
			            	alert('�ϴ���ʱ��������');

			            	if (location.hostname.toLowerCase() === 'wangeditor.github.io') {
			            		// ����demo��������ʾ
			            		alert('��ʾ��wangEditor����demoû�к�̨������˳�ʱ����alert��ʵ����Ŀ�в�����֣�');
			            	}
			            }

			            log('׼���ϴ��ļ�...');
			            xhr.open('POST', uploadImgUrl, true);

			            // ��ʱ��ʼ
			            timeoutId = setTimeout(timeoutCallback, timeout);
			            
			            xhr.onload = function () {
			            	// �õ���Ϣ֮�������ʱ
			            	clearTimeout(timeoutId);

			            	var resultSrc = xhr.responseText; //��������Ҫ����ͼƬurl��ַ
			            	var erroInfo;
			            	var $prevImgContainer = $('#' + prveImgContainerId);
			            	var loadImg;
			            	var $loadImg;

			            	log('�������˵ķ�������Ϊ��' + resultSrc);

			            	// �������ݴ���
			            	if (resultSrc.indexOf('error|') === 0) {
			            		erroInfo = resultSrc.split('|')[1];
			            		log('���ź�����̨����error��������ϢΪ��' + erroInfo);
			            		
			            		// ��ʾ����
			            		alert('�ϴ�ͼƬ����: \n' + erroInfo);

			            		// �Ƴ�Ԥ��ͼƬ
			            		$prevImgContainer.remove();

			            	} else {
			            		// ������ȷ��ͼƬ��ַ

			            		log('��ȷ������ͼƬ�Ƿ���Ч����Ч���޷���ʾ��ҳ����');
			            		log('׼�����ظ�ͼƬ...');
			            		
			            		// ����ͼƬ��������ɺ�ֵ���༭����
			            		$('#' + prevImgInfoId).text('������...');
			
			            		loadImg = document.createElement('img');
			            		loadImg.src = resultSrc;
			            		loadImg.onload = function () {
			            			log('������ɣ���ʽ�����ڱ༭����');
		
									$loadImg = $(loadImg);
									$loadImg.css('max-width', '100%');
			            			$prevImgContainer.after($loadImg);
			            			$prevImgContainer.remove();

			            			// ��������
			            			self.saveSourceCode();
			            		};
			            		loadImg.onerror = function () {
			            			log('ͼƬ����ʧ�ܣ���ȷ�����url�Ƿ��ܳɹ��õ�ͼƬ��' + resultSrc);
			            			
			            			alert('ͼƬ����ʧ��');
			            			$prevImgContainer.remove();

			            			// ��������
			            			self.saveSourceCode();
			            		};
			            	}
			            };

			            // ���ͼƬ����
			            // 1. ͼƬ����Ҫ���� convertBase64UrlToBlob ת��
			            // 2. wangEditorMobileFile Ҫ�ͺ�̨һ��
			            //formData.append('wangEditorMobileFile', convertBase64UrlToBlob(base64, fileType));
			            formData.append('wangEditorMobileFile', base64);
			            xhr.send(formData);
					};

					//��ȡ�ļ�
					reader.readAsDataURL(file);
				});

				// ����˵������� input �¼�
				$trigger.on('singleTap', function (e) {
					// singleTap��Ҫ��֤
					if (self.checkTapTime(e, 'img') === false) {
						return;
					}

					function fn() {
						$inputFlie.trigger('click');
					}

					self.customCommand(true, fn, e);
				});
			},


			// ������ʽ
			updateStyle: function () {
				// ��ʱ����Ҫ
			}
		};
	};
});
// ��Ⱦ�༭������
window.___E_mod(function (E, $) {

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
// ��Ⱦ�˵���
window.___E_mod(function (E, $) {

	E.fn.renderMenu = function () {
		var self = this;
		var menus = self.menus;
		var $menuContainer = self.$menuContainer;
		var $menuItemContainer = self.$menuItemContainer;
		var $txt = self.$txt;
		var $gap = $('<div class="gap"></div>');
		var $body = self.$body;

		// �����ļ��еĲ˵�����
		var configMenus = self.config.menus;

		// �����˵����ü��ϣ���Ⱦ�˵�
		$.each(configMenus, function (key, menuId) {
			var menu = menus[menuId];
			if (menu == null) {
				return;
			}

			var $trigger = menu.$trigger;
			var $wrap = menu.$wrap;

			if ($trigger) {
				// ��Ⱦ�˵�
				if ($wrap) {
					$wrap.append($trigger);
					$menuItemContainer.append($wrap);
				} else {
					$menuItemContainer.append($trigger);
				}
				
				// �˵�֮��ļ�϶
				// ֮������Ҫ�� clone ����Ϊ append ��һ�֡������ƶ��������ԣ�����ע�⣡��
				$menuItemContainer.append($gap.clone());
			}
		});

		// ɾ�����һ����϶�������һ����Ԫ�أ�
		$menuItemContainer.children().last().remove();

		// Ĭ������
		$menuContainer.hide();
		
		// ������¼�˵���������ʾ������
		self.menuDisplayShow = false;
		$body.append($menuContainer);
	};

});
// ��document�¼�
window.___E_mod(function (E, $) {

	E.fn.bindDocumentEvent = function () {
		var $document = $(document);
		var self = this;
		var $txt = self.$txt;
		var srollTime = Date.now();

		// ����ʱ���ز˵���
		$document.on('scroll', function (e) {
			// �������¼�����һ��ʱ����������
			if (Date.now() - srollTime <= 50) {
				return;
			} else {
				srollTime = Date.now();
			}

			// ���ز˵�
			self.hideMenuContainer();

		});
	};

});
// �󶨱༭�����¼�
window.___E_mod(function (E, $) {

	E.fn.bindTxtEvent = function () {
		var self = this;
		var $txt = self.$txt;
		var $menuContainer = self.$menuContainer;
		var menuContainer = $menuContainer.get(0);
		var srollTime = Date.now();

		// ������ $txt ��ѡ��
		// $txt �� tap �¼��е���
		function selectionHeadle () {
			var focusElem;
			var $focusElem;

			// ����ѡ������
			self.saveSelection();

			// ��ȡ��ǰѡ�е�Ԫ�أ�������һ��������ʽ
			focusElem = self.getWrapRangeElem();
			if (focusElem) {
				$focusElem = $(focusElem);
				// ������ʽ
				$focusElem.addClass('focus-elem');
				self.$focusElem = $focusElem;
			}

			// ���²˵���ʽ
			self.updateMenuStyle();

		} // ������ $txt ��ѡ��

		// tapʱ����¼ѡ��������ʾ�˵�
		$txt.on('focus', function () {
			// ��¼�༭�������Ѿ�focus
			self.isFocus = true;
		});
		$txt.on('singleTap', function (e) {
			if (self.checkTapTime(e, '$txt') === false) {
				return;
			}

			// �����ǰ����focus״̬���򷵻�
			if (!self.isFocus) {
				return;
			}

			// ��ȡ target ������
			var $target = $(e.target);
			self.eventTarget($target);

			if ($target.hasClass('focus-elem')) {
				// �����ǰ����ľ�����һ�ε����Ԫ�أ������ز˵���������
				self.hideMenuContainer();
				return;
			}

			if ($target.get(0).nodeName === 'IMG') {
				// ���ͼƬʱ�����ز˵�������
				self.hideMenuContainer();
				return;
			}

			if ($target.get(0) === $txt.get(0)) {
				// �����ǰѡ�еı༭���������ز˵�������
				self.hideMenuContainer();
				return;
			}

			// ���ݵ����λ�ã��Բ˵������ж�λ
			self.setMenuContainerPosition();

			// �������һ��ѡ�е�Ԫ�أ��������ʽ
			var $focusElem = self.$focusElem;
			if ($focusElem) {
				$focusElem.removeClass('focus-elem');
			}
			
			// �ȴ� xxx ms    ������ $txt ��ѡ��
			setTimeout(selectionHeadle, self.txtTapDelay);
			self.txtTapDelay = 100;

			// �����ֹð�ݣ���ֹdocument���յ���document��tap�¼�Ҫ���ز˵���
			e.stopPropagation();
		});

		// ����ʱ���ز˵���
		$txt.on('scroll', function (e) {

			// �������¼�����һ��ʱ����������
			if (Date.now() - srollTime <= 50) {
				return;
			} else {
				srollTime = Date.now();
			}

			// ���ز˵�
			self.hideMenuContainer();

			// ��ֹð��
			e.stopPropagation();
		});

		// ����ʱ���ز˵���
		$txt.on('keydown', function (e) {
			// ���ز˵�
			self.hideMenuContainer();

			// ɾ������û�����ݵ�ʱ�򣬾ͽ�ֹ��ɾ����
			var html = $txt.html();
			if (e.keyCode === 8 && /^<(\w+)[^<>]*><br><\/\1>$/.test(html)) {
				e.preventDefault();
			}
		});

		// longtap doubletap ���ز˵�
		$txt.on('longTap, doubleTap', function () {
			// ���ز˵�
			self.hideMenuContainer();
		});

		// blurʱ�����ز˵���
		// �洢Դ����
		$txt.on('blur', function (e) {

			// ��¼�༭�����Ѿ� blur
			self.isFocus = false;

			var explicitOriginalTarget = e.explicitOriginalTarget;
			if (menuContainer.contains(explicitOriginalTarget)) {
				// firefox �У�����˵��ᵼ�� $txt blur
				// e.explicitOriginalTarget ��ֵ�����Ұ����ڲ˵������У�֤���� ff ����˵����µ� blur
				
				e.preventDefault();
				return;

			} else {
				// ���������������˵������������ blur �����
				// ������������µ� blur

				// �洢Դ�����
				self.saveSourceCode();

				// ���ز˵� fn
				self.hideMenuContainer();
			}
		}); // $txt-blur end
	};

});
// �󶨲˵������¼�
window.___E_mod(function (E, $) {

	// ----------------- ��menucontiner�¼�
	E.fn.bindMenuContainerEvent = function () {
		
		// tapʱfocus $text
		var self = this;
		var $menuContainer = self.$menuContainer;

		//tapʱ����ֹð�ݣ���Ϊ�ϲ�� $txt ���� tap �¼�
		$menuContainer.on('tap', function (e) {
			e.preventDefault();
			e.stopPropagation();
		});
	};

});
// �󶨲˵���ť���¼�
window.___E_mod(function (E, $) {

	E.fn.bindMenuBtnEvent = function () {
		var self = this;
		var menus = self.menus;


		// �����˵������ִ��bindEvent�¼�
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
	// ��ʱû����
	// E.fn.focusTxt = function () {
	// 	var self = this;
	// 	var $txt = self.$txt;

	// 	if (!self.isFocus) {
	// 		$txt.focus();
	// 	}
	// };

	// ���桢��ȡ $txt tapʱevent�����targetԪ��
	E.fn.eventTarget = function ($elem) {
		var self = this;
		if ($elem == null) {
			return self.$eventTargetElem;
		} else {
			self.$eventTargetElem = $elem;
		}
	};

	// ����Դ����
	E.fn.saveSourceCode = function () {
		var self = this;
		var $txt = self.$txt;
		var $textarea = self.$textarea;
		var sourceCode = '';

		var $txtClone = $txt.clone();
		var $focusElem1 = $txtClone.find('.focus-elem');

		// ����ǰ�� $focusElem �����ʽ
		$focusElem1.removeClass('focus-elem');

		// ��ȡԴ��
		sourceCode = $txtClone.html();
		sourceCode = sourceCode.replace(/\s?class=""/g, '');
		$textarea.val(sourceCode);
	};

	// �ڱ༭�������������
	E.fn.insertEmpltyLink = function () {
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

	var positionFirst = true;  // ��һ�μ���λ��
	var firstTop = 0;
	// -------------------����˵���λ�ã���ʾ�˵�-------------------
	E.fn.setMenuContainerPosition = function () {
		var self = this;

		// Ŀ��Ԫ��
		var $targetElem = self.eventTarget();
		var targetElemTop = $targetElem.offset().top;

		// �༭����
		var $txt = self.$txt;
		var txtTop = $txt.offset().top;
		var txtLeft = $txt.offset().left;

		// �˵�
		var $menuContainer = self.$menuContainer;
		var menuHeight = $menuContainer.height();

		// ���� top ���
		var top = targetElemTop;
		if (top < txtTop) {
			// ͣ���ڱ༭�������Ϸ�
			top = txtTop;
		}
		top = top - 55;  // ���� 55px ���˵����ĸ߶�


		// ���ò˵�����ʽ����λ
		$menuContainer.css({
			'top': top,
			'left': txtLeft + 2
		}); 

		// ��ʾmenucontainer
		self.showMenuContainer();
	};

	// -------------------��ʾ�˵�-------------------
	E.fn.showMenuContainer = function () {
		var self = this;
		var $menuContainer = self.$menuContainer;

		if (self.menuDisplayShow === false) {
			$menuContainer.show();
			$menuContainer.css('opacity', '0.9');   // �˴�Ҫ����Ч��

			// ��¼״̬
			self.menuDisplayShow = true;
		}
	};

	// -------------------���ز˵�-------------------
	E.fn.hideMenuContainer = function () {
		var self = this;
		var $menuContainer = self.$menuContainer;
		var $txt = self.$txt;
		
		var $focusElem = self.$focusElem;
		var $otherFocusElem = $txt.find('.focus-elem'); // �����²��ң����ܷ����仯

		if (self.menuDisplayShow) {

			$menuContainer.hide();
			// �˴�����֮��������͸���ȡ���Ҫ����Ч���ˣ�Ч������
			$menuContainer.css('opacity', '0');

			// ��¼״̬
			self.menuDisplayShow = false;

			// ���� focuselem
			if ($focusElem) {
				$focusElem.removeClass('focus-elem');
				$otherFocusElem.removeClass('focus-elem');
			}
		}
	};
});
// menus api
window.___E_mod(function (E, $) {
	
	// ���²˵���ʽ
	E.fn.updateMenuStyle = function () {
		var self = this;
		var menus = self.menus;

		// �������в˵����������ǵ���ʽ
		$.each(menus, function (key, menu) {
			var fn = menu.updateStyle;
			if (fn) {
				fn.call(menu);
			}
		});
	};

});
// �༭���������¼�
window.___E_mod(function (E, $) {

	// �������������ʽ������ָ�ѡ��ʱ����Ҫ�ָ���Χѡ���������ͼƬ��
	var regRestoreNoWrapSelection = /insertimage/i;

	// ��ͳ�¼�
	E.fn.command = function (commandName, bool, commandValue, e, callback) {
		var self = this;

		// ��֤�������Ƿ��ָܻ���Χѡ���������뵽 customCommand ��
		var regResult = regRestoreNoWrapSelection.test(commandName);

		var fn = function () {
			document.execCommand(commandName, !!bool, commandValue);
		};

		// ִ���¼�
		self.customCommand(regResult, fn, e, callback);
	};

	// �Զ����¼�
	E.fn.customCommand = function (isRestoreNoWrapSelection, fn, e, callback) {
		var self = this;
		var currentRange = self.currentRange();
		var currentWrapRange = self.currentWrapRange();
		var $txt = self.$txt;

		/*
			isRestoreNoWrapSelection ���������ã�
			1. ��Щ command ����Ҫѡ��������Χѡ���ٽ��в����ģ�һ�����޸���ʽ������Ӵ֡�
			   ��ԼӴ�������ʽ�����������Ĭ��ѡ��һ��ѡ�����ǿ������κ�Ч���ġ�
			2. ������Щ command һ������ѡ����Χѡ����һ���ǲ���������������ͼƬ��
			   ���ѡ����һ��������ִ�в���ͼƬ������ͼƬ֮�󣬸ղŵ��Ƕ�ѡ����û���ˡ�

			��ˣ�isRestoreNoWrapSelection �����þ������жϣ��Ƿ�Ҫѡ����Χѡ����
		*/
		if (isRestoreNoWrapSelection) {
			// �ָ�ѡ������������Χѡ����
			self.restoreSelection(currentRange);
		} else {
			// �ָ�ѡ����������Χѡ����
			self.restoreSelection(currentWrapRange);
		}

		// ִ������
		fn();

		// ��� $txt ���û�п��У�������һ��
		self.insertEmpltyLink();

		// ���±���ѡ������Ϊ������������Զ����ѡ��
		self.saveSelection();

		// �ָ�ѡ��������Χѡ����
		self.restoreSelection(currentRange);

		// ��ֹĬ����Ϊ����ֹð��
		if (e) {
			e.preventDefault();
			e.stopPropagation();
		}

		// �ص�����
		if (callback) {
			callback.call(self);
		}

		// ���ز˵���
		self.hideMenuContainer();
	};
});
// range selection ����ز���
window.___E_mod(function (E, $) {

	// ���û��ȡ��ǰ��range
	E.fn.currentRange = function (cr){
		if (cr) {
			this.currentRangeData = cr;
		} else {
			return this.currentRangeData;
		}
	};

	// ���û��ȡ��ǰrange��wrapRange
	E.fn.currentWrapRange = function (cwr){
		if (cwr) {
			this.currentWrapRangeData = cwr;
		} else {
			return this.currentWrapRangeData;
		}
	};

	// ��ȡ wrapRange ��Ԫ�أ�������text���ͣ� 
	E.fn.getWrapRangeElem = function () {
		var self = this;
		var $txt = self.$txt;
		var txtClass = $txt.attr('class');     // ��ȡ�༭�����class

		var wrapRange = this.currentWrapRange();
		var elem;
		var resultElem;

		var eventTargetElem = self.eventTarget().get(0);

		if (wrapRange == null) {
			return;
		}

		// ��ȡ range �İ���Ԫ��
		elem = wrapRange.commonAncestorContainer;

		if (elem.nodeType === 3) {
			// text���ͣ���ȡ��Ԫ��
			resultElem = elem.parentNode;
		} else {
			// ���� text ����
			resultElem = elem;
		}

		// �ж� resultElem �ǲ��� $txt ��ͨ�� class �жϣ�
		if (resultElem.className === txtClass) {
			// ��� resultElem ������ $txt
			// �� resultElem ��ͼ����Ϊ $txt ���һ����Ԫ��
			resultElem = $txt.children().last().get(0) || resultElem;
		}

		// ����
		return resultElem;
	};

	// ����ѡ������
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

		// ȷ����Ԫ��һ��Ҫ�����ڱ༭��������
		if (_parentElem && (txt.contains(_parentElem) || txt === _parentElem) ) {

			// ����ѡ������
			self.currentRange(range);

			// ���� wrapRange
			wrapRange = document.getSelection().getRangeAt(0);
			wrapRange.selectNodeContents(_parentElem);
			self.currentWrapRange(wrapRange);
		}
	};

	// �ָ�ѡ������
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
// editor API ���⿪�ŵĽӿ�
window.___E_mod(function (E, $) {

	

});
// ��ʼ���༭������
window.___E_mod(function (E, $) {

	E.fn.init = function () {
		var self = this;

		// ��Ⱦ�༭���� 
		self.renderTxt();

		// ��Ⱦ�˵��� 
		self.renderMenu();

		// ���¼�
		self.bindDocumentEvent();
		self.bindTxtEvent();
		self.bindMenuBtnEvent();
		self.bindMenuContainerEvent();
	};

});