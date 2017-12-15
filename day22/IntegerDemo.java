package com.briup.jd1721.corejava.day22;

/**
 * 1.包装器类和字符串之间的转换
 * 2.进制之间的转换
 */
public class IntegerDemo{
	public static void main(String[] args){
		Integer it_1=new Integer(-128111111);
		System.out.println(it_1.toString());

		//int num=10;
		//System.out.println(num+"");

		//String str="123";
		//Integer it_2=new Integer(str);
		//Integer it_2=Integer.valueOf(str);
		//int it_2=Integer.parseInt(str);
		//System.out.println(it_2);


		//int num=16;
		// 转化成16进制
		//String hexStr=Integer.toHexString(num);
		//System.out.println("0x"+hexStr);
		// 转化成8进制
		//String octalStr=Integer.toOctalString(num);
		//System.out.println(octalStr);
		// 转化成2进制
		//String binStr=Integer.toBinaryString(num);
		//System.out.println(binStr);

		// 将任意某个数转化成10进制
		//Integer str=Integer.valueOf("16",10);
		//int str=Integer.parseInt("11111111",5);
		//System.out.println(str);

		//Boolean bl=new Boolean(null);
		//System.out.println(bl);

		//Integer it_1=new Integer(5);
		//
		//Integer it_2=5;// 自动装箱
		//
		//
		//it_2+=2;
		//
		//it_2=it_2+2;  // 自动拆箱
		//
		//String str=it_2.toString();
		//int num=Integer.parseInt(str);
		//
		//int tmp=num+2;
		//
		//it_2=new Integer(tmp);

	}
}



