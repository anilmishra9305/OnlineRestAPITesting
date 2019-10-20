package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestCase1 {
	
	
	@Test
	public void testCityTemprature()
	{
		
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response response=httpRequest.request(Method.GET,"/london");
		
		
		String responseBody=response.getBody().asString();
		
		System.out.println(responseBody);
		
		//verification of status code
		
		int statuscode=response.getStatusCode();
		
		System.out.println("Status code : "+statuscode);
		Assert.assertEquals(statuscode, 200);
		
		
		// status line
		
		String statusline=response.getStatusLine();
		
		System.out.println("Status Line "+statusline);
		
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		
		
		//Response Header Verification
		
		String contentType_header=response.header("Content-Type");
		
		System.out.println("Content-Type "+contentType_header);
		
		Assert.assertEquals(contentType_header, "application/json");
		
		
		// Verify Server
		
		String serverName=response.header("Server");
		
		System.out.println("Server Name "+serverName);
		
		Assert.assertEquals(serverName, "nginx", "I have verified Server Name");
		
		
		// All headers Name
		
		System.out.println("*********************All Headers Start*******************************************");
		
		
	    Headers allheaders	=response.headers();
	    for(Header header:allheaders)
	    {
	    	
	    	System.out.println("For Header Name "+header.getName());
	    	System.out.println("For Header Value "+header.getValue());

	    }
	    
		
		System.out.println("*********************All Headers End*******************************************");
		
		
		
		
		System.out.println("****************Session ID********************");
		
		
		
		String sessionId=response.getSessionId();
		System.out.println("Session ID: "+sessionId);
		
		
		

		
		
		
		
		
	}

}
