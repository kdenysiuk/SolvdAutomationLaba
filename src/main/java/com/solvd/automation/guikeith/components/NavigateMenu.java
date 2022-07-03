package com.solvd.automation.guikeith.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.automation.guikeith.pages.ContactUsPage;
import com.solvd.automation.guikeith.pages.SignInPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NavigateMenu extends AbstractUIObject {

    @FindBy(xpath = ".//a[@title = 'Log in to your customer account']")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = ".//a[@title = 'Contact Us']")
    private ExtendedWebElement contactUsButton;

    @FindBy(xpath = ".//a[@title = 'View my customer account']")
    private ExtendedWebElement accountUserButton;

    @FindBy(xpath = ".//a[@title = 'Log me out']")
    private ExtendedWebElement signOutButton;

    public NavigateMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SignInPage clickSignInButton(){
        signInButton.click();
        return new SignInPage(driver);
    }

    public boolean isItSignedIn(){
        return accountUserButton.isElementPresent(3);
    }

    public ContactUsPage clickContactUsButton(){
        contactUsButton.click();
        return new ContactUsPage(driver);
    }

    public void clickSignOutButton(){
        signOutButton.click();
    }
}
