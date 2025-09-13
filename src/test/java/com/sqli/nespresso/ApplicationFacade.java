package com.sqli.nespresso;

import org.openqa.selenium.WebDriver;

import com.sqli.nespresso.flows.CheckoutFlow;
import com.sqli.nespresso.flows.LoginFlow;
import com.sqli.nespresso.pages.ProfilePage;

public class ApplicationFacade {

    WebDriver driver;

    public ApplicationFacade(WebDriver driver) {
        this.driver = driver;
    }

    public ProfilePage login(String email, String password) {
        return new LoginFlow(driver).loginAs(email, password);
    }

    public void checkout(String productName, int quantity) {
        new CheckoutFlow(driver).checkout(productName, quantity);
    }

}
