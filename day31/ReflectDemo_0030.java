package com.briup.jd1721.corejava.day31;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo_0030{
	public static void main(String[] args)
		throws Exception{
		Class<?> clazz=
			Class.forName("com.briup.jd1721.corejava.bean.Student");
		getMethodDemo1(clazz);
	}

	public static void getMethodDemo(Class clazz)
		throws NoSuchMethodException,
				IllegalAccessException,
				InstantiationException,
				InvocationTargetException{
		// 通过getMethod方法获取指定的类中的指定的方法名
		// 为“show”的这个方法，返回的是Method对象。
		Method showMethod=clazz.getMethod("show");
		// 对获取到的“show”方法进行调用。
		showMethod.invoke(clazz.newInstance());
		System.out.println(showMethod);
	}

	public static void getMethodDemo1(Class clazz)
		throws NoSuchMethodException,
		IllegalAccessException,
		InstantiationException,
		InvocationTargetException{
		// 获取带参的指定方法
		Method showMethod=
			clazz.getMethod("show",String.class);
		// 调用方法
		showMethod.invoke(clazz.newInstance(),"zhangsan");
	}
}
