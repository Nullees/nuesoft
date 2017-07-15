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
			//获取页面数据
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			//实例化业务逻辑类
			LoginServices services=new LoginServices();
			Map<String,String> userinfo=services.checkUser(username, password);
			//判断用户名和密码的正确性
			if(userinfo!=null)
			{
				//修改跳转路径
			    path="/main.jsp";
			    //查询该用户可以访问的菜单
			    List<Map<String,String>> menus=services.queryMenu(userinfo.get("saa101"));
			    if(menus.size()>0)
			    {
			    	//向session中写入系统菜单
			    	request.getSession().setAttribute("menus", menus);
			    }
			    
			    
			    //存储用户信息
			    request.getSession().setAttribute("userinfo",userinfo);
			}
			else
			{
				request.setAttribute("msg", "错误的用户名或密码!");
			}
		}
		catch(Exception ex)
		{
			request.setAttribute("msg", "网络故障!!");
			ex.printStackTrace();
		}
		//Servlet调回JSP的语法
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		this.doGet(request, response);
	}

}
