package com.neusoft.system.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//驱动管理器
import java.sql.DriverManager;
//资源文件解析类
import java.util.ResourceBundle;

public final class DBUtils
{
	//1.数据库相关信息
	private static String driver=null;
	private static String url=null;
	private static String username=null;
	private static String password=null;

	
	private DBUtils(){}

	
	static
	{
    	try 
    	{
    		/**
    		 * 2.资源文件解析
    		 */
    		//2.1获取资源文件解析对象
    		ResourceBundle bundle=ResourceBundle.getBundle("DBOptions");
    		//2.1获取相关信息
    		driver=bundle.getString("DRIVER");
    		url=bundle.getString("URL");
    		username=bundle.getString("USERNAME");
    		password=bundle.getString("PASSWORD");
    		
			/**
			 * 3.通过静态块加载驱动
			 * 
			 * 在类被第一次加载入内存时候执行,以后不再执行
			 * 静态块创建的对象,常驻内存不释放
			 * 
			 * 通过反射机制实例化驱动jar中的核心类
			 * 等价于   new com.mysql.jdbc.Driver();
			 */
			Class.forName(driver);
		} 
    	catch (Exception e) 
    	{
			e.printStackTrace();
		}
	}
	
    public static Connection getConnection()throws Exception
    {
    	return DriverManager.getConnection(url, username, password); 
    }
	  
    public static void close(ResultSet rs)
    {
    	try
    	{
    		if(rs!=null)
    		{
    			rs.close();
    		}
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    }
    
    public static void close(PreparedStatement pstm)
    {
    	try
    	{
    		if(pstm!=null)
    		{
    			pstm.close();
    		}
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    }

    
    public static void close(Connection conn)
    {
    	try
    	{
    		if(conn!=null)
    		{
    			conn.close();
    		}
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    }

    
	public static void main(String[] args) 
	{
	    try 
	    {
			System.out.println(DBUtils.getConnection());
		}
	    catch (Exception e) 
	    {
			e.printStackTrace();
		}	
	}

}
