package com.briup.jd1721.corejava.day46;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo_0010{
	public static void main(String[] args) throws IOException{
		String path="P:\\ps.txt";
		//read(path);
		write(path);
	}

	public static void read(String path) throws IOException{
		File file=new File(path);
		RandomAccessFile raf=
			new RandomAccessFile(file,"r");
		System.out.println(raf.getFilePointer());

		//int b=raf.read();
		//System.out.println(b);
		//System.out.println(raf.getFilePointer());
        //
		//byte[] bytes=new byte[10000];
		//raf.read(bytes);
		//System.out.println(raf.getFilePointer());

		raf.seek(5);
		int read=raf.read();
		System.out.println(read);
	}

	public static void write(String path) throws IOException{
		RandomAccessFile raf=
			new RandomAccessFile(path,"rw");

		System.out.println(raf.getFilePointer());

		raf.seek(20);
		raf.write("你好".getBytes());
		System.out.println(raf.getFilePointer());

		raf.seek(100);
		raf.write("杰普".getBytes());
		System.out.println(raf.getFilePointer());
	}
}
