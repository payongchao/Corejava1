package com.briup.jd1721.corejava.day22;

public class ObjectDemo{
	public static void main(String[] args){
		Student stu_1=new Student(4);
		System.out.println(stu_1.toString());

		Class clazz=stu_1.getClass();
		String className=clazz.getName();

		System.out.println(
			className+"@"+
				Integer.toHexString(
					stu_1.hashCode()));

		//Student stu_2=new Student(4);
		//Teacher teacher=new Teacher();
		//boolean equals=stu_1.equals(stu_2);
		//System.out.println(equals);
		//System.out.println(stu_1==stu_2);

		//boolean compare=stu_1.compare(stu_2);
		//System.out.println(compare);
	}
}

class Teacher{

}

class Student{
	private int age;

	Student(int age){
		this.age=age;
	}

	//public boolean compare(Student stu){
	//	if(this.age==stu.age){
	//		return true;
	//	}else {
	//		return false;
	//	}
	//}

	/**
	 * 重载
	 * @param stu
	 * @return
	 */
	//public boolean equals(Student stu){
	//	return false;
	//}

	/**
	 * 重写了父类中的equals方法
	 * @param obj
	 * @return
	 */
	public boolean equals(Object obj){
		if(obj instanceof Student){
			Student that=(Student)obj;
			if(this.age==that.age){
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}

	}
}
