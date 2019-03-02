package com.ncu.dao;

import java.util.List;

import com.ncu.bean1.NewsLabel;

public interface INewsLabelDao {
	
	List<NewsLabel> selectChildrenByParent(int pid);
	//查找还栏目下的所有子孙栏目
	
	List<NewsLabel> selectChildrenById(int id);

}
