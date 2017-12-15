package com.briup.jd1721.corejava.day43;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CopyCharTextFileDemo_0010{
	public static void main(String[] args) throws IOException{
		String src="P:\\1.png";
		String dest="P:\\1_copy.png";
		copy(src,dest);
	}

	public static void copy(String src,String dest) throws IOException{
		/**
		 * 需求：拷贝一个文本文件到另一个文本文件
		 * 思路：
		 * 	1.创建一个输入流读取原文件。
		 * 		File
		 * 		FileInputStream
		 * 		InputStreamReader
		 * 		BufferedReader
		 * 	2.创建一个输出流写入数据到文件中。
		 * 		File
		 * 		FileOutputStream
		 * 		OutputStreamWriter
		 * 		BufferedWriter
		 * 	3.边读边写。
		 */
		// 创建读取文件的相关对象。
		File srcFile=new File(src);
		FileInputStream fis=
			new FileInputStream(srcFile);
		InputStreamReader isr=
			new InputStreamReader(fis);
		BufferedReader br=
			new BufferedReader(isr);

		// 创建写入文件数据的相关对象
		File destFile=new File(dest);
		FileOutputStream fos=
			new FileOutputStream(destFile);
		OutputStreamWriter osw=
			new OutputStreamWriter(fos);
		BufferedWriter bw=
			new BufferedWriter(osw);

		// 边读边写
		int index=0;
		String line;
		while((line=br.readLine())!=null){
			bw.write(line);
			bw.newLine();
			//index++;
			if((index++)%300==0){
				bw.flush();
			}
		}

		bw.flush();

		// 关闭相关流对象
		bw.close();
		osw.close();
		fos.close();

		br.close();
		isr.close();
		fis.close();
	}
}
