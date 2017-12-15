package com.briup.jd1721.corejava.day35.dao;

import com.briup.jd1721.corejava.day35.bean.Student;
import java.util.HashMap;
import java.util.Map;

public class SimulateDatabase{
	// 声明模拟的数据库对象
	private Map<Integer,Student> stus;

	public SimulateDatabase(){
		// 初始化模拟的数据库
		stus=new HashMap<>();
		// 给“数据库”中添加数据
		stus.put(1,new Student(1,"张三",20,"男","zhangsan"));
		stus.put(2,new Student(2,"李四",22,"女","lisi"));
		stus.put(3,new Student(3,"王五",23,"男","wangwu"));
		stus.put(4,new Student(4,"赵六",24,"女","zhaoliu"));
		stus.put(5,new Student(5,"钱琦",25,"男","qianqi"));
	}

	// 由于外界需要访问该“数据库”，所以提供对外访问方式
	public Map<Integer,Student> getStus(){
		return stus;
	}
}
