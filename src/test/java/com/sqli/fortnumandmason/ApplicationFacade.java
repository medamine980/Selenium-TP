package com.sqli.fortnumandmason;

import org.openqa.selenium.WebDriver;

import com.sqli.fortnumandmason.flows.CheckoutFlow;
import com.sqli.fortnumandmason.flows.LoginFlow;

public class ApplicationFacade {

    private WebDriver driver;

    public ApplicationFacade(WebDriver driver) {
        this.driver = driver;
    }

    public String login(String email, String password) {
        return new LoginFlow(driver).loginAs(email, password);
    }

    public void checkout(String productName) {
        new CheckoutFlow(driver).checkout(productName);
    }

}
