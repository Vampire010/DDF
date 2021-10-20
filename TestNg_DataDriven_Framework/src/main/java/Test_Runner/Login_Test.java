package Test_Runner;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import User_Data_Stream.ReadExcel_Data;
import User_Data_Stream.Write_To_Excel_Stream;
import User_Login.Login;

public class Login_Test 
{
	String url = "https://demo.openmrs.org/openmrs/login.htm";
	String browser_Type ="chrome";
	
	Login lg = new Login();
	Write_To_Excel_Stream wrt_exl = new Write_To_Excel_Stream();
	
	@DataProvider(name = "Authentication")
	 public   Object[][] credentials() throws Exception 
	 {
	         // The number of times data is repeated, test will be executed the same no. of times
		 ReadExcel_Data read = new ReadExcel_Data();
		 return read.getCellData("C:\\Users\\91973\\eclipse-workspace\\TestNg_DataDriven_Framework\\src\\main\\java\\Data_Source\\User_Creds.xlsx","user_cred");
	 }
	
	@BeforeMethod
	public void open_browser()
	{
		lg.browsers(browser_Type,url);
	} 

	@Test(dataProvider = "Authentication")
	public void login_Tc1(String Username ,String Usr_Password ) throws EncryptedDocumentException, IOException
	{		
			lg.login_page(Username, Usr_Password);	
			
			String MyString =  lg.driver.getCurrentUrl();
			System.out.print(MyString);
			String YourString = "https://demo.openmrs.org/openmrs/referenceapplication/home.page";
			
			if(MyString.equals(YourString)) 
			{
				//Assert.assertTrue()- Condition, Message
			    Assert.assertTrue(YourString.equals(MyString), "AssertTrue test is failed!");
			    System.out.println("AssertTrue test is Passed!\n");
				wrt_exl.Write_Me(Username, Usr_Password, "PASS");	
			}
			else
			{
			  //Assert.assertTrue()- Condition, Message
			  Assert.assertFalse(YourString.equals(MyString), "AssertTrue test is failed!");
			  System.out.println("AssertTrue test is Passed!\n");
			  wrt_exl.Write_Me(Username, Usr_Password, "FAIL");									
			}			
	}
	
	@AfterMethod
	public void close_browser() throws InterruptedException
	{
		Thread.sleep(3000);
	}
}
