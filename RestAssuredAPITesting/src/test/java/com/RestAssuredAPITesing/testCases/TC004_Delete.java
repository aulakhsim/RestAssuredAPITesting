package com.RestAssuredAPITesing.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.RestAssuredApITesting.base.BaseClass;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC004_Delete extends BaseClass {
	
	@BeforeClass
	void deleteEmployee() {
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
		
		response =httpRequest.request(Method.GET,"/employees");
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		
		response=httpRequest.request(Method.DELETE,"/delete/3");
		
	}
	
	@Test
	void statusCode() {
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	void checkResposebody() {
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains("sucessfully! deleted Records"),true);
	}

}
