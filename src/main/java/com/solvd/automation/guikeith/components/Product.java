package com.solvd.automation.guikeith.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.automation.guikeith.pages.ProductPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Product extends AbstractUIObject {

    @FindBy(xpath = ".//a[@class = 'product-name']")
    private ExtendedWebElement productTitle;

    @FindBy(xpath = ".//div[@class = 'right-block']//span[@itemprop = 'price']")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = ".//a[@title = 'Add to cart']")
    private ExtendedWebElement addToCartButton;

    public Product(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public String getPrice() {
        return productPrice.getText();
    }

    public ProductPage clickProductTitle(){
        productTitle.click();
        return new ProductPage(driver);
    }
}
