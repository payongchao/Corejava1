package com.briup.jd1721.corejava.day43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GetDataFromKeyBoardDemo_0010{
	public static void main(String[] args) throws IOException{
		//getData();
		add();
	}

	public static void getData() throws IOException{
		// 1.获取标准输入流对象。
		InputStream is=System.in;
		// 2.将字节流转化成字符流
		InputStreamReader isr=
			new InputStreamReader(is);
		// 3.使用缓冲技术
		BufferedReader br=
			new BufferedReader(isr);
		// 4.读取键盘录入的数据
		// readLine方法又称为“阻塞式”方法。
		// 当接受不到数据的时候，会一直等待，而不往下执行。
		String line=br.readLine();
		System.out.println("键盘输入的数据："+line);

		// 关于在该操作中关闭流资源的说明：
		// 一般在使用系统的标准输入输出流时，
		// 不做流的关闭操作。
	}

	/**
	 * 需求：
	 * 	循环录入数据，录入的数据只能是数字，
	 * 	最后计算所录入的数字的和。
	 * 	当录入的数据是“bye”的时候，结束录入。
	 */
	public static void add() throws IOException{
		BufferedReader br=
			new BufferedReader(
				new InputStreamReader(System.in));
		double sum=0.0;
		int index=1;
		while(true){
			System.out.println("请输入第"+(index++)+"个数字：");
			String line=br.readLine();
			if("bye".equals(line)) break;
			try{
				double num=Double.parseDouble(line);
				sum+=num;
			}catch(Exception e){
				continue;
			}
		}
		System.out.println(sum);
	}
}
