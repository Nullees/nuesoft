package com.neusoft.services;

//���Ӷ���
import java.sql.Connection;
//������
import java.sql.PreparedStatement;
//���������
import java.sql.ResultSet;

import com.neusoft.system.db.DBUtils;

public final class Ac01Services 
{
	
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

