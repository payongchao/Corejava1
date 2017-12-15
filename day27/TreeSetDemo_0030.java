package com.briup.jd1721.corejava.day27;

import com.briup.jd1721.corejava.bean.Student;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo_0030{
	public static void main(String[] args){

		/**
		 * 需求：
		 * 先按照姓名排序，如果姓名相等，再按照年龄排序。
		 */



		Set set=new TreeSet(new MyComparator());
		set.add(new Student("zhangsan",20));
		set.add(new Student("lisi",22));
		set.add(new Student("wangwu",27));
		set.add(new Student("zhaoliu",19));
		set.add(new Student("qianqi",15));
		set.add(new Student("sunba",17));
		set.add(new Student("zhaoliu",25));
		set.add(new Student("xiaoming",22));
		set.add(new Student("alibaba",22));

		for(Object o:set){
			System.out.println(o);
		}
	}
}

class MyComparator implements Comparator{

	@Override
	public int compare(Object o1,Object o2){
		Student s1=(Student)o1;
		Student s2=(Student)o2;

		int temp=s1.getName().compareTo(s2.getName());
		//if(temp==0){
		//	int ageComp=s1.getAge()-s2.getAge();
		//	return ageComp;
		//}else{
		//	return temp;
		//}
		return temp==0?s1.getAge()-s2.getAge():temp;
	}
}
