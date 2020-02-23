package com.RestAssuredAPITesing.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.RestAssuredApITesting.base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class TC001_GET  extends BaseClass{
	@BeforeClass
	void getAllEmployees() {
		RestAssured.baseURI="http://dummy.restapiexample.com";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET,"/employees");
	}
	
	@Test
	void checkStatusCode()
	{
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
}
