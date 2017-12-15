package com.briup.jd1721.corejava.day39;

public class ThreadDemo_0010{
	public static void main(String[] args){
		new Thread(()->{
			for(int i=0;i<100;i++){
				System.out.println(
					Thread.currentThread().getName()
						+"==="+i);
			}
		}).start();
	}
}
