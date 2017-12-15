package com.briup.jd1721.corejava.day35.service;

import com.briup.jd1721.corejava.day35.bean.Student;
import com.briup.jd1721.corejava.day35.dao.StudentDao;

public class StudentService{
	private StudentDao dao;

	public StudentService(){
		dao=new StudentDao();
	}

	public boolean isExist(Student student){
		Student stu=
			dao.getStudentById(student.getId());
		if(stu==null){
			return false;
		}else{
			return true;
		}
	}

	public boolean isRight(Student student){
		Student stu=
			dao.getStudentById(student.getId());
		if(isExist(student)){
			if(student.getPasswd()
					.equals(stu.getPasswd())){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
}
