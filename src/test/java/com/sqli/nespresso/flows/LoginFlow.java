package com.sqli.nespresso.flows;

import org.openqa.selenium.WebDriver;

import com.sqli.Utility;
import com.sqli.nespresso.pages.LoginPage;
import com.sqli.nespresso.pages.ProfilePage;

public class LoginFlow {

    WebDriver driver;

    public LoginFlow(WebDriver driver) {
        this.driver = driver;
    }

    public ProfilePage loginAs(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        Utility.sleepThread(3000); // j'ai ajouter cette ligne car Nespresso prend un peu de temps avant d'ajouter
                                   // le js eventlistener au bouton de PopUp
        loginPage.clickLoginPopup();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        return new ProfilePage(driver);
    }

}
