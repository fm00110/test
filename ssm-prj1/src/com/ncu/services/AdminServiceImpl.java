package com.ncu.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ncu.bean.Admin;
import com.ncu.bean.TeacherAllInfo;
import com.ncu.daos.IAdminDao;

@Service("aservice")
public class AdminServiceImpl implements IAdminService {

	@Resource(name="IAdminDao")
	private IAdminDao dao;
	
	public IAdminDao getDao() {
		return dao;
	}

	public void setDao(IAdminDao dao) {
		this.dao = dao;
	}

	@Override
	public Admin checkAdmin(String ausername, String password) {
		// TODO Auto-generated method stub
		return dao.selectAdminByUP(ausername, password);
	}

	@Override
	public ArrayList<TeacherAllInfo> findAllTeacherInfo() {
		// TODO Auto-generated method stub
		return dao.selectAllTeacherInfo();
	}

}
