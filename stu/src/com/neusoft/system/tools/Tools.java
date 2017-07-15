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
	
	
	//******************BEGIN MD5����********************
	
	public static String getMd5Code(String pwd)throws Exception
	{
		  //2.��ȡ��һ�μ��ܵ�����
		  String md5code1=Tools.MD5Encode(pwd);
		  //3.����һ�μ��ܵ��������ɶ�������
		  String pwd2=md5code1+"�ƺ�Զ��,�ާڧ��Ǩΰ���һƬ,�³ǦѦǦ�����ɽ,Ǽ�Ѻ���Թ,�����æ¦�����,������ͨӨɨ��Ź� ������,�o�����̷��ƽ�,�@��һ����ȫ���ܴa"+md5code1;
		  //4.���ж��μ���
		  String code2=Tools.MD5Encode(pwd2);
		  return code2;
	}
	
	
	
	 private final static String[] hexDigits = {
	     "0", "1", "2", "3", "4", "5", "6", "7",
	     "8", "9", "a", "b", "c", "d", "e", "f"};

	  /**
	   * ת���ֽ�����Ϊ16�����ִ�
	   * @param b �ֽ�����
	   * @return 16�����ִ�
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
	   * ת���ֽ�Ϊ16�����ַ���
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
	   * �õ�MD5����������
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
    	//1.����JDBC�ӿ�
    	Connection conn=null;
    	PreparedStatement pstm1=null;   //��ѯ����ֵ
    	PreparedStatement pstm2=null;   //��������ֵ
    	ResultSet rs=null;
    	try
    	{
    		//2.��������
    		conn=DBUtils.getConnection();
    		//3.�����ѯ���
    		StringBuilder sql1=new StringBuilder()
			.append("select svalue")
			.append("  from sequence")
			.append(" where fname=?") 		
    		;
    		//4.����SQL���
    		pstm1=conn.prepareStatement(sql1.toString());
    		pstm1.setObject(1, fieldName);
    		//5.ִ�в�ѯ
    		rs=pstm1.executeQuery();
    		
    		
    		//6.����������
    		StringBuilder sql2=new StringBuilder();
    		
    		//7.�����ֶ�����Ӧ�ĵ�ǰֵ����
    		int svalue=0;
    		if(rs.next())
    		{
    			//8.�޸�svalue��ֵΪ���ݿ��еĵ�ǰֵ
    			svalue=rs.getInt(1);
    			//9.1��д�������
    			sql2.append("update sequence")
    			    .append("   set svalue=?")
    			    .append(" where fname=?");
    		}
    		else
    		{
    			//9.2��д�������
    		    sql2.append("insert into sequence(svalue,fname)")
    		        .append("              values(?,?)");
    		}	
    		//10.�������2
    		pstm2=conn.prepareStatement(sql2.toString());
    		pstm2.setObject(1, ++svalue);
    		pstm2.setObject(2, fieldName);
    		//11.ִ��SQL���
    		pstm2.executeUpdate();
    		
    		//12.������ֵ
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
