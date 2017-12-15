package com.briup.jd1721.corejava.day23;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo_0010{
	public static void main(String[] args){
		// 1.创建一个Collection集合并添加元素
		Collection coll=new ArrayList();
		coll.add("briup01");
		coll.add("briup02");
		coll.add("briup03");

		/**
		 * 需求：迭代取出集合中的每个元素，并将其打印出来
		 */
		// 2.获取Iterator对象并迭代
		Iterator it=coll.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		// for循环的迭代
		//for(Iterator it1=coll.iterator();it1.hasNext();  ){
		//	System.out.println(it1.next());
		//}
	}
}
