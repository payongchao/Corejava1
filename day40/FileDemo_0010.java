package com.briup.jd1721.corejava.day40;

import java.io.File;

public class FileDemo_0010{
	public static void main(String[] args){
		// 创建一个File对象，构造器参数是String类型的数据。
		// 该String类型的数据表示一个文件的路径。
		// File类是没有空参构造器，因为只要创建File对象，
		// 就必须要有一个文件或者目录的路径与之对应。

		/**
		 * 在创建File对象的时候，构造器参数所对应的文件
		 * 一定要存在吗？？？
		 * 该路径对应的文件不一定要预先存在。
		 *
		 * 绝对路径：
		 * 		Windows下：绝对路径的路径名是以盘符开始。
		 * 		Unix/Linux下： 绝对路径的路径名是以“/”（根目录）开始。
		 *
		 * 相对路径：
		 * 		对于不同的文件编辑器，相对路径的表示也不同。
		 * 		Idea：相对路径是相对于项目的src目录，意思就是
		 * 			  “a.txt”和项目的src目录是同级的。
		 *
		 * 		Eclipse：相对路径是相对于项目的src目录。
		 *
		 * 		其他文本编辑器：当使用其他文本编辑器在编辑
		 * 			某一个文件的时候，该文件中出现的相对路径
		 * 		    是相对于该文件来说的。
		 *
		 * 	所有相对路径最顶层的目录（文件）和某个参照点是同级的。
		 */

		// 第一种创建File对象的形式。
		//File file=new File("C:\\a.txt");

		// 第二种创建File对象的形式。
		// 第二个字符串参数表示某个文件的文件名。
		// 第一个字符串参数表示该文件所处的目录路径。
		//File file=new File("C:\\","a.txt");

		// 第三种创建File对象的形式。
		// 文件：File；目录：Directory
		File dir=new File("C:\\");
		File file=new File(dir,"a.txt");

	}
}
