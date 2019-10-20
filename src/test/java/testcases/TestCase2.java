package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TestCase2 {
	
	
	@Test
	public void displayAllNodes()
	{
		
		
		
	RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
	RequestSpecification httpRequest=RestAssured.given();
	Response response=httpRequest.get("/london");
	//First get the jsonPath object instance from the response interface
	
	System.out.println("********************Testing bu JsonPath*************************************");
	JsonPath jsonpatheval=response.jsonPath();
	
	System.out.println("City Name from response "+jsonpatheval.get("City"));
	
	
	Assert.assertEquals("london".toLowerCase(), jsonpatheval.get("City").toString().toLowerCase());
	
	
	System.out.println("Temprature form Response : "+jsonpatheval.get("Temperature"));
	
	System.out.println("Humidity form Response : "+jsonpatheval.get("Humidity"));
	
	
	
	System.out.println("********************************Json body data **********************************************");
	
	
	
	
	   ResponseBody body= response.getBody();
	   
	   System.out.println("Whole body data "+body.asString());
	   
	   String bodyData=body.asString();
	   
	   Assert.assertEquals(bodyData.contains("London"), true,"Both Are Matched!!");
	   
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
	}
	
	

}
