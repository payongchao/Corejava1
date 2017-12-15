package com.briup.jd1721.corejava.day42;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo_0010{
	public static void main(String[] args)
			throws IOException{
		String filePath="P:\\temp.txt";
		//writeDataToFile(filePath);
		//readDataFromFile(filePath);
		//byte[] bytes=new byte[1024];
		//bytes[0]=97;
		//bytes[1]=98;
		//System.out.println(
		//	new String(bytes));
		readDataFromFile2(filePath);
	}

	/**
	 * 将一段数据写入到磁盘的某个文件中。
	 * 1.创建File对象。
	 * 2.创建相关的输出流对象，用来操作该文件。
	 * 3.执行相关输出流的写操作方法。
	 * 4.关闭流资源。
	 */
	public static void writeDataToFile(String filePath) throws IOException{
		// 1.创建File对象。
		File file=new File(filePath);
		// 2.创建相关的流对象。
		// 该构造器的第二个参数表示是否追加到源文件中。
		// 默认是false，设置为true表示追加。
		FileOutputStream fos=new FileOutputStream(file,true);
		// 3.执行写操作，写数据。
		for(int i=0;i<500;i++){
			// 该方法会覆盖原有的数据
			fos.write("你好".getBytes());
		}
		// 4.关闭流资源
		fos.close();
	}

	public static void readDataFromFile(String filePath) throws IOException{
		// 1.创建要读取的文件的File对象。
		File file=new File(filePath);
		// 2.创建相关的输入流对象。
		FileInputStream fis=new FileInputStream(file);
		// 3.调用相关输入流的读方法来读取数据
		//int b1=fis.read(); //该方法的返回值就是读取到的字节
		//System.out.println(b1);
		//int b2=fis.read();
		//System.out.println(b2);
		//int b3=fis.read();
		//System.out.println(b3);
		//int b4=fis.read();
		//System.out.println(b4);
		//int b5=fis.read();
		//System.out.println(b5);
		int b=0;
		//while(b!=-1){
		//	b=fis.read();
		//	System.out.println(b);
		//}
		while((b=fis.read())!=-1){
			System.out.println(b);
		}
		// 4.关闭相关流资源
		fis.close();
	}

	public static void readDataFromFile2(String path)
			throws IOException{
		File file=new File(path);
		FileInputStream fis=new FileInputStream(file);
		// 定义一个字节数组，用来存放读取的数据
		// 该数组的长度在开发中一般定义成1024的整倍数
		byte[] bytes=new byte[1024];
		// 该方法的返回值代表本次读取到的实际字节个数
		int read=fis.read(bytes);
		System.out.println(read);
		System.out.println(new String(bytes,0,read));
	}
}







