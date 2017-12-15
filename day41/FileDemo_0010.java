package com.briup.jd1721.corejava.day41;

import java.io.File;

public class FileDemo_0010{
	public static void main(String[] args){
		/**
		 * 当File封装的字符串所代表的目录或者文件存在的
		 * 时候，能通过File的相关方法来判断该File对象封装
		 * 的是文件还是目录；当不存的时候，不能判断是文件
		 * 还是目录。
		 */
		File file=new File("C:\\abc");

		// 来判断File封装的字符串代表的是不是文件。
		boolean isFile=file.isFile();
		System.out.println(isFile);

		// 判断File封装的字符串是否是目录
		boolean directory=file.isDirectory();
		System.out.println(directory);
	}
}
