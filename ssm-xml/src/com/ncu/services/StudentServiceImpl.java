package com.ncu.services;

import com.ncu.bean.Student;
import com.ncu.daos.IStudentDao;

public class StudentServiceImpl implements IStudentService {
	
	private IStudentDao dao;
	
	public void setDao(IStudentDao dao) {
		this.dao = dao;
	}

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		dao.insertStudent(student);
	}

}
