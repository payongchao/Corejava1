package com.briup.jd1721.corejava.day32;

public class ExceptionDemo_0010{
	public static void main(String[] args){
		try{
			int divide=divide(4,0);
			System.out.println(divide);
		}catch(Exception e){
			e.printStackTrace();
			//能够显示发生的异常类型、原因、还有发生异常的代码位置
			System.out.println("==================");
			System.out.println("getMess："+e.getMessage());
			// 能够显示发生异常的原因。
			System.out.println("toString："+e.toString());
			// 发生异常的类型和原因。
			//System.out.println(e);
			//System.out.println("发生了异常。。。");
		}finally{
			System.out.println("finally执行了。。。");
		}
		System.out.println("hello");
	}

	public static int divide(int a,int b)
			throws Exception{
		return a/b;
		// throw new ArithmeticException("/ by zero");
	}
}


