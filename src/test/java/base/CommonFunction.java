package base;

import java.io.FileInputStream;
import java.util.Properties;

public class CommonFunction {
	
	
	
	public static double randomNumber()
	{
		double value=0;
		try {
			
		 value=(Math.random()*1000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
		
	}
	
	
	
	
	public String readPropertyFile(String key)
	{
		String value="";
		try {
			
			String path=System.getProperty("user.dir");
			FileInputStream file=new FileInputStream(path+"\\restapitesting.properties");
			Properties prop=new Properties();
			prop.load(file);
			value=prop.getProperty(key);
			
		} catch (Exception e) {
              e.printStackTrace();
		  
		}
		return value;
		
		
		
		
	}
	
	

}
