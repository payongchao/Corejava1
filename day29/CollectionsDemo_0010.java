package com.briup.jd1721.corejava.day29;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo_0010{
	public static void main(String[] args){
		// addAll 参数：coll     es
		List<String> list=new ArrayList<>();
		Collections.addAll(list,"2","1","1","3");
		System.out.println(list);

		//Collections.fill(list,"5");
		//Collections.sort(list);
		System.out.println(list);
	}
}









