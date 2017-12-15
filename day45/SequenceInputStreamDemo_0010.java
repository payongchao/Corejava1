package com.briup.jd1721.corejava.day45;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class SequenceInputStreamDemo_0010{
	private static List<FileInputStream> fiss=new ArrayList<>();
	/**
	 * 需求：将多个文件合并成一个文件。
	 * 1.需要多个文件。
	 */

	public static void main(String[] args) throws IOException{
		String path="P:\\create";
		String destPath="P:\\combine";
		int num=5;
		String data="Hello";
		String ext="txt";

		//createSeveralFiles(path,num,data,ext);
		//readFromFiles(path,destPath,"合并.txt");
		//readFromDir(path,destPath,"combine.txt");
		combineToOneFromSeveralDirectories("P:\\create","txt");
		writeToFile(fiss,"P:\\combine","a.txt");
	}


	public static void createSeveralFiles(
		String path,int num,String data,String ext)
		throws IOException{
		File dir=new File(path);
		if(!dir.exists()) dir.mkdirs();
		for(int i=0;i<num;i++){
			File file=new File(dir,i+"."+ext);
			new FileOutputStream(file)
				.write((data+i).getBytes());
		}
	}

	public static void readFromFiles(
			String srcPath,String destPath,String name) throws IOException{

		File dir=new File(srcPath);
		if(!dir.exists())
			throw new RuntimeException("指定的目录不存在。抽啦？？？");
		if(dir.isFile())
			throw new RuntimeException("指定的路径非目录。抽啦？？？");

		File[] files=dir.listFiles(new FileFilter(){
			@Override
			public boolean accept(File pathname){
				return pathname
					.getName().endsWith(".txt");
			}
		});

		List<FileInputStream> fiss=new ArrayList<>();
		for(File file:files){
			fiss.add(new FileInputStream(file));
		}

		SequenceInputStream sis=
			new SequenceInputStream(
				Collections.enumeration(fiss));

		FileOutputStream fos=
			new FileOutputStream(
				new File(new File(destPath),name));

		byte[] bytes=new byte[1024];
		int length;
		while((length=sis.read(bytes))!=-1){
			fos.write(bytes,0,length);
		}

		fos.close();
		sis.close();
 	}


 	public static void readFromDir(
 		String src,String dest,String name) throws IOException{
		File dir =new File(src);
		if(!dir.exists())
			throw new RuntimeException("目录不存在。");
		if(!dir.isDirectory())
			throw new RuntimeException(dir+"不是目录。");

		class MyFilter implements FileFilter{
			@Override
			public boolean accept(File name){
				return name.getName().endsWith(".txt");
			}
		}

		File[] files=dir.listFiles(new MyFilter());

		List<FileInputStream> fiss=new ArrayList<>();

		for(File file:files){
			FileInputStream fis=
				new FileInputStream(file);
			fiss.add(fis);
		}

		Enumeration<FileInputStream> enumeration=
			Collections.enumeration(fiss);

		SequenceInputStream sis=
			new SequenceInputStream(enumeration);

		File destDir=new File(dest);
		if(!destDir.exists()) destDir.mkdirs();

		FileOutputStream fos=
			new FileOutputStream(
				new File(destDir,name));

		byte[] bytes=new byte[1024];
		int length=0;

		while((length=sis.read(bytes))!=-1){
			fos.write(bytes,0,length);
		}

		fos.close();
		sis.close();
	}

	/**
	 *
	 * @param srcPath
	 */
	public static void combineToOneFromSeveralDirectories(String srcPath,String fileExt)
			throws IOException{
		File dir=new File(srcPath);
		if(!dir.exists()){
			throw new RuntimeException("指定的目录不存在。");
		}
		if(!dir.isDirectory()){
			throw new RuntimeException("指定的路径非目录。");
		}
		File[] files=dir.listFiles(new FileFilter(){
			@Override
			public boolean accept(File file){
				return file.getName().endsWith(fileExt)||file.isDirectory();
			}
		});
		for(File file:files){
			if(file.isFile()){
				fiss.add(new FileInputStream(file));
			}
			if(file.isDirectory()){
				combineToOneFromSeveralDirectories(file.getAbsolutePath(),fileExt);
			}
		}
	}

	public static void writeToFile(List<FileInputStream> fiss,String destPath,String fileName) throws IOException{
		SequenceInputStream sis=new SequenceInputStream(Collections.enumeration(fiss));
		File desrDir=new File(destPath);
		if(!desrDir.exists()) desrDir.mkdirs();
		FileOutputStream fos=new FileOutputStream(new File(desrDir,fileName));
		byte[] bytes=new byte[1024];
		int length=0;
		while((length=sis.read(bytes))!=-1){
			fos.write(bytes,0,length);
		}
	}
}








