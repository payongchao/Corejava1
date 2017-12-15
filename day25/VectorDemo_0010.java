package com.briup.jd1721.corejava.day25;

import java.util.Enumeration;
import java.util.Vector;

public class VectorDemo_0010{
	public static void main(String[] args){
		Vector v=new Vector();
		v.add("briup01");
		v.add("briup02");
		v.add("briup03");
		v.add("briup04");

		// 获取Enumeration对象，该对象的功能
		// 和Iterator对象的功能是一模一样的。
		Enumeration en=v.elements();
		while(en.hasMoreElements()){
			System.out.println(en.nextElement());
		}
		System.out.println(v);
	}
}
