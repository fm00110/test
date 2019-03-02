package com.ncu.dao;

import com.ncu.bean1.Student;

public interface IStudentDao {

	Student selectStudentById(int sid);
}
