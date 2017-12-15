package com.briup.jd1721.corejava.day44;

import java.io.FileInputStream;
import java.io.IOException;

public class SkipByteDemo_0010{
	public static void main(String[] args) throws IOException{
		FileInputStream fis=
			new FileInputStream("P:\\bos.txt");
		fis.skip(5);
		int read=fis.read();
		System.out.println(read);
	}
}
