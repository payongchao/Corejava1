package com.briup.jd1721.corejava.day26;

import com.briup.jd1721.corejava.bean.Student;
import java.util.ArrayList;
import java.util.List;

public class ArrayListPractice1{
	public static void main(String[] args){
		List list=new ArrayList();

		list.add(new Student("zhangsan",20));
		list.add(new Student("lisi",22));
		list.add(new Student("wangwu",25));
		list.add(new Student("zhaoliu",29));
		list.add(new Student("zhangsan1",20));
		list.add(new Student("zhangsan2",20));
		list.add(new Student("zhangsan3",20));
		list.add(new Student("zhangsan4",20));
		list.add(new Student("zhangsan5",20));
		list.add(new Student("zhangsan6",20));
		list.add(new Student("zhangsan7",20));

		System.out.println(list.size());

		for(int i=list.size();i>0;i--){
			if(i%3==0&&i!=0&&i<10){
				list.remove(i);
			}
		}
		System.out.println(list);
		System.out.println(list.size());
	}
}
