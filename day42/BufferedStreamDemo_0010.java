package com.briup.jd1721.corejava.day42;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedStreamDemo_0010{
	public static void main(String[] args)
			throws IOException{
		String path="P:\\bos.txt";
		//write(path);
		read(path);
	}

	/**
	 * 需求：使用BufferedOutputStream
	 * 	     将一段数据写入到某个文件中。
	 * 思路：
	 * 		1.创建File对象。
	 * 		2.创建原始的操作文件的字节输出流
	 * 		3.创建带有缓冲功能的字节输出流，并将
	 * 		  第2步产生的输出流对象作为参数传递给
	 * 		  该缓冲流对象的构造器。
	 * 		4.执行带缓冲功能的字节输出流的写操作。
	 * 		5.关闭相关流资源。俩。
	 */
	public static void write(String path) throws IOException{
		File file=new File(path);
		FileOutputStream fos
			=new FileOutputStream(file);
		BufferedOutputStream bos
			=new BufferedOutputStream(fos);
		bos.write("Hello1".getBytes());
		bos.flush();
		bos.write("Hello2".getBytes());
		bos.flush();
		//--------------------
		bos.close();
		bos.write(1);
		bos.flush();
		//fos.close();
	}

	public static void read(String path) throws IOException{
		/**
		 * 1.创建File对象
		 * 2.创建原始的InputStream对象
		 * 3.创建BufferedInputStream对象
		 * 4.读取数据
		 * 5.关闭流资源
		 */
		File file=new File(path);
		FileInputStream fis=
			new FileInputStream(file);
		BufferedInputStream bis=
			new BufferedInputStream(fis);
		byte[] bytes=new byte[1024];
		// 该方法是调用的父类中的read方法。
		int length=bis.read(bytes);
		System.out.println(length);
		System.out.println(new String(bytes,0,length));
		bis.close();
		fis.close();
	}
}
