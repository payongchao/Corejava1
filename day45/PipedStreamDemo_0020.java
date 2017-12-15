package com.briup.jd1721.corejava.day45;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamDemo_0020{
	public static void main(String[] args) throws IOException{
		PipedInputStream pis=new PipedInputStream();
		PipedOutputStream pos=new PipedOutputStream(pis);

		byte[] bytes=new byte[1024];
		System.out.println(1111111);
		int length=pis.read(bytes);
		System.out.println(222222222);
		System.out.println(new String(bytes,0,length));
		pos.write("hello".getBytes());
	}
}
