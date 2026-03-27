package testclasses;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.Loginpage;
import utils.BaseClass;

public class Loginpagetest extends BaseClass {
	
	 @Test(priority=1)
	public void testclicklogo()
	{
		Loginpage login=new Loginpage(driver);
		login.clickLogo();
		String actualURL=driver.getCurrentUrl();
		String expectedURL="https://ginandjuice.shop/";
		Assert.assertEquals(actualURL,expectedURL);

	}
	@Test(priority=2)
	public void testproductlink()
	{
		Loginpage login=new Loginpage(driver);
		login.clickProducts();
		String actualURL=driver.getCurrentUrl();
		Assert.assertTrue(driver.getCurrentUrl().contains("/catalog"));
		
	}
	
	@Test(priority=3)
	public void testBlogLink()
	{
		Loginpage login=new Loginpage(driver);
		login.clickBlog();
		 String actualURL = driver.getCurrentUrl();
	 Assert.assertTrue(driver.getCurrentUrl().contains("/blog"));	
	}
@Test(priority=4)
public void testClickOurStory()
{
	Loginpage login=new Loginpage(driver);
	login.clickOurStory();
	 String actualURL = driver.getCurrentUrl();
	 Assert.assertTrue(driver.getCurrentUrl().contains("/about"));
}
 @Test(priority=5)
 public void testClickAccountIcon()
 {
	 Loginpage login=new Loginpage(driver);
		login.clickAccountIcon();
		    String actualURL = driver.getCurrentUrl();
	        Assert.assertTrue(actualURL.contains("login"),
	                "Users is not redirected to login page");
 }
@Test(priority=6)
public void testClickLogin()
{
	Loginpage login=new Loginpage(driver);
	login.clickAccountIcon();
    login.enterUsername("carlos");
    login.clickLoginButton();
    login.enterPassword("hunter2");

    login.clickLoginButton();

    Assert.assertTrue(driver.getCurrentUrl().contains("my-account"),
            "Login failed");
   
}

@Test(priority=7) 
public void testClickMyAccount()throws InterruptedException
{
	Loginpage login=new Loginpage(driver);
	login.clickMyAccount();
	Thread.sleep(3000);
	 Assert.assertTrue(driver.getCurrentUrl().contains("/login"),"Should be on My Account page");
}
@Test(priority=8)
public void testClickCartIcon() throws InterruptedException
{
	Loginpage login=new Loginpage(driver);
	login.clickCartIcon();
	Thread.sleep(2000);
	Assert.assertTrue(driver.getCurrentUrl().contains("/catalog/cart"),"Should be on Cart page");
}
@Test(priority=9)
public void testCartCount()
{
	Loginpage login = new Loginpage(driver);

    String actualCount = login.getCartCount();
    String expectedCount = "0";

    Assert.assertEquals(actualCount, expectedCount,
            "Cart count is not zero on homepage");
}

@Test(priority=10)
public void testEmailSubscription()
{
	Loginpage login = new Loginpage(driver);

    login.subscribeWithEmail("test@gmail.com");

    Assert.assertTrue(login.isCouponDialogDisplayed(),
            "Coupon dialog is not displayed after subscription");
}

@Test(priority=11)
public void testEmptyEmailSubscription()
{
	Loginpage login = new Loginpage(driver);

    login.subscribeWithEmail("");

    String validation = login.getEmailValidationMessage(); 

    Assert.assertTrue(validation.contains("Please"),
            "Validation message not displayed");
}
@Test(priority=12)
public void testInvalidEmailSubscription()
{
    Loginpage login = new Loginpage(driver);

    login.subscribeWithEmail("trfdre@yudegyewy3t7813713y.com");

    Assert.assertFalse(login.isCouponDialogDisplayed(),
    		"Test Failed: Coupon dialog appeared even though the email was invalid!");
}
@Test(priority=13)
public void testCouponInfoText()
{
	Loginpage login = new Loginpage(driver);

    login.subscribeWithEmail("test@gmail.com");

    String couponText = login.getCouponInfoText();

    Assert.assertTrue(couponText.contains("coupon"),
            "Coupon information text is incorrect");
}
@Test(priority = 14)
public void testViewAllProducts()
{
    Loginpage product = new Loginpage(driver);

    product.clickViewAllProducts();

    Assert.assertTrue(driver.getCurrentUrl().contains("catalog"),
            "User is not redirected to the products page");
}
@Test(priority = 15)
public void testViewAllBlog()
{
    Loginpage product = new Loginpage(driver);

    product.clickViewAllBlog();

    Assert.assertTrue(driver.getCurrentUrl().contains("blog"),
            "User is redirected to the blog page");
}
@Test(priority = 16)
public void testViewPost()
{
    Loginpage product = new Loginpage(driver);

    product.clickViewPost();

    Assert.assertTrue(driver.getCurrentUrl().contains("blog/post?postId=3"),
            "User is redirected to the post page");
}
@Test(priority = 17)
public void testViewAllProducts1()
{
    Loginpage product = new Loginpage(driver);

    product.clickviewAllProducts1();

    Assert.assertTrue(driver.getCurrentUrl().contains("catalog"),
            "User is redirected to the post page");
}
}
