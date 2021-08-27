package com.sdet18.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * 
 * @author Nitheesha
 *
 */
public class PropertyFileUtility {

	Properties prop;
	/**
	 * Load the property file before utilizing the key and value
	 * @throws Throwable
	 */
	public void loadProperty() throws Throwable {
		FileInputStream fis=new FileInputStream(IFilePath.PROPERTY_FILE);
		prop=new Properties();
		prop.load(fis);
	}
	
	public String getBrowser() {
		return prop.getProperty("browser");
	}
	
	public String getUrl() {
		return prop.getProperty("url");
	}
	
	public String getUsername() {
		return prop.getProperty("username");
	}
	public String getPassword() {
		return prop.getProperty("password");
	}
	
	public int getImplicitWait() {
		return Integer.parseInt(prop.getProperty("implicitWait"));
	}
	
	public int getExplicitWait() {
		return Integer.parseInt(prop.getProperty("ExplicitWait"));
	}
	
	public String getRemote() {
		return prop.getProperty("remote");
	}
}
