package com.neusoft.services;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.neusoft.system.db.DBUtils;

public abstract class ServicesSupport 
{
	/**
	 * 
	 * @param sql --- ��Ҫִ�е�SQL���
	 * @param val --- ����ֵ����
	 * @return
	 * @throws Exception
	 */
	
	public final int update(String sql,String...val)throws Exception
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
				pstm.setObject(index++,param);
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
}
