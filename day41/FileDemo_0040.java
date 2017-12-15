package com.briup.jd1721.corejava.day41;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class FileDemo_0040{
	public static void main(String[] args){
		// 1.获取某个文件或者目录的父目录
		//File file=new File("hello");

		//String parent=file.getParent();
		//System.out.println(parent);

		// 2.获取绝对路径或者相对路径
		//String absolutePath=file.getAbsolutePath();
		//System.out.println(absolutePath);
        //
		//String path=file.getPath();
		//System.out.println(path);

		/**
		 * 查找某个目录下全部以“.java”结尾的文件
		 */
		File dir=new File("P:\\");

		//MyFilter filter=new MyFilter();
		//String[] list=dir.list(filter);
		//for(String name:list){
		//	System.out.println(name);
		//}

		File[] files=dir.listFiles(new MyFileFilter());
		for(File file:files){
			System.out.println(file);
		}
	}
}

/**
 * P:\\
 *
 * a.pdf
 * b.pdf
 * c.docx
 * d.txt
 *
 */
class MyFilter implements FilenameFilter{
	@Override
	public boolean accept(File dir,String name){
		System.out.println(name);
		return name.endsWith(".pdf");
	}
}


class MyFileFilter implements FileFilter{

	@Override
	public boolean accept(File pathname){
		return pathname.isHidden();
	}
}












