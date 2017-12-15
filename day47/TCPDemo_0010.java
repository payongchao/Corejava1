package com.briup.jd1721.corejava.day47;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPDemo_0010{
}

class Client{
	public static void main(String[] args)
			throws IOException{
		System.out.println("客户端运行了。。。");

		// 1.创建客户端的Socket对象，
		// 由于TCP是面向连接的协议，需要在创建该Socket对象
		// 的时候就指定所要连接的目标主机IP和端口号。
		Socket s=new Socket("127.0.0.1",50000);

		// 2.通过客户端的Socket对象获取数据发送的输出流对象
		OutputStream os=s.getOutputStream();

		// 3.发送数据
		os.write("服务器，你好。我是客户端。".getBytes());

		// 获取输入流对象，收取数据。
		InputStream is=s.getInputStream();

		byte[] bytes=new byte[1024];
		int length=is.read(bytes);

		System.out.println(new String(bytes,0,length));

		// 4.关闭相关资源
		s.close();
	}
}

class Server{
	public static void main(String[] args)
			throws IOException{
		System.out.println("服务器端运行了。。。");

		// 1.创建服务器端的ServerSocket对象，
		//   并且要指定监听的端口。
		ServerSocket ss=new ServerSocket(50000);

		// 2.通过接受客户端的请求，拿到客户端的Socket对象。
		Socket s=ss.accept(); // 阻塞式方法

		// 3.通过第二步获取到的客户端的Socket对象，
		// 获取读取数据的输入流对象。
		InputStream is=s.getInputStream();

		// 4.获取其他额外信息、
		String ip=s.getInetAddress().getHostAddress();
		System.out.println(ip+"...连接进来了。。。");

		// 5.读取数据
		byte[] bytes=new byte[1024];
		int length=is.read(bytes);
		System.out.println(new String(bytes,0,length));

		// 通过Socket对象获取OutputStream对象，
		// 给客户端回传数据

		OutputStream os=s.getOutputStream();
		os.write("客户端，你好，我是服务器。".getBytes());

		// 6.关闭相关资源
		s.close();
		ss.close();
	}
}

