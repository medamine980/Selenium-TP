package com.sqli.fortnumandmason.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(css = "[aria-label='Login & My Account']")
    WebElement loginPopupBtn;

    @FindBy(css = "[name=email]")
    WebElement emailInput;

    @FindBy(css = "[name=password]")
    WebElement passwordInput;

    @FindBy(css = "button[type=submit]")
    WebElement loginBtn;

    @FindBy(css = ".p-toast-message [class*=richContent]")
    WebElement flashMessage;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickLoginPopUp() {
        loginPopupBtn.click();
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

    public String getLoginFlashMessage() {
        return flashMessage.getText().trim();
    }
}
