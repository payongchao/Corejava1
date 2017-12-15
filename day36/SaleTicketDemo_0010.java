package com.briup.jd1721.corejava.day36;

public class SaleTicketDemo_0010{
	public static void main(String[] args){
		Ticket t1=new Ticket();
		Ticket t2=new Ticket();
		t1.start();
		t2.start();
	}
}

class Ticket extends Thread{
	static int nums=100;

	// 线程所执行的任务
	public void sale(){
		System.out.println(--nums);
	}

	@Override
	public void run(){
		sale();
	}
}



class PlaneTicket extends Ticket{

}
