package com.ncu.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ncu.bean.Inform;
import com.ncu.bean.Student;
import com.ncu.bean.StudentScore;
import com.ncu.bean.Teacher;
import com.ncu.daos.ITeacherDao;

@Service("tservice")
public class TeacherServiceImpl implements ITeacherService {

	@Resource(name="ITeacherDao")
	private ITeacherDao dao;
	
	public ITeacherDao getDao() {
		return dao;
	}

	public void setDao(ITeacherDao dao) {
		this.dao = dao;
	}

	@Override
	public Teacher checkTeacher(String username, String password) {
		// TODO Auto-generated method stub
		return dao.selectTeacherByUP(username, password);
	}

	@Override
	public ArrayList<Student> findMyStudent(String tcname) {
		// TODO Auto-generated method stub
		return dao.selectMyStudent(tcname);
	}

	@Override
	public void addMyStudent(int stuid, String sname, String sex, String phone, String stuusername) {
		// TODO Auto-generated method stub
		dao.insertMyStudent(stuid, sname, sex, phone, stuusername);
	}

	@Override
	public String findMyCname(String tcname) {
		// TODO Auto-generated method stub
		return dao.selectMyCname(tcname);
	}

	@Override
	public void addMyStudentScore(String cname, String stuname, double score, String tcname, String grname) {
		// TODO Auto-generated method stub
		dao.insertMyStudentScore(cname,stuname,score,tcname,grname);
	}

	@Override
	public void addMyStudentGra(String grname, String stuname) {
		// TODO Auto-generated method stub
		dao.insertMyStudentGra(grname,stuname);
	}

	@Override
	public int findMyDegree(String username) {
		// TODO Auto-generated method stub
		return dao.selectMyDegree(username);
	}

	@Override
	public ArrayList<Inform> findAllInform() {
		// TODO Auto-generated method stub
		return dao.selectAllInform();
	}

	@Override
	public void insertInform(String title, String content, String tcname) {
		// TODO Auto-generated method stub
		dao.insertInform(title,content,tcname);
	}

	@Override
	public ArrayList<StudentScore> findMyStudentScore(String tcname) {
		// TODO Auto-generated method stub
		return dao.selectMyStudentScore(tcname);
	}

	@Override
	public void modifyMyStudentScore(String stuname, double score, String tcname) {
		// TODO Auto-generated method stub
		dao.updateMyStudentScore(stuname,score,tcname);
	}


	

}
