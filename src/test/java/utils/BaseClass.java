package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
	protected WebDriver driver;
  @BeforeMethod
  public void setup()
  {
	  driver=new ChromeDriver();
	 // driver1=new EdgeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://ginandjuice.shop/");
	  
  }
@AfterMethod
public void teardown()
{
  driver.quit();
}
}
