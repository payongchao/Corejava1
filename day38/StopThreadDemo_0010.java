package com.briup.jd1721.corejava.day38;

import java.lang.Thread.State;

public class StopThreadDemo_0010{
	public static void main(String[] args){
		StopDemo sd=new StopDemo();
		Thread t1=new Thread(sd);
		Thread t2=new Thread(sd);
		t1.start();
		// interrupt方法只能中断一次
		t1.interrupt();
		t2.start();
		t2.interrupt();
	}
}

class StopDemo implements Runnable{
	@Override
	public synchronized void run(){
		int index=0;
		while(true){
			index++;
			if(index>100) break;
			System.out.println(
				Thread.currentThread().getName()+"--"
					+index);
			try{ //----
				wait();//-------------
			}catch(InterruptedException e){
				e.printStackTrace();
				break;
				//index=1000;
				//return;
			}
			State state=
				Thread.currentThread().getState();
			System.out.println(state);
		}
	}
}
