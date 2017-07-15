package com.neusoft.services;

public class Ac01Services extends ServicesSupport 
{
	public boolean delete(String id)throws Exception
	{
		//1.定义SQL语句
		String sql="delete from ac01 where aac101=?";
		//2.执行
		return this.update(sql, id)>0;
	}
	
	public boolean add(String...val)throws Exception
	{

		//1.定义SQL语句
		StringBuilder sql=new StringBuilder()
				.append("insert into ac01(aac102,aac103,aac104,aac105,aac106,aac107)")
				.append("          values(?,?,?,?,?,current_timestamp)")
				;
		//2.执行SQL语句
		return this.update(sql.toString(), val)>0;
	}



}
