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
		//1.��ȡ��������-User���Ӧ����
		Map<String,String[]> map=request.getParameterMap();
		User user=new User();
		/**
		 * user.setName(request.getParamter("username");
		 */
		//ʹ��BeanUtils��װ����->һ���Դ���
		try {
			BeanUtils.populate(user, map);
		}catch(Exception e) {
			
		}
		
		/*�ڷ���������̨�������ν��*/
		//System.out.println(user.getUsername());
		//System.out.println(user.getPassword());
		
		//����DAO�µķ������ж�User����null->ת��success.html
		//����DAO�µķ������ж�UserΪnull->ת��fail.html
		UserDAO dao = new UserDAO();
		if(dao.login(user)!=null) {
			//ת����success.html
			RequestDispatcher rd = request.getRequestDispatcher("/success.html");
			rd.forward(request,response);
		}else {
			//ת����fail.html
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