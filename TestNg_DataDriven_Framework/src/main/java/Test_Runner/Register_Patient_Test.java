package Test_Runner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Register_patient.Register_Patient_Page;
import User_Data_Stream.ReadExcel_Data;
import User_Login.Login;

public class Register_Patient_Test
{

	//Browser parameters
	String url = "https://demo.openmrs.org/openmrs/login.htm";
	String browser_Type ="chrome";
	
	//Demographics
	String First_Name = "Sam"; 
	String Last_Name = "jan";
	String Gender = "Male";
	
	//Patient_birth_date
	String Dob_Date="08";
	String Dob_Month="February";
	String Dob_Year="1998";
	
	//Address_Info
	String Address_1 = "Temple Street , Krish Avenue";
	String City_Village = "NewYork";
	String State_Province = "Alaska";
	String Country = "USA"; 
	String PostalCode = "1674411";
	
	//Patient_Contact_Number
	String Phone_Number = "1237894560";
	
	//Relationship
	String patient_related_to = "Aunt/Uncle";
	String Person_name = "Jackijan";
	
	Register_Patient_Page rp = new Register_Patient_Page();	

	

	@BeforeMethod
	public void open_browser()
	{
		rp.browsers(browser_Type,url);
		rp.login_page("Admin", "Admin123");

	}

	@Test
	public void login_Tc1() throws InterruptedException
	{
		rp.Demographics( First_Name ,  Last_Name ,  Gender);
		rp.Patient_birth_date( Dob_Date ,  Dob_Month ,  Dob_Year);
		rp.Address_Info( Address_1 ,  City_Village , State_Province ,  Country ,  PostalCode);
		rp.Patient_Contact_Number(Phone_Number);
		rp.Relationship( patient_related_to ,  Person_name);
		rp.Registration_Confirmation();
		
	}
	@AfterMethod
	public void close_browser() throws InterruptedException
	{
		Thread.sleep(3000);
		rp.driver.close();
	}

}
