package com.briup.jd1721.corejava.day36;

public class ThreadDemo_0020{
	public static void main(String[] args){
		Demo2 d1=new Demo2(); // Thread-0
		Demo2 d2=new Demo2(); // Thread-1
		d1.start();
		d2.start();
		// 获取执行当前代码所在的方法的线程对象
		Thread thread=Thread.currentThread();
		System.out.println(thread.getName()+"---------------");
	}
}

/**
 * 自定义线程类：
 * 	1.继承Thread类
 * 	2.重写run方法
 * 	3.启动线程，应该调用父类中的start方法。
 */
class Demo2 extends Thread{
	@Override
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println(getName()+":"+i);
		}
	}
}













