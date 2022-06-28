package com.solvd.automation.guikeith.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends AbstractPage {

    @FindBy(xpath = "//a[@title = 'Pay by bank wire']")
    private ExtendedWebElement payByBankWireButton;

    @FindBy(xpath = "//p/button[@type = 'submit']")
    private ExtendedWebElement iConfirmMyOrderButton;

    @FindBy(xpath = "//p[@class = 'cheque-indent']")
    private ExtendedWebElement orderConfirmation;

    public PaymentPage(WebDriver driver) {
        super(driver);
        setPageURL("index.php?controller=order&multi-shipping=");
    }

    public void clickPayByBankWireButton(){
        payByBankWireButton.click();
    }

    public void clickIConfirmMyOrderButton(){
        iConfirmMyOrderButton.click();
    }

    public boolean isOrderConfirmed(){
        return orderConfirmation.isElementPresent();
    }
}
