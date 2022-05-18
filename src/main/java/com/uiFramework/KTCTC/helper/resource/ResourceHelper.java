package com.uiFramework.KTCTC.helper.resource;

public class ResourceHelper {

	public static String getResourcePath(String path) {
        String basePath = System.getProperty("user.dir");
		return basePath +"\\"+ path;
	}


public static void main(String[] args) {
	
	ResourceHelper.getResourcePath("automation.out");
}


}