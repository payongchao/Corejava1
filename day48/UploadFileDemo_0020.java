package com.briup.jd1721.corejava.day48;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadFileDemo_0020{
}

class UploadFileClient{
	public static void main(String[] args)
			throws IOException{
		System.out.println("客户端已启动。。。");
		// 1.创建Socket对象。
		Socket s=new Socket("172.16.17.155",50000);
		// 2.创建字节输入流，读取本地文件。
		BufferedInputStream bis=
			new BufferedInputStream(
				new FileInputStream("P:\\corejava.wmv"));
		// 3.创建字节输出流，将数据发送给服务器
		BufferedOutputStream bos=
			new BufferedOutputStream(
				s.getOutputStream());
		// 4.创建字符输入流，读取服务器回传的数据。
		BufferedReader reader=
			new BufferedReader(
				new InputStreamReader(
					s.getInputStream()));
		// 5.边读边写
		byte[] bytes=new byte[1024];
		int length;
		while((length=bis.read(bytes))!=-1){
			bos.write(bytes,0,length);
			bos.flush();
		}
		// 6.给服务器传递数据发送结束的标记
		s.shutdownOutput();
		// 7.读取服务器端回传给客户端的数据
		String feedback=reader.readLine();
		System.out.println(feedback);
		// 8.关闭相关资源
		bis.close();
		bos.close();
		s.close();
	}
}

class UploadFileServer{
	public static void main(String[] args)
			throws IOException{
		System.out.println("服务器已启动。。。");
		// 创建服务器端的ServerSocket对象
		ServerSocket ss=
			new ServerSocket(50000);
		// 由于服务器一直处于运行状态。
		while(true){
			// 有了新的客户端连接进来之后
			// 就需要获取客户端的Socket对象。
			Socket s=ss.accept();
			// 新的客户端连接进来，就开始上传文件了
			// 需要启用一个新的线程来处理文件上传
			new Thread(new HandleFile(s)).start();
		}
	}
}

/**
 * 每当有新的客户端连接到服务器之后，
 * 服务器新开启线程，用该类来处理文件数据。
 */
class HandleFile implements Runnable{
	private Socket s;

	public HandleFile(Socket s){
		this.s=s;
	}

	@Override
	public void run(){
		String ip=
			s.getInetAddress().getHostAddress();
		System.out.println(
			ip+"...连接进来了..."+
			Thread.currentThread().getName());
		try{
			// 1.创建字节输入流，
			//   读取客户端发送过来的数据
			BufferedInputStream bis=
                new BufferedInputStream(
                	s.getInputStream());
			// 2.创建字节输出流，
			//   将从客户端读取到的数据保存到本地
			// 2.1创建文件对象，File对象。
			//    解决上传文件到服务器上，服务器在
			// 	  存储文件的时候重名的问题：
			//    重新定义文件名：
			//    客户端IP_当前时间戳.后缀
			String path="P:\\";
			String name=ip+"_"+System.currentTimeMillis()+".txt";
			File file=new File(path,name);
			BufferedOutputStream bos=
				new BufferedOutputStream(
					new FileOutputStream(file));
			// 3.创建输出流，给客户端回传数据。
			BufferedWriter writer=
				new BufferedWriter(
					new OutputStreamWriter(
						s.getOutputStream()));
			// 4.边读取客户端发送过来的数据，
			//   边写入到服务器本地文件中。
			byte[] bytes=new byte[1024];
			int length;
			while((length=bis.read(bytes))!=-1){
				bos.write(bytes,0,length);
				bos.flush();
			}
			// 5.回传信息给客户端
			writer.write("来自"+ip+"的文件上传成功！");
			writer.flush();
		}catch(IOException e){
			System.out.println(
				Thread.currentThread().getName()+"——"+ip+"断开了。。。");
		}finally{
			// 6.上传成功之后，关闭客户端的连接。
			//s.close();
			if(s!=null) {
				try{
					s.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
}











