package com.briup.jd1721.corejava.day37;

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
	private static int nums=100;
	private static Object object=new Object();
	@Override
	public void run(){
		try{
			sale();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	public static void sale() throws InterruptedException{
		while(true){
			// 使用锁对象，将同步代码块进行保护，
			// 当其中一个线程拿到锁对象之后，就去执行
			// 任务代码，当任务代码执行完毕之后，释放锁对象
			// 只有释放了锁对象，其他线程才能拿到所对象。
			// 把这种现象叫线程同步/安全。意味着效率低。
			// 民间叫法：该锁叫“明锁”
			synchronized(Ticket2.class){
				if(nums>0){
					Thread.sleep(10);
					System.out.println(nums--);
				}
			}
		}
	}
}
