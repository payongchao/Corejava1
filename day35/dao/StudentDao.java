package com.briup.jd1721.corejava.day35.dao;

import com.briup.jd1721.corejava.day35.bean.Student;
import java.util.Map;

public class StudentDao{
	private SimulateDatabase database;

	public StudentDao(){
		database=new SimulateDatabase();
	}

	// 通过学号查询学生
	public Student getStudentById(Integer id){
		Map<Integer,Student> stus=
			database.getStus();
		Student student=stus.get(id);
		return student;
	}
}
