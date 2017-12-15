package com.briup.jd1721.corejava.day27;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
   作业：
 	    实现教师信息管理系统。
 		Teacher(id,name,age,gender,grade);
 		当上面的所有信息都相同的时候认为是同一个学生。
   功能：
 		1.能对教师进行增删改查操作。
 		2.能够按照教师的教师编号进行从小到大的排列。
 		*.能够按照教师的教师编号进行从小到大或者从大到小的排列。
 		3.能够按照性别和姓名以及年龄进行排序，如果上面都满足，按照学号排。
 */

class Demo{
	public static void main(String[] args){
		TIMS tims=new TIMS();
		tims.addOne(new Teacher(4,"zhangsan",25,1,"jd1721"));
		tims.addOne(new Teacher(6,"lis",26,0,"jd1722"));
		tims.addOne(new Teacher(3,"wangwu",27,1,"jd1723"));
		tims.addOne(new Teacher(1,"zhangsan",25,0,"jd1721"));

		//List<Teacher> teachers=new ArrayList<>();
		//teachers.add(new Teacher(10,"zhaoliu",30,1,"BD1702"));
		//teachers.add(new Teacher(2,"lis",26,0,"jd1722"));
		//tims.addMany(teachers);
        //
		//tims.deleteOneById(1);
        //
		//tims.deleteOne(new Teacher(3,"wangwu",27,0,"jd1723"));
        //
		//tims.deleteMany(teachers);
        //
		//tims.modifyOneById(new Teacher(1,"Kevin",30,0,"JD1721"));
        //
		//tims.sortById(false);

		//tims.sortByOtherCondition();

		//Teacher teacher=tims.getOne(7);
		//System.out.println(teacher);

		tims.showAll();
	}
}

public class TIMS{
	// 创建集合对象，只是声明，未做初始化
	private List<Teacher> list;

	public TIMS(){
		if(list==null) list=new ArrayList<>();
	}

	public TIMS(List<Teacher> list){
		this.list=list;
	}

	// 添加单个教师
	public boolean addOne(Teacher teacher){
		// 在添加之前，先判断该集合中是否包含指定
		// 的Student对象，如果包含，直接返回false。
		if(list.contains(teacher)) return false;
		// 如果不包含，则添加到该集合中
		return list.add(teacher);
	}

	// 添加一群教师
	public void addMany(List<Teacher> teachers){
		// 为什么不使用addAll()?
		// 因为使用addAll方法在添加的过程中，不会对
		// 元素进行判断，这样有可能会造成添加重复的元素
		// 解决方案：对指定的集合进行遍历，一个一个地添加
		// 到原集合中，在添加的过程中进行判断。
		for(Teacher teacher:teachers){
			// 这样写会不会出现问题？不会
			addOne(teacher);
		}
	}

	// 删除操作
	// 按照ID删除元素
	public boolean deleteOneById(int id){
		/**
		 * 按照ID删除的原理：
		 * 1.在原集合中通过id找到相对应的Teacher对象。
		 * 2.如果存在这样的Teacher对象，则删除，返回true；
		 *   如果不存在，直接返回false。
		 */

		for(Teacher teacher:list){
			int idFromList=teacher.getId();
			if(idFromList==id){
				// 通过该Teacher对象找到该对象在
				// 原集合中的索引
				int index=list.indexOf(teacher);
				// 通过上一步的索引，删除该元素
				list.remove(index);
				return true;
			}
		}
		return false;
	}

	// 按照Teacher对象删除元素
	public boolean deleteOne(Teacher teacher){
		/**
		 * 原理：在原集合中判断该Teacher对象是否存在，
		 *       如果存在，则删除，返回true；
		 *       如果不存在，直接返回false；
		 */

		if(list.contains(teacher))
			return list.remove(teacher);
		return false;
	}

	// 删除一群教师
	public void deleteMany(List<Teacher> teachers){
		for(Teacher teacher:teachers){
			deleteOne(teacher);
		}
	}

