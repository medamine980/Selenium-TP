package com.sqli.nespresso.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(css = "#header-login-link")
    WebElement loginBtnPopup;

    @FindBy(css = "[name='login[username]']")
    WebElement emailInput;

    @FindBy(css = "[name='login[password]']")
    WebElement passwordInput;

    @FindBy(css = "#send2")
    WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickLoginPopup() {
        loginBtnPopup.click();
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        loginBtn.click();
    }

}
