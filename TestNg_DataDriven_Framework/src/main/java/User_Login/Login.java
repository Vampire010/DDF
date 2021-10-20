package User_Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Browser_Configuration.Launch_Browsers;
import Browser_Configuration.Page_Assertions;

public class Login extends Launch_Browsers
{	
	public void login_page(String Username , String Password)
	{
		WebElement Usrname = driver.findElement(By.id("username"));
		Usrname.sendKeys(Username);
		
		WebElement Usrpassword = driver.findElement(By.id("password"));
		Usrpassword.sendKeys(Password);
		
		WebElement Location_session = driver.findElement(By.id("Registration Desk"));
		Location_session.click();
	
		WebElement Lobin_btn = driver.findElement(By.id("loginButton"));
		Lobin_btn.click();
		
		
	}
}
