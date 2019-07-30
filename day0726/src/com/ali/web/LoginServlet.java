package com.ali.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.ali.domain.User;
import com.ali.service.UserService;
import com.ali.service.Impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
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
		//1、设置编码
		request.setCharacterEncoding("utf-8");
		//2、获取数据
			//2、1验证码
		String verifycode=request.getParameter("verifycode");
		//3、校验验证码
		HttpSession session=request.getSession();
		String checkcode_server=(String)session.getAttribute("CHECKCODE_SERVER");
		session.removeAttribute("CHECKCODE_SERVER");//确保验证码的一次性
		if(!checkcode_server.equalsIgnoreCase(verifycode)) {
			//验证码不正确
			//提示信息
			request.setAttribute("login_msg", "验证码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
			
		}
		
		Map<String,String[]> map=request.getParameterMap();
		
		//4、封装User对象
		User user=new User();
		try {
			BeanUtils.populate(user, map);
		}catch (Exception e) {
			// TODO: handle exception
		}
	
		//5、调用service查询
		UserService service=new UserServiceImpl();
		User loginUser=service.login(user);
		//6、判断登陆是否成功
		if(loginUser!=null) {
			//登陆成功
			//将用户存入session
			session.setAttribute("user", loginUser);
			//跳转页面
			response.sendRedirect( request.getContextPath()+"/index.jsp");
			
		}else {
			//登陆失败
			//提示信息
			request.setAttribute("login_msg", "用户名或密码错误");
			//跳转到登陆界面
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
