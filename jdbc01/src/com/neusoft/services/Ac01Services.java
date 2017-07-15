package com.neusoft.services;

//���Ӷ���
import java.sql.Connection;
//������
import java.sql.PreparedStatement;
//���������
import java.sql.ResultSet;

import java.util.*;
//�����Ԫ���ݣ��������������;
import java.sql.ResultSetMetaData;

import com.neusoft.system.db.DBUtils;

public final class Ac01Services 
{
	
	public Map<String,String> findById(Object id)throws Exception
	{
		//1.����JDBC�ӿ�
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try
		{
			//2.��������
			conn=DBUtils.getConnection();
			//3.����SQL���
			StringBuilder sql=new StringBuilder()
			.append("select aac101,aac102,aac103 Dname,aac104,aac105,aac106")
			.append("  from ac01")
			.append(" where aac101=?")//ע������ط����ʺ���Ӣ���ַ�
			//            |
			//           SQL���������ĸ���룡
			;
			//4.����SQL
			pstm=conn.prepareStatement(sql.toString());
			//5.������ֵ
			pstm.setObject(1, id);
			//6.ִ�в�ѯ---ͨ��������ִ��SQL��䣬���ɽ��������
			rs=pstm.executeQuery();
			//7.��������װ������
			Map<String,String> ins=null;
			//8.�ж��Ƿ���ڲ�ѯ���
			if(rs.next())
			{
				//9.��ȡ�������������
				ResultSetMetaData rsmd=rs.getMetaData();
			    //10.��������
				int count=rsmd.getColumnCount();
			    //11.����HashMap��ʼ����
				//12.ʵ����HashMap
				ins=new HashMap();
			    //13.ѭ����ȡ��ǰ�и���
				for(int i=1;i<=count;i++)
				{
					//��Map�з�����
					ins.put(rsmd.getColumnLabel(i).toLowerCase(),rs.getString(i));
				}
			}
			
			//14.����
			return ins;
			
		}
		finally
		{
			DBUtils .close(rs);
			DBUtils .close(pstm);
			DBUtils .close(conn);
		}
	}
	
	public boolean delete(String id)throws Exception
	{
		//1.����JDBC�ӿ�
		Connection conn=null;
		PreparedStatement pstm=null;
		try
		{
			//2.��������
			conn=DBUtils.getConnection();
			//3.����SQL
			String sql="delete from ac01 where aac101=?";
			//4.����SQL
			pstm=conn.prepareStatement(sql);
			//5.������ֵ
			pstm.setObject(1, id);
			//6.ִ��
			return pstm.executeUpdate()>0;
		}
		finally
		{
			DBUtils.close(pstm);
			DBUtils.close(conn);
		}
	}
	

	/**
	 * ���
	 * @param val[]={aac102,aac103,aac104,aac105,aac106}
	 * @return
	 * @throws Exception
	 */
	public boolean add(String...val)throws Exception
	{
		//1.����JDBC�ӿ�
		Connection conn=null;
		PreparedStatement pstm=null;
		try
		{
			//2.�������Ӷ���
			conn=DBUtils.getConnection();
			//3.����SQL���
			StringBuilder sql=new StringBuilder()
			.append("insert into ac01(aac102,aac103,aac104,aac105,aac106,aac107)")
			.append("          values(?,?,?,?,?,current_timestamp)")
			;
			//4.����SQL���
			pstm=conn.prepareStatement(sql.toString());
			//5.������ֵ
			int index=1;
			for(String param:val)
			{
				pstm.setObject(index++, param);
			}
			//6.ִ��SQL���
			return pstm.executeUpdate()>0;
		}
		finally
		{
			DBUtils.close(pstm);
			DBUtils.close(conn);
		}
	}
	
}

