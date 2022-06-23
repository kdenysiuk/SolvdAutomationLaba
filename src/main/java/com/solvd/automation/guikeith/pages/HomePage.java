package com.solvd.automation.guikeith.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.automation.guikeith.components.NavigateMenu;
import com.solvd.automation.guikeith.components.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//*[@class=\"nav\"]")
    private NavigateMenu navigateMenu;

    @FindBy(xpath = "//*[@name = \"search_query\"]")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//*[@name = \"submit_search\"]")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//*[@title = \"View my shopping cart\"]")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//*[@id = \"homefeatured\"]//div[@class=\"product-container\"]")
    private List<Product> popularProducts;

    @FindBy(xpath = "//*[@id = \"blockbestsellers\"]//div[@class=\"product-container\"]")
    private List<Product> bestSellerProducts;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePagePresent(){
        return searchButton.isElementPresent();
    }

    public NavigateMenu getNavigateMenu() {
        return navigateMenu;
    }
}
