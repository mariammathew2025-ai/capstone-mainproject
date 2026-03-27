package testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.BlogPage;
import utils.BaseClass;

public class Blogpagetest extends BaseClass
{
	 @Test(priority = 1)
	public void testOpenBlogPage() {

	    BlogPage blog = new BlogPage(driver);
	    blog.openBlogPage();

	    Assert.assertTrue(driver.getCurrentUrl().contains("blog"),
	            "Blog page not opened");
	}
	@Test(priority = 2)
	public void testBlogPostsDisplayed() {

	    BlogPage blog = new BlogPage(driver);
	    blog.openBlogPage();

	    Assert.assertTrue(blog.areBlogPostsDisplayed(),
	            "No blog posts displayed");
	}
	@Test(priority = 3)
	public void testClickBlogPost() {

	    BlogPage blog = new BlogPage(driver);
	    blog.openBlogPage();

	    blog.clickFirstBlogPost();

	    Assert.assertTrue(blog.isBlogContentDisplayed(),
	            "Blog content not displayed");
	}
	@Test(priority = 4)
	public void testBlogDetails() {

	    BlogPage blog = new BlogPage(driver);
	    blog.openBlogPage();

	    blog.clickFirstBlogPost();

	    Assert.assertTrue(blog.isBlogTitleDisplayed(),
	            "Blog title not displayed");

	    Assert.assertTrue(blog.isBlogContentDisplayed(),
	            "Blog content not displayed");
	}
	@Test(priority = 5)
	public void testBlogImagesDisplayed() {

	    BlogPage blog = new BlogPage(driver);
	    blog.openBlogPage();

	    Assert.assertTrue(blog.areImagesDisplayed(),
	            "Blog images not displayed");
	}
	@Test(priority = 6)
	public void testNavigateBackToBlogList() {

	    BlogPage blog = new BlogPage(driver);
	    blog.openBlogPage();

	    blog.clickFirstBlogPost();
	    driver.navigate().back();

	    Assert.assertTrue(blog.areBlogPostsDisplayed(),
	            "Failed to return to blog list");
	}
	
	@Test(priority = 7)
	public void testInvalidBlogURL() 
	{
		  BlogPage blog = new BlogPage(driver);
    blog.openInvalidBlogPage();
	    Assert.assertTrue(driver.getPageSource().contains("something went wrong!")
	            ,"404 page not displayed");
	}
}
