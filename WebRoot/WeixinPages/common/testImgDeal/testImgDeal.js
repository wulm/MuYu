window.onerror = function (errMsg, scriptURI, lineNumber, columnNumber, errorObj) {
    setTimeout(function () {
        var rst = {
            "������Ϣ��": errMsg,
            "�����ļ���": scriptURI,
            "�����кţ�": lineNumber,
            "�����кţ�": columnNumber,
            "�������飺": errorObj
        };

        alert('�����ˣ���һ������ʾ������Ϣ');
        alert(JSON.stringify(rst, null, 10));
    });
};


[].forEach.call(document.querySelectorAll('[data-src]'), function (el) {
    (function (el) {
        el.addEventListener('click', function () {
            el.src = 'img/loading.gif';

            lrz(el.dataset.src)
                .then(function (rst) {
                    el.src = rst.base64;


                    return rst;
                });
        });

        fireEvent(el, 'click');
    })(el);
});


document.querySelector('input').addEventListener('change', function () {
    var that     = this,
        progress = document.querySelector('progress');

    lrz(that.files[0], {
        width: 800
    })
        .then(function (rst) {
            var img        = new Image(),
                div        = document.createElement('div'),
                p          = document.createElement('p'),
                sourceSize = toFixed2(that.files[0].size / 1024),
                resultSize = toFixed2(rst.fileLen / 1024),
                effect     = parseInt(100 - (resultSize / sourceSize * 100));

            p.style.fontSize = 13 + 'px';
            p.innerHTML      = 'Դ�ļ���<span class="text-danger">!{sourceSize}KB</span> <br>ѹ�������С��<span class="text-success">!{resultSize}KB (ʡ!{effect}%)</span> '.render({
                sourceSize: sourceSize,
                resultSize: resultSize,
                effect    : effect
            });

            div.className = 'col-sm-6';
            div.appendChild(img);
            div.appendChild(p);

            img.onload = function () {
                document.querySelector('#upload-container').appendChild(div);
            };

            progress.value = 0;

            /* ==================================================== */
            // ԭ��ajax�ϴ����룬���Կ������ر�� �r(�s_�t)�q������������
            // ������ܣ�����ajax����formData���в�ͬ��������google��baidu��
            var xhr = new XMLHttpRequest();
            xhr.open('POST', 'http://koa-upload.herokuapp.com');

            xhr.onload = function () {
                var data = JSON.parse(xhr.response);

                if (xhr.status === 200) {
                    // �ϴ��ɹ�
                    img.src        = rst.base64;
                    progress.value = 0;
                } else {
                    // �������
                    alert(data.msg);

                    div.remove();
                    that.value = null;
                }
            };

            xhr.onerror = function (err) {
                alert('δ֪����:' + JSON.stringify(err, null, 2));
                div.remove();
                that.value = null;
            };

            // issues #45 �ᵽ�ƺ��м���������,����progress
            if (xhr.upload) {
                try {
                    xhr.upload.addEventListener('progress', function (e) {
                        if (!e.lengthComputable) return false;

                        // �ϴ�����
                        progress.value = ((e.loaded / e.total) || 0) * 100;
                    });
                } catch (err) {
                    console.error('����չʾ������,�ƺ���֧�ִ�����?', err);
                }
            }

            // ��Ӳ���
            rst.formData.append('fileLen', rst.fileLen);
            rst.formData.append('xxx', '������������');

            // �����ϴ�
            xhr.send(rst.formData);
            /* ==================================================== */

            return rst;
        });
});

document.querySelector('#version').innerHTML = lrz.version;
document.querySelector('.UA').innerHTML      = 'UA: ' + navigator.userAgent;

function toFixed2(num) {
    return parseFloat(+num.toFixed(2));
}

/**
 * �滻�ַ��� !{}
 * @param obj
 * @returns {String}
 * @example
 * '����!{str}'.render({str: '����'});
 */
String.prototype.render = function (obj) {
    var str = this, reg;

    Object.keys(obj).forEach(function (v) {
        reg = new RegExp('\\!\\{' + v + '\\}', 'g');
        str = str.replace(reg, obj[v]);
    });

    return str;
};

/**
 * �����¼� - ֻ��Ϊ�˼�����ʾdemo����
 * @param element
 * @param event
 * @returns {boolean}
 */
function fireEvent(element, event) {
    var evt;

    if (document.createEventObject) {
        // IE�����֧��fireEvent����
        evt = document.createEventObject();
        return element.fireEvent('on' + event, evt)
    }
    else {
        // ������׼�����ʹ��dispatchEvent����
        evt = document.createEvent('HTMLEvents');
        // initEvent����3��������
        // �¼����ͣ��Ƿ�ð�ݣ��Ƿ���ֹ�������Ĭ����Ϊ
        evt.initEvent(event, true, true);
        return !element.dispatchEvent(evt);
    }
}

/**
 * �滻�ַ��� !{}
 * @param obj
 * @returns {String}
 * @example
 * '����!{str}'.render({str: '����'});
 */
String.prototype.render = function (obj) {
    var str = this, reg;

    Object.keys(obj).forEach(function (v) {
        reg = new RegExp('\\!\\{' + v + '\\}', 'g');
        str = str.replace(reg, obj[v]);
    });

    return str;
};


if (!('remove' in Element.prototype)) {
    Element.prototype.remove = function () {
        this.parentNode.removeChild(this);
    };
}

/**
 *
 * ��������������������
 * ���������ߩ��������ߩ�
 * ����������������������
 * ����������������������
 * ���������ש������ס���
 * ����������������������
 * �������������ߡ�������
 * ����������������������
 * ����������������������Code is far away from bug with the animal protecting
 * ������������������    ���ޱ���,������bug
 * ������������������
 * ��������������������������
 * �������������������� �ǩ�
 * ������������������ ����
 * �������������������ש�����
 * �������������ϩϡ����ϩ�
 * �������������ߩ������ߩ�
 *
 */
