package com.sqli.fortnumandmason.flows;

import org.openqa.selenium.WebDriver;

import com.sqli.fortnumandmason.pages.LoginPage;

public class LoginFlow {

    private WebDriver driver;

    public LoginFlow(WebDriver driver) {
        this.driver = driver;
    }

    public String loginAs(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginPopUp();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        return loginPage.getLoginFlashMessage();
    }

}
