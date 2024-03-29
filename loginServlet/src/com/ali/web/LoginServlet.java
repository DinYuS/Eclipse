package com.ali.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.ali.dao.UserDAO;
import com.ali.domain.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		//1.获取表单数据-User类对应属性
		Map<String,String[]> map=request.getParameterMap();
		User user=new User();
		/**
		 * user.setName(request.getParamter("username");
		 */
		//使用BeanUtils封装方法->一次性传参
		try {
			BeanUtils.populate(user, map);
		}catch(Exception e) {
			
		}
		
		/*在服务器控制台传出传参结果*/
		//System.out.println(user.getUsername());
		//System.out.println(user.getPassword());
		
		//调用DAO下的方法来判断User不空null->转发success.html
		//调用DAO下的方法来判断User为null->转发fail.html
		UserDAO dao = new UserDAO();
		if(dao.login(user)!=null) {
			//转发到success.html
			RequestDispatcher rd = request.getRequestDispatcher("/success.html");
			rd.forward(request,response);
		}else {
			//转发到fail.html
			RequestDispatcher rd = request.getRequestDispatcher("/fail.html");
			rd.forward(request,response);
		}
		
		
		
		
	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
