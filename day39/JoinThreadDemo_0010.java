package com.briup.jd1721.corejava.day39;

public class JoinThreadDemo_0010{
	public static void main(String[] args) throws InterruptedException{
		Demo d=new Demo();
		Thread t1=new Thread(d);
		Thread t2=new Thread(d);
		t1.setPriority(Thread.MAX_PRIORITY);
		//Thread t3=new Thread(d);
		t1.start();
		t2.start();
		//t1.join();
		//t3.start();
		// --------------------
		for(int i=0;i<100;i++){
			System.out.println(
				Thread.currentThread().toString()
					+"===="+i);
		}
	}
}

class Demo implements Runnable{
	@Override
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println(
				Thread.currentThread().toString()
					+"---"+i);
			//Thread.yield();
			//Thread.sleep(10);
		}
	}
}
