package com.briup.jd1721.corejava.day40;

import java.io.File;
import java.io.IOException;

public class FileDemo_0020{
	public static void main(String[] args)
			throws IOException{
		//File dir=new File("C:\\");
		//File file=new File(dir,"a.txt");

		File file=new File("a.txt");

		// 如何判断该文件是否存在呢？？？
		boolean exists=file.exists();
		System.out.println(exists);

		// 该文件不存在，新建文件。
		boolean newFile=file.createNewFile();
		System.out.println(newFile);
	}
}
