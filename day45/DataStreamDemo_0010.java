package com.briup.jd1721.corejava.day45;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamDemo_0010{
	public static void main(String[] args) throws IOException{
		String path="P:\\dsd.txt";
		//write(path);
		//write2(path);
		//read(path);
		read2(path);
	}

	public static void read2(String path) throws IOException{
		DataInputStream dis=
			new DataInputStream(
				new FileInputStream(path));
		int i1=dis.readInt();
		System.out.println(i1);
	}

	public static void read(String path) throws IOException{
		FileInputStream fis=
			new FileInputStream(path);
		//System.out.println(fis.read());
		//System.out.println(fis.read());
		//System.out.println(fis.read());
		//System.out.println(fis.read());

		// 将流的读取标记重置到流的开始位置
		//fis.reset();

		byte[] bytes=new byte[4];
		fis.read(bytes);
		System.out.println(new String(bytes));

	}

	public static void write2(String path) throws IOException{
		// 创建DataOutputStream对象
		DataOutputStream dos=
			new DataOutputStream(
				new FileOutputStream(path));
		// 写入数据
		dos.writeInt(353);
		dos.close();
	}

	public static void write(String path) throws IOException{
		FileOutputStream fos=
			new FileOutputStream(path);
		// 该write方法在将一个字节个数大于1的的数据写入到
		// 文件中的时候，只会将低位的1个字节写入到文件中
		fos.write(354);
		fos.close();
	}
}
