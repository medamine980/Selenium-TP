package com.sqli.fortnumandmason.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sqli.Utility;

public class ProductListingPage {

    private WebDriver driver;

    @FindBy(css = "#basket-btn span span")
    WebElement itemsNumberInCartPopup;

    @FindBy(css = "#toast-view-bag-and-checkout-button")
    WebElement viewBagBtn;

    public ProductListingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void addProductToCart(String productName) {
        WebElement product = driver.findElement(By.xpath(
                String.format("//a[@data-discover][contains(text(), '%s')]/ancestor::div[@data-sku]", productName)));
        WebElement addToBagBtn = product.findElement(By.cssSelector(".add-basket"));
        Utility.centerElement(driver, addToBagBtn);
        addToBagBtn.click();
    }

    public void viewBag() {
        if (itemsNumberInCartPopup.isDisplayed()) {
            viewBagBtn.click();
        }
    }

}
