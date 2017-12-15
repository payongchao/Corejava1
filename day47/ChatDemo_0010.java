package com.briup.jd1721.corejava.day47;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ChatDemo_0010{
}

class ChatSender{
	public static void main(String[] args) throws IOException{
		System.out.println("发送端启动了。。。");
		DatagramSocket ds=new DatagramSocket();

		BufferedReader br=
			new BufferedReader(
				new InputStreamReader(System.in));
		String line;

		while(true){
			line=br.readLine();
			DatagramPacket dp=
				new DatagramPacket(
					line.getBytes(), // 数据
					line.getBytes().length,  // 数据的长度
					InetAddress.getByName("172.16.17.155"), // IP
					60000); // 端口

			ds.send(dp);

			if("over".equals(line)){
				break;
			}
		}
		ds.close();
	}
}

class ChatReceiver{
	public static void main(String[] args) throws IOException{
		System.out.println("接受端启动了。。。");
		DatagramSocket ds=new DatagramSocket(60000);

		byte[] bytes=new byte[1024];

		DatagramPacket dp=
			new DatagramPacket(bytes,bytes.length);

		while(true){
			ds.receive(dp);

			String ip=dp.getAddress().getHostAddress();
			String data=new String(
				dp.getData(),0,dp.getLength());

			System.out.println(ip+"::"+data);

			if("over".equals(data)) {
				System.out.println(ip+"...退出了群聊。");
			}
		}
	}
}
