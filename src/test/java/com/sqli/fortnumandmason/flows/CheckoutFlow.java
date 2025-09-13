package com.sqli.fortnumandmason.flows;

import org.openqa.selenium.WebDriver;

import com.sqli.fortnumandmason.pages.CheckoutPage;
import com.sqli.fortnumandmason.pages.ProductListingPage;

public class CheckoutFlow {

    private WebDriver driver;

    public CheckoutFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void checkout(String productName) {
        ProductListingPage plp = new ProductListingPage(driver);
        plp.addProductToCart(productName);
        plp.viewBag();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkout();
    }

}
