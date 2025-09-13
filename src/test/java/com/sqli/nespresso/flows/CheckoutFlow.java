package com.sqli.nespresso.flows;

import org.openqa.selenium.WebDriver;

import com.sqli.nespresso.pages.ProductListingPage;

public class CheckoutFlow {

    WebDriver driver;

    public CheckoutFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void checkout(String productName, int qty) {
        ProductListingPage plp = new ProductListingPage(driver);
        plp.clickAddToCart(productName);
        plp.addProductToCart(productName, qty);
        plp.openCart();
    }

}
