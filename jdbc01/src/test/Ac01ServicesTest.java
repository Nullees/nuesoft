package test;

import java.util.Map;

import com.neusoft.services.Ac01Services;

public class Ac01ServicesTest {

	public static void main(String[] args) 
	{
		try 
		{
			Ac01ServicesTest
							//.addTest();
			                .findByIdTest();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private static void findByIdTest()throws Exception
	{
		Ac01Services services=new Ac01Services();
		Map<String,String> ins=services.findById(1);
		System.out.println(ins);
	}
	
	private static void addTest()throws Exception
	{
		//1.��֯����
		String val[]={"D1002","�����������","01","����һ��","2015-09-01"};
		//2.ʵ����Services
		Ac01Services services=new Ac01Services();
		//3.���÷���
		boolean tag=services.add(val);
		System.out.println(tag);
	}

}
