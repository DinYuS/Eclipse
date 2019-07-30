package com.ali.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ali.domain.User;
import com.ali.utils.JDBCUtils;

/*
 * �������ݿ��е�User01����->�Բ�������ķ�ʽȥ������
 */
public class UserDAO {
	
	
	//SpringJDBCTemplate
	//1.����JDBCTemplate������
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	
	
	
	
	//����û��������ܺ�SQLƥ��->User��Ϊ�գ�������¼�ɹ�
	//����û������벻�ܺ�SQLƥ��->UserΪ�գ�������¼ʧ��
	public User login(User user){
		try {
			//1.SQL
			String sql = "SELECT * FROM user01 WHERE username=? AND password=?";
			User loginUser = template.queryForObject(sql, 
					new BeanPropertyRowMapper<User>(User.class),
					user.getUsername(),
					user.getPassword());			
			return loginUser;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
}