package com.briup.jd1721.corejava.day26;

import com.briup.jd1721.corejava.bean.Student;
import java.util.ArrayList;
import java.util.List;

public class ArrayListPractice{
	public static void main(String[] args){
		List list=new ArrayList();

		//list.add(new Student("zhangsan",20));
		//list.add(new Student("lisi",22));
		//list.add(new Student("wangwu",25));
		//list.add(new Student("zhaoliu",29));
		//list.add(new Student("zhangsan",20));

		/**
		 * 创建新的集合，然后遍历原集合中的每一个元素，
		 * 将该元素放入新集合中，在放之前进行判断，判断
		 * 该元素在新集合中是否存在，如果不存，存进去；
		 * 如果存在，什么都不做。
		 */
		List temp=new ArrayList();
		for(Object obj:list){
			Student student=(Student)obj;
			if(!temp.contains(student)){
				temp.add(student);
			}
		}
		System.out.println(temp);
		System.out.println(list);
	}
}
