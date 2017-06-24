package com.util;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Decoder;

public class ImageMethod {

	
	/*
	 * 创建文件 
	 */
	public static void NewFile(String pathString) {
		File file = new File(pathString);
		if (!file.exists()) {
			try {
				if (file.createNewFile()) {
					System.out.println("文件创建成功");
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else {
			System.out.println("文件已存在");
		}
	}
	
	/*
	 * 创建文件 
	 */
	public static void NewFileBox(String pathString) {
		File file2 = new File(pathString);
		if (!file2.exists()) {
			if (file2.mkdirs()) {
				System.out.println("文件夹成功");
			}
		} else {
			System.out.println("文件夹存在");
			file2.delete();//销毁文件
		}
	}
	
	/*
	 * 用FileWriter写入文
	 */
	public  static void ForFileWriter(String string,String fileName) {
		File file = new File(fileName);
		try {
			FileWriter fWriter = new FileWriter(file);
			fWriter.write(string);
			fWriter.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	/*
	 * 用BufferedWriter写入文件
	 */
	public static void ForBufferedWriter(String string,String desFile) {
		BufferedWriter bWriter = null;
		try {
			bWriter = new BufferedWriter(new FileWriter(new File(desFile)));
			bWriter.write(string.toString());
			bWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 用FileReader读取文件
	 */
	public static void testReadByReader(String fileName){
		File file = new File(fileName);
		FileReader fis = null;
		try {
			fis =  new FileReader(file);
			char[] arr = new char[1024 * 1000 * 6];
			int len = fis.read(arr);
			String data = new String(arr, 0, len);
			fis.close();
			System.out.println(fileName+"中按FileReader读取的文件内容是：\n"+data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/*
	 * 用FileInputStream读取文件
	 */
	public static void testReadByInputStream(String fileName){
		File file = new File(fileName);
		FileInputStream fis = null;
		try {
			fis =  new FileInputStream(file);
			byte[] arr = new byte[1024 * 1000 * 6];
			int len = fis.read(arr);
			String data = new String(arr, 0, len);
			fis.close();
			System.out.println(fileName+"中按FileInputStream读取的文件内容是：\n"+data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 用BufferedReader读取文
	 */
	public static void testReadByBufferedReader(String fileName) {
		BufferedReader bReader = null;
		String line = null;
		StringBuffer buffer = new StringBuffer();
		try {
			bReader =new BufferedReader(new FileReader(new File(fileName)));
			while ((line = bReader.readLine())!=null) {
				buffer.append(line).append("\n");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(fileName+"中按BufferedReader读取的文件内容是：\n"+buffer.toString());
	}
	
	
	/*
	 * 字符流复制
	 */
	public static void FileCopy1(String readfile,String writeFile) {
		try {
			FileReader input = new FileReader(readfile);
			FileWriter output = new FileWriter(writeFile);
			int read = input.read();		
			while ( read != -1 ) {
				output.write(read);	
				read = input.read();
			}			
			input.close();
			output.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	
	/*
	 * 字节流复制
	 */
	public static void FileCopy2(String readfile,String writeFile) {
		try {
			FileInputStream input = new FileInputStream(readfile);
			FileOutputStream output = new FileOutputStream(writeFile);
			int read = input.read();		
			while ( read != -1 ) {
				output.write(read);	
				read = input.read();
			}			
			input.close();
			output.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	
	/*
	 * 处理流复制 
	 */
	public static void FileCopy3(String readfile,String writeFile) {
		BufferedReader bReader = null;
		BufferedWriter bWriter = null;
		String line = null; 
		try {
			bReader = new BufferedReader(new FileReader(new File(readfile)));
			bWriter = new BufferedWriter(new FileWriter(new File(writeFile)));
			while ((line = bReader.readLine())!=null) {
				bWriter.write(line);
				bWriter.newLine();
			}
			bWriter.close();
			bReader.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	/*
	 * 读取给定图片文件的内容，用FileInputStrea
	 */
	public static byte[] mReaderPicture(String filePath) {
		byte[] arr = null;
		try {
			File file = new File(filePath);
			FileInputStream fReader = new FileInputStream(file);
			arr = new byte[1024*100];
			fReader.read(arr);
		} catch (Exception  e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arr;
	}
	
	/*
	 * 根据byte数组，创建一张新图
	 */
	public static void mWriterPicture(String newFileName,byte[] b){
		try {
			File file = new File(newFileName);
			FileOutputStream fStream = new FileOutputStream(file);
			fStream.write(b);
			fStream.close();
			System.out.println("图片创建成功    "+b.length);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/*
	 * 获取指定网址的图片，返回其byte[]
	 */
	public static byte[] mReaderPictureToInternet(String strUr1){
		byte[] imgData = null;
		URL url;
		try {
			url = new URL(strUr1);
			URLConnection connection = url.openConnection();
			int length = (int)connection.getContentLength();
			InputStream is = connection.getInputStream();
			if (length!=-1) {
				imgData = new byte[length];
				byte[] temp = new byte[500*1024];
				int readLen = 0;
				int destPos = 0;
				while ((readLen = is.read(temp))>0) {
					System.arraycopy(temp, 0, imgData, destPos, readLen);
					//arraycopy(Object src, int srcPos, Object dest, int destPos, int length) 
					//从指定源数组中复制一个数组，复制从指定的位置开始，到目标数组的指定位置结束
					destPos+=readLen;
				}
			}
			return imgData;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imgData;
	}
	
	
	/*
	 * 直接获取指定网址的图片
	 */
	public static void DownPictureToInternet(String filePath,String strUr1){
		try {
			URL url = new URL(strUr1);
			InputStream fStream = url.openConnection().getInputStream();
			int b = 0;
			FileOutputStream fos = new FileOutputStream(new File(filePath));
			while ((b=fStream.read())!=-1) {
				fos.write(b);
			}
			fStream.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
