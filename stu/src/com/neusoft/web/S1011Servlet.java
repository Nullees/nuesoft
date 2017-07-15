package com.neusoft.web;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import com.neusoft.services.S1010Services;
import com.neusoft.web.support.ServletSupport;

@WebServlet("/s1011.html")  //元数据主键
public final class S1011Servlet extends ServletSupport 
{
	@Override
	protected String execute(HttpServletRequest request, Map<String, Object> dto) throws Exception 
	{
		S1010Services services=new S1010Services();
		List<Map<String,String>> rows=services.queryMenu(dto);
		if(rows.size()>0)
		{
			//将数据写入request
			request.setAttribute("rows", rows);
		}
		else
		{
			request.setAttribute("msg", "没有符合条件的数据!");
		}	
		
		return "/S1010.jsp";
	}
}
