package com.briup.jd1721.corejava.day31;

import java.lang.reflect.Field;

public class ReflectDemo_0020{
	public static void main(String[] args)
			throws Exception{
		Class<?> clazz=Class.forName(
		"com.briup.jd1721.corejava.bean.Student");

		//getFieldDemo(clazz);
		getFieldDemo1(clazz);
	}

	public static void getFieldDemo(Class clazz)
		throws ClassNotFoundException,
		       NoSuchFieldException{
		// 通过clazz对象的getField方法获取Field对象
		Field field=clazz.getField("name");
		System.out.println(field);
	}

	public static void getFieldDemo1(Class clazz)
			throws NoSuchFieldException,
		           IllegalAccessException,
		           InstantiationException{
		// 由于Student类中的name字段是私有的，要通过
		// 反射获取该字段的话，就要使用getDeclaredField
		// 方法。因为getField方法只能获取到共有的字段。
		Field field=clazz.getDeclaredField("name");

		// 由于Student类中的name字段是私有的，想要
		// 通过Field中的相关方法来获取或者指定值时
		// 是不允许的，可以通过setAccessible方法开放
		// 对该字段的访问权限。
		field.setAccessible(true); // 暴力访问

		Object obj=clazz.newInstance();

		// 给指定的字段赋值
		field.set(obj,"zhangsan");

		// 获取指定的字段的值
		Object o=field.get(obj);
		System.out.println(o);
	}
}
