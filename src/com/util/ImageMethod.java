package com.util;

import java.io.*;
import java.util.UUID;

import sun.misc.BASE64Decoder;

public class ImageMethod {

	/*
	 * base64�ַ���ת����ͼƬ������ͼƬ����
	 * ������base64�ַ���imgStr��ͼƬ�������·��savaPath
	 * ���أ��ɹ�������jpg�ļ����ƣ���Ϊ�ջ���󣬷���null
	 */
    public static String Base64SaveAsImage(String base64imgStr,String savaPath)  
    {   //���ֽ������ַ�������Base64���벢����ͼƬ  
        if (base64imgStr == null) //ͼ������Ϊ��  
            return null;  
        BASE64Decoder decoder = new BASE64Decoder();  
        try   
        {  
            //Base64����  
            byte[] b = decoder.decodeBuffer(base64imgStr);  
            for(int i=0;i<b.length;++i)  
            {  
                if(b[i]<0)  
                {//�����쳣����  
                    b[i]+=256;  
                }  
            } 
            
            String imageName=UUID.randomUUID().toString().replace("-", "")+".jpg";//�������ͼƬ����
            //����jpegͼƬ  
            String imgFilePath = savaPath+imageName;//�����ɵ�ͼƬ ·��
            OutputStream out = new FileOutputStream(imgFilePath);     
            out.write(b);   //д���ļ�
            out.flush();  
            out.close();  
            return imageName;  
        }   
        catch (Exception e)   
        {  
            return null;  
        }  
    }  
	
	
}
