package Browser_Configuration;

import org.testng.Assert;

public class Page_Assertions 
{
	public void verify_auth(String myString, String yourString)
	{
		if(myString.equals(yourString)) 
		{
			//Assert.assertTrue()- Condition, Message
		    Assert.assertTrue(yourString.equals(myString), "AssertTrue test is failed!");
		    System.out.println("AssertTrue test is Passed!\n");
		}
		else
		{
			//Assert.assertTrue()- Condition, Message
		  Assert.assertFalse(yourString.equals(myString), "AssertTrue test is failed!");
		  System.out.println("AssertTrue test is Passed!\n");
			
		}
	}

}
