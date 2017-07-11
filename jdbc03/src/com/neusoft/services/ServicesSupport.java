package com.neusoft.services;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.neusoft.system.db.DBUtils;

public abstract class ServicesSupport 
{
	/**
	 * 
	 * @param sql --- 需要执行的SQL语句
	 * @param val --- 参数值数组
	 * @return
	 * @throws Exception
	 */
	
	public final int update(String sql,String...val)throws Exception
	{
		//1.定义JDBC接口变量
		Connection conn=null;
		PreparedStatement pstm=null;
		try
		{
			//2.创建连接
			conn=DBUtils.getConnection();
			//3.编译SQL语句
			pstm=conn.prepareStatement(sql);
			//4.参数赋值
			int index=1;
			for(String param:val)
			{
				pstm.setObject(index++,param);
			}
			//5.执行SQL
			return pstm.executeUpdate();
		}
		finally
		{
			DBUtils.close(pstm);
			DBUtils.close(conn);
		}
	}
}
