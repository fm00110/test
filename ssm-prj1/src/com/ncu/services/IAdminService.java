package com.ncu.services;

import java.util.ArrayList;

import com.ncu.bean.Admin;
import com.ncu.bean.TeacherAllInfo;

public interface IAdminService {

	Admin checkAdmin(String ausername, String password);

	ArrayList<TeacherAllInfo> findAllTeacherInfo();

}
