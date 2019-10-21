package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.RestAssured;

public class TestCase8 extends TestBase {
	
	
	
	@Test
	public void testStatusCode()
	{
		
		int statuscode= RestAssured.given()
		.get()
		.getStatusCode();
		
		System.out.println("status code "+statuscode);
		
		
		Assert.assertEquals(statuscode, 200,"I have sucessfully Tested");
		
	}

}
