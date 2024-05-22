package org.pompage;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
	
	public Properties properties=new Properties();
	
	
	public String userName()
	{
		String username=properties.getProperty("username");
		return username;
	}
	
	public String password()
	{
		String password=properties.getProperty("password");
		return password;
	}
	
	public String url()
	{
		String url=properties.getProperty("url");
		return url;
	}
	
	public Properties loadProperties() throws IOException {
      //  Properties properties = new Properties();
		FileReader reader=new FileReader("C:\\Users\\ankit\\eclipse-workspace\\QuickTestAutomation\\src\\test\\java\\QTEAutomation\\application.properties");
		properties.load(reader);
        
        return properties;
    }

}
