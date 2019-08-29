package com.atmecs.shoptools.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	
		public static Properties  loadProperty(String propertiesFilePath) {
			Properties properties = new Properties();
			
			
			
			try {
				FileInputStream ip = new FileInputStream(propertiesFilePath);
				properties.load(ip);
				
			
			} catch (IOException ioException) {
			System.out.println("IOException occured as " + ioException.getMessage());
			return null;
			}

			return properties;
			}
		
		
		
	
	
	
	
	

}
