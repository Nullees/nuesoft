package com.neusoft.services;

import com.neusoft.services.support.ServicesSupport;

import java.util.*;
import java.sql.*;
import com.neusoft.system.db.DBUtils;
import com.neusoft.system.tools.Tools;

public class S1010Services extends ServicesSupport
{
	public List<Map<String,String>> queryMenu(Map<String,Object> dto)throws Exception
	{
		//1.还原页面查询条件为Object
		Object saa402=dto.get("qsaa402");
		Object saa403=dto.get("qsaa403");
		Object saa405=dto.get("qsaa405");
		//2.定义List
		List<Object> params=new ArrayList<>();
		
		StringBuilder sql=new StringBuilder()
				.append("select x.saa401,x.saa402,x.saa403,x.saa404,x.saa405")
				.append("  from sa04 x")
				.append(" where 1=1")
				;
		if(saa402!=null && !saa402.equals(""))
		{
			sql.append(" and x.saa402 like ?");
			params.add("%"+saa402+"%");
		}
		if(saa403!=null && !saa403.equals(""))
		{
			sql.append(" and x.saa403  like ?");
			params.add("%"+saa403+"%");
		}
		if(saa405!=null && !saa405.equals(""))
		{
			sql.append(" and x.saa405=?");
			params.add(saa405);
		}
		sql.append(" order by x.saa402");
		System.out.println(sql);
		System.out.println(params);
		
		return this.queryForList(sql.toString(), params.toArray());
	}
	
	public boolean addMenu(Map<String,String> dto)throws Exception
	{
		//1.定义JDBC接口
		Connection conn=null;
		PreparedStatement pstm1=null;   //添加菜单表
		PreparedStatement pstm2=null;   //对admin授权
		try
		{
			//2.创建链接对象
			conn=DBUtils.getConnection();
			
			//3.获取主表主键流水号
			int saa401=Tools.getSequence("saa401");
			
			//4.定义SQL语句--添加菜单
			StringBuilder sql1=new StringBuilder()
			.append("insert into sa04(saa401,saa402,saa403,saa404,saa405)")
			.append("          values(?,?,?,?,?)")		
			;
			//5.编译SQL语句1
			pstm1=conn.prepareStatement(sql1.toString());
			pstm1.setObject(1, saa401);
			pstm1.setObject(2, dto.get("saa402"));
			pstm1.setObject(3, dto.get("saa403"));
			pstm1.setObject(4, dto.get("saa404"));
			pstm1.setObject(5, "1");
			
			//6.定义SQL语句2---为admin授权
			StringBuilder sql2=new StringBuilder()
			.append("insert into sa05(saa201,saa401,saa502)")
			.append("         values(?,?,?)")		
			;
			//7.编译授权语句
            pstm2=conn.prepareStatement(sql2.toString());
            pstm2.setObject(1, 1);
            pstm2.setObject(2, saa401);
            pstm2.setObject(3, "1");
            
            //8.以事务方式执行所有更新语句
            //8.1定义事务返回值
            boolean tag=false;
            //8.2开启事务
            conn.setAutoCommit(false);
            try
            {
            	//8.3在事务内部执行所有更新语句
            	pstm1.executeUpdate();
            	pstm2.executeUpdate();
            	
            	//8.4确认对数据的修改-----事务提交
            	conn.commit();
            	//8.5修改返回值,确认执行成功
            	tag=true;
            }
            catch(Exception ex)
            {
            	//取消对数据的修改---事务回滚
            	conn.rollback();
            	ex.printStackTrace();
            }
            finally
            {
            	//9.技术事务
            	conn.setAutoCommit(true);
            }
            return tag;
			
		}
		finally
		{
			DBUtils.close(pstm1);
			DBUtils.close(pstm2);
			DBUtils.close(conn);
		}
	}
}
