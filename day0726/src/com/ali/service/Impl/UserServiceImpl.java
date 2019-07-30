package com.ali.service.Impl;

import java.util.List;
import java.util.Map;

import com.ali.dao.UserDao;
import com.ali.dao.Impl.UserDaoImpl;
import com.ali.domain.PageBean;
import com.ali.domain.User;
import com.ali.service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDao dao=new UserDaoImpl();
	
	@Override
	public List<User> findAll() {
		// TODO �Զ����ɵķ������
		//����Dao��ɲ�ѯ
		return dao.findAll();
	}
	@Override
	public User login(User user) {
		// TODO �Զ����ɵķ������
		return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
	}
	@Override
	public void addUser(User user) {
		// TODO �Զ����ɵķ������
		dao.add(user);
	}
	@Override
	public void updateUser(User user) {
		// TODO �Զ����ɵķ������
		dao.update(user);
	}
	@Override
	public void deleteUser(String id) {
		// TODO �Զ����ɵķ������
		dao.delete(Integer.parseInt(id));
	}
	@Override
	public void delSelectedUser(String[] ids) {
		// TODO �Զ����ɵķ������
		if(ids!=null && ids.length>0) {
			for(String id:ids) {
			dao.delete(Integer.parseInt(id));
			}
		}
	}
	@Override
	public User findUserById(String id) {
		// TODO �Զ����ɵķ������
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
		
		//1�������յ�PageBean����
		PageBean<User> pb=new PageBean<User>();
		//2�����ò���
		pb.setCurrentPage(currentPage);
		pb.setRows(rows);
		//3������dao��ѯ�ܼ�¼��
		int totalCount=dao.findTotalCount(condition);
		pb.setTotalCount(totalCount);
		//4������dao��ѯList����
			//���㿪ʼ�ļ�¼��λ������
		int start=(currentPage-1)*rows;
		List<User> list=dao.findByPage(start, rows, condition);
		pb.setList(list);
		//5��������ҳ��
		int totalPage=(totalCount%rows)==0?totalCount/rows:(totalCount/rows)+1;
		pb.setTotalPage(totalPage);
		
		
		
		return pb;
	}
	
	
	
}