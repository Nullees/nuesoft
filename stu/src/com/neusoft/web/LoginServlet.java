package com.neusoft.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.services.LoginServices;


@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String path="/login.jsp";
		try
		{
			//��ȡҳ������
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			//ʵ����ҵ���߼���
			LoginServices services=new LoginServices();
			Map<String,String> userinfo=services.checkUser(username, password);
			//�ж��û������������ȷ��
			if(userinfo!=null)
			{
				//�޸���ת·��
			    path="/main.jsp";
			    //��ѯ���û����Է��ʵĲ˵�
			    List<Map<String,String>> menus=services.queryMenu(userinfo.get("saa101"));
			    if(menus.size()>0)
			    {
			    	//��session��д��ϵͳ�˵�
			    	request.getSession().setAttribute("menus", menus);
			    }
			    
			    
			    //�洢�û���Ϣ
			    request.getSession().setAttribute("userinfo",userinfo);
			}
			else
			{
				request.setAttribute("msg", "������û���������!");
			}
		}
		catch(Exception ex)
		{
			request.setAttribute("msg", "�������!!");
			ex.printStackTrace();
		}
		//Servlet����JSP���﷨
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		this.doGet(request, response);
	}

}
