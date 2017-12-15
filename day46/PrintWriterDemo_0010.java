package com.briup.jd1721.corejava.day46;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class PrintWriterDemo_0010{
	public static void main(String[] args) throws IOException{
		BufferedReader br=
			new BufferedReader(
				new InputStreamReader(
					new FileInputStream(
						new File("P:\\ps.txt"))));

		PrintWriter pw=
			new PrintWriter(
				new BufferedWriter(
					new OutputStreamWriter(
						new FileOutputStream(
							new File("P:\\pw.txt")))),true);

		String line;
		while((line=br.readLine())!=null){
			pw.println(line);
		}

		pw.close();
		br.close();
	}
}
