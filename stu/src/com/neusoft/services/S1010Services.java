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
		//1.��ԭҳ���ѯ����ΪObject
		Object saa402=dto.get("qsaa402");
		Object saa403=dto.get("qsaa403");
		Object saa405=dto.get("qsaa405");
		//2.����List
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
		//1.����JDBC�ӿ�
		Connection conn=null;
		PreparedStatement pstm1=null;   //��Ӳ˵���
		PreparedStatement pstm2=null;   //��admin��Ȩ
		try
		{
			//2.�������Ӷ���
			conn=DBUtils.getConnection();
			
			//3.��ȡ����������ˮ��
			int saa401=Tools.getSequence("saa401");
			
			//4.����SQL���--��Ӳ˵�
			StringBuilder sql1=new StringBuilder()
			.append("insert into sa04(saa401,saa402,saa403,saa404,saa405)")
			.append("          values(?,?,?,?,?)")		
			;
			//5.����SQL���1
			pstm1=conn.prepareStatement(sql1.toString());
			pstm1.setObject(1, saa401);
			pstm1.setObject(2, dto.get("saa402"));
			pstm1.setObject(3, dto.get("saa403"));
			pstm1.setObject(4, dto.get("saa404"));
			pstm1.setObject(5, "1");
			
			//6.����SQL���2---Ϊadmin��Ȩ
			StringBuilder sql2=new StringBuilder()
			.append("insert into sa05(saa201,saa401,saa502)")
			.append("         values(?,?,?)")		
			;
			//7.������Ȩ���
            pstm2=conn.prepareStatement(sql2.toString());
            pstm2.setObject(1, 1);
            pstm2.setObject(2, saa401);
            pstm2.setObject(3, "1");
            
            //8.������ʽִ�����и������
            //8.1�������񷵻�ֵ
            boolean tag=false;
            //8.2��������
            conn.setAutoCommit(false);
            try
            {
            	//8.3�������ڲ�ִ�����и������
            	pstm1.executeUpdate();
            	pstm2.executeUpdate();
            	
            	//8.4ȷ�϶����ݵ��޸�-----�����ύ
            	conn.commit();
            	//8.5�޸ķ���ֵ,ȷ��ִ�гɹ�
            	tag=true;
            }
            catch(Exception ex)
            {
            	//ȡ�������ݵ��޸�---����ع�
            	conn.rollback();
            	ex.printStackTrace();
            }
            finally
            {
            	//9.��������
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
