package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

	public class BlogPage {

	    private WebDriver driver;
	    private WebDriverWait wait;

	    private By blogPosts = By.xpath("//div[contains(@class,'blog')]");
	    private By firstBlog = By.xpath("(//div[contains(@class,'blog')])[1]");
	    private By blogTitle = By.xpath("//h1");
	    private By blogContent = By.xpath("//p");
	    private By blogImages = By.xpath("//img");
	    private By viewPosts=By.xpath("//div[4]//a[2]");

	    public BlogPage(WebDriver driver) {
	        this.driver = driver;
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    public void openBlogPage() {
	        driver.get("https://ginandjuice.shop/blog");
	    }

	    public boolean areBlogPostsDisplayed() {
	        List<WebElement> posts = wait.until(
	                ExpectedConditions.visibilityOfAllElementsLocatedBy(blogPosts));
	        return posts.size() > 0;
	    }

	    public void clickFirstBlogPost() {
	        wait.until(ExpectedConditions.elementToBeClickable(firstBlog)).click();
	    }

	    public boolean isBlogTitleDisplayed() {
	        return wait.until(
	                ExpectedConditions.visibilityOfElementLocated(blogTitle)).isDisplayed();
	    }

	    public boolean isBlogContentDisplayed() {
	        return wait.until(
	                ExpectedConditions.visibilityOfElementLocated(blogContent)).isDisplayed();
	    }

	    public boolean areImagesDisplayed() {
	        return wait.until(
	                ExpectedConditions.visibilityOfAllElementsLocatedBy(blogImages)).size() > 0;
	    }
	    public void openInvalidBlogPage()
	    {
	        driver.get("https://ginandjuice.shop/blog/invalid");
	    }
	}