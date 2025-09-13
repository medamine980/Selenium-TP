package com.sqli.fortnumandmason.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    @FindBy(css = ".p-dialog-header-close")
    WebElement headerCloseBtn;

    // @FindBy(css = "[data-testid='uc-deny-all-button']")
    // WebElement cookieCloseBtn;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void acceptCookiesIfPresent() {
        try {
            SearchContext shadowRoot = driver.findElement(By.cssSelector("#usercentrics-root")).getShadowRoot();
            WebElement cookieCloseBtn = shadowRoot.findElement(By.cssSelector("[data-testid='uc-deny-all-button']"));
            if (cookieCloseBtn.isDisplayed()) {
                cookieCloseBtn.click();
            }
            if (headerCloseBtn.isDisplayed()) {
                headerCloseBtn.click();
            }
        } catch (TimeoutException e) {
            // No cookie popup → do nothing
        }
    }

}
