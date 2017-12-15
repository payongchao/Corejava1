package com.briup.jd1721.corejava.day31;

public class EnumDemo_0010{
	public static void main(String[] args){
		Color red=Color.RED;
		System.out.println(red);
		System.out.println(red.getName());
	}
}

// 定义一个枚举类
enum Color{
	// 当枚举类型的数据后面还有代码时，枚举类型
	// 常量声明结束后必须加分号。
	RED("红色"),YELLOW("黄色"),GREEN("绿色");
	//-----------------------------------------

	private String name;

	private Color(String name){
		this.name=name;
	}

	public String getName(){
		return name;
	}

	public String toString(){
		return this.name;
	}

	public void show(){
		System.out.println("show 运行。。。");
	}
}


