package com.briup.jd1721.corejava.day27;

import com.briup.jd1721.corejava.bean.Student;
import java.util.ArrayList;
import java.util.List;

public class GenericDemo_0010{
	public static void main(String[] args){

		List<Student> list=new ArrayList();
		list.add(new Student("zhangsan",20));
		list.add(new Student("lisi",25));
		list.add(new Student("wangwu",20));
		list.add(new Student("zhaoliu",20));

		//Tool<Student> tool=new Tool();
		//tool.sum(list);

		//UtilDemo demo=new UtilDemo();
		//demo.show(list);

		//UtilDemo<Student> demo=new UtilDemo<>();
		//demo.show(list);
	}

	public static void showGeneric(){
		/**
		 * 在集合中存储int类型的数据，
		 * 然后对该集合中的所有数据求和。
		 */
		/**
		 * Exception in thread "main"
		 * java.lang.ClassCastException:
		 * java.lang.String cannot be
		 * cast to java.lang.Integer
		 *
		 * 出现该异常的原因：
		 * 直接原因：String不能强转成Integer。
		 * 间接原因：集合中所存储的元素的数据类型不一致。
		 * 解决方案：在创建集合的时候，直接规定该集合
		 * 			中能够存储的数据类型。
		 * 如何规定：使用泛型。
		 */

		List<Integer> list=new ArrayList();
		list.add(4);
		list.add(1);
		list.add(2);
		list.add(3);
		//list.add("3");

		int sum=0;
		for(Object o:list){
			Integer i=(Integer)o;
			sum=sum+i;
		}
		System.out.println(sum);
	}
}


class Tool<O>{
	public void sum(List<O> list){
		for(O o:list){
			System.out.println(o);
		}
	}
}

interface Util<O>{
	public void show(List<O> list);
}

class UtilDemo<W> implements Util<W>{
	@Override
	public void show(List<W> list){
		System.out.println(list);
	}
}