	// 修改单个教师
	public void modifyOneById(Teacher teacher){
		/**
		 * 1.先通过ID在原集合中找到相对应的Teacher对象。
		 * 2.再通过该对象找到相对应的索引。
		 * 3.调用List集合的set(index,teacher);
		 */
		//1.先通过ID在原集合中找到相对应的Teacher对象。
		for(Teacher s:list){
			if(s.getId()==teacher.getId()){
				//再通过该对象找到相对应的索引。
				int index=list.indexOf(s);
				//调用List集合的set(index,teacher);
				list.set(index,teacher);
			}
		}
	}

	// 修改一群教师信息
	public void modifyMany(List<Teacher> teachers){
		for(Teacher teacher:teachers){
			modifyOneById(teacher);
		}
	}

	// 显示所有的教师
	public void showAll(){
		for(Teacher teacher:list){
			System.out.println(teacher);
		}
	}

	// 通过ID查询教师
	public Teacher getOne(int id){
		/**
		 * 遍历原集合，找到和这个id相等的Student对象，
		 * 直接返回。
		 */
		for(Teacher teacher:list){
			if(teacher.getId()==id) return teacher;
		}
		return null;
	}

	// 按照教师编号进行排序
	public void sortById(boolean desc){
		// 由于TreeSet具有排序功能，
		TreeSet<Teacher> set=new TreeSet(list);
		// 清空list集合，然后将set集合中的所有元素再
		list.clear();
		// 如果是true，倒序；如果是false，正序。
		if(desc){
			list.addAll(set.descendingSet());
		}else{
			// 添加到list中。
			list.addAll(set);
		}
		// 下面代码是上面代码的改版
		//list=new ArrayList<>(desc?set.descendingSet():set);
	}

	// 按照其他条件进行排序
	public void sortByOtherCondition(){
		/**
		 * 1.排序
		 * 2.使用Comparator。
		 */
		TreeSet<Teacher> set=new TreeSet<>(
			new Comparator<Teacher>(){
			@Override
			public int compare(Teacher t1,Teacher t2){
				/**
				 * 能够按照性别和姓名以及年龄进行排序，如果上面都满足，按照学号排。
				 */
				int genderComp=t1.getGender()-t2.getGender();
				int nameComp=t1.getName().compareTo(t2.getName());
				int ageComp=t1.getAge()-t2.getAge();
				int idComp=t1.getId()-t2.getId();
				return genderComp==0?(nameComp==0?(ageComp==0?idComp:ageComp):nameComp):genderComp;
			}
		});
		set.addAll(list);
		list=new ArrayList(set);
	}
}

class Teacher implements Comparable<Teacher>{
	// Student(id,name,age,gender,class);
	private int id;
	private String name;
	private int age;
	private int gender;
	private String clazz;

	// 构造器
	// 带有N多成员变量的类，在创建构造器的时候
	// 一般会创建俩，一个是无参构造器；一个是全参构造器
	public Teacher(){
	}

	public Teacher(int id,String name,int age,int gender,String clazz){
		this.id=id;
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.clazz=clazz;
	}

	// 下面是各个成员变量的get和set方法
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

	public int getGender(){
		return gender;
	}

	public void setGender(int gender){
		this.gender=gender;
	}

	public String getClazz(){
		return clazz;
	}

	public void setClazz(String clazz){
		this.clazz=clazz;
	}

	@Override
	public boolean equals(Object o){
		if(this==o) return true;
		if(!(o instanceof Teacher)) return false;
		Teacher that=(Teacher)o;
		return this.getId()==that.getId()&&
			   this.getName().equals(that.getName())&&
			   this.getAge()==that.getAge()&&
			   this.getGender()==that.getGender()&&
			   this.getClazz().equals(that.getClazz());
	}

	@Override
	public int hashCode(){
		int result=getId();
		result=31*result+getName().hashCode();
		result=31*result+getAge();
		result=31*result+getGender();
		result=31*result+getClazz().hashCode();
		return Math.abs(result);
	}

	@Override
	public String toString(){
		return "Student["+
			"id="+id+", " +
			"name='"+name+'\''+", " +
			"age="+age+", " +
			"gender="+gender+", " +
			"clazz='"+clazz+'\''+']';
	}

	@Override
	public int compareTo(Teacher o){
		return this.getId()-o.getId();
	}
}

/**
 * 属性（成员变量）
 *
 * 构造器
 *
 * get&set
 *
 * hashCode
 *
 * equals
 *
 * compareTo()
 *
 * toString();
 */
