package com.util;

import java.io.*;
import java.util.UUID;

import sun.misc.BASE64Decoder;

public class ImageMethod {

	/*
	 * base64字符串转化成图片，返回图片名称
	 * 参数：base64字符串imgStr，图片保存绝对路径savaPath
	 * 返回：成功创建的jpg文件名称，若为空或错误，返回null
	 */
    public static String Base64SaveAsImage(String base64imgStr,String savaPath)  
    {   //对字节数组字符串进行Base64解码并生成图片  
        if (base64imgStr == null) //图像数据为空  
            return null;  
        BASE64Decoder decoder = new BASE64Decoder();  
        try   
        {  
            //Base64解码  
            byte[] b = decoder.decodeBuffer(base64imgStr);  
            for(int i=0;i<b.length;++i)  
            {  
                if(b[i]<0)  
                {//调整异常数据  
                    b[i]+=256;  
                }  
            } 
            
            String imageName=UUID.randomUUID().toString().replace("-", "")+".jpg";//随机生成图片名称
            //生成jpeg图片  
            String imgFilePath = savaPath+imageName;//新生成的图片 路径
            OutputStream out = new FileOutputStream(imgFilePath);     
            out.write(b);   //写入文件
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
