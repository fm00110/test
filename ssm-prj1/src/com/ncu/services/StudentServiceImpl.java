package com.ncu.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ncu.bean.CouTeacher;
import com.ncu.bean.Course;
import com.ncu.bean.Evaluation;
import com.ncu.bean.Inform;
import com.ncu.bean.Score;
import com.ncu.bean.Student;
import com.ncu.daos.IStudentDao;

@Service("sservice")
public class StudentServiceImpl implements IStudentService {
	
	@Resource(name="IStudentDao")
	private IStudentDao dao;
	

	public IStudentDao getDao() {
		return dao;
	}


	public void setDao(IStudentDao dao) {
		this.dao = dao;
	}


	@Override
	public Student checkStudent(String username, String password) {
		// TODO Auto-generated method stub
		return dao.selectStudentByUP(username, password);
	}


	@Override
	public ArrayList<Score> findStudentScoreInfo(String stuname) {
		// TODO Auto-generated method stub
		return dao.selectStudentScoreInfo(stuname);
	}


	@Override
	public ArrayList<CouTeacher> findAllCourse() {
		// TODO Auto-generated method stub
		return dao.selectAllCourse();
	}


	@Override
	public ArrayList<String> findMyCourse(String stuname) {
		// TODO Auto-generated method stub
		return dao.selectMyCourse(stuname);
	}


	@Override
	public String findMyGrade(String stuname) {
		// TODO Auto-generated method stub
		return dao.selectGrade(stuname);
	}


	@Override
	public void updateCourse(String cname, String stuname, String tcname, String grname) {
		// TODO Auto-generated method stub
		dao.updateCourse(cname, stuname, tcname, grname);
	}


	@Override
	public void updatePartEvaluation(String cname, String tcname, String stuname) {
		// TODO Auto-generated method stub
		dao.insertPartEvaluation(cname, tcname, stuname);
	}


	@Override
	public ArrayList<Evaluation> selectMyEvaluation(String stuname) {
		// TODO Auto-generated method stub
		return dao.selectMyEvaluation(stuname);
	}


	@Override
	public void updateEvaluation(String cname, String tcname, String stuname, double score, String evaluation) {
		// TODO Auto-generated method stub
		dao.updateEvaluation(cname, tcname, stuname, score, evaluation);
	}


	@Override
	public ArrayList<Inform> seeInform() {
		// TODO Auto-generated method stub
		return dao.selectInform();
	}


	@Override
	public String findMyPassword(String username) {
		// TODO Auto-generated method stub
		return dao.selectMyPassword(username);
	}


	@Override
	public void updateMyPassword(String username, String password) {
		// TODO Auto-generated method stub
		dao.updateMyPassword(username, password);
	}

}
