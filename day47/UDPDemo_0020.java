package com.briup.jd1721.corejava.day47;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPDemo_0020{
}

class Sender2{
	public static void main(String[] args)
			throws IOException{
		System.out.println("发送端启动了。。。");

		DatagramSocket ds=new DatagramSocket();

		byte[] data="这是UDP发送端。--Kevin".getBytes();
		InetAddress ia=
			InetAddress.getByName("172.16.17.255");
		int port=60000;

		DatagramPacket dp=
			new DatagramPacket(
				data,data.length,ia,port);

		ds.send(dp);

		ds.close();
	}
}

class Receiver2{
	public static void main(String[] args) throws IOException{
		System.out.println("接收端启动了。。。");
		DatagramSocket ds=
			new DatagramSocket(60000);

		byte[] bytes=new byte[1024];
		DatagramPacket dp=
			new DatagramPacket(bytes,bytes.length);

		while(true){
			ds.receive(dp);

			// 获取发送端的IP
			String ip=
				dp.getAddress().getHostAddress();

			// 获取发送端发过来的数据
			String data=
				new String(
					dp.getData(),0,dp.getLength());

			System.out.println(ip+"::"+data);
		}
	}
}



















