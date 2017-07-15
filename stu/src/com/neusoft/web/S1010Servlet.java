package com.neusoft.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.system.tools.Tools;

import java.util.*;

//����������

@WebServlet("/s1010.html")
public class S1010Servlet extends HttpServlet 
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		try
		{	
			Map<String,Object> dto=Tools.createDto(request);
			System.out.println(dto);
		}
		catch(Exception e)
		{
			request.setAttribute("msg", "�������!");
			e.printStackTrace();
		}
		request.getRequestDispatcher("/S1011.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		this.doGet(request, response);
	}

}
