package com.briup.jd1721.corejava.day38;

public class SingtonDemo_0010{
}

/**
 * 在获取Demo类的对象的时候，
 * 不管获取多少次，得到的都是同一个对象
 */

/**
 * 饿汉式：推荐
 */
class Demo{
	private static final Demo demo=new Demo();

	// 1.私有化构造器
	private Demo(){}
	// 2.提供公有的获取对象的方法
	public Demo getInstance(){
		return demo;
	}
}

/**
 * 懒汉式
 * 多线程中的懒汉式的单例模式：既在一定几率上提高了效率，
 * 也保证了线程安全问题。
 */
class Demo2{
	private static Demo2 d;
	private Demo2(){}
	public static Demo2 getInstance(){
		if(d==null){
			synchronized(Demo2.class){
				if(d==null) {
					d=new Demo2();
				}
			}
		}
		return d;
	}
}










