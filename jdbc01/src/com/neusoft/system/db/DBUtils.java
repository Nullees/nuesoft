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
	//���ݿ������Ϣ
	/*
	 * ���һ���������еķ�������static�ģ���ô����Ĺ�������Ҫ˽��
	 * ˽��֮�󣬸��಻���Ա��̳У������Ա�������ʵ������
	 */
	//1.����������
	private static String driver=null;
	
//	private static String driver="com.mysql.jdbc.driver";//����JAR��������ĵ�Driver.class��
	
	//2.�������Ӵ�
//	private static String url="jdbc:mysql://localhost/neu01?characterEncoding=GBK";//�����������ݿ�����̨������ϡ����ݿ��������ɶ�����ӵ����ݿ�ʱ���õı����ʽ��ʲô��
	private static String url=null;
	private static String username=null;
	private static String password=null;
	
	private DBUtils(){}
	
	static
	{
		try {
			/*
			 * 2.��Դ�ļ�����
			 */
			//2.1��ȡ��Դ�ļ���������
			ResourceBundle bundle=ResourceBundle.getBundle("DBOptions");
			//2.2��ȡ�����Ϣ
			driver=bundle.getString("DRIVER");
			url=bundle.getString("URL");
			username=bundle.getString("USERNAME");
			password=bundle.getString("PASSWORD");
			
			
			/*3.��������
			 * 
			 * ���౻��һ�μ������ڴ��ʱ��ִ�У��Ժ���ִ��
			 * ��̬�鴴���Ķ��󣬳�פ�ڴ治�ͷš�
			 * 
			 * ͨ���������ʵ��������JAR���еĺ�����
			 * �ȼ��� new com.mysql.jdbc.Driver()
			 */
			Class.forName(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection()throws Exception
	{
		    			
			
//			//4.��������--ͨ������������������Ŀ�������������
//			Connection conn=DriverManager.getConnection(url,"root","123456");
//			
//			/*
//			 * ��DriverManager����url���ж����������ݿ⣬�жϳ���֮���URL,username,password�������ݿ�������࣬��com.mysql.jdbc.driver�����ӵ�Ŀ�������е�Ŀ�����ݿ⣬����������ӷ��ظ�DriverManager,�����DriverManager��getConnection()��������һ��Connection����
//			 */
//			return conn;
//			//5.�������Ӷ���
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
