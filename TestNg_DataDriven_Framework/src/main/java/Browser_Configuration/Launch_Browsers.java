package Browser_Configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Launch_Browsers 
{
public   WebDriver driver;
	

	public String browsers(String browser_Type , String Url)
	{
	
		if(browser_Type.equals("chrome"))
		{				
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\91973\\eclipse-workspace\\TestNg_DataDriven_Framework\\Browser_Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(Url);				
		}
		
		else if(browser_Type.equals("firefox"))
		{				
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\91973\\eclipse-workspace\\TestNg_DataDriven_Framework\\Browser_Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(Url);			
		}
		
		else if(browser_Type.equals("edge"))
		{				
			System.setProperty("webdriver.edge.driver", "C:\\Users\\91973\\eclipse-workspace\\TestNg_DataDriven_Framework\\Browser_Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.get(Url);			
		}
			
		else 
		{				
			System.out.println("Specified browser type is not found");			
		}		
		return Url;	
	}
	
	

}
