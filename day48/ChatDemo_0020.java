package com.briup.jd1721.corejava.day48;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ChatDemo_0020{
	public static void main(String[] args){
		new Thread(new ChatReceiver()).start();
		new Thread(new ChatSender()).start();
	}
}

class ChatSender implements Runnable{
	@Override
	public void run(){
		try{
			DatagramSocket ds=
				new DatagramSocket();
			BufferedReader br=
				new BufferedReader(
					new InputStreamReader(
						System.in));
			String line=null;
			while(!("over".equals(line))){
				line=br.readLine();
				byte[] bytes=line.getBytes();
				DatagramPacket dp=
					new DatagramPacket(
						bytes,
						bytes.length,
						InetAddress.getByName("172.16.17.255"),
						60000);
				ds.send(dp);
			}
			ds.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}

class ChatReceiver implements Runnable{
	@Override
	public void run(){
		try{
			DatagramSocket ds=
				new DatagramSocket(60000);
			byte[] bytes=new byte[1024];
			DatagramPacket dp=
				new DatagramPacket(bytes,bytes.length);
			while(true){
				ds.receive(dp);
				bytes=dp.getData();
				String data=
					new String(bytes,0,dp.getLength());
				String ip=dp.getAddress().getHostAddress();
				System.out.println(ip+"::"+data);
				if("over".equals(data))
					System.out.println(ip+"...退出了群聊。");
			}
			//ds.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}


