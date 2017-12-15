package com.briup.jd1721.corejava.day29;

public class ParamDemo_0010{
	public static void main(String...args){
		//int add=add(3,4);
		int[] arr={3,4,5};
		//int add=add(arr);
		// 可变长参数一定要定义在参数列表的最后。
		int add=add1(1,2,3,5);
		System.out.println(add);
	}

	/**
	 * add，计算多个数的和。
	 */

	public static int add(int a,int b){
		return a+b;
	}

	public static int add(int[] arr){
		int sum=0;
		for(int num:arr){
			sum+=num;
		}
		return sum;
	}

	public static int add1(int a,int...nums){
		int sum=0;
		for(int num:nums){
			sum+=num;
		}
		return sum;
	}
}
