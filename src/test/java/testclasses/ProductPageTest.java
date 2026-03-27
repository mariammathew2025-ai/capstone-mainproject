package testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.ProductPage;
import utils.BaseClass;

public class ProductPageTest extends BaseClass {
	
	@Test(priority=1)
	public void testOpenCatalogPage() {
	    ProductPage product = new ProductPage(driver);

	    product.openCatalogPage();

	    Assert.assertTrue(driver.getCurrentUrl().contains("catalog"),
	            "Catalog page not opened");
	}
	
	@Test(priority=2)
	public void testSearchProduct()
	{
	
       ProductPage product = new ProductPage(driver);
       product.openCatalogPage();

	    product.searchForProducts("juice");

	    Assert.assertTrue(product.areProductsDisplayed(),
	            "Products should appear after search");
	}
	@Test(priority=3)
	public void testFilterAllCategory()
	{
	  

	    ProductPage product = new ProductPage(driver);
	    product.openCatalogPage();

	    product.selectAllCategory();

	    Assert.assertTrue(product.areProductsDisplayed(),
	            "all products not displayed");
	}
	@Test(priority=4)
	public void testAccessoriesCategory()
	{
	  

	    ProductPage product = new ProductPage(driver);
	    product.openCatalogPage();

	    product.selectAccessoriesCategory();

	    Assert.assertTrue(product.areProductsDisplayed(),
	            "Accessories products not displayed");
	}
	@Test(priority=5)
	public void testAccompanimentsCategory()
	{
	  

	    ProductPage product = new ProductPage(driver);
	    product.openCatalogPage();

	    product.selectAccompanimentsCategory();

	    Assert.assertTrue(product.areProductsDisplayed(),
	            "Accompaniments products not displayed");
	}
	@Test(priority=6)
	public void testBooksCategory()
	{
	  

	    ProductPage product = new ProductPage(driver);
	    product.openCatalogPage();

	    product.selectBooksCategory();

	    Assert.assertTrue(product.areProductsDisplayed(),
	            "Books products not displayed");
	}
	@Test(priority=7)
	public void testGinCategory()
	{
	  

	    ProductPage product = new ProductPage(driver);
	    product.openCatalogPage();

	    product.selectGinCategory();

	    Assert.assertTrue(product.areProductsDisplayed(),
	            "Gin products not displayed");
	}
	@Test(priority=8)
	public void testFilterJuiceCategory()
	{
	  

	    ProductPage product = new ProductPage(driver);
	    product.openCatalogPage();

	    product.selectJuiceCategory();

	    Assert.assertTrue(product.areProductsDisplayed(),
	            "Juice products not displayed");
	}
	@Test(priority=9)
	public void testEmptySearchClick() {

	    ProductPage product = new ProductPage(driver);

	    product.openCatalogPage();

	    // Click search without entering anything
	    product.clickSearchWithoutInput();

	    // Capture validation message
	    String message = product.getSearchValidationMessage();

	    System.out.println("Validation Message: " + message);

	    Assert.assertTrue(driver.getCurrentUrl().contains("catalog"),
	            "Page navigated unexpectedly on empty search");
	}
	@Test(priority=10)
	
	public void testSelectJuiceExtractorProduct()
	{
	    ProductPage product = new ProductPage(driver);

	    product.openCatalogPage();  
	    product.clickJuiceExtractor();

	    Assert.assertTrue(product.isProductPriceDisplayed(),
	            "Product detail page is not displayed");
	}	
}
	