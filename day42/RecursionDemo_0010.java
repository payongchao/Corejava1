package com.briup.jd1721.corejava.day42;

public class RecursionDemo_0010{
	public static void main(String[] args){
		int sum=jiecheng(4);
		System.out.println(sum);
	}

	public static int jiecheng(int num){
		// 设置递归的终止条件
		if(num==0) return 1;
		return num*jiecheng(--num);
	}
}
