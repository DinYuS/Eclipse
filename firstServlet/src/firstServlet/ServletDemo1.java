package firstServlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/demo1")

public class ServletDemo1 implements Servlet{
	
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	/**
	 * init()  service()  destroy()  servlet生命周期三方法
	 * 
	 */
	
	//相当于Java类构造方法
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("初始化方法init");
		
	}
	
	
	//相当于Java类main方法
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("hello Sevlet!");
		System.out.println("可执行方法Service");
	}
	
	
	//相当于Java类销毁方法
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("销毁方法destroy");
		
	}


	
	
}
