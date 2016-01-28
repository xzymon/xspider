package com.xzymon.xspider;

import java.util.List;
import java.util.Properties;

public class Invoker {
	public static final void main(String[] args){
		System.out.println("Invoked!");
		
		Properties props = Utils.getLoadedDefaultProperties();
		Utils.printProperties(props);
		
		String key = Constants.SPIDER_ROOT_URL_KEY;
		List<String> subkeys = Utils.getAllSubKeys(key, props);
		for(String foundKey : subkeys){
			System.out.println("Found subkey of " + key + " is " + foundKey + " = " + props.getProperty(foundKey));
		}
		
		key = Constants.SPIDER_ROOT_URL_KEY;
		printSubKeys(Utils.getAllSubKeys(key, props), key, props);
		
		key = Constants.SPIDER_BRANCH_RESOURCES_PATHS_KEY_PREFIX;
		printSubKeys(Utils.getAllSubKeys(key, props), key, props);
		
		key = Constants.SPIDER_LEAF_RESOURCES_PATHS_KEY_PREFIX;
		printSubKeys(Utils.getAllSubKeys(key, props), key, props);
		
		key = Constants.SPIDER_LEAF_KEY;
		printSubKeys(Utils.getAllSubKeys(key, props), key, props);
		
	}
	
	private static void printSubKeys(List<String> subkeys, String key, Properties props){
		for(String foundKey : subkeys){
			System.out.println("Found subkey of " + key + " is " + foundKey + " = " + props.getProperty(foundKey));
		}
	}
}
