package com.ali.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.ali.domain.User;
import com.ali.service.UserService;
import com.ali.service.Impl.UserServiceImpl;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1¡¢
		request.setCharacterEncoding("utf-8");
		//2¡¢ÐÞ¸Äºó
		Map<String,String[]> map=request.getParameterMap();
		//3¡¢
		User user=new User();
		try {
			BeanUtils.populate(user, map);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//4
		UserService service=new UserServiceImpl();
		service.updateUser(user);
		//5
		response.sendRedirect(request.getContextPath()+"/userListServlet");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
