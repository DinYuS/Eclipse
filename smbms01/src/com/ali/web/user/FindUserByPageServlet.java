package com.ali.web.user;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ali.domain.User;
import com.ali.service.user.UserService;
import com.ali.service.user.UserServiceImpl;
import com.ali.util.PageBean;

/**
 * Servlet implementation class FindUserByPageServlet
 */
@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindUserByPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		//1
		String currentPage=request.getParameter("currentPage");//当前页码
		String rows=request.getParameter("rows");//每页显示的记录数
		
		if(currentPage==null || "".equals(currentPage)) {
			currentPage="1";
		}
		if(rows==null || "".equals(rows)) {
			rows="5";
		}
		
		//2、调用条件查询参数
		Map<String,String[]> condition=request.getParameterMap();
		
		//调用services查询
		UserService service=new UserServiceImpl();
		PageBean<User> pb=service.findUserByPage(currentPage, rows, condition);
		System.out.println(pb);
		
		//3、将PageBean共享到request中
		request.setAttribute("pb", pb);
		request.setAttribute("condition", condition);//将查询条件存入request
		
		//4、转发到list.jsp
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
