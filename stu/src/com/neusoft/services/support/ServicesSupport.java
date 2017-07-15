package com.neusoft.services.support;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.neusoft.system.db.DBUtils;

public abstract class ServicesSupport 
{
	
	protected final List<Map<String,String>> queryForList(String sql,Object...args)throws Exception
	{
		//1.����JDBC�ӿ�
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try
		{
			//2.��������
			conn=DBUtils.getConnection();
			//4.����SQL���
			pstm=conn.prepareStatement(sql);
			
			int index=1;
			for(Object param:args)
			{
				pstm.setObject(index++, param);
			}
			
			//5.ִ��SQL���
			rs=pstm.executeQuery();
			//6.��ȡ�������������
			ResultSetMetaData rsmd=rs.getMetaData();
			//7.��������
			int count=rsmd.getColumnCount();
			//8.�����ʼ����
			int initSize=(int)(count/0.75)+2;
			//9.����װ��ȫ�����ݵ�List����
			List<Map<String,String>> rows=new ArrayList<>();
			//10.����װ�ص�ǰ�����ݵ�Map����
			Map<String,String> ins=null;
			//11.ѭ������rsָ��
			while(rs.next())
			{
				//12.����װ�ص�ǰ�����ݵ�HashMapʵ��
				ins=new HashMap<>(initSize);
				//13.ѭ����ȡ��ǰ��ÿ������
				for(int i=1;i<=count;i++)
				{
				    //14.����ǰ�����ݷ���Map
					ins.put(rsmd.getColumnLabel(i).toLowerCase(),rs.getString(i));
				}
				//15.��Map����List
				rows.add(ins);
			}
			//16.���ز�ѯ���
			return rows;
		}
		finally
		{
			DBUtils.close(rs);
			DBUtils.close(pstm);
			DBUtils.close(conn);
		}
	}

	
	
	/**
	 * �����������,��һ����·���
	 * @param sql  --- ��Ҫִ�е�SQL���
	 * @param val  --- ����ֵ����
	 * @return
	 * @throws Exception
	 */
	protected final int update(String sql,String...val)throws Exception
	{
		//1.����JDBC�ӿڱ���
		Connection conn=null;
		PreparedStatement pstm=null;
		try
		{
			//2.��������
			conn=DBUtils.getConnection();
			//3.����SQL���
			pstm=conn.prepareStatement(sql);
			//4.������ֵ
			int index=1;
			for(String param:val)
			{
				pstm.setObject(index++, param);
			}
			//5.ִ��SQL
			return pstm.executeUpdate();
			
		}
		finally
		{
			DBUtils.close(pstm);
			DBUtils.close(conn);
		}
	}
	
	/**
	 * ��һʵ����ѯ����
	 * @param sql  --  ��Ҫִ�е�SQL
	 * @param val   --  ����ֵ
	 * @return
	 * @throws Exception
	 */
	protected final Map<String,String> queryForMap(String sql,Object...val)throws Exception
	{
		//1.����JDBC�ӿ�
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try
		{
			//2.��������
			conn=DBUtils.getConnection();
			//4.����SQL
			pstm=conn.prepareStatement(sql);
			//5.������ֵ
			int index=1;
			for(Object param:val)
			{
				pstm.setObject(index++, param);
			}
			//6.ִ�в�ѯ---ͨ��������ִ��SQL���,���ɽ��������
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
				int initSize=(int)(count/0.75)+2;
				//12.ʵ����HashMap
				ins=new HashMap<>(initSize);
				//13.ѭ����ȡ��ǰ�и���
				for(int i=1;i<=count;i++)
				{
					//��Map�з�������
					ins.put(rsmd.getColumnLabel(i).toLowerCase(), rs.getString(i));  //2
				}
			}
			//14.����	
			return ins;
		}
		finally
		{
			DBUtils.close(rs);
			DBUtils.close(pstm);
			DBUtils.close(conn);
		}
	}

}
