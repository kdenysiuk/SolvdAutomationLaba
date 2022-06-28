package com.solvd.automation.guikeith.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Breadcrumb extends AbstractUIObject {

    @FindBy(xpath = ".//a[@title = 'Return to Home']")
    private ExtendedWebElement homeButton;

    public Breadcrumb(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
