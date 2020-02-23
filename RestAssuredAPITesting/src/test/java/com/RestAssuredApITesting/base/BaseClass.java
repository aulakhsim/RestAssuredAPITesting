package com.RestAssuredApITesting.base;


import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.log4testng.Logger;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public String empID="21";
	
	public  Logger logger;
	//@BeforeClass
	/*public void setup() {
		logger=Logger.getLogger("");
		PropertyConfigurator.configure("log4j.properties");
		logger.getLevel(Level.DEBUG);
	}*/
	

}
