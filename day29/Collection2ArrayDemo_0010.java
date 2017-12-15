package com.briup.jd1721.corejava.day29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Collection2ArrayDemo_0010{
	public static void main(String[] args){
		Collection<Integer> coll=new ArrayList();
		coll.add(1);
		coll.add(2);
		coll.add(3);
		coll.add(4);
		//Object[] objects=coll.toArray();

		/**
		 * 该数组的长度怎么定义呢？
		 * 如果定义的数组的长度小于集合的size，Java自己
		 * 新创建一个长度和集合的长度相等的数组。如果定义
		 * 的数组的长度大于等于集合的size，Java会使用该
		 * 数组做数据存储。
		 * 一般在将集合转化成数组的时候，定义的数组的大小
		 * 为给集合的size。
		 */
		Integer[] integers=
			coll.toArray(new Integer[coll.size()]);
		System.out.println(
			Arrays.toString(integers));

	}
}
