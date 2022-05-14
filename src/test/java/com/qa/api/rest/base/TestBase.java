package com.qa.api.rest.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	/**
	 * This Method returns given propery value
	 * Accessmodifier static datatype methodname(datatype key){logic; return value;}
	 * @throws IOException 
	 * 
	 */

	public static String readPropertyValue(String key) throws IOException {
		//Step1-create object for Properties class
		Properties prop=new Properties();
		//Step2:Read the properties file using FileInputStream class
		File f=new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\qa\\api\\rest\\config\\config.properties");
		try {
			FileInputStream fis=new FileInputStream(f);
		//step3 - load all the properties
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop.getProperty(key);
	}
	
}
