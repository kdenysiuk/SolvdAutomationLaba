package com.solvd.automation.guikeith.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ShippingPage extends AbstractPage {

    @FindBy(css = "#cgv")
    private ExtendedWebElement termsOfServiceCheckbox;

    @FindBy(xpath = "//button[@name = 'processCarrier']")
    private ExtendedWebElement proceedToCheckoutButton;

    public ShippingPage(WebDriver driver) {
        super(driver);
        setPageURL("index.php?controller=order");
    }

    public void clickCheckbox(){
        termsOfServiceCheckbox.click();
    }

    public PaymentPage clickProceedToCheckoutButton(){
        proceedToCheckoutButton.click();
        return new PaymentPage(driver);
    }

}
