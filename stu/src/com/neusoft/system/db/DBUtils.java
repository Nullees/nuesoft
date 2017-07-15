package com.neusoft.system.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//����������
import java.sql.DriverManager;
//��Դ�ļ�������
import java.util.ResourceBundle;

public final class DBUtils
{
	//1.���ݿ������Ϣ
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
    		 * 2.��Դ�ļ�����
    		 */
    		//2.1��ȡ��Դ�ļ���������
    		ResourceBundle bundle=ResourceBundle.getBundle("DBOptions");
    		//2.1��ȡ�����Ϣ
    		driver=bundle.getString("DRIVER");
    		url=bundle.getString("URL");
    		username=bundle.getString("USERNAME");
    		password=bundle.getString("PASSWORD");
    		
			/**
			 * 3.ͨ����̬���������
			 * 
			 * ���౻��һ�μ������ڴ�ʱ��ִ��,�Ժ���ִ��
			 * ��̬�鴴���Ķ���,��פ�ڴ治�ͷ�
			 * 
			 * ͨ���������ʵ��������jar�еĺ�����
			 * �ȼ���   new com.mysql.jdbc.Driver();
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
