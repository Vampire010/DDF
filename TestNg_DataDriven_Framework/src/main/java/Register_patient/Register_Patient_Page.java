package Register_patient;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import User_Login.Login;

public class Register_Patient_Page extends Login
{
	
	
	public void Demographics(String First_Name , String Last_Name , String Gender) throws InterruptedException
	{
		WebElement Regstr_pat_lnk = driver.findElement(By.id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension"));
		Regstr_pat_lnk.click();
		
		Thread.sleep(2000);
		WebElement Given_First_Name = driver.findElement(By.xpath("/html/body/div/div[3]/form/section[1]/div/fieldset[1]/div[1]/p[1]/input"));
		Given_First_Name.sendKeys(First_Name);
		
		WebElement Given_Last_Name = driver.findElement(By.xpath("/html/body/div/div[3]/form/section[1]/div/fieldset[1]/div[1]/p[3]/input"));
		Given_Last_Name.sendKeys(Last_Name);
		
		WebElement Gender_label = driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/button[2]"));
		Gender_label.click();

		Select gender_field = new  Select(driver.findElement(By.id("gender-field")));
		gender_field.selectByVisibleText(Gender);
	}
	
	public void Patient_birth_date(String Dob_Date , String Dob_Month , String Dob_Year)
	{
		WebElement Dob = driver.findElement(By.xpath("/html/body/div/div[3]/form/ul/li[1]/ul/li[3]"));
		Dob.click();
		
		WebElement birth_Day = driver.findElement(By.id("birthdateDay-field"));
		birth_Day.sendKeys(Dob_Date);
		
		Select birth_Month = new  Select(driver.findElement(By.id("birthdateMonth-field")));
		birth_Month.selectByVisibleText(Dob_Month);
		
		WebElement birth_Year = driver.findElement(By.id("birthdateYear-field"));
		birth_Year.sendKeys(Dob_Year);
	}
	
	
	public void Address_Info(String Address_1 , String City_Village ,String State_Province , String Country , String PostalCode )
	{
		WebElement Address = driver.findElement(By.xpath("/html/body/div/div[3]/form/ul/li[2]/ul/li[1]"));
		Address.click();
		
		WebElement Patient_Address = driver.findElement(By.id("address1"));
		Patient_Address.sendKeys(Address_1);
		
		WebElement Patient_City_Village = driver.findElement(By.id("cityVillage"));
		Patient_City_Village.sendKeys(City_Village);
		
		WebElement Patient_State_Province = driver.findElement(By.id("stateProvince"));
		Patient_State_Province.sendKeys(City_Village);
		
		WebElement Patient_Country = driver.findElement(By.id("country"));
		Patient_Country.sendKeys(Country);
		
		WebElement Patient_PostalCode = driver.findElement(By.id("postalCode"));
		Patient_PostalCode.sendKeys(PostalCode);
	}
	
	public void Patient_Contact_Number(String Phone_Number)
	{
		WebElement Phone_Number_Field = driver.findElement(By.xpath("/html/body/div/div[3]/form/ul/li[2]/ul/li[2]"));
		Phone_Number_Field.click();
		
		WebElement Patient_Phone_Number = driver.findElement(By.xpath("/html/body/div/div[3]/form/section[2]/div/fieldset[2]/p/input"));
		Patient_Phone_Number.sendKeys(Phone_Number);
	}
	
	
	public void Relationship(String patient_related_to , String Person_name)
	{
		WebElement reltnship = driver.findElement(By.xpath("//*[@id=\"formBreadcrumb\"]/li[3]/ul/li"));
		reltnship.click();
		
		Select patient_related = new  Select(driver.findElement(By.id("relationship_type")));
		patient_related.selectByVisibleText(patient_related_to);
		
		WebElement patient_related_name = driver.findElement(By.xpath("//*[@id=\"relationship\"]/p[2]/input[1]"));
		patient_related_name.sendKeys(Person_name);
		
	}	
	
	public void Registration_Confirmation()
	{
		WebElement confirm_btn = driver.findElement(By.id("confirmation_label"));
		confirm_btn.click();
		
	}
	

}
