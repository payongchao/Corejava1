package com.briup.jd1721.corejava.day25;

import java.util.LinkedList;

public class LinkedListDemo_0010{
	public static void main(String[] args){
		LinkedList list=new LinkedList();
		list.addLast("briup01");
		list.addLast("briup02");
		list.addLast("briup03");
		list.addLast("briup04");

		// removeFisrt(); 移除并返回该链表中的第一个元素
		while(list.isEmpty()){
			System.out.println(list.peekLast());
		}

		System.out.println(list);
	}
}
