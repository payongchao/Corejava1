package com.briup.jd1721.corejava.day25;

import com.briup.jd1721.corejava.bean.Student;
import java.util.HashSet;

public class SetDemo_0020{
	public static void main(String[] args){
		// 1.创建HashSet对象、
		HashSet set=new HashSet();

		// 2.添加Student的对象
		/**
		 * 需求：当姓名和年龄都相等的时候，认为这两个
		 * Student对象同一个对象。
		 */
		set.add(new Student("xyz",20));
		set.add(new Student("hello",20));
		set.add(new Student("hello",20));
		set.add(new Student("xiaoming",20));
		set.add(new Student("zhangsan",20));

		System.out.println(set);
	}
}
