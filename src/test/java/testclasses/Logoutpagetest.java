package testclasses;

import org.openqa.selenium.bidi.log.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.Loginpage;
import pageobject.Logoutpage;
import utils.BaseClass;

public class Logoutpagetest extends BaseClass {

	    @Test(priority = 1)
	    public void verifyLogoutFunctionality()
	    {

	    	Logoutpage logout  = new Logoutpage(driver);
	    	logout.openLoginPage();


	        // Step 2: Login (Precondition)
	    	logout.enterUsername("carlos");
	    	logout.clickLoginButton();
	    	logout.enterPassword("hunter2");
	    	logout.clickLoginButton();
	       

	        // Step 3: Logout
	        logout.clickLogout();

	        // Step 4: Validation
	        Assert.assertTrue(logout.isLoginButtonDisplayed(),
	                "Logout failed - Login button not visible");
	}
}
	