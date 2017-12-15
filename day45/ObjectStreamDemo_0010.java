package com.briup.jd1721.corejava.day45;

import com.briup.jd1721.corejava.day45.bean.Student;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamDemo_0010{
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		String path="P:\\oos.txt";
		//write(path);
		read(path);
	}

	// 对象的序列化
	public static void write(String path) throws IOException{
		// 1.创建要保存的对象。
		Student student=new Student("张三",20);
		// 局部变量在使用之前需要显式初始化。
		ObjectOutputStream oos=null;
		try{
			// 2.创建ObjectOutputStream对象。
			oos=new ObjectOutputStream(
					new FileOutputStream(path));
			// 3.调用写操作
			oos.writeObject(student);
		}finally{
			// 关闭流资源
			if(oos!=null){
				oos.close();
			}
		}
	}

	// 对象的反序列化
	public static void read(String path) throws IOException, ClassNotFoundException{
		// 创建ObjectInputStream的对象。
		ObjectInputStream ois=
			new ObjectInputStream(
				new FileInputStream(path));
		// 读取对象。
		Object object=ois.readObject();
		System.out.println(object);
		// 关闭流
		ois.close();
	}
}
