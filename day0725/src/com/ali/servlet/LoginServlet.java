package com.ali.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		//1.����request����
		request.setCharacterEncoding("utf-8");
		//2.��ȡ����
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String checkCode=request.getParameter("checkCode");
		
		//3.�Ȼ�ȡ���ɵ���֤��
		HttpSession session=request.getSession();
		String checkCode_session=(String)session.getAttribute("checkCode_session");
		System.out.println(checkCode_session);
		//ɾ��session�д洢����֤��
		session.removeAttribute("checkCode_session");
		//4.�ж���֤���Ƿ���ȷ
		if(checkCode_session!=null && checkCode_session.equalsIgnoreCase(checkCode)) {
			//���Դ�Сд
			//��֤������ȷ��
			//�û��������Ƿ���ȷ
			if("zhangsan".equals(username) && "123".equals(password)) {
				//��½�ɹ�
				//�洢�û���
				session.setAttribute("user", username);
				//�ض���success.jsp
				response.sendRedirect(request.getContextPath() + "/success.jsp");
				
			}else {
				//��½ʧ��
				//request����洢��ʾ��Ϣ
				request.setAttribute("login_error", "�û������������");
				//ת������½ҳ��
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				
			}
		}else {
			//��֤�벻һ��
			//�洢��Ϣ��request
			
			request.setAttribute("cc_error", "��֤�����");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
				
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


















