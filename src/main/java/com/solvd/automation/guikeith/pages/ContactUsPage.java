package com.solvd.automation.guikeith.pages;

import com.qaprosoft.carina.core.foundation.utils.StringGenerator;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"id_contact\"]/option[2]")
    private ExtendedWebElement subjectHeading;

    @FindBy(css = "#email")
    private ExtendedWebElement emailField;

    @FindBy(css = "#id_order")
    private ExtendedWebElement orderReferenceField;

    @FindBy(css = "#message")
    private ExtendedWebElement messageField;

    @FindBy(css = "#submitMessage")
    private ExtendedWebElement sendButton;

    @FindBy(css = ".alert")
    private ExtendedWebElement confirmationMessage;

    public ContactUsPage(WebDriver driver) {
        super(driver);
        setPageURL("index.php?controller=contact");
    }

    public void completeFields(){
        subjectHeading.click();
        emailField.type(StringGenerator.generateEmail());
        orderReferenceField.type(StringGenerator.generateWord(15));
        messageField.type(StringGenerator.generateWord(200));
        sendButton.click();
    }

    public boolean isMessageSent(){
        return confirmationMessage.isElementPresent();
    }

}
