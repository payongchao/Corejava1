package com.briup.jd1721.corejava.day48;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPDemo_0020{
	/**
	 * 需求：
	 * 	1.客户端通过键盘录入数据，
	 * 	  然后发送给服务器端。
	 * 	2.服务器端将该数据的英文字母转化成
	 * 	  大写之后反馈给客户端。
	 */
}

class TransClient{
	public static void main(String[] args) throws IOException{
		System.out.println("客户端启动了。。。");
		Socket s=new Socket("172.16.17.155",50000);
		OutputStream os=s.getOutputStream();
		PrintWriter pw=new PrintWriter(os,true);

		BufferedReader br=
			new BufferedReader(
				new InputStreamReader(
					System.in));
		String line=null;
		while(!("886".equals(line))){
			line=br.readLine();
			//os.write(line.getBytes());
			//os.write("\r\n".getBytes());
			pw.println(line);

			BufferedReader reader=
				new BufferedReader(
					new InputStreamReader(
						s.getInputStream()));

			System.out.println("服务器说："+
				reader.readLine());
		}
		s.close();
	}
}

class TransServer{
	public static void main(String[] args) throws IOException{
		System.out.println("服务器启动了。。。");
		ServerSocket ss=new ServerSocket(50000);
		while(true){
			Socket s=ss.accept(); // 阻塞式方法
			String ip=s.getInetAddress().getHostAddress();
			System.out.println(ip+"...连接进来了。。。");
			BufferedReader br=
				new BufferedReader(
					new InputStreamReader(
						s.getInputStream()));
			String line=br.readLine();

			BufferedWriter bw=
				new BufferedWriter(
					new OutputStreamWriter(
						s.getOutputStream()));
			bw.write(line.toUpperCase());
			s.close();
		}
	}
}




















