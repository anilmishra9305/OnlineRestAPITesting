package testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.CommonFunction;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestCase3 {
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void registrationPage()
	{
		
		 RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		 RequestSpecification request = RestAssured.given();
		 
		 //payload
		 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("FirstName", "firstname"+CommonFunction.randomNumber()); 
		 requestParams.put("LastName", "lastname"+CommonFunction.randomNumber());
		 requestParams.put("UserName", "username"+CommonFunction.randomNumber());
		 requestParams.put("Password", "password"+CommonFunction.randomNumber());
		 requestParams.put("Email", CommonFunction.randomNumber()+ "abcduser@gmail.com");
		
		 // Add a header stating the Request body is a JSON
		 request.header("Content-Type", "application/json");
		  
		 // Add the Json to the body of the request
		 request.body(requestParams.toJSONString());
		  
		 // Post the request and check the response
		 Response response = request.post("/register");
		 
		 
		 System.out.println("****************************Verification*****************************************************");
		 
		 
		 System.out.println("Response body: " + response.body().asString());
		 
		
		  int statusCode = response.getStatusCode();
		  
		  System.out.println("Status Code "+statusCode);
		  
		  Assert.assertEquals(statusCode, 201);
		  
		  String successCode = response.jsonPath().get("SuccessCode");
		  
		  Assert.assertEquals(successCode, "OPERATION_SUCCESS", "I have verified Sucess operation!!");

		  
		  String message=response.jsonPath().get("Message");
		  
		  Assert.assertEquals(message, "Operation completed successfully", "I have sucessfully Verified response");
		  
		  
		  
		  
		  
		 
		
		
		
		
		
		
		
		
		
		
	}
	
	

}
