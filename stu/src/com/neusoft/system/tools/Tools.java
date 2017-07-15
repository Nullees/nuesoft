package com.neusoft.system.tools;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.neusoft.system.db.DBUtils;

public final class Tools 
{
	public final static String init_pwd="1bf8cd9bbec894f915c600a2c27bcf53";
	
	private Tools(){}
	
	public static void main(String[] args) 
	{
		  try 
		  {
			 
			  String md5code=Tools.getMd5Code("0000");
			  System.out.println(md5code);
		  } 
		  catch (Exception e) 
		  {
			  e.printStackTrace();
		  }
	}
	
	
	
	public static Map<String,Object> createDto(HttpServletRequest request)
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
	
	
	//******************BEGIN MD5加密********************
	
	public static String getMd5Code(String pwd)throws Exception
	{
		  //2.获取第一次加密的密文
		  String md5code1=Tools.MD5Encode(pwd);
		  //3.基于一次加密的密文生成二次明文
		  String pwd2=md5code1+"黄河远上,митъㄇㄎ白云一片,孤城ρηο万仞山,羌笛何须怨,杨柳γβα春风,不度玉ㄍㄓㄉè门关 氣死你,無ìǒμ法破解,這是一個安全的密碼"+md5code1;
		  //4.进行二次加密
		  String code2=Tools.MD5Encode(pwd2);
		  return code2;
	}
	
	
	
	 private final static String[] hexDigits = {
	     "0", "1", "2", "3", "4", "5", "6", "7",
	     "8", "9", "a", "b", "c", "d", "e", "f"};

	  /**
	   * 转换字节数组为16进制字串
	   * @param b 字节数组
	   * @return 16进制字串
	   */
	  private static String byteArrayToHexString(byte[] b)
	  {
	      StringBuffer resultSb = new StringBuffer();
	      for (int i = 0; i < b.length; i++)
	      {
	         resultSb.append(byteToHexString(b[i]));
	      }
	      return resultSb.toString();
	  }
	  /**
	   * 转换字节为16进制字符串
	   * @param b byte
	   * @return String
	   */
	  private static String byteToHexString(byte b)
	  {
	      int n = b;
	      if (n < 0)
	         n = 256 + n;
	      int d1 = n / 16;
	      int d2 = n % 16;
	      return hexDigits[d1] + hexDigits[d2];
	  }
	  /**
	   * 得到MD5的秘文密码
	   * @param origin String
	   * @throws Exception
	   * @return String
	   */
	  private static String MD5Encode(Object origin) throws Exception
	  {
	       String resultString = null;
	       try
	       {
	           resultString=new String(origin.toString());
	           MessageDigest md = MessageDigest.getInstance("MD5");
	           resultString=byteArrayToHexString(md.digest(resultString.getBytes()));
	           return resultString;
	       }
	       catch (Exception ex)
	       {
	          throw ex;
	       }
	  }	
	//******************END  MD5******************	  

	
	
    public static int getSequence(String fieldName)throws Exception
    {
    	//1.定义JDBC接口
    	Connection conn=null;
    	PreparedStatement pstm1=null;   //查询序列值
    	PreparedStatement pstm2=null;   //更新序列值
    	ResultSet rs=null;
    	try
    	{
    		//2.创建链接
    		conn=DBUtils.getConnection();
    		//3.定义查询语句
    		StringBuilder sql1=new StringBuilder()
			.append("select svalue")
			.append("  from sequence")
			.append(" where fname=?") 		
    		;
    		//4.编译SQL语句
    		pstm1=conn.prepareStatement(sql1.toString());
    		pstm1.setObject(1, fieldName);
    		//5.执行查询
    		rs=pstm1.executeQuery();
    		
    		
    		//6.定义更新语句
    		StringBuilder sql2=new StringBuilder();
    		
    		//7.定义字段名对应的当前值变量
    		int svalue=0;
    		if(rs.next())
    		{
    			//8.修改svalue的值为数据库中的当前值
    			svalue=rs.getInt(1);
    			//9.1编写更新语句
    			sql2.append("update sequence")
    			    .append("   set svalue=?")
    			    .append(" where fname=?");
    		}
    		else
    		{
    			//9.2编写插入语句
    		    sql2.append("insert into sequence(svalue,fname)")
    		        .append("              values(?,?)");
    		}	
    		//10.编译语句2
    		pstm2=conn.prepareStatement(sql2.toString());
    		pstm2.setObject(1, ++svalue);
    		pstm2.setObject(2, fieldName);
    		//11.执行SQL语句
    		pstm2.executeUpdate();
    		
    		//12.处理返回值
    		return svalue;
    	}
    	finally
    	{
    		DBUtils.close(rs);
    		DBUtils.close(pstm1);
    		DBUtils.close(pstm2);
    		DBUtils.close(conn);
    	}
    }
}
