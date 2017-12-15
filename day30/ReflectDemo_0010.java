package com.briup.jd1721.corejava.day30;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo_0010{
	public static void main(String[] args) throws Exception{
		/**
		 * 1.获取Class类的对象
		 * 2.通过该对象就可以创建.class文件对应的类的对象
		 * 3.直接通过上面创建的对象调用方法。
		 */
		getClazz3(
			"com.briup.jd1721.corejava.bean.Student");
	}

	// 1.获取Class类的对象，有三种方式

	/**
	 * 第一种：通过Object类中的getClass()方法。
	 */
	//public static void getClazz(){
	//	Student student=new Student();
	//	Class<? extends Student> studentClass
	//		=student.getClass();
	//	Class<? extends Student> studentClass2
	//		=student.getClass();
	//	System.out.println(
	//		studentClass==studentClass2);
	//}

	/**
	 * 第二种：通过“.class”属性来获取Class对象
	 */
	//public static void getClazz2(){
	//	Class<Student> studentClass=Student.class;
	//	Class<Student> studentClass1=Student.class;
	//	System.out.println(studentClass==studentClass1);
	//}

	/**
	 * 第三种：通过Class类的一个静态方法“forName(str)”来
	 * 		  获取Class对象。
	 */
	public static void getClazz3(String className)
		throws ClassNotFoundException,
			   IllegalAccessException,
			   InstantiationException,
			   NoSuchMethodException,
			   InvocationTargetException{
		Class<?> clazz=Class.forName(className);
		System.out.println(clazz);
		// 使用clazz对象创建className所代表的类的对象。
		// Object o=clazz.newInstance();

		/**
		 * 获取className所代表的类的构造器。
		 */
		Constructor<?> constructor
			=clazz.getConstructor(String.class,int.class);
		Object o=
			constructor.newInstance("zhangsan",22);

		System.out.println(o);

		// 正常情况：
		//Student student=new Student("zhangsan",22);

	}
}
