package com.solvd.automation.guikeith.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends AbstractPage {

    @FindBy(xpath = "//input[@id = \"email\"]")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//input[@id = \"passwd\"]")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//button[@id = \"SubmitLogin\"]")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//*[@name = \"email_create\"]")
    private ExtendedWebElement emailCreateField;

    @FindBy(xpath = "//button[@name = \"SubmitCreate\"]")
    private ExtendedWebElement createAccountButton;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSignInPagePresent() {
        return emailCreateField.isElementPresent();
    }

    public void fillEmailField(String email) {
        emailField.type(email);
    }

    public void fillPasswordField(String password) {
        passwordField.type(password);
    }

    public void clickSignInButton() {
        signInButton.click();
    }
}
