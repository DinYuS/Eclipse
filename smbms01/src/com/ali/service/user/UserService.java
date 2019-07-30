package com.ali.service.user;

import java.util.List;
import java.util.Map;

import com.ali.domain.User;
import com.ali.util.PageBean;

/*
 * 用户管理的业务接口
 */
public interface UserService {
	/**
	 *  查询所有用户信息
	 * @return List
	 */
	public List<User> findAll();
	
	/**
	 * 登陆方法
	 * @param User
	 * @return User
	 */
	public User login(User user);
	
	/**
	 * 保存User
	 * @param User
	 * @return User
	 */
	public void addUser(User user);
	
	/**
	 * 修改User
	 * @param User
	 * @return User
	 */
	public void updateUser(User user);
	
	/**
	 * 删除User
	 * @param id
	 * @return 
	 */
	public void deleteUser(String id);
	
	/**
	 * 批量删除用户信息
	 * @param String[] ids
	 * @return 
	 */
	void delSelectedUser(String[] ids);
	
	/**
	 * 根据ID进行查询
	 * @param int id
	 * @return user
	 */
	User findUserById(String id);
	
	/**
	 * 分页条件查询
	 * @param current
	 * @param rows
	 * @param condition
	 * @return list
	 */
	PageBean<User> findUserByPage(String currentPage,String rows,Map<String,String[]> condition);
	
	
}
