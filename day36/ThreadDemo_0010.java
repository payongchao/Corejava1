package com.briup.jd1721.corejava.day36;

public class ThreadDemo_0010{
	public static void main(String[] args){
		Demo d1=new Demo();
		Demo d2=new Demo();
		d1.show();
		d2.show();
	}
}

class Demo{
	public void show(){
		for(int i=0;i<10;i++){
			System.out.println(i);
		}
	}
}
