package basic;

import java.util.Map;
import java.util.HashMap;

public class MapDemo {

	public static void main(String[] args) 
	{
		//1.����HashMapʵ��
		Map<String,String> data=new HashMap<>();//JDK1.5֮ǰ�İ汾����Ҫд Map<String,String> data=new HashMap<String,String>();
		
		//2.��Map��д������
		//        key     value
		data.put("aac101","1");
		data.put("aac102","D1001");
		data.put("aac103", "���������");
		data.put("aac104", "01");
		//3.֧���������
		System.out.println(data);
		//4.��һvalue�Ļ�ȡ
		String aac103=data.get("aac103");
		System.out.println(aac103);
		
	}

}
