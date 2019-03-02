package com.ncu.daos;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ncu.bean.Admin;
import com.ncu.bean.TeacherAllInfo;

public interface IAdminDao {

	Admin selectAdminByUP(@Param("ausername")String ausername, @Param("password")String password);

	ArrayList<TeacherAllInfo> selectAllTeacherInfo();

}
