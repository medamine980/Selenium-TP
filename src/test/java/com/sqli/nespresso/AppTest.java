package com.sqli.nespresso;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sqli.nespresso.factories.DriverFactory;
import com.sqli.nespresso.pages.ProfilePage;

public class AppTest {

    static WebDriver driver;
    static WebDriverWait wait;
    static ApplicationFacade app;

    static final long IMPLICIT_WAIT_IN_SECONDS = 4;

    @BeforeClass
    public static void init() {
        driver = DriverFactory.createFirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_IN_SECONDS));
        wait = new WebDriverWait(driver, Duration.ofSeconds(IMPLICIT_WAIT_IN_SECONDS));
        app = new ApplicationFacade(driver);
    }

    @Test
    public void testLogin() {
        driver.get("https://www.nespresso.com/ma/fr/");
        String email = "mexito8889@certve.com";
        String password = "Mexito123*";
        ProfilePage profilePage = app.login(email, password);
        assertTrue(profilePage.getTitle().toUpperCase().equals("MON COMPTE"));
    }

    @Test
    public void testCheckoutLoginRedirection() {
        driver.get("https://www.nespresso.com/ma/fr/coffee-capsules/original.html");
        String productName = "Assortiment Ristretto 200 capsules";
        int qty = 20;
        String expectedUrl = "https://www.nespresso.com/ma/fr/customer/account/login";
        app.checkout(productName, qty);
        wait.until(ExpectedConditions.urlContains(expectedUrl));
        assertTrue(driver.getCurrentUrl().contains(expectedUrl));
    }

    @AfterClass
    public static void clear() {
        driver.quit();
    }

}
