function proDownImage(path,imgObj) { // �ȱ�ѹ��ͼƬ����
	//var proMaxHeight = 185;
	var proMaxHeight=300;
	var proMaxWidth = 175;
    var size = new Object();��
    var image = new Image();��
    image.src = path;��
    image.attachEvent("onreadystatechange",
    function() { // ������״̬�ı�ʱִ�д˷���,��Ϊimg�ļ������ӳ�
        if (image.readyState == "complete") { // ������״̬Ϊ��ȫ����ʱ����
        	if (image.width > 0 && image.height > 0) {
                var ww = proMaxWidth / image.width;
                var hh = proMaxHeight / image.height;��
                var rate = (ww < hh) ? ww: hh;
                if (rate <= 1) {��
                    alert("imgage width*rate is:" + image.width * rate);
                    size.width = image.width * rate;
                    size.height = image.height * rate;
                } else {
                    alert("imgage width is:" + image.width);����
                    size.width = image.width;����
                    size.height = image.height;������
                }��
            }
        }
        imgObj.attr("width",size.width);
        imgObj.attr("height",size.height);
    });
}