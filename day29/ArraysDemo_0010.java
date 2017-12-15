package com.briup.jd1721.corejava.day29;

import java.util.Arrays;
import java.util.List;

public class ArraysDemo_0010{
	public static void main(String[] args){
		// 长度不可变的List集合，
		//List<Integer> list=Arrays.asList(1,2,3,4);
		//System.out.println(list);
		////list.set(1,4);
		////list.add(5);
		////list.remove(1);
		//System.out.println(list);


		//String[] arr={"zhangsan","lisi","wangwu"};
		/**
		 * Arrays中的asList方法可以将某个数组转化成
		 * 集合，但是在转化的过程中有以下两点需要注意：
		 * 1.当数组中存储的是基本数据类型时，该方法会
		 * 将整个数组作为一个元素存储到集合中。
		 * 2.当数组中存储的是引用数据类型时，该方法会
		 * 将数组中的每一个元素作为集合的每一个元素存储
		 * 到该集合中。
		 */
		int[] arr={1,2,3,4};
		List<int[]> list=Arrays.asList(arr);
		System.out.println(list);
		System.out.println(list.size());
	}
}
