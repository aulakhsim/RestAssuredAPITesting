package com.RestAssuredAPITesing.testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.RestAssuredAPITesing.utilities.RestUtils;
import com.RestAssuredApITesting.base.BaseClass;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC002_POST extends BaseClass {

	String empName=RestUtils.empName();
	String empSalary=RestUtils.empSalary();
	String empAge=RestUtils.empAge();
	
	@BeforeClass
	void createEmployee() {
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
		
		JSONObject reqParams = new JSONObject();
		reqParams.put("name", empName);
		reqParams.put("salary", empSalary);
		reqParams.put("age", empAge);
		
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(reqParams.toJSONString());
		
		response=httpRequest.request(Method.POST, "/create");
				
	}
	@Test
	
	void checkResponse() {
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains(empName), true);
		Assert.assertEquals(responseBody.contains(empSalary), true);
		Assert.assertEquals(responseBody.contains(empAge), true);
			
		}
	@Test
	void checkStatusCode() {
		int statusCode= response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

}
