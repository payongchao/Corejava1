package com.briup.jd1721.corejava.day27;

import com.briup.jd1721.corejava.bean.Student;
import java.util.ArrayList;
import java.util.List;

public class GenericDemo_0020{
	public static void main(String[] args){
		Show<String> show=new Show<>();
		show.show(1+"");
		show.print(new Student());

		//List<?> list=new ArrayList<>();
		//list.add("123");

		List<Student> list=new ArrayList();
		//list.add("1");
		list.add(new Student());
		//list.add(1);

		Abc abc=new Abc();
		abc.showList(list);
	}
}

class Show<O>{
	public void show(O o){
		System.out.println(o);
	}

	public <W> void print(W w){
		System.out.println(w);
	}
}

class Abc{
	public void showList(List<?> list){
		System.out.println(list);
	}
}

class Def<O>{
	public void showList(List<O> list){
		System.out.println(list);
	}
}
