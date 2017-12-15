package com.briup.jd1721.corejava.day35.bean;

public class Student{
	// 定义成员变量
	private int id;
	private String name;
	private int age;
	private String gender;
	private String passwd;

	// 定义构造器
	public Student(){
	}

	public Student(int id,String passwd){
		this.id=id;
		this.passwd=passwd;
	}

	public Student(int id,String name,int age,String gender,String passwd){
		this.id=id;
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.passwd=passwd;
	}

	// Get和Set方法
	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id=id;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name=name;
	}

	public int getAge(){
		return age;
	}

	public void setAge(int age){
		this.age=age;
	}

	public String getGender(){
		return gender;
	}

	public void setGender(String gender){
		this.gender=gender;
	}

	public String getPasswd(){
		return passwd;
	}

	public void setPasswd(String passwd){
		this.passwd=passwd;
	}

	//toString()

	@Override
	public String toString(){
		return "Student["+"id="+id
				+", name='"+name+'\''
				+", age="+age
				+", gender='"+gender+'\''
				+", passwd='"+passwd+'\''+']';
	}
}
