package com.solvd.automation.guikeith.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.automation.guikeith.pages.SignInPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NavigateMenu extends AbstractUIObject {

    @FindBy(xpath = "//*[@title = \"Log in to your customer account\"]")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//*[@title = \"Contact Us\"]")
    private ExtendedWebElement contactUsButton;

    @FindBy(xpath = "//*[@title = \"View my customer account\"]")
    private ExtendedWebElement accountUserButton;

    @FindBy(xpath = "//*[@title = \"Log me out\"]")
    private ExtendedWebElement signOutButton;

    public NavigateMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SignInPage clickSignInButton(){
        signInButton.click();
        return new SignInPage(driver);
    }

    public boolean isItSignedIn(){
        return accountUserButton.isElementPresent();
    }
}
