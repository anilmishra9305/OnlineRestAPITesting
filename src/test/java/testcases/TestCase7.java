package testcases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TestCase7 {
	
	
	
	@Test
	public void checkBasicAuthentication()
	{
		
		
		
		 String bodydata=RestAssured.given().auth().preemptive().basic("ToolsQA", "TestPassword")
		                .when().get("http://restapi.demoqa.com/authentication/CheckForAuthentication")
		                .body().asString();
		 
		 System.out.println("Body Data "+bodydata);
		
	}
	
	

}
