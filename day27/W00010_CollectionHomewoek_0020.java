package com.briup.jd1721.corejava.day27;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.TreeSet;

/**
 * 作业：实现学生信息管理系统。Student(id,name,age,gender,grade);
 * 		 当上面的所有信息都相同的时候认为是同一个学生。
 * 功能：
 * 		 1.能对学生进行增删改查操作。
 * 		 2.能够按照学生的学号进行从小到大的排列。
 * 		 *.能够按照学生的学号进行从小到大或者从大到小的排列。
 * 		 3.能够按照性别和姓名以及年龄进行排序，如果上面都满足，按照学号排。
 */
public class W00010_CollectionHomewoek_0020{
	public static void main(String[] args){
		PeopleUtil util=new PeopleUtil(new ArrayList<>());
		// 添加单个元素
		util.addPeople(new People(3,"Kevin3",324,true,"43"));
		util.addPeople(new People(1,"Kevin1",322,false,"1"));
		util.addPeople(new People(5,"Kevin5",326,false,"bigdata"));
		util.addPeople(new People(0,"Kevin0",321,true,"qwe"));
		util.addPeople(new People(4,"Kevin4",325,false,"q"));
		util.addPeople(new People(2,"Kevin2",323,true,"q"));

		// 添加一组元素
		//util.addManyPeoples(util.getPeoples());

		// 删除单个元素
		//util.deletePeople(new People(0,"Kevin0",321,true,"bigdata"));

		// 删除一组元素
		//List<People> temp=new ArrayList<>();
		//temp.add(new People(10,"Kevin0",321,true,"bigdata"));
		//temp.add(new People(1,"Kevin1",322,false,"bigdata"));
		//util.deleteManyPeoples(temp);

		// 修改单个学生信息
		//util.modifyById(0,new People(100,"zhangsan",111,true,"aaaaa"));
		//util.modifyById(2,new People(2000,"zhangsan",111,true,"aaaaa"));

		// 修改一组学生信息
		//List<People> temp=new ArrayList<>();
		//temp.add(new People(0,"Kevin000",32100,true,"bigdata00"));
		//temp.add(new People(1,"Kevin000",32111,true,"bigdata11"));
		//temp.add(new People(2,"Kevin000",32122,true,"bigdata22"));
		//util.modifyManyById(temp);

		// 按照ID从小到大进行排序
		//List<People> peoples=util.sortedById();
		//util.showAllPeoples(peoples,true);

		// 按照ID从小到大或者从大到小进行排序
		//List<People> peoples=util.sortedByIdForFree(false);
		//util.showAllPeoples(peoples,true);


		// 自由排序
		//List<People> peoples=util.sortedByDIYCondition();
		//util.showAllPeoples(peoples,true);

		// 显示所有元素
		//util.showAllPeoples(true);
	}
}

class PeopleUtil{
	private List<People> peoples;

	public PeopleUtil(){
		if(peoples==null){
			peoples=new ArrayList<>();
		}
	}

	public PeopleUtil(List<People> peoples){
		this.peoples=peoples;
	}

	// 增加单个学生
	public boolean addPeople(People people){
		if(isNull(this.peoples)) return false;
		return peoples.add(people);
	}

	// 增加一组学生
	public boolean addManyPeoples(Collection<People> peoples){
		if(isNull(this.peoples)) return false;
		if(isNull(peoples)) return false;
		return this.peoples.addAll(peoples);
	}

	// 删除单个学生
	public boolean deletePeople(People people){
		if(isNullAndEmpty(this.peoples)) return false;
		if(people==null) return false;
		boolean flag=false;
		ListIterator<People> lt=peoples.listIterator();
		while(lt.hasNext()){
			People next=lt.next();
			if(next.equals(people)){
				lt.remove();
				flag=true;
			}
		}
		return flag;
	}

	// 删除一组学生
	public boolean deleteManyPeoples(Collection<People> peoples){
		if(isNullAndEmpty(this.peoples)) return false;
		if(isNullAndEmpty(peoples)) return false;
		// 定义临时集合
		List<People> temp=new ArrayList<>(this.peoples);
		// 从整个集合中删除和指定集合中相同的部分
		this.peoples.removeAll(peoples);
		// 通过下面的方法得到被删除的学生组成的集合
		temp.removeAll(this.peoples);
		// 得到指定的集合中没有被删除的学生组成的集合
		peoples.removeAll(temp);
		System.out.println("被删除的学生为：");
		temp.forEach((v)->System.out.println(v));
		System.out.println("原集合中不存在以下学生，所以没有被删除！");
		peoples.forEach((v)->System.out.println(v));
		return true;
	}

