package test;
import com.neusoft.services.Ac01Services;

public class Ac01ServicesTest {

	public static void main(String[] args) {
		
		try {
			Ac01ServicesTest.deleteTest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void deleteTest()throws Exception
	{
		Ac01Services services=new Ac01Services();
		String msg=services.add("D1003","数据库维护一部","02","对美一部","2017-07-11")?"插入成功！":"插入失败！";
//		String msg=services.delete("2")?"删除成功！":"删除失败！";
		System.out.println(msg);
	}

}
