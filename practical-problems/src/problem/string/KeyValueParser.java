package problem.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class KeyValueParser {
	
	
	public Map<String,String> parseString(String str){
		
		Map<String,String> map = new LinkedHashMap<>();
		
		
		str=str.trim();
		
		String [] kv = str.split(";");
		
		for(String keyvalue : kv) {
			
			String [] t= keyvalue.split(":");
			
			map.put(t[0], t[1]);
			
			
		}
		
		
		for(Map.Entry<String, String>item : map.entrySet()) {
			System.out.println(item.getKey() +" "+item.getValue());
		}
		
		
		return map;
	}
	
	public static void main(String[] args) {
		
		String str = "key1:value1;key2:value2";
		
		KeyValueParser keyValueParser=new KeyValueParser();
		
		keyValueParser.parseString(str);
		
	}

}
