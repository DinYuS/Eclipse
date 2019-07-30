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
//		//���տͻ���(Browse)�����ύ����
//		String username=request.getParameter("username");
//		String passwd=request.getParameter("password");
//		String email=request.getParameter("Email");
		
		
		//��ȡ���в����ļ���(Map)
		Map<String,String[]> params = request.getParameterMap();
		
		//����Map
		Set<String> keySet = params.keySet();
		for(String name:keySet) {
			//ͨ������ȡֵ
			String[] values = params.get(name);
			System.out.println(name);
			for(String value:values) {
				System.out.println(value);
			}
		
		
		
		}
		
		
		
//		//���ύ������ΪӦ�𷵻ظ��ͻ���(Browse)
//		PrintWriter out=response.getWriter();
//		out.print("<h2>���ؽ����</h2></br>");
//		out.print("�û����ǣ� "+ username + "�����ǣ� " + passwd + "�����ǣ� " + email);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}