package com.briup.jd1721.corejava.day24;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListDemo_0010{
	public static void main(String[] args){
		//showList();
		showListIterator();
	}

	/**
	 * List中特有的方法演示1
	 */
	public static void showList(){
		// 1.创建List的对象并实例化
		List list=new ArrayList();
		// 2.添加元素
		list.add("briup01");
		list.add("briup02");
		list.add("briup03");
		list.add("briup04");
		System.out.println(list);

		//System.out.println(list);
		//list.add(1,"Hello");
		//System.out.println(list);
		//// 使用addAll(index,list)
		//list.addAll(1,list);
		//System.out.println(list);

		// 删除元素
		//list.remove(1);

		// 更改元素
		//list.set(1,"Hello");

		// 查询元素
		//System.out.println(list.get(1));
		//System.out.println(list.get(2));
		//System.out.println(list.get(0));

		// 通过迭代器获取所有元素
		//Iterator iterator=list.iterator();
		//while(iterator.hasNext()){
		//	System.out.println(iterator.next());
		//}

		// List中特有的遍历方式
		//for(int i=0;i<list.size();i++){
		//	System.out.println(list.get(i));
		//}

		// System.out.println(list.indexOf("briup02"));

		// subList(start,end);
		//System.out.println(list.subList(1,3));

		// subString();
		//String s="Hello_World!!";
		//System.out.println(s.substring(5,5));

		System.out.println(list);
	}

	/**
	 * List中的特有的迭代
	 */
	public static void showListIterator(){
		List list=new ArrayList();
		list.add("briup01");
		list.add("briup02");
		list.add("briup03");
		list.add("briup04");
		list.add("briup02");

		/**
		 * 需求：在迭代遍历的过程中，
		 *      如果元素的值为“briup02”,
		 *      就添加一个元素“Hello”
		 */
		// 先使用共性的迭代器
		// java.util.ConcurrentModificationException
		// 出现该异常的原因是：
		//      Iterator对象在取元素，
		//      但是List的对象在操作元素。
		//Iterator iterator=list.iterator();
		//while(iterator.hasNext()){
		//	Object o=iterator.next();
		//	if(o.equals("briup02")){
		//		int index=list.indexOf("briup02");
		//		list.add(index,"Hello");
		//	}
		//}

		ListIterator lt=list.listIterator();
		while(lt.hasNext()){
			Object next=lt.next();
			if(next.equals("briup02")){
				lt.add("Hello");
			}
		}

		System.out.println(list);
	}
}
