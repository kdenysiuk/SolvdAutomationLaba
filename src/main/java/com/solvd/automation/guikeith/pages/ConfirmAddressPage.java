package com.solvd.automation.guikeith.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ConfirmAddressPage extends AbstractPage {

    @FindBy(xpath = "//button[@name = 'processAddress']")
    private ExtendedWebElement proceedToCheckoutButton;

    public ConfirmAddressPage(WebDriver driver) {
        super(driver);
        setPageURL("index.php?controller=order&step=1");
    }

    public ShippingPage clickProceedToCheckoutButton(){
        proceedToCheckoutButton.click();
        return new ShippingPage(driver);
    }

}
