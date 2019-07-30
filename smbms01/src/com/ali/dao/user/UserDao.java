package com.ali.dao.user;


import java.util.List;
import java.util.Map;

import com.ali.domain.User;
import com.ali.util.PageBean;

/*
 * 用来操作用户的DAO接口
 */
public interface UserDao {
	
	User findUserByUsernameAndPassword(String userCode,String userPassword);
	
	void add(User user);
	void update(User user);
	void delete(int id);
	User findById(int id);
	List<User> findAll();
	
	/**
	 * 查询总记录数
	 * @author 陈沔
	 * @param condition
	 * @return int
	 */
	int findTotalCount(Map<String,String[]> condition);
	
	/**
	 * 分页查询 每页记录
	 * @param start
	 * @param rows
	 * @param condition
	 * @return list
	 */
	List<User> findByPage(int start,int rows,Map<String,String[]> condition);
	
	/**
	 * 分页条件查询
	 * @param current
	 * @param rows
	 * @param condition
	 * @return list
	 */
	PageBean<User> findUserByPage(String currentPage,String rows,Map<String,String[]> condition);
	
	
	
	
	
	
	
	
	
	
}
