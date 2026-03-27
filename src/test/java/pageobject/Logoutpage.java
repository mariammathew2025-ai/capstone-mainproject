package pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logoutpage 
{
	private WebDriver driver;
	private WebDriverWait wait;
	private By usernameField=By.xpath("//input[@placeholder='Username']");
	private By password=By.xpath("//input[@placeholder='Password']");
	private By loginButton=By.xpath("//button[normalize-space()='Log in']");
	private By logOutButton=By.xpath("//a[normalize-space()='Log out']");
	private By loginButtonAfterLogout=By.xpath("//a[normalize-space()='Log in']");

        public Logoutpage (WebDriver driver)
{
	this.driver=driver;
	wait=new WebDriverWait(driver,Duration.ofSeconds(10));
}
        public void openLoginPage()
        {
        	driver.get("https://ginandjuice.shop/my-account/");
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
public void clickLogout() {
    wait.until(ExpectedConditions.elementToBeClickable(logOutButton)).click();
}

public boolean isLoginButtonDisplayed() {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonAfterLogout)).isDisplayed();
}
}

