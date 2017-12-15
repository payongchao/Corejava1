package com.briup.jd1721.corejava.day26;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo_0010{
	public static void main(String[] args){
		Set set=new TreeSet();

		set.add("xiaoming");
		set.add("xiaoming");
		set.add("xiaohong");
		set.add("zhangsan");
		set.add("lisi");
		set.add("wangwu");
		set.add("liuxiaoguang");

		for(Object o:set){
			System.out.println(o);
		}
		System.out.println(set);
	}
}
