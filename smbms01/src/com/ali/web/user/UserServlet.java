package com.ali.web.user;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.ali.domain.User;
import com.ali.service.user.UserService;
import com.ali.service.user.UserServiceImpl;
import com.ali.util.PageBean;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		System.out.println("method------>"+method);
		
		if(method!=null && method.equals("add")) {
			//执行增加操作
			this.add(request, response);
		}else if(method!=null &&method.equals("query")){
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("query()==========");
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
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("add()==========");
		Map<String,String[]> map=request.getParameterMap();
		User user=new User();
		user.setUserCode(request.getParameter("userCode"));
		user.setUserName(request.getParameter("userName"));
		user.setUserPassword(request.getParameter("userPassword"));
		//user.setUserRole(request.getParameter("userRole"));
		user.setUserRoleName(request.getParameter("userRoleName"));
		
		//对birthday
		try {
			user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday")));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			BeanUtils.populate(user, map);
		} catch (Exception e) {
			// TODO: handle exception
		}
		//gender
		user.setGender(Integer.valueOf(request.getParameter("gender")));
		//userRole
		user.setUserRole(Integer.valueOf(request.getParameter("userRole")));
		user.setCreationDate(new Date());
		user.setCreatedBy(1);
		
		
		
		
		
		
		UserService service=new UserServiceImpl();
		service.addUser(user);
		response.sendRedirect(request.getContextPath()+"userServlet?method=query");
		
		
	}

}
