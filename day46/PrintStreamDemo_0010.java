package com.briup.jd1721.corejava.day46;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class PrintStreamDemo_0010{
	public static void main(String[] args) throws IOException{
		FileInputStream fis=
			new FileInputStream("P:\\bw.txt");
		InputStreamReader isr=new InputStreamReader(fis);
		//BufferedReader br=new BufferedReader(isr);

		PrintStream ps=new PrintStream(System.out);
		// 边读边写
		//byte[] bytes=new byte[1024];
		char[] chars=new char[1024];
		int length=0;
		while((length=isr.read(chars))!=-1){
			ps.println(chars);
		}
		ps.close();
		fis.close();
	}
}
