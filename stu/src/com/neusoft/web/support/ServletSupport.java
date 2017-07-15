package com.neusoft.web.support;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ServletSupport extends HttpServlet 
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String path=null;
		try
		{
			//1.生成DTO
			Map<String,Object> dto=this.createDto(request);
			//2.接收返回路径
			path=this.execute(request, dto);
		}
		catch(Exception ex)
		{
			request.setAttribute("msg", "网络故障!");
			ex.printStackTrace();
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	/**
	 * 子类Servlet中取代doGet方法
	 * @param request
	 * @param response
	 * @param dto
	 * @return   --- 跳转目标路径
	 * @throws Exception
	 */
	protected abstract String execute(HttpServletRequest request, Map<String,Object> dto)throws Exception;
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		this.doGet(request, response);
	}
	
	
	private final Map<String,Object> createDto(HttpServletRequest request)
	{
		
		Map<String,String[]> tem=request.getParameterMap();
		//DTO数据传输对象,负责在系统的多个组件之间传递数据
		Map<String,Object> dto=new HashMap<>();
		//获取tem中,所有的key
		Set<String> keySet=tem.keySet();
		//System.out.println(keySet);
		//定义代表tem的value部分数组
		String val[]=null;
		//循环keySet
		for(String key:keySet)
		{
			//依据key获取value
			val=tem.get(key);
			//判断val的长度
			if(val.length==1)
			{
				//向DTO中放入数据
				dto.put(key, val[0]);
			}
			else
			{
				dto.put(key, val);
			}	
		}
		//System.out.println(dto);
		return dto;
	}


}
