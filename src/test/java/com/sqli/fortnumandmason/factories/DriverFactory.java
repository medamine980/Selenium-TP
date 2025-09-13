package com.sqli.fortnumandmason.factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class DriverFactory {

    public static WebDriver createChromeDriver() {
        WebDriver rawDriver = new ChromeDriver();

        return decorateDriver(rawDriver);
    }

    public static WebDriver createFirefoxDriver() {
        WebDriver rawDriver = new FirefoxDriver();

        return decorateDriver(rawDriver);
    }

    private static WebDriver decorateDriver(WebDriver rawDriver) {

        WebDriver decorated = new EventFiringDecorator<WebDriver>().decorate(rawDriver);

        return decorated;
    }

}
