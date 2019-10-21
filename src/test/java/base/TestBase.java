package base;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class TestBase {
	
	CommonFunction com=new CommonFunction();
	
	
	@BeforeSuite
	public void setup()
	{
		
		String userName=com.readPropertyFile("username");
		String password=com.readPropertyFile("password");
		String baseUri= com.readPropertyFile("baseuri");
		
		// For basic preemptive Authentication 
		RestAssured.authentication=RestAssured.preemptive().basic(userName, password);
		
		//For baseuri
		RestAssured.baseURI=baseUri;
		
		
		
		
	}
	
	

}
