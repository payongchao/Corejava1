package com.briup.jd1721.corejava.day43;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriterDemo_0010{
	public static void main(String[] args) throws IOException{
		String path="P:\\osw.txt";

		// 1.创建一个File对象。
		File file=new File(path);

		// 2.创建OutputStream对象，FileOutputStream。
		FileOutputStream fos=
			new FileOutputStream(file);

		// 3.创建OutputStreamWriter对象。
		OutputStreamWriter osw=
			new OutputStreamWriter(fos);

		// 4.写数据。
		osw.write("你好");

		// 5.关闭相关的流资源。
		osw.close();
		fos.close();
	}
}
