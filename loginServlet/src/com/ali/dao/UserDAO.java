package com.ali.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ali.domain.User;
import com.ali.utils.JDBCUtils;

/*
 * 操作数据库中的User01表类->以操作对象的方式去操作表
 */
public class UserDAO {
	
	
	//SpringJDBCTemplate
	//1.声明JDBCTemplate对象公用
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	
	
	
	
	//如果用户名密码能和SQL匹配->User不为空，代表登录成功
	//如果用户名密码不能和SQL匹配->User为空，代表登录失败
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
