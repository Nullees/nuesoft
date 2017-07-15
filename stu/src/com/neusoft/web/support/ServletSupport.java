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
			//1.����DTO
			Map<String,Object> dto=this.createDto(request);
			//2.���շ���·��
			path=this.execute(request, dto);
		}
		catch(Exception ex)
		{
			request.setAttribute("msg", "�������!");
			ex.printStackTrace();
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	/**
	 * ����Servlet��ȡ��doGet����
	 * @param request
	 * @param response
	 * @param dto
	 * @return   --- ��תĿ��·��
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
		//DTO���ݴ������,������ϵͳ�Ķ�����֮�䴫������
		Map<String,Object> dto=new HashMap<>();
		//��ȡtem��,���е�key
		Set<String> keySet=tem.keySet();
		//System.out.println(keySet);
		//�������tem��value��������
		String val[]=null;
		//ѭ��keySet
		for(String key:keySet)
		{
			//����key��ȡvalue
			val=tem.get(key);
			//�ж�val�ĳ���
			if(val.length==1)
			{
				//��DTO�з�������
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
