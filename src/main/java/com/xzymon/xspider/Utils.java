package com.xzymon.xspider;

import java.io.IOException;
import java.util.Properties;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class Utils {
	private static Properties loadedDefaultProperties = null;
	public static Properties getLoadedDefaultProperties(){
		if(loadedDefaultProperties==null){
			loadedDefaultProperties = new Properties();
			try {
				loadedDefaultProperties.load(Utils.class.getResourceAsStream("/default.properties"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return loadedDefaultProperties;
	}
	
	public static void printProperties(Properties toPrintProperites){
		String key = null;
		String value = null;
		for(Entry<Object, Object> entry: toPrintProperites.entrySet()){
			key = (String) entry.getKey();
			value = (String) entry.getValue();
			System.out.println(key + " = " + value);
		}
	}
	
	public static List<String> getAllSubKeys(String key, Properties propsInstanceToSearchIn){
		List<String> subKeys = new ArrayList<String>();
		
		String preparedPhrase = key + ".";
		
		String keyString = null;
		for(Object propKey : propsInstanceToSearchIn.keySet()){
			keyString = (String) propKey;
			if(keyString.startsWith(preparedPhrase)){
				subKeys.add(keyString);
			}
		}
		
		return subKeys;
	}
}
