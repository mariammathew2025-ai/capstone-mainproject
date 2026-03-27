package testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.CartPage;
import utils.BaseClass;

public class Cartpagetest extends BaseClass {

    @Test(priority = 1)
    public void verifyCartHappyFlow() {

        CartPage cart = new CartPage(driver);

        // Step 1: Open Catalog
        cart.openCatalog();

        // Step 2: Select Product
        cart.selectProduct();

        // Step 3: Add to Cart
        cart.addTocart();

        // Step 4: Open Cart
        cart.openCart();
        // Step 5: Validation
        Assert.assertTrue(cart.isProductAddedToCart(), "Product not added to cart");
    }
    @Test(priority = 2)
    public void testRemoveProductFromCart() {


        CartPage cart = new CartPage(driver);
        cart.openCatalog();
        cart.selectProduct();
        cart.addTocart();
        cart.openCart();

        cart.removeProduct();

        Assert.assertTrue(cart.isCartEmpty(),
                "Cart is not empty after removing product");
    }


}