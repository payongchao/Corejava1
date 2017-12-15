package com.briup.jd1721.corejava.bean;

/**
 * 静态常量
 *
 * 成员变量
 *
 * 构造器
 *
 * 其他自定义方法
 *
 * get/set方法
 *
 * hashCode/equals方法
 *
 * compareTo方法
 *
 * toString方法
 *
 */
public class Student implements Comparable{
	private String name;
	private int age;

	public Student(){
	}

	public Student(String name,int age){
		this.name=name;
		this.age=age;
	}

	public void show(){
		System.out.println("show方法运行。。。");
	}

	public void show(String str){
		System.out.println("show方法运行。。。"+str);
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

	public int hashCode(){
		return this.name.hashCode()+this.age*31;
	}


	// 下面的equals方法，只有Student对象能够调用
	public boolean equals(Object o){
		System.out.println(this+"-----"+o);
		// 如果传递的参数为空，直接返回false
		if(o==null) return false;
		// 如果传递的参数的对象的地址值和调用
		// 该方法的对象的地址值相等，直接返回true
		if(this==o) return true;
		// 如果传递的对象不是是Student的对象，返回false
		if(!(o instanceof Student)) return false;
		Student that=(Student)o;
		return this.name.equals(that.name)
			&&this.age==that.age;
	}

	@Override
	public String toString(){
		return name+":"+age;
	}

	/**
	 * 需要按照学生的年龄进行自然排序
	 * @param o
	 * @return
	 */
	@Override
	public int compareTo(Object o){
		Student that=(Student)o;
		System.out.println(this.name+":"+this.age+"--"+that.name+":"+that.age);
		/**
		 * 由于需求是按照年龄进行排序，所以在比较的时候
		 * 只需要比较年龄即可。
		 *
		 * 如果当前对象的年龄大于指定对象的年龄，则返回正整数。
		 * 如果当前对象的年龄等于指定对象的年龄，则返回0。
		 * 如果当前对象的年龄小于指定对象的年龄，则返回负整数。
		 *
		 */
		//if(this.age>that.age) return 1;
		//if(this.age==that.age) return 0;
		//if(this.age<that.age) return -1;
		//return 0;

		/**
		 * return this.age-that.age;
		 * 此返回值有bug，当两个学生对象的姓名不同，但是
		 * 年龄相同时，还是存不进去。咋办？
		 *
		 * 需求：先按照年龄排序，如果俩对象的年龄相等，
		 * 		再按照姓名进行排序。如果姓名和年龄都相同
		 * 		则认为他俩是同一个学生。
		 */      // -10       -15
		int temp=this.age-that.age;     // +5
		//if(temp==0){
		//	return this.name.compareTo(that.name);
		//}else{
		//	return temp;
		//}

		return temp==0?
			this.name.compareTo(that.name):
			temp;
	}
}








