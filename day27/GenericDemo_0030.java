package com.briup.jd1721.corejava.day27;

import com.briup.jd1721.corejava.bean.Student;
import java.util.ArrayList;
import java.util.List;

public class GenericDemo_0030{
	public static void main(String[] args){
		List<Student> list=new ArrayList();
		ShowUtil util=new ShowUtil();
		util.show(list);
	}
}

class ShowUtil{
	public void show(List<? extends Student> list){
		System.out.println(list);
	}
}
