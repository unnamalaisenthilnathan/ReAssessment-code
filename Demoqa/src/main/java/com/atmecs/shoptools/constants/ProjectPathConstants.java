package com.atmecs.shoptools.constants;

import java.io.File;

public class ProjectPathConstants {
	public static String currentdir = System.getProperty("user.dir");
	//public static String resources = currentdir +  File.separator + "resources" + File.separator;
	public static String configfile=currentdir +  File.separator + "resources" + File.separator+"configfolder";
	public static String log = currentdir +  File.separator + "log" + File.separator;
	public static String test = currentdir +  File.separator + "test" + File.separator;
	
	
	

	public static String configpropsfile=configfile+File.separator +"config.properties";
	
	
	public static String locators= currentdir+File.separator+"resources"+File.separator+"locators.properties";
	
	
	//log
	public static String logpropertyfile=log+"log.properties";
	
	
	//public static String testdatapropertyfile=test+"testdata.properties";
	
	//public static String testdataproperties=currentdir +  File.separator + "resources" + File.separator;
	//public static String  testdata=testdataproperties+"testdataproperties.xlsx";
	
	//testdata
	
	public static String testDataprops= currentdir+File.separator+"resources"+File.separator+"testdata.properties";
	
}
