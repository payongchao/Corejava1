package com.briup.jd1721.corejava.day23;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo_0010{
	public static void main(String[] args){
		//Collection coll=new ArrayList();
		//showCollection(coll);

		showAllCollection();
	}

	/**
	 * 演示Collection的基本操作
	 * @param coll
	 */
	public static void
		showCollection(Collection coll){
		// 1.添加元素
		coll.add("briup01");
		coll.add("briup02");
		coll.add("briup03");
		coll.add(10);

		// 2.移除元素
		//coll.remove(10);
		//coll.clear();

		// 3.判断
		System.out.println(coll.size());
		System.out.println(coll.isEmpty());
		System.out.println(coll.contains(10));

		System.out.println(coll);
	}

	/**
	 * 演示Collection集合的带All的方法的操作
	 */
	public static void
		showAllCollection(){

		Collection c1=new ArrayList();
		Collection c2=new ArrayList();

		// 1.给每个集合添加元素
		c1.add("briup01");
		c1.add("briup02");
		c1.add("briup03");

		c2.add("briup02");
		c2.add("briup03");
		c2.add("briup07");

		// 2.添加一组元素，把c2添加到c1中
		//c1.addAll(c2);

		// 2.移除,removeAll();retainAll();，从c1中移除c2。
		//c1.removeAll(c2);
		c1.retainAll(c2);

		// 3.判断 containsAll()
		//boolean containsAll=c1.containsAll(c2);
		//System.out.println(containsAll);

		System.out.println(c1);
		System.out.println(c2);
	}
}
