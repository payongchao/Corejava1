package com.briup.jd1721.corejava.day44;

import com.briup.jd1721.corejava.day44.bean.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class PracticeDemo_0010{
	public static void main(String[] args) throws IOException{
		// 获取键盘录入
		BufferedReader br=new BufferedReader(
			new InputStreamReader(System.in));
		// 创建集合，存储Student对象
		List<Student> students=new ArrayList<>();
		int index=1;
		while(true){
			System.out.println("请输入第"+(index++)+"个学生的信息（或“over”结束输入）：");
			String line=br.readLine();
			if("over".equals(line)) break;
			// 将获取的数据以“,”分割
			String[] strs=line.split("[,]");
			if(strs.length<4){
				System.out.println("输入数据长度不足，请重新输入！");
				index--;
				continue;
			}
			// 获取Student的每个字段的数据并填充
			String name=strs[0];
			double chinese=0;
			double math=0;
			double english=0;
			try{
				chinese=Double.parseDouble(strs[1]);
				math=Double.parseDouble(strs[2]);
				english=Double.parseDouble(strs[3]);
				double sum=chinese+math+english;
				// 创建学生对象，将相关的属性值做填充
				Student student=
					new Student(name,chinese,math,english,sum);
				students.add(student);
			}catch(Exception e){
				System.err.println("当前输入数据错误，请重新输入！");
				index--;
			}
		}

		BufferedWriter bw=
			new BufferedWriter(
				new OutputStreamWriter(
					new FileOutputStream("P:\\stus.txt",true)));
		for(Student student:students){
			bw.write(student.getName()+"::"+student.getSum());
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}
}
