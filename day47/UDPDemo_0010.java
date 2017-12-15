package com.briup.jd1721.corejava.day47;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPDemo_0010{

}

class Sender{
	public static void main(String[] args) throws IOException{
		/**
		 * 1.需要DatagramSocket类来支撑数据的发送。
		 * 2.将需要发送的数据进行封包。DatagramPacket。
		 * 3.发送数据。
		 * 4.关闭相关资源。
		 */
		DatagramSocket ds=new DatagramSocket();

		byte[] data="这是UDP数据。".getBytes();

		InetAddress ia=
			InetAddress.getByName("127.0.0.1");

		int port=60000;

		DatagramPacket dp=
			new DatagramPacket(
				data,data.length,ia,port);

		ds.send(dp);

		ds.close();
	}
}


class Receiver{
	public static void main(String[] args) throws IOException{
		/**
		 * 1.需要DatagramSocket支撑数据的接收。并且
		 *    需要绑定或者监听一个端口，只有发送到该
		 *    端口中的数据，此接收端才能收到。
		 * 2.先创建接受数据的包对象：DatagramPacket。
		 * 3.接收数据。
		 * 4.关闭资源。
		 */
		DatagramSocket ds=new DatagramSocket(60000);

		byte[] data=new byte[1024];

		DatagramPacket dp=
			new DatagramPacket(data,data.length);

		ds.receive(dp); // 阻塞式方法

		String dataStr=
			new String(dp.getData(),0,dp.getLength());

		String ip=dp.getAddress().getHostAddress();

		System.out.println(ip+"::"+dataStr);

		ds.close();
	}
}









