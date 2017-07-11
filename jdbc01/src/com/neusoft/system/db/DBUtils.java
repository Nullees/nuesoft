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
	//数据库相关信息
	/*
	 * 如果一个类中所有的方法都是static的，那么该类的构造子需要私有
	 * 私有之后，该类不可以被继承，不可以被其他类实例化。
	 */
	//1.定义驱动串
	private static String driver=null;
	
//	private static String driver="com.mysql.jdbc.driver";//驱动JAR包中最核心的Driver.class类
	
	//2.定义链接串
//	private static String url="jdbc:mysql://localhost/neu01?characterEncoding=GBK";//告诉我们数据库在哪台计算机上、数据库的名称是啥、连接到数据库时采用的编码格式是什么？
	private static String url=null;
	private static String username=null;
	private static String password=null;
	
	private DBUtils(){}
	
	static
	{
		try {
			/*
			 * 2.资源文件解析
			 */
			//2.1获取资源文件解析对象
			ResourceBundle bundle=ResourceBundle.getBundle("DBOptions");
			//2.2获取相关信息
			driver=bundle.getString("DRIVER");
			url=bundle.getString("URL");
			username=bundle.getString("USERNAME");
			password=bundle.getString("PASSWORD");
			
			
			/*3.加载驱动
			 * 
			 * 在类被第一次加载入内存的时候执行，以后不再执行
			 * 静态块创建的对象，常驻内存不释放。
			 * 
			 * 通过反射机制实例化驱动JAR包中的核心类
			 * 等价于 new com.mysql.jdbc.Driver()
			 */
			Class.forName(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection()throws Exception
	{
		    			
			
//			//4.创建链接--通过驱动管理器创建到目标管理器的连接
//			Connection conn=DriverManager.getConnection(url,"root","123456");
//			
//			/*
//			 * 由DriverManager解析url，判断是哪种数据库，判断出来之后把URL,username,password传给数据库的驱动类，由com.mysql.jdbc.driver类链接到目标计算机中的目标数据库，最后把这个链接返回给DriverManager,最后由DriverManager的getConnection()方法返回一个Connection对象。
//			 */
//			return conn;
//			//5.返回链接对象
		return DriverManager.getConnection(url,username,password);
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

}
