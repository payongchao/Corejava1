package com.briup.jd1721.corejava.day41;

import java.io.File;

public class FileDemo_0030{
	public static void main(String[] args){
		File dir=new File("O:\\hello");

		//String[] names=dir.list();
		//showArray(names);
        //
		//File[] files=dir.listFiles();
		//showArray(files);

		showDirContent(dir);
	}

	public static void showArray(Object[] os){
		for(Object o:os){
			System.out.println(o);
		}
		System.out.println("=======================");
	}

	/**
	 * 递归：方法自己调用自己，要注意设置递归终止条件。
	 * Java对于文件系统的操作跟文件系统的权限有关系。
	 */
	public static void showDirContent(File dir){
		if(!dir.exists())
			throw new RuntimeException(
				"指定的目录'"+dir+"'不存在。");
		File[] files=dir.listFiles();
		for(File file:files){
			if(file.isFile()){
				System.out.println("File："+file.delete());
			}
			if(file.isDirectory()){
				showDirContent(file);
			}
		}
		System.out.println("Dir："+dir.delete());
	}
}
