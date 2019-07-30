package com.ali.service.user;

import java.util.List;
import java.util.Map;

import com.ali.dao.user.UserDao;
import com.ali.dao.user.UserDaoImpl;
import com.ali.domain.User;
import com.ali.util.PageBean;


public class UserServiceImpl implements UserService{
	
	private UserDao dao=new UserDaoImpl();
	
	@Override
	public List<User> findAll() {
		// TODO 自动生成的方法存根
		//调用Dao完成查询
		return dao.findAll();
	}
	@Override
	public User login(User user) {
		// TODO 自动生成的方法存根
		return dao.findUserByUsernameAndPassword(user.getUserCode(), user.getUserPassword());
	}
	@Override
	public void addUser(User user) {
		// TODO 自动生成的方法存根
		dao.add(user);
	}
	@Override
	public void updateUser(User user) {
		// TODO 自动生成的方法存根
		dao.update(user);
	}
	@Override
	public void deleteUser(String id) {
		// TODO 自动生成的方法存根
		dao.delete(Integer.parseInt(id));
	}
	@Override
	public void delSelectedUser(String[] ids) {
		// TODO 自动生成的方法存根
		if(ids!=null && ids.length>0) {
			for(String id:ids) {
			dao.delete(Integer.parseInt(id));
			}
		}
	}
	@Override
	public User findUserById(String id) {
		// TODO 自动生成的方法存根
		return dao.findById(Integer.parseInt(id));
	}
	@Override
	public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
		// TODO Auto-generated method stub
		int currentPage=Integer.parseInt(_currentPage);
		int rows=Integer.parseInt(_rows);
		
		if(currentPage<=0) {
			currentPage=1;
		}
		
		//1、创建空的PageBean对象
		PageBean<User> pb=new PageBean<User>();
		//2、设置参数
		pb.setCurrentPage(currentPage);
		pb.setRows(rows);
		//3、调用dao查询总记录数
		int totalCount=dao.findTotalCount(condition);
		pb.setTotalCount(totalCount);
		//4、调用dao查询List集合
			//计算开始的记录的位置索引
		int start=(currentPage-1)*rows;
		List<User> list=dao.findByPage(start, rows, condition);
		pb.setList(list);
		//5、计算总页码
		int totalPage=(totalCount%rows)==0?totalCount/rows:(totalCount/rows)+1;
		pb.setTotalPage(totalPage);
		
		
		
		return pb;
	}
	
	
	
}
