package com.briup.jd1721.corejava.day48;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPDemo_0030{
}

class TransClient2{
	public static void main(String[] args) throws IOException{
		System.out.println("客户端启动了。。。");
		Socket s=new Socket("127.0.0.1",50000);
		// 给服务器发送数据的输出流
		BufferedWriter bw=
			new BufferedWriter(
				new OutputStreamWriter(
					s.getOutputStream()));
		// 接收服务器回传数据的输入流
		BufferedReader br=
			new BufferedReader(
				new InputStreamReader(
					s.getInputStream()));
		// 需要一个输入流从键盘接收数据的输入
		BufferedReader reader=
			new BufferedReader(
				new InputStreamReader(
					System.in));
		// 定义String变量，接收键盘录入的数据
		String line;
		while((line=reader.readLine())!=null){
			System.out.println("客户端已输入的数据："+line);
			if("886".equals(line)) break;
			// 发送数据
			bw.write(line);
			bw.newLine();
			bw.flush();
			// 接收服务器回传的数据
			String data=br.readLine();
			System.out.println("服务器说："+data);
		}
		// 当while循环结束之后，关闭客户端的Socket对象。
		s.close();
	}
}

class TransServer2{
	public static void main(String[] args) throws IOException{
		System.out.println("服务器启动了。。。");
		// 定义ServerSocket对象，监听端口。
		ServerSocket ss=new ServerSocket(50000);
		// 接收客户端的连接，并获取客户端的Socket对象
		while(true){
			Socket s=ss.accept();
			// 定义输入流，接收客户端发送过来的数据
			BufferedReader br=
				new BufferedReader(
					new InputStreamReader(
						s.getInputStream()));
			// 定义输出流，将转化之后的数据回传给客户端。
			BufferedWriter bw=
				new BufferedWriter(
					new OutputStreamWriter(
						s.getOutputStream()));
			// 接收客户发送过来的数据，存储到line中
			// 该readLine方法能够读取到一行数据的标志是：
			// 读取到回车换行符。
			String line;
			while((line=br.readLine())!=null){
				System.out.println("服务器收到的数据："+line);
				// 判断当客户传过来的数据是“886”的时候，
				// 关闭获取到的客户端的Socket对象。
				if("886".equals(line)) s.close();
					// 将数据进行转化，然后回传给客户端。
				else {
					bw.write(line.toUpperCase());
					bw.newLine();
					bw.flush();
				}
			}
		}
	}
}


