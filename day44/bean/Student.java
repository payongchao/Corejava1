package com.briup.jd1721.corejava.day44.bean;

public class Student{
	private String name;
	private double chinese;
	private double math;
	private double english;
	private double sum;

	public Student(){
	}

	public Student(String name,double chinese,double math,double english,double sum){
		this.name=name;
		this.chinese=chinese;
		this.math=math;
		this.english=english;
		this.sum=sum;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name=name;
	}

	public double getChinese(){
		return chinese;
	}

	public void setChinese(double chinese){
		this.chinese=chinese;
	}

	public double getMath(){
		return math;
	}

	public void setMath(double math){
		this.math=math;
	}

	public double getEnglish(){
		return english;
	}

	public void setEnglish(double english){
		this.english=english;
	}

	public double getSum(){
		return sum;
	}

	public void setSum(double sum){
		this.sum=sum;
	}

	@Override
	public String toString(){
		return "Student ["+"name='"+name+'\''+", chinese="+chinese+", math="+math+", english="+english+", sum="+sum+']';
	}
}
