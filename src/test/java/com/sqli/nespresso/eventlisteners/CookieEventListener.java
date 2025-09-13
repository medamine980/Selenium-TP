package com.sqli.nespresso.eventlisteners;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.support.events.WebDriverListener;

import com.sqli.Utility;

public class CookieEventListener implements WebDriverListener {

    boolean clicked = false;

    @Override
    public void beforeClick(WebElement element) {
        try {
            if (clicked)
                return;
            WebDriver driver = ((WrapsDriver) element).getWrappedDriver();
            WebElement cookieBtn = driver.findElement(By.cssSelector("#onetrust-reject-all-handler"));
            if (cookieBtn.isDisplayed()) {
                cookieBtn.click();
                clicked = true;
                Utility.sleepThread(3000);
            }
        } catch (NoSuchElementException ignored) {
        }
    }

}
