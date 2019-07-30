package com.ali.dao.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ali.dao.UserDao;
import com.ali.domain.PageBean;
import com.ali.domain.User;
import com.ali.util.JDBCUtils;

public class UserDaoImpl implements UserDao {
//使用jdbcTemplate简化CRUD
	
	private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
	
	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		// TODO 自动生成的方法存根
		//1.sql
		try {
			String sql="SELECT * FROM user WHERE username=? AND password=?";
			User user=template.queryForObject(sql, 
					new BeanPropertyRowMapper<User>(User.class),
					username,
					password);
			
			return user;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void add(User user) {
		// TODO 自动生成的方法存根
		//定义SQL语句
		String sql="INSERT INTO user VALUES (null,?,?,?,?,?,?,?,?)";
		//执行SQL语句
		template.update(sql,
				user.getUsername(),
				user.getPassword(),
				user.getName(),
				user.getGender(),
				user.getAge(),
				user.getAddress(),
				user.getQq(),
				user.getEmail()
				//user.getId()
				);
		
		
	}

	@Override
	public void update(User user) {
		// TODO 自动生成的方法存根
		// 1.sql
		String sql = "update user set username=?,"
				+ "password=?,"
				+ "name=?,"
				+ "gender=?,"
				+ "age=?,"
				+ "address=?,"
				+ "qq=?,"
				+ "email=? where id=?";
		// 2.执行sql
		template.update(sql, 
				user.getUsername(), 
				user.getPassword(), 
				user.getName(), 
				user.getGender(), 
				user.getAge(),
				user.getAddress(), 
				user.getQq(), 
				user.getEmail(), 
				user.getId());
	}

	@Override
	public void delete(int id) {
		// TODO 自动生成的方法存根
		String sql="DELETE FROM user WHERE id=?";
		template.update(sql,id);
	}

	@Override
	public User findById(int id) {
		// TODO 自动生成的方法存根
		//1.定义SQL
		String sql="SELECT * FROM user WHERE id=?";
		//2.执行SQL
		return template.queryForObject(sql, 
				new BeanPropertyRowMapper<User>(User.class),id);
	}

	@Override
	public List<User> findAll() {
		// TODO 自动生成的方法存根
		//使用JDBC操作数据库
		//1、定义SQL语句
		String sql="SELECT * FROM user";
		//返回值
		List list=template.query(sql, 
				new BeanPropertyRowMapper<User>(User.class));
		return list;
	}

	@Override
	public int findTotalCount(Map<String, String[]> condition) {
		// TODO Auto-generated method stub
		//1、定义模板初始化SQL
		String sql="SELECT count(*) FROM user WHERE 1 = 1 ";
		StringBuilder sb=new StringBuilder(sql);
		//2、遍历Map
		Set<String> keySet=condition.keySet();
		//3、定义参数集合
		List<Object> params=new ArrayList<Object>();
		
		for(String key:keySet) {
			//排除分页条件参数
			if("currentPage".equals(key) || "rows".equals(key)) {
				continue;
			}
			
			//获取value
			String value=condition.get(key)[0];
			
			//判断value是否有值
			if(value!=null && !"".equals(value)) {
				//证明有值
				sb.append(" and "+key+" like ? ");
				params.add("%"+value+"%");//?代表条件的值
			}
			System.out.println(sb.toString());
			System.out.println(params);
			
		}
		
		return template.queryForObject(sb.toString(), Integer.class, params.toArray());
	}

	@Override
	public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM user WHERE 1 = 1 ";
		StringBuilder sb=new StringBuilder(sql);
		
		Set<String> keySet=condition.keySet();
		List<Object> params=new ArrayList<Object>();
		for(String key:keySet) {
			if("currentPage".equals(key) || "rows".equals(key)) {
				continue;
			}
			
			String value=condition.get(key)[0];
			if(value!=null && !"".equals(value)) {
				//证明有值
				sb.append(" and "+key+" like ? ");
				params.add("%"+value+"%");//?代表条件的值
			}
		}
		
		//添加分页查询
		sb.append("limit ?,?");
		
		//添加分页查询参数值
		params.add(start);
		params.add(rows);
		sql=sb.toString();
		System.out.println(sql);
		System.out.println(params);
		return template.query(sql, new BeanPropertyRowMapper<User>(User.class), params.toArray());
	}

	@Override
	public PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
