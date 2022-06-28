package com.solvd.automation.guikeith.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {

    @FindBy(xpath = "//p/a[@title = 'Proceed to checkout']")
    private ExtendedWebElement proceedToCheckoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageURL("index.php?controller=order");
    }

    public ConfirmAddressPage clickProceedToCheckoutButton(){
        proceedToCheckoutButton.click();
        return new ConfirmAddressPage(driver);
    }
}
