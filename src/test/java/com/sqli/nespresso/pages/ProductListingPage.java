package com.sqli.nespresso.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sqli.Utility;

public class ProductListingPage {

    WebDriver driver;

    @FindBy(css = ".tocart[type='submit']")
    WebElement addToCartBtn;

    @FindBy(css = "a.showcart")
    WebElement cartBtn;

    @FindBy(css = ".counter-number")
    WebElement cartCounterNumber;

    @FindBy(css = "#top-cart-btn-checkout")
    WebElement commandBtn;

    WebDriverWait wait;

    public ProductListingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickAddToCart(String productName) {
        WebElement add2 = driver.findElement(By.xpath(
                String.format(
                        "//a[@class='product-item-link'][contains(text(), '%s')]//ancestor::li[contains(@class, 'product-item')]//button[contains(@class, 'tocart')]",
                        productName)));
        add2.click();

        // addToCartBtn.click();
    }

    public void addProductToCart(String productName, int qty) {
        WebElement product = driver.findElement(
                By.xpath(String.format(
                        "//a[@class='product-item-link'][contains(text(), '%s')]//ancestor::li[contains(@class, 'product-item')]",
                        productName)));
        Utility.centerElement(driver, product);
        if (qty > 15) {
            WebElement qtyInput = product.findElement(By.cssSelector(".qty-selector-input"));
            WebElement okBtn = product.findElement(By.cssSelector(".qty-selector-btn"));
            qtyInput.sendKeys(Integer.toString(qty));
            okBtn.click();
        } else {
            WebElement qtyBtn = product.findElement(By.cssSelector(String.format("[data-qtyitem='%d']", qty)));
            Utility.centerElement(driver, qtyBtn);
            qtyBtn.click();
        }
    }

    public void openCart() {
        wait.until(ExpectedConditions.visibilityOf(cartCounterNumber));
        cartBtn.click();
    }

    public void command() {
        wait.until(ExpectedConditions.visibilityOf(commandBtn));
        commandBtn.click();
    }

}
