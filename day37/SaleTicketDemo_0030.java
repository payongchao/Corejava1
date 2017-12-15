package com.briup.jd1721.corejava.day37;

public class SaleTicketDemo_0030{
	public static void main(String[] args){
		Ticket3 t=new Ticket3();
		Thread t1=new Thread(t); // 创建线程
		Thread t2=new Thread(t);
		t1.start();				 // 启动线程
		t2.start();
	}
}

// 定义资源类/普通类，
// 让该类具备可被启动/运行的性质
// 该类不是线程类
class Ticket3 implements Runnable{
	private int nums=100;
	private Object object=new Object();
	@Override
	public void run(){
		try{
			while(true){
				sale();
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	/**
	 * 同步方法中的锁是谁？
	 * this。
	 */
	public synchronized void sale() throws InterruptedException{
		if(nums>0){
			Thread.sleep(10);
			System.out.println(nums--);
		}
	}
}
