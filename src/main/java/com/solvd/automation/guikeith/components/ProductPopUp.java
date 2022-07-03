package com.solvd.automation.guikeith.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.automation.guikeith.pages.CartPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPopUp extends AbstractUIObject {

    @FindBy(css = "#layer_cart_product_title")
    private ExtendedWebElement productTitle;

    @FindBy(css = "#layer_cart_product_price")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = ".//span[@title = 'Continue shopping']")
    private ExtendedWebElement continueShoppingButton;

    @FindBy(xpath = ".//a[@title = 'Proceed to checkout']")
    private ExtendedWebElement proceedToCheckoutButton;

    public ProductPopUp(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductTitle(String title){
        productTitle.assertElementWithTextPresent(title,3);
        return productTitle.getText();
    }

    public String getProductPrice(){
        return productPrice.getText();
    }

    public CartPage clickProceedToCheckoutButton(){
        proceedToCheckoutButton.click();
        return new CartPage(driver);
    }
}
