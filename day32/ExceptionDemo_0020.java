package com.briup.jd1721.corejava.day32;

public class ExceptionDemo_0020{
	public static void main(String[] args){
		int div=0;
		div=UtilDemo.div(1,-1);
		System.out.println(div);
	}
}

class UtilDemo{
	/**
	 * 功能：定义一个除法运算方法；
	 * 但是，当除数为0的时候，
	 * 		 抛出ArithmeticException对象。
	 * 当除数小于0的时候，抛出
	 * 		 DividerLessThanZeroException对象。
	 */

	public static int div(int a,int b){
		/**
		 * 在自定义异常的时候，如果继承了Exception类，
		 * 那么Java虚拟机认为该自定义异常时编译时异常，
		 * 当使用“throw”关键字将编译时异常抛出的话，
		 * 必须在当前所属的方法上用“throws”关键字对该
		 * 异常进行声明。
		 */
		if(b==0){
			throw new ArithmeticException("除数为0了。");
		}

		if(b<0){
			throw new DividerLessThanZeroException("除数小于0了。");
		}

		return a/b;
	}


	public <String> void show(){
		String a;
	}
}


// 定义异常类
/**
 * Throwable
 * Exception
 */
class DividerLessThanZeroException
		extends RuntimeException{

	public DividerLessThanZeroException(String mess){
		//super();
		super(mess);
	}
}


























