package pageobject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

   private By filterCategoryJuice=By.xpath("//a[@class='filter-category selected']");
   private By product=By.xpath("//h3[normalize-space()='Juice Extractor']");
   private By addToCartButton=By.xpath("//button[normalize-space()='Add to cart']");
   private By cartIcon=By.xpath("//span[normalize-space()='1']");
   private By  productNameInCart=By.xpath("//a[normalize-space()='Juice Extractor']");
   private By cartItems = By.xpath("//div[contains(@class,'cart-item')]");
   private By removeButton = By.xpath("//button[contains(text(),'Remove') or contains(text(),'Delete')]");
   private By emptyCartMessage = By.xpath("//*[contains(text(),'empty') or contains(text(),'Cart is empty')]");
   
   public CartPage(WebDriver driver)
   {
	   this.driver=driver;
	   this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
   }
   public void openCatalog()
   {
	   driver.get("https://ginandjuice.shop/catalog");
   }
   public void selectProduct()
   {
	   wait.until(ExpectedConditions.elementToBeClickable(product)).click();
   }
   public void addTocart()
   {
	   wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
	   wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
   }
   public void openCart()
   {
	   wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
   }
   public boolean isProductAddedToCart() {
	   return wait.until(
		        ExpectedConditions.visibilityOfElementLocated(productNameInCart)
		    ).isDisplayed();
	   
	   
	}
   public void removeProduct() {
       wait.until(ExpectedConditions.elementToBeClickable(removeButton)).click();

       // wait until cart item disappears
       wait.until(ExpectedConditions.invisibilityOfElementLocated(cartItems));
   }
   public boolean isCartEmpty() {
       return wait.until(driver ->
               driver.findElements(cartItems).size() == 0 ||
               driver.findElements(emptyCartMessage).size() > 0
       );
   }


}