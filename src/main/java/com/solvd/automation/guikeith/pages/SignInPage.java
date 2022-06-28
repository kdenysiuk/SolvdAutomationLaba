package com.solvd.automation.guikeith.pages;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.StringGenerator;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends AbstractPage {

    @FindBy(id = "email")
    private ExtendedWebElement emailField;

    @FindBy(id = "passwd")
    private ExtendedWebElement passwordField;

    @FindBy(id = "SubmitLogin")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//*[@name = 'email_create']")
    private ExtendedWebElement emailCreateField;

    @FindBy(xpath = "//button[@name = 'SubmitCreate']")
    private ExtendedWebElement createAccountButton;

    public SignInPage(WebDriver driver) {
        super(driver);
        setPageURL("index.php");
    }

    public void fillEmailField(String email) {
        emailField.type(email);
    }

    public void fillPasswordField(String password) {
        passwordField.type(password);
    }

    public void completeFields(){
        fillEmailField(R.TESTDATA.get("user_email"));
        fillPasswordField(R.TESTDATA.get("user_pass"));
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public CreateAccountPage createAnAccount(){
        emailCreateField.type(StringGenerator.generateEmail());
        createAccountButton.click();
        return new CreateAccountPage(driver);
    }
}
