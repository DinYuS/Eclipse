package com.ali.web.user;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ali.domain.User;
import com.ali.service.user.UserService;
import com.ali.service.user.UserServiceImpl;

/**
 * Servlet implementation class UserListServlet
 */
@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、调用UserService完成查询
		UserService service=new UserServiceImpl();
		
		List<User> users=service.findAll();
		for(Iterator iterator=users.iterator();iterator.hasNext();) {
			User user=(User) iterator.next();
			System.out.println(user.getId());
		}
		//2、将List存入request域对象
		request.setAttribute("users", users);
		//3、转发到List.jsp
		request.getRequestDispatcher("/list.jsp").forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
