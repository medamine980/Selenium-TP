package com.sqli.fortnumandmason.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    @FindBy(xpath = "//*[contains(text(), 'Proceed to Checkout')]")
    WebElement checkoutBtn;

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void checkout() {
        checkoutBtn.click();
    }
}
