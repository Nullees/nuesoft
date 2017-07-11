package com.neusoft.services;

//链接对象
import java.sql.Connection;
//语句对象
import java.sql.PreparedStatement;
//结果集对象
import java.sql.ResultSet;

import com.neusoft.system.db.DBUtils;

public final class Ac01Services 
{
	/**
	 * 
	 * @param sql --- 需要执行的SQL语句
	 * @param val --- 参数值数组
	 * @return
	 * @throws Exception
	 */
	
	public int update(String sql,String...val)throws Exception
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
	
	public boolean delete(String id)throws Exception
	{
		/*//1.定义JDBC接口
		Connection conn=null;
		PreparedStatement pstm=null;
		try
		{
			//2.创建链接
			conn=DBUtils.getConnection();
			//3.定义SQL
			String sql="delete from ac01 where aac101=?";
			//4.编译SQL
			pstm=conn.prepareStatement(sql);
			//5.参数赋值
			pstm.setObject(1, id);
			//6.执行
			return pstm.executeUpdate()>0;
		}
		finally
		{
			DBUtils.close(pstm);
			DBUtils.close(conn);
		}*/
		//1.定义SQL语句
		String sql="delete from ac01 where aac101=?";
		//2.执行SQL语句
		return this.update(sql,id)>0;
	}
	

	/**
	 * 添加
	 * @param val[]={aac102,aac103,aac104,aac105,aac106}
	 * @return
	 * @throws Exception
	 */
	public boolean add(String...val)throws Exception
	{
		/*//1.定义JDBC接口
		Connection conn=null;
		PreparedStatement pstm=null;
		try
		{
			//2.创建链接对象
			conn=DBUtils.getConnection();
			//3.定义SQL语句
			StringBuilder sql=new StringBuilder()
			.append("insert into ac01(aac102,aac103,aac104,aac105,aac106,aac107)")
			.append("          values(?,?,?,?,?,current_timestamp)")
			;
			//4.编译SQL语句
			pstm=conn.prepareStatement(sql.toString());
			//5.参数赋值
			int index=1;
			for(String param:val)
			{
				pstm.setObject(index++, param);
			}
			//6.执行SQL语句
			return pstm.executeUpdate()>0;
		}
		finally
		{
			DBUtils.close(pstm);
			DBUtils.close(conn);
		}*/
		//1.定义SQL语句
		StringBuilder sql=new StringBuilder()
				.append("insert into ac01(aac102,aac103,aac104,aac105,aac106,aac107)")
				.append("          values(?,?,?,?,?,current_timestamp)")
				;
		//2.执行SQL语句
		return this.update(sql.toString(), val)>0;
	}
	
}

