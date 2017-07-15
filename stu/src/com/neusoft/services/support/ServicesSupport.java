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
		//1.定义JDBC接口
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try
		{
			//2.创建链接
			conn=DBUtils.getConnection();
			//4.编译SQL语句
			pstm=conn.prepareStatement(sql);
			
			int index=1;
			for(Object param:args)
			{
				pstm.setObject(index++, param);
			}
			
			//5.执行SQL语句
			rs=pstm.executeQuery();
			//6.获取结果集描述对象
			ResultSetMetaData rsmd=rs.getMetaData();
			//7.计算列数
			int count=rsmd.getColumnCount();
			//8.计算初始容量
			int initSize=(int)(count/0.75)+2;
			//9.定义装载全部数据的List对象
			List<Map<String,String>> rows=new ArrayList<>();
			//10.定义装载当前行数据的Map变量
			Map<String,String> ins=null;
			//11.循环控制rs指针
			while(rs.next())
			{
				//12.创建装载当前行数据的HashMap实例
				ins=new HashMap<>(initSize);
				//13.循环读取当前行每列数据
				for(int i=1;i<=count;i++)
				{
				    //14.将当前列数据放入Map
					ins.put(rsmd.getColumnLabel(i).toLowerCase(),rs.getString(i));
				}
				//15.将Map放入List
				rows.add(ins);
			}
			//16.返回查询结果
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
	 * 非事务情况下,单一表更新方法
	 * @param sql  --- 需要执行的SQL语句
	 * @param val  --- 参数值数组
	 * @return
	 * @throws Exception
	 */
	protected final int update(String sql,String...val)throws Exception
	{
		//1.定义JDBC接口变量
		Connection conn=null;
		PreparedStatement pstm=null;
		try
		{
			//2.创建链接
			conn=DBUtils.getConnection();
			//3.编译SQL语句
			pstm=conn.prepareStatement(sql);
			//4.参数赋值
			int index=1;
			for(String param:val)
			{
				pstm.setObject(index++, param);
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
	
	/**
	 * 单一实例查询方法
	 * @param sql  --  需要执行的SQL
	 * @param val   --  参数值
	 * @return
	 * @throws Exception
	 */
	protected final Map<String,String> queryForMap(String sql,Object...val)throws Exception
	{
		//1.定义JDBC接口
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try
		{
			//2.创建链接
			conn=DBUtils.getConnection();
			//4.编译SQL
			pstm=conn.prepareStatement(sql);
			//5.参数赋值
			int index=1;
			for(Object param:val)
			{
				pstm.setObject(index++, param);
			}
			//6.执行查询---通过语句对象执行SQL语句,生成结果集对象
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
				int initSize=(int)(count/0.75)+2;
				//12.实例化HashMap
				ins=new HashMap<>(initSize);
				//13.循环读取当前行各列
				for(int i=1;i<=count;i++)
				{
					//向Map中放入数据
					ins.put(rsmd.getColumnLabel(i).toLowerCase(), rs.getString(i));  //2
				}
			}
			//14.返回	
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
