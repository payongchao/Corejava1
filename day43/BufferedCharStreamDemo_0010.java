package com.briup.jd1721.corejava.day43;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BufferedCharStreamDemo_0010{
	public static void main(String[] args) throws IOException{
		String path="P:\\demo.txt";
		//read(path);
		write(path);
	}

	public static void read(String path) throws IOException{
		// 创建File对象
		File file=new File(path);

		// 创建InputStream对象。
		FileInputStream fis=
			new FileInputStream(file);

		// 创建InputStreamReader对象。
		InputStreamReader isr=
			new InputStreamReader(fis);

		// 创建带缓冲区的BufferedReader对象
		BufferedReader br=
			new BufferedReader(isr);

		// 读取数据
		//String line=br.readLine();
		//System.out.println(line);

		// 定义String类型变量，接受读取到的一行数据
 		String line;
 		while((line=br.readLine())!=null){
			System.out.println(line);
		}

		// 关闭流资源
		br.close();
		isr.close();
		fis.close();
	}

	public static void write(String path) throws IOException{
		// 1.创建File对象。
		File file=new File(path);

		// 2.创建FileOutputStream对象。
		FileOutputStream fos=
			new FileOutputStream(file);

		// 3.创建OutputStreamWriter对象。
		OutputStreamWriter osw=
			new OutputStreamWriter(fos);

		// 4.创建BufferedWriter对象。
		BufferedWriter bw=
			new BufferedWriter(osw);

		//BufferedWriter writer=
		//	new BufferedWriter(
		//		new OutputStreamWriter(
		//			new FileOutputStream(
		//				new File(path))));
		//writer.close();

		// 5.写入数据。
		//bw.write("qwertyuiop");
		//bw.newLine();
		//// 上面的newLine方法就等效于bw.write("\r\n");
		//bw.write("hello");

		for(int i=0;i<1000;i++){
			bw.write(i+"：Hello World");
			bw.newLine();
			//bw.flush();
		}

		// 5.1在使用有缓冲区的输出流的时候，要进行flush操作。
		bw.flush();

		// 6.关闭相关流资源。
		bw.close();
		osw.close();
		fos.close();
	}
}
