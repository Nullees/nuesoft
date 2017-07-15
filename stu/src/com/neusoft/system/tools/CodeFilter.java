package com.neusoft.system.tools;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;


/**
 * Servlet Filter implementation class CodeFilter
 */
@WebFilter("/*")
/**
 * ���Ĺ�����������servlet�������ģ��Զ���ԭ�����ġ�
 * @author zjr
 *
 */
public class CodeFilter extends HttpServlet implements Filter 
{

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException 
	{
		    //���ύ������ת��������
		    request.setCharacterEncoding("GBK");
		
			chain.doFilter(request, response);   //������Ŀ��Servlet���д���
	}

	public void init(FilterConfig fConfig) throws ServletException //���ţ���������ɾ��	
	{
	}

}
