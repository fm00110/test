package com.ncu.dao;

import java.util.List;

import com.ncu.bean1.NewsLabel;

public interface INewsLabelDao {
	
	List<NewsLabel> selectChildrenByParent(int pid);
	//���һ���Ŀ�µ�����������Ŀ
	
	List<NewsLabel> selectChildrenById(int id);

}
