package com.briup.jd1721.corejava.day43;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderDemo_0010{
	public static void main(String[] args) throws IOException{
		String path="P:\\temp.txt";

		// 1.创建File对象。
		File file=new File(path);

		// 2.创建InputStream对象，FileInputStream
		FileInputStream fis=
			new FileInputStream(file);

		// 3.创建InputStreamReader对象。
		InputStreamReader isr=
			new InputStreamReader(fis,"UTF-8");

		// 4.读取数据。
		//int ch=isr.read();
		// 该方法的返回值就是读取到的字符所对应的编码值
		//System.out.println((char)ch);
		int ch;
		while((ch=isr.read())!=-1){
			System.out.println((char)ch);
		}

		// 5.关闭流资源。
		isr.close();
		fis.close();
	}
}
