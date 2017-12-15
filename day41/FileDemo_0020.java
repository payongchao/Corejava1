package com.briup.jd1721.corejava.day41;

import java.io.File;

public class FileDemo_0020{
	public static void main(String[] args){
		File dir=new File("O:\\hello\\a\\b\\c\\d\\e");

		// 调用File的相关方法，创建目录，
		// 只能创建单层目录
		//boolean mkdir=dir.mkdir();
		//System.out.println(mkdir);

		// 能够创建多级目录
		boolean mkdirs=dir.mkdirs();
		System.out.println(mkdirs);

		//boolean exists=dir.exists();
		//System.out.println(exists);

		//File file=new File("P:\\fos.txt");
		//boolean delFile=file.delete();
		//System.out.println(delFile);
        //
		//boolean delDir=dir.delete();
		//System.out.println(delDir);
	}
}
