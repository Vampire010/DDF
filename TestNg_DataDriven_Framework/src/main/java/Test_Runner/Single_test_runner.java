package Test_Runner;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import User_Data_Stream.ReadExcell_Row_Cell_Data;
import User_Login.Login;

public class Single_test_runner {
	String url = "https://demo.openmrs.org/openmrs/login.htm";
	String browser_Type ="chrome";
	
	Login lg = new Login();
	ReadExcell_Row_Cell_Data rd = new ReadExcell_Row_Cell_Data();
	@BeforeMethod
	public void open_browser()
	{
		lg.browsers(browser_Type,url);
	} 

	@Test
	public void login_Tc1( ) throws EncryptedDocumentException, IOException
	{		
		String Username = rd.getdata(1, 0);
		String Usr_Password = rd.getdata(1, 1);
			lg.login_page(Username, Usr_Password);	
			
			String MyString =  lg.driver.getCurrentUrl();
			System.out.print(MyString);
			String YourString = "https://demo.openmrs.org/openmrs/referenceapplication/home.page";
			
			if(MyString.equals(YourString)) 
			{
				//Assert.assertTrue()- Condition, Message
			    Assert.assertTrue(YourString.equals(MyString), "AssertTrue test is failed!");
			    System.out.println("AssertTrue test is Passed!\n");
				String test_Status = rd.Write_Data(1, 2 ,"Pass");

			}
			else
			{
			  //Assert.assertTrue()- Condition, Message
			  Assert.assertFalse(YourString.equals(MyString), "AssertTrue test is failed!");
			  System.out.println("AssertTrue test is Passed!\n");
			  String test_Status = rd.Write_Data(1, 2 ,"Fail");			
			}			
	}
	
	@AfterMethod
	public void close_browser() throws InterruptedException
	{
		Thread.sleep(3000);
	}
}
