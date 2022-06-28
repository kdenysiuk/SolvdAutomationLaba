package com.solvd.automation.guikeith.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.automation.guikeith.components.ProductPopUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//h1[@itemprop = 'name']")
    private ExtendedWebElement productTitle;

    @FindBy(css = "#short_description_content")
    private ExtendedWebElement productDescription;

    @FindBy(css = "#our_price_display")
    private ExtendedWebElement productPrice;

    @FindBy(id = "add_to_cart")
    private ExtendedWebElement addToCartButton;
    public ProductPage(WebDriver driver) {
        super(driver);
        setPageURL("index.php?id_product=");
    }

    @FindBy(xpath = "//div[@id = 'layer_cart']/div[@class = 'clearfix']")
    private ProductPopUp productPopUp;

    public String getProductTitle(){
        return productTitle.getText();
    }

    public String getProductDescription(){
        return  productDescription.getText();
    }

    public String getProductPrice(){
        return productPrice.getText();
    }

    public ProductPopUp clickAddToCartButton(){
        addToCartButton.click();
        return productPopUp;
    }
}
