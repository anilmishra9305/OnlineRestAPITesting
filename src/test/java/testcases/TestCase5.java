package testcases;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestCase5 {
	
	@Test
	public void updateRecord()
	{
		
		int empid=15410;
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification request=RestAssured.given();
		
		//payload
		
		JSONObject object=new JSONObject();
		
		object.put("name", "123");
		object.put("age", "abc");
		object.put("salary", 123456789);
		
		request.header("Content-Type","application/json");
		
		request.body(object.toJSONString());
		
		Response resonse=request.put("/update/"+empid);
		
		
		System.out.println("put body "+resonse.body().asString());
		
		System.out.println("status code "+resonse.getStatusCode());
		
		
		
		
		
	}
	

}
