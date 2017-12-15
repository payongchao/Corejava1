package com.briup.jd1721.corejava.day26;

import com.briup.jd1721.corejava.bean.Student;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo_0020{
	public static void main(String[] args){
		/**
		 * 需求：往该集合中存入Student对象
		 */
		Set set=new TreeSet();

		set.add(new Student("zhangsan",20));
		set.add(new Student("lisi",22));
		set.add(new Student("wangwu",27));
		set.add(new Student("zhaoliu",19));
		set.add(new Student("qianqi",15));
		set.add(new Student("sunba",17));
		set.add(new Student("zhoujiu",25));
		set.add(new Student("xiaoming",22));
		set.add(new Student("alibaba",22));

		/**
		 * Exception in thread "main"
		 * java.lang.ClassCastException:
		 * com.briup.jd1721.corejava.bean.Student
		 * cannot be cast to java.lang.Comparable
		 *
		 * 涉及到排序，肯定会涉及到比较大小的问题。
		 * 但是在Student类中有没有定义比较功能呢？没有。
		 * 比较大小分三种情况：大于，等于，小于.
		 *
		 * 如果要让自定义的类具有可比较的功能，
		 * 则需要自定义的类实现Comparable接口。
		 *
		 */

		for(Object o:set){
			System.out.println(o);
		}
	}
}
