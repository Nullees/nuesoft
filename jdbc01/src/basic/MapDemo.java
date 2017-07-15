package basic;

import java.util.Map;
import java.util.HashMap;

public class MapDemo {

	public static void main(String[] args) 
	{
		//1.创建HashMap实例
		Map<String,String> data=new HashMap<>();//JDK1.5之前的版本，需要写 Map<String,String> data=new HashMap<String,String>();
		
		//2.向Map中写入数据
		//        key     value
		data.put("aac101","1");
		data.put("aac102","D1001");
		data.put("aac103", "软件开发部");
		data.put("aac104", "01");
		//3.支持整体输出
		System.out.println(data);
		//4.单一value的获取
		String aac103=data.get("aac103");
		System.out.println(aac103);
		
	}

}
