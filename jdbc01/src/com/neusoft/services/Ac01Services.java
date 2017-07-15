package com.neusoft.services;

//链接对象
import java.sql.Connection;
//语句对象
import java.sql.PreparedStatement;
//结果集对象
import java.sql.ResultSet;

import java.util.*;
//结果集元数据（结果集描述对象）;
import java.sql.ResultSetMetaData;

import com.neusoft.system.db.DBUtils;

public final class Ac01Services 
{
	
	public Map<String,String> findById(Object id)throws Exception
	{
		//1.定义JDBC接口
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try
		{
			//2.创建链接
			conn=DBUtils.getConnection();
			//3.定义SQL语句
			StringBuilder sql=new StringBuilder()
			.append("select aac101,aac102,aac103 Dname,aac104,aac105,aac106")
			.append("  from ac01")
			.append(" where aac101=?")//注意这个地方的问号是英文字符
			//            |
			//           SQL单词最后字母对齐！
			;
			//4.编译SQL
			pstm=conn.prepareStatement(sql.toString());
			//5.参数赋值
			pstm.setObject(1, id);
			//6.执行查询---通过语句对象执行SQL语句，生成结果集对象。
			rs=pstm.executeQuery();
			//7.定义数据装载容器
			Map<String,String> ins=null;
			//8.判断是否存在查询结果
			if(rs.next())
			{
				//9.获取结果集描述对象
				ResultSetMetaData rsmd=rs.getMetaData();
			    //10.计算列数
				int count=rsmd.getColumnCount();
			    //11.计算HashMap初始容量
				//12.实例化HashMap
				ins=new HashMap();
			    //13.循环读取当前行各列
				for(int i=1;i<=count;i++)
				{
					//向Map中放数据
					ins.put(rsmd.getColumnLabel(i).toLowerCase(),rs.getString(i));
				}
			}
			
			//14.返回
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
		//1.定义JDBC接口
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
		}
	}
	

	/**
	 * 添加
	 * @param val[]={aac102,aac103,aac104,aac105,aac106}
	 * @return
	 * @throws Exception
	 */
	public boolean add(String...val)throws Exception
	{
		//1.定义JDBC接口
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
		}
	}
	
}

