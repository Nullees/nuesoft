package com.neusoft.services;


import java.util.*;
import com.neusoft.services.support.ServicesSupport;
import com.neusoft.system.tools.Tools;

public final class LoginServices extends ServicesSupport 
{
	
	/**
	 * 查询菜单
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,String>> queryMenu(Object userId)throws Exception
	{
		StringBuilder sql=new StringBuilder()
		.append("select a.saa402,a.saa403,a.saa404")
		.append("  from sa04 a,sa05 b,sa03 c,sa01 d")
		.append(" where a.saa401=b.saa401")
		.append("   and b.saa201=c.saa201")
		.append("   and d.saa101=c.saa101")
		.append("   and c.saa302=?")
		.append("   and b.saa502=?")
		.append("   and a.saa405=?")
		.append("   and d.saa101=?")
		;
		Object args[]={
				"1","1","1",userId
		};
		
		return this.queryForList(sql.toString(),args);
	}
	
	/**
	 * 校验用户
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
    public Map<String,String> checkUser(String username,String password)throws Exception
    {
    	//定义SQL语句
    	StringBuilder sql=new StringBuilder()
		.append("select saa101,saa102,saa103") 
		.append("  from sa01")
		.append(" where saa105=?")
		.append("   and saa104=?")
		.append("   and saa103=?")		
    	;
    	//准备数据
    	Object val[]={
    			"1",
    			Tools.getMd5Code(password),
    			username
    	};
    	//执行查询
    	return this.queryForMap(sql.toString(), val);
    }	

}
