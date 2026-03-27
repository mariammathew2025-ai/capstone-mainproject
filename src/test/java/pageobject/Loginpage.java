package pageobject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public  class Loginpage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	private By logo=By.xpath("//div[@class='scanme-logo']");
	private By productlink=By.xpath("//div[@class='title-container']//a[@class='button'][normalize-space()='Products']");
	private By blogLink=By.xpath("//div[@class='title-container']//a[@class='button'][normalize-space()='Blog']");
	private By ourStoryLink=By.xpath("//div[@class='title-container']//a[@class='button'][normalize-space()='Our story']");
	private By accountIcon=By.xpath("//a[@class='account-icon']//*[name()='svg']");
	private By loginIn=By.xpath("//a[normalize-space()='Log in']");
	private By usernameField=By.xpath("//input[@placeholder='Username']");
	private By password=By.xpath("//input[@placeholder='Password']");
	private By loginButton=By.xpath("//button[normalize-space()='Log in']");
	//private By myAccount=By.xpath("//a[normalize-space()='My account']");
	private By myAccount=By.linkText("My account");
	private By cartIcon=By.xpath("//a[@class='cart-icon']//*[name()='svg']");
	private By cartCount=By.xpath("//span[normalize-space()='0']");
	private By header=By.xpath("//h2[normalize-space()='Never miss a deal - subscribe now']");
	private By subscriptionInput=By.name("email");
	private By subscribeButton=By.xpath("//*[@id=\"subscribe\"]/button");
	private By couponDialog=By.xpath("//h2[normalize-space()='Never miss a deal - subscribe now']");
	private By couponInfo=By.className("coupon-info");
	private By emptyEmailSubscription=By.xpath("//*[@id=\"subscribe\"]/input[1]");
	private By viewAllProducts=By.xpath("//a[@class='viewProductsButton']");
	private By viewAllProducts1=By.xpath("//section[@id='productsPreview']//a[normalize-space()='View all products']");
	private By viewAllBlog=By.xpath("//a[normalize-space()='View all blog posts']");
	private By viewPost=By.xpath("//div[@class='blogPostList']//div[1]//a[2]");
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	public void clickLogo()
	{
		driver.findElement(logo).click();
		
	}
public void clickProducts()
{
	driver.findElement(productlink).click();
}
      public  void clickBlog() 
      {
	driver.findElement(blogLink).click();
}
      public void clickOurStory()
      {
    	  driver.findElement(ourStoryLink).click();
      }
      public void clickAccountIcon()
      {
    	  //driver.findElement(accountIcon).click();
    	  wait.until(ExpectedConditions.elementToBeClickable(accountIcon)).click();
      }
      public void clickLogIn()
      {
    	// driver.findElement(loginIn).click();
    	  wait.until(ExpectedConditions.elementToBeClickable(loginIn)).click();
      }
      public void enterUsername(String username)
      {
          driver.findElement(usernameField).sendKeys(username);
      }
      public void enterPassword(String pass)
      {
          //password).sendKeys(pass);
    	 wait.until(ExpectedConditions.presenceOfElementLocated(password)).sendKeys(pass);
    	  
      }

      public void clickLoginButton()
      {
          //((WebElement) loginButton).click();
    	  wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
      }
      
      public void clickMyAccount()
      {
    	  //driver.findElement(myAccount).click();
    	  //wait.until(ExpectedConditions.elementToBeClickable(myAccount)).click();
    	  WebElement account = wait.until(ExpectedConditions.visibilityOfElementLocated(accountIcon));
    	    Actions actions = new Actions(driver);
    	    actions.moveToElement(account).click().perform();
      }
      public void clickCartIcon()
      {
    	  //driver.findElement(cartIcon).click();
    	  wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
      }
      public String getCartCount()
      {
    	  return driver.findElement(cartCount).getText();
      }
      public String getHeaderText() 
      {
    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	    return 
    	    		wait.until(ExpectedConditions.visibilityOfElementLocated(header)).getText();
    	}
public void subscribeWithEmail(String email) 
{
    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	    WebElement emailInput = wait.until(
    	            ExpectedConditions.visibilityOfElementLocated(subscriptionInput));

    	    emailInput.sendKeys(email);

    	    driver.findElement(subscribeButton).click();
    	}

    	public boolean isCouponDialogDisplayed() 
    	{
    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	    return wait.until(ExpectedConditions.visibilityOfElementLocated(couponDialog)).isDisplayed();
    	}

    	public String getCouponInfoText()
    	{
    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	    return wait.until(ExpectedConditions.visibilityOfElementLocated(couponInfo)).getText();
    	}
		public String getEmailValidationMessage() {
			// TODO Auto-generated method stub
			driver.findElement(subscribeButton).click();
			String validationmsg="Please fill in this field";
			return validationmsg;
			
		}
		public void clickViewAllProducts()
		{
		    wait.until(ExpectedConditions.elementToBeClickable(viewAllProducts)).click();
		}
		
		public void clickViewAllBlog()
		{
		    wait.until(ExpectedConditions.elementToBeClickable(viewAllBlog)).click();
		}
		
		public void clickViewPost()
		{
		    wait.until(ExpectedConditions.elementToBeClickable(viewPost)).click();
		}
		public void clickviewAllProducts1()
		{
		    wait.until(ExpectedConditions.elementToBeClickable(viewAllProducts1)).click();
		}
		

		
}