package com.sqli.fortnumandmason;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sqli.fortnumandmason.factories.DriverFactory;
import com.sqli.fortnumandmason.pages.BasePage;

public class AppTest {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static ApplicationFacade app;

    final static int IMPLICIT_WAIT_IN_MILLIS = 10000;

    @BeforeClass
    public static void init() {
        driver = DriverFactory.createFirefoxDriver();
        app = new ApplicationFacade(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(IMPLICIT_WAIT_IN_MILLIS));
        driver.get("https://www.fortnumandmason.com/");
        new BasePage(driver).acceptCookiesIfPresent();
        wait = new WebDriverWait(driver, Duration.ofMillis(IMPLICIT_WAIT_IN_MILLIS));
    }

    @Test
    public void testLogin() {
        String email = "mexito8889@certve.com";
        String password = "Mexito123*";
        String flashMessage = app.login(email, password);
        assertTrue(flashMessage.equals("You are logged in!"));
    }

    @Test
    public void testCheckoutRedirection() {
        driver.get("https://www.fortnumandmason.com/seasonal-events/halloween-event/chocolate-confectionery");
        String productName = "Halloween Sweet Mix, 250g";
        String expectedUrl = "https://www.fortnumandmason.com/checkout/login";
        app.checkout(productName);
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        assertTrue(driver.getCurrentUrl().equals(expectedUrl));
    }

    @AfterClass
    public static void clear() {
        driver.quit();
    }

}
