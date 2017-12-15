package com.briup.jd1721.corejava.day36;

public class SaleTicketDemo_0020{
	public static void main(String[] args){
		Ticket2 t=new Ticket2();
		Thread t1=new Thread(t); // 创建线程
		Thread t2=new Thread(t);
		t1.start();				 // 启动线程
		t2.start();
	}
}

// 定义资源类/普通类，
// 让该类具备可被启动/运行的性质
// 该类不是线程类
class Ticket2 implements Runnable{
	private int nums=100;
	@Override
	public void run(){
		while(true){
			if(nums<0) break;
			sale();
		}
	}

	public void sale(){
		System.out.println(--nums);
	}
}
