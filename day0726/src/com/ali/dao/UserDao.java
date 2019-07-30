package com.ali.dao;

import java.util.List;
import java.util.Map;

import com.ali.domain.PageBean;
import com.ali.domain.User;

/*
 * ���������û���DAO�ӿ�
 */
public interface UserDao {
	
	User findUserByUsernameAndPassword(String username,String password);
	
	void add(User user);
	void update(User user);
	void delete(int id);
	User findById(int id);
	List<User> findAll();
	
	/**
	 * ��ѯ�ܼ�¼��
	 * @author ����
	 * @param condition
	 * @return int
	 */
	int findTotalCount(Map<String,String[]> condition);
	
	/**
	 * ��ҳ��ѯ ÿҳ��¼
	 * @param start
	 * @param rows
	 * @param condition
	 * @return list
	 */
	List<User> findByPage(int start,int rows,Map<String,String[]> condition);
	
	/**
	 * ��ҳ������ѯ
	 * @param current
	 * @param rows
	 * @param condition
	 * @return list
	 */
	PageBean<User> findUserByPage(String currentPage,String rows,Map<String,String[]> condition);
	
	
	
	
	
	
	
	
	
	
}