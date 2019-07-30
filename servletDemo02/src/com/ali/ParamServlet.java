package com.ali;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamServlet
 */
@WebServlet("/ParamServlet")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("GBK");
//		//接收客户端(Browse)表单提交内容
//		String username=request.getParameter("username");
//		String passwd=request.getParameter("password");
//		String email=request.getParameter("Email");
		
		
		//获取所有参数的集合(Map)
		Map<String,String[]> params = request.getParameterMap();
		
		//遍历Map
		Set<String> keySet = params.keySet();
		for(String name:keySet) {
			//通过键获取值
			String[] values = params.get(name);
			System.out.println(name);
			for(String value:values) {
				System.out.println(value);
			}
		
		
		
		}
		
		
		
//		//将提交内容作为应答返回给客户端(Browse)
//		PrintWriter out=response.getWriter();
//		out.print("<h2>返回结果是</h2></br>");
//		out.print("用户名是： "+ username + "密码是： " + passwd + "邮箱是： " + email);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
