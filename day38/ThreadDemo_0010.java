package com.briup.jd1721.corejava.day38;

public class ThreadDemo_0010{
	public static void main(String[] args){
		// 第一种常用的设计线程的方式
		new Thread(){
			@Override
			public void run(){
				System.out.println(Thread.currentThread().getName()+"====0000000");
			}
		}.start();

		// 第二种
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+"====1111111");
		}).start();

		// 第三种
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+"====2222222");
		}){
			@Override
			public void run(){
				System.out.println(Thread.currentThread().getName()+"====3333333");
			}
		}.start();
	}
}
