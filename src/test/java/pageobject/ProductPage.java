package pageobject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage 
{
	
	private WebDriver driver;
	private WebDriverWait wait;
	private By searchBar=By.xpath("//input[@id='searchBar']");
	private By searchButton=By.xpath("/html/body/div[2]/section/div/section[1]/form/button");
	private By productTitles=By.xpath("//*[@id=\"react-container\"]/div");
	private By productPrices=By.xpath("/html/body/div[2]/section/div/section[3]/a[1]/span[1]");
	private By filterCategoryAll=By.xpath("//a[normalize-space()='Accessories']");
	private By filterCategoryAccessories=By.xpath("//a[@class='filter-category selected']");
	private By filterCategoryAccompaniments=By.xpath("//a[normalize-space()='Accompaniments']");
	private By filterCategoryBooks=By.xpath("//a[normalize-space()='Books']");
	private By filterCategoryGin=By.xpath("//a[normalize-space()='Gin']");
	private By filterCategoryJuice =By.xpath("//*[@id=\"react-container\"]/div/a[6]");
	private By juiceExtractorProduct=By.xpath("//a[4]//span[2]");
	private By productPrice=By.xpath("//span[normalize-space()='$81.46']");
	private By productRating=By.xpath("//span[@class='price-rating']//img");
	private By addToCartButton=By.xpath("//*[@id=\"addToCartForm\"]/button");
	private By cartCount=By.xpath("//select[@name='quantity']");

	public ProductPage(WebDriver driver)
	{
			this.driver=driver;
			wait=new WebDriverWait(driver,Duration.ofSeconds(10));	
	}
	public void openCatalogPage() 
	{
        driver.get("https://ginandjuice.shop/catalog");
    }
		//search product
		 public  void searchForProducts(String productName)
		{
			//driver.findElement(searchBar).sendKeys(productName);
			//wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
			WebElement searchInput = wait.until(
		            ExpectedConditions.visibilityOfElementLocated(searchBar));

		    searchInput.clear();
		    searchInput.sendKeys(productName);

		    wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();	
		
		
	}
		public boolean areProductsDisplayed()
	    {
	        List<WebElement> products = wait.until(
	                ExpectedConditions.visibilityOfAllElementsLocatedBy(productTitles));

	        return products.size() > 0;
	    }
		public void clickSearchWithoutInput() {
		    WebElement searchInput = wait.until(
		            ExpectedConditions.visibilityOfElementLocated(searchBar));

		    searchInput.clear(); // ensure it's empty

		    wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
		}
		public String getSearchValidationMessage() {
		    WebElement searchInput = wait.until(
		            ExpectedConditions.visibilityOfElementLocated(searchBar));

		    return searchInput.getAttribute("validationMessage");
		}
		public void selectAllCategory()
	    {
	        wait.until(ExpectedConditions.elementToBeClickable(filterCategoryAll)).click();
	    }
		public void selectAccessoriesCategory()
	    {
	        wait.until(ExpectedConditions.elementToBeClickable(filterCategoryAccessories)).click();
	    }
		public void selectAccompanimentsCategory()
	    {
	        wait.until(ExpectedConditions.elementToBeClickable(filterCategoryAccompaniments)).click();
	    }
		public void selectBooksCategory()
	    {
	        wait.until(ExpectedConditions.elementToBeClickable(filterCategoryBooks)).click();
	    }
		public void selectGinCategory()
	    {
	        wait.until(ExpectedConditions.elementToBeClickable(filterCategoryGin)).click();
	    }
		// Click Juice filter
	    public void selectJuiceCategory()
	    {
	        wait.until(ExpectedConditions.elementToBeClickable(filterCategoryJuice)).click();
	    }
	    public void clickJuiceExtractor()
	    {
	        WebElement product = wait.until(
	                ExpectedConditions.elementToBeClickable(juiceExtractorProduct));

	        product.click();
	    }
	    public boolean isProductPriceDisplayed()
	    {
	        return wait.until(
	                ExpectedConditions.visibilityOfElementLocated(productPrice)).isDisplayed();
	    }
	    public boolean isRatingDisplayed()
	    {
	        return wait.until(
	                ExpectedConditions.visibilityOfElementLocated(productRating))
	                .isDisplayed();
	    }	
	    public void clickAddToCart()
	    {
	        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
	    }
	    public String getCartCount()
	    {
	        return wait.until(
	                ExpectedConditions.visibilityOfElementLocated(cartCount))
	                .getText();
	    }
	

}