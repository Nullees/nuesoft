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
		String msg=services.add("D1003","���ݿ�ά��һ��","02","����һ��","2017-07-11")?"����ɹ���":"����ʧ�ܣ�";
//		String msg=services.delete("2")?"ɾ���ɹ���":"ɾ��ʧ�ܣ�";
		System.out.println(msg);
	}

}
