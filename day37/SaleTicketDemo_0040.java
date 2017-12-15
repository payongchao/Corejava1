package com.briup.jd1721.corejava.day37;

public class SaleTicketDemo_0040{
	public static void main(String[] args){
		Ticket4 t=new Ticket4();
		Thread t1=new Thread(t);
		Thread t2=new Thread(t);
		t1.start();
		t2.start();
	}
}

class Ticket4 implements Runnable{
	private int nums=1000;
	private Object object=new Object();

	@Override
	public void run(){
		while(true){
			try{
				sale1();
				sale2();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}

	public synchronized void sale1() throws InterruptedException{
		synchronized(object){
			if(nums>0){
				Thread.sleep(10);
				System.out.println(nums--);
			}
		}
	}

	public synchronized void sale2() throws InterruptedException{
		synchronized(object){
			//if(nums>0){
			//	Thread.sleep(10);
			//	System.out.println(nums--);
			//}
			sale1();
		}
	}
}
