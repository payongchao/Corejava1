package com.briup.jd1721.corejava.day48;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadFileDemo_0010{
}

class UploadClient{
	public static void main(String[] args) throws IOException{
		System.out.println("客户端启动了。。。");
		Socket s=new Socket("172.16.17.155",50000);

		BufferedInputStream bis=
			new BufferedInputStream(
				new FileInputStream(
					"P:\\create\\0.txt"));

		PrintStream ps=
			new PrintStream(
				s.getOutputStream(),true);

		BufferedReader reader=
			new BufferedReader(
				new InputStreamReader(
					s.getInputStream()));

		byte[] bytes=new byte[1024];
		int length;
		while((length=bis.read(bytes))!=-1){
			//ps.println(bytes);
			ps.write(bytes,0,length);
		}
		s.shutdownOutput();
		String feedback=reader.readLine();
		System.out.println(feedback);

	}
}

class UploadServer{
	public static void main(String[] args) throws IOException{
		System.out.println("服务器启动。。。");
		ServerSocket ss=new ServerSocket(50000);
		while(true){
			Socket s=ss.accept();
			String ip=
				s.getInetAddress().getHostAddress();
			System.out.println(
				ip+"。。。连接进来了。。。");
			BufferedInputStream bis=
				new BufferedInputStream(
					s.getInputStream());
			String fileName=
				ip+"_"+
				System.currentTimeMillis()+
				".txt";
			File dir=new File("P:\\");
			File file=new File(dir,fileName);
			BufferedOutputStream bos=
				new BufferedOutputStream(
					new FileOutputStream(file));
			PrintWriter writer=
				new PrintWriter(
					s.getOutputStream(),true);
			byte[] bytes=new byte[1024];
			int length;
			while((length=bis.read(bytes))!=-1){
				bos.write(bytes,0,length);
				bos.flush();
			}
			writer.println("上传成功！");
			s.close();
		}
	}
}