	// 修改单个学生信息
	public boolean modifyById(int id,People people){
		boolean flag=false;
		ListIterator<People> lt=this.peoples.listIterator();
		while(lt.hasNext()){
			People next=lt.next();
			if(next.getId()==id){
				lt.remove();
				lt.add(people);
				flag=true;
			}
		}
		return false;
	}

	// 修改一组学生信息
	public boolean modifyManyById(Collection<People> peoples){
		boolean flag=false;
		for(People people:peoples){
			modifyById(people.getId(),people);
			flag=true;
		}
		return flag;
	}

	// 查询所有学生
	public void showAllPeoples(boolean...all){
		if(all.length==0) {
			System.out.println("参数错误。");
			return;
		}
		System.out.println("----------------显示所有学生--------------------");
		if(all[0]){
			this.peoples.forEach((v)->System.out.println(v));
		}
	}

	// 查询指定集合中的所有学生
	public void showAllPeoples(Collection<People> peoples,boolean...all){
		if(all.length==0) {
			System.out.println("参数错误。");
			return;
		}
		System.out.println("----------------显示所有学生--------------------");
		if(all[0]){
			peoples.forEach((v)->System.out.println(v));
		}
	}

	// 按照ID进行排序
	public List<People> sortedById(){
		TreeSet set=new TreeSet(this.peoples);
		return new ArrayList<>(set);
	}

	// 按照ID进行从小到大或者从大到小排序
	public List<People> sortedByIdForFree(boolean isDesc){
		if(isDesc){
			TreeSet set=new TreeSet(this.peoples);
			return new ArrayList<>(set.descendingSet());

		}
		return sortedById();
	}

	// 按照自定义规则进行排序
	public List<People> sortedByDIYCondition(){
		Comparator<People> comparator=(a,b)->{
			int genderComp=new Boolean(a.isGender()).compareTo(new Boolean(b.isGender()));
			if(genderComp==0){
				int nameComp=a.getName().compareTo(b.getName());
				if(nameComp==0){
					int ageComp=a.getAge()-b.getAge();
					if(ageComp==0){
						return a.getId()-b.getId();
					}else{
						return ageComp;
					}
				}else{
					return nameComp;
				}
			}else{
				return genderComp;
			}
		};
		TreeSet<People> peoples=new TreeSet(comparator);
		peoples.addAll(this.peoples);
		return new ArrayList<>(peoples);
	}

	public List<People> getPeoples(){
		return peoples;
	}

	public void setPeoples(List<People> peoples){
		this.peoples=peoples;
	}

	public boolean isNullAndEmpty(Collection<?> collection){
		return collection==null||collection.isEmpty();
	}

	public boolean isNull(Collection<?> collection){
		return collection==null;
	}
}

class People implements Comparable<People>{
	private int id;
	private String name;
	private int age;
	private boolean gender;
	private String grade;

	public People(){
	}

	public People(int id,String name,int age,boolean gender,String grade){
		this.id=id;
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.grade=grade;
	}

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

	public boolean isGender(){
		return gender;
	}

	public void setGender(boolean gender){
		this.gender=gender;
	}

	public String getGrade(){
		return grade;
	}

	public void setGrade(String grade){
		this.grade=grade;
	}

	@Override
	public int compareTo(People o){
		return this.id-o.id;
	}

	@Override
	public boolean equals(Object o){
		if(this==o) return true;
		if(!(o instanceof People)) return false;
		People people=(People)o;
		if(getId()!=people.getId()) return false;
		if(getAge()!=people.getAge()) return false;
		if(isGender()!=people.isGender()) return false;
		if(!getName().equals(people.getName())) return false;
		return getGrade().equals(people.getGrade());
	}

	@Override
	public int hashCode(){
		int result=getId();
		result=31*result+getName().hashCode();
		result=31*result+getAge();
		result=31*result+(isGender()?1:0);
		result=31*result+getGrade().hashCode();
		return result;
	}

	@Override
	public String toString(){
		return "People ["+"id="+id+", name='"+name+'\''+", age="+age+", gender="+gender+", grade='"+grade+'\''+']';
	}
}
