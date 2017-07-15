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
 * 中文过滤器，帮助servlet解析中文，自动还原成中文。
 * @author zjr
 *
 */
public class CodeFilter extends HttpServlet implements Filter 
{

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException 
	{
		    //将提交的数据转换成中文
		    request.setCharacterEncoding("GBK");
		
			chain.doFilter(request, response);   //请求向目标Servlet进行传递
	}

	public void init(FilterConfig fConfig) throws ServletException //空着，但不可以删除	
	{
	}

}
