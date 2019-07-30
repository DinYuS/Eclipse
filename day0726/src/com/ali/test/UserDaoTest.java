package com.ali.test;

import java.util.List;

import com.ali.dao.UserDao;
import com.ali.dao.Impl.UserDaoImpl;
import com.ali.domain.User;

public class UserDaoTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		UserDao dao=new UserDaoImpl();
		//测试1
		
		User user=new User();
		user.setUsername("admin");
		user.setPassword("123");
		
		User userA=dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
		
		if(userA!=null) {
			System.out.println("登陆验证方法测试成功");
		}else {
			System.out.println("登陆验证方法测试失败");
		}
		
		
		//测试2
		/*
		User userB=new User();
		userB.setUsername("manager");
		userB.setPassword("456");
		userB.setName("李四");
		userB.setGender("女");
		userB.setAge(23);
		userB.setQq("134135413");
		userB.setAdress("吉林吉林");
		userB.setEmail("12414153@12.com");
		
		dao.add(userB);
		List list=dao.findAll();
		if(list.size()==2) {
			System.out.println("验证成功");
		}else {
			System.out.println("验证失败");
		}
		*/
		
		//测试3 findById
		/*
		User user=dao.findById(2);
//		user.setPassword("789");
		user.setName("李四2");
//		userC.setGender("女");
//		userC.setAge(23);
//		userC.setQq("134135413");
//		userC.setAdress("吉林吉林");
//		userC.setEmail("12414153@12.com");
		
		dao.update(user);
		User userC=dao.findById(2);
		System.out.println(userC.getName());
		*/
		
		
		//测试删除
		/*
		dao.delete(2);
		*/
	}

}
