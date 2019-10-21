package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestCase9 {
	
	double empid=15410.100;
	RequestSpecification httpRequest;
	Response response;
	
	@BeforeClass
	public void deleteEmployeerecord() throws InterruptedException
	{
		
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET,"/employees");
		
		System.out.println("*****************body of employee*******************************");
		
		System.out.println(response.getBody().asString());
		System.out.println("************************************************");

		//first get the json path object instance from the response interface
		
		JsonPath jsonpathevaluator=response.jsonPath();
		
		//capture id
		
		String empId=jsonpathevaluator.get("[0].id");
		response=httpRequest.request(Method.DELETE,"/delete/"+empId);
		Thread.sleep(10000);
        
		
	}
	
	@Test
	public void getstausCode()
	{
		
		int statuscode=response.getStatusCode();
		System.out.println("Status code "+statuscode);
		
		Assert.assertEquals(statuscode, 200);
		
	}
	
	
	@Test
	public void checkBody()
	{
		
		
		String message=response.getBody().asString();
		
		System.out.println("Messagge After Delete Operation: "+message);
		
		Assert.assertEquals(message.contains("successfully! deleted Records"), true);
		
	}
	
	@Test
	public void checkStausLine()
	{
		
		String statusLine=response.getStatusLine();
		System.out.println("Status Line "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}
	
	@Test
	public void checkServerType()
	{
		
		
		String serverType=response.header("Server");
		Assert.assertEquals(serverType, "nginx/1.16.0");
		
		
		
	}
	

	
	public void checkContentEncoding()
	{
		
		String content=response.header("content-encoding");
		
		Assert.assertEquals(content, "gzip");
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
