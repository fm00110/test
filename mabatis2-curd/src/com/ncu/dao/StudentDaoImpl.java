package com.ncu.dao;



import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ncu.bean1.Student;
import com.ncu.util.MyBatisUtil;

public class StudentDaoImpl implements IStudentDao {

	private SqlSession sqlSession;
	@Override
	public void insertStudent(Student student) {
		// TODO Auto-generated method stub
	
		try {
		/*	//1、加载主配置文件
			inputStream = Resources.getResourceAsStream("mybatis.xml");
			//2、创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			//3、创建SqlSession对象
		    sqlSession = sqlSessionFactory.openSession();*/
			
			sqlSession = MyBatisUtil.getSqlSession();  //从工具类中获取sqlSession 
			
			//4、相关操作
			sqlSession.insert("insertStudent", student);
			//5、提交
			sqlSession.commit();
			
		
		} finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		
		
		

	}
	@Override
	public void insertStudentCacheId(Student student) {
		// TODO Auto-generated method stub
		try {
		/*	//1、加载主配置文件
			inputStream = Resources.getResourceAsStream("mybatis.xml");
			//2、创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			//3、创建SqlSession对象
		    sqlSession = sqlSessionFactory.openSession();*/
			
			sqlSession = MyBatisUtil.getSqlSession();  //从工具类中获取sqlSession 
			
			//4、相关操作
			sqlSession.insert("insertStudentCacheId", student);
			//5、提交
			sqlSession.commit();
			
		
		} finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		
	}
	@Override
	public void deleteStudentById(int id) {
		// TODO Auto-generated method stub
		try {
		/*	//1、加载主配置文件
			inputStream = Resources.getResourceAsStream("mybatis.xml");
			//2、创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			//3、创建SqlSession对象
		    sqlSession = sqlSessionFactory.openSession();*/
			
			//获得sqlSession
			sqlSession = MyBatisUtil.getSqlSession();  //从工具类中获取sqlSession 
			
			//4、相关操作
			sqlSession.delete("deleteStudentById", id);
			//5、提交
			sqlSession.commit();
			
		
		} finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
	}
	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		try {
		/*	//1、加载主配置文件
			inputStream = Resources.getResourceAsStream("mybatis.xml");
			//2、创建SqlSessionFactory对象
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			//3、创建SqlSession对象
		    sqlSession = sqlSessionFactory.openSession();*/
			
			//获得sqlSession
			sqlSession = MyBatisUtil.getSqlSession();  //从工具类中获取sqlSession 
			
			//4、相关操作
			sqlSession.update("updateStudent", student);
			//5、提交
			sqlSession.commit();
			
		
		} finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
	
	}
	@Override
	public List<Student> selectAllStudents() {
		// TODO Auto-generated method stub
		List<Student> students = new ArrayList<Student>();
		try {
			/*	//1、加载主配置文件
				inputStream = Resources.getResourceAsStream("mybatis.xml");
				//2、创建SqlSessionFactory对象
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				//3、创建SqlSession对象
			    sqlSession = sqlSessionFactory.openSession();*/
				
				//获得sqlSession
				sqlSession = MyBatisUtil.getSqlSession();  //从工具类中获取sqlSession 
				
				//4、相关操作
				students = sqlSession.selectList("selectAllStudents");
				//5、提交
				sqlSession.commit();
				
				
			} finally{
				if(sqlSession != null){
					sqlSession.close();
				}
			}	
		return students;
	}
	@Override
	public Map<String, Object> selectAllStudentsMap() {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			/*	//1、加载主配置文件
				inputStream = Resources.getResourceAsStream("mybatis.xml");
				//2、创建SqlSessionFactory对象
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				//3、创建SqlSession对象
			    sqlSession = sqlSessionFactory.openSession();*/
				
				//获得sqlSession
				sqlSession = MyBatisUtil.getSqlSession();  //从工具类中获取sqlSession 
				
				//4、相关操作
				map = sqlSession.selectMap("selectAllStudents", "name"); //最后一个参数是要查询对象的属性名
				//5、提交
				sqlSession.commit();
				
				
			} finally{
				if(sqlSession != null){
					sqlSession.close();
				}
			}
		return map;
	}
	@Override
	public Student selectStudentById(int id) {
		// TODO Auto-generated method stub
		
		Student student = new Student();
		try {
			/*	//1、加载主配置文件
				inputStream = Resources.getResourceAsStream("mybatis.xml");
				//2、创建SqlSessionFactory对象
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				//3、创建SqlSession对象
			    sqlSession = sqlSessionFactory.openSession();*/
				
				//获得sqlSession
				sqlSession = MyBatisUtil.getSqlSession();  //从工具类中获取sqlSession 
				
				//4、相关操作
				student = sqlSession.selectOne("selectStudentById",id);
				//5、提交
				sqlSession.commit();
				
				
			} finally{
				if(sqlSession != null){
					sqlSession.close();
				}
			}
		return student;
	}
	@Override
	public List<Student> selectStudentByName(String name) {
		// TODO Auto-generated method stub
		List<Student> students = new ArrayList<Student>();
		try {
			/*	//1、加载主配置文件
				inputStream = Resources.getResourceAsStream("mybatis.xml");
				//2、创建SqlSessionFactory对象
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				//3、创建SqlSession对象
			    sqlSession = sqlSessionFactory.openSession();*/
				
				//获得sqlSession
				sqlSession = MyBatisUtil.getSqlSession();  //从工具类中获取sqlSession 
				
				//4、相关操作
				students = sqlSession.selectList("selectStudentByName", name);
				//5、提交
				sqlSession.commit();
				
				
			} finally{
				if(sqlSession != null){
					sqlSession.close();
				}
			}	
		return students;

	}
	@Override
	public ArrayList selectStudent() {
		// TODO Auto-generated method stub
		ArrayList students = new ArrayList();
		try {
			/*	//1、加载主配置文件
				inputStream = Resources.getResourceAsStream("mybatis.xml");
				//2、创建SqlSessionFactory对象
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				//3、创建SqlSession对象
			    sqlSession = sqlSessionFactory.openSession();*/
				
				//获得sqlSession
				sqlSession = MyBatisUtil.getSqlSession();  //从工具类中获取sqlSession 
				
				//4、相关操作
				students = (ArrayList) sqlSession.selectList("selectStudent");
				//5、提交
				sqlSession.commit();
				
				
			} finally{
				if(sqlSession != null){
					sqlSession.close();
				}
			}	
		return students;
	}

}
