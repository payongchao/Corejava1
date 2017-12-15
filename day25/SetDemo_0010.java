package com.briup.jd1721.corejava.day25;

import java.util.HashSet;
import java.util.Iterator;

public class SetDemo_0010{
	public static void main(String[] args){
		// 1.创建HashSet集合对象
		HashSet set=new HashSet();

		// 2.添加元素
		set.add("abc");
		set.add("hello");
		set.add("xyz");
		set.add("xiaoming");
		set.add("xiaoming");

		// 3.删除元素
		set.remove("xiaoming");
		//set.clear();

		// 4.获取元素：迭代器
		Iterator it=set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

		// 5.关于判断的方法
		System.out.println(set.isEmpty());
		System.out.println(set.contains("xiaoming"));


		System.out.println(set);
	}
}
