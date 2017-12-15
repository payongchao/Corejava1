package com.briup.jd1721.corejava.day42;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileDemo_0010{
	public static void main(String[] args) throws IOException{
		String src="P:\\1.png";
		String dest="P:\\2.jpg";
		copy(src,dest);
	}

	/**
	 * 需求：从某个源文件中读取数据，
	 * 		然后写入到另外一个目的文件中。
	 * 		边读边写。
	 * 思路：
	 * 	1.定义源文件和目标文件的File对象。
	 * 	2.定义读取源文件的字节输入流和写入目标文件的字节输出流
	 * 	3.读取源文件的数据，并将读取到的数据写入到目标文件中
	 * 	4.关闭相关流资源
	 */
	public static void copy(String src,String dest) throws IOException{
		File srcFile=new File(src);
		File destFile=new File(dest);

		FileInputStream fis=
			new FileInputStream(srcFile);
		FileOutputStream fos=
			new FileOutputStream(destFile);

		int length=0;
		byte[] bytes=new byte[1024];
		while((length=fis.read(bytes))!=-1){
			fos.write(bytes,0,length);
		}

		fos.close();
		fis.close();
	}
}
