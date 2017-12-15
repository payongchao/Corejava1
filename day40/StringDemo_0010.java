package com.briup.jd1721.corejava.day40;

import java.util.Arrays;

public class StringDemo_0010{
	//private static String s1="abc";
	public static void main(String[] args){
		String s1="abcabc";
		//String s2=new String("abc");
		//System.out.println(s1==s2);
		//System.out.println(s1.equals(s2));

		/**
		 * indexOf('')
		 * lastIndexOf('')
		 */
		//System.out.println(s1.indexOf('b'));
		//System.out.println(s1.lastIndexOf('b'));

		/**
		 * substring(start,end);
		 */

		//String substring=s1.substring(1,4);
		//System.out.println(substring);

		//char c=s1.charAt(3);
		//System.out.println(c);

		/**
		 * concat(String);
		 * // 将指定的字符串添加到此字符串的尾部
		 */
		//String concat=s1.concat(s2);
		//System.out.println(s1);
		//System.out.println(s2);
		//System.out.println(concat);


		//show(s1);
		//System.out.println(s1);

		/**
		 * endsWith(suffix);
		 */
		//boolean ends=s1.endsWith("abc");
		//System.out.println(ends);
		//
		//boolean starts=s1.startsWith("abc");
		//System.out.println(starts);

		/**
		 * split(String);
		 * 将调用该方法的字符串按照参数中指定的字符串进行
		 * 切割，形成字符串数组。
		 */
		//String str="abc,def,ghi,jkl,mn";
		//String[] strings=str.split(",");
		//System.out.println(strings.length);
		//System.out.println(Arrays.toString(strings));

		String[] strs={"abc","def","hij"};
		show(strs);
		System.out.println(Arrays.toString(strs));
	}

	public static String show(String s1){
		/**
		 * 对于基本数据类型和String类型的数据，
		 * 在做参数传递时，是将原来的值进行
		 * 拷贝一份之后作为实参传递给方法。
		 *
		 * 对于基本数据类型和String数据类型，作为
		 * 参数传递时，可以认为形参就是该方法的局部变量，
		 * 在方法中的对于参数的操作类似于对于局部变量
		 * 的操作，对其他的全局变量没有影响。
		 */
		s1+="Hello";
		return s1;
	}


	public static void show(String[] strs){
		strs[1]="Hello";
	}
}
