package com.solvd.automation.guikeith.pages;

import com.qaprosoft.carina.core.foundation.utils.StringGenerator;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends AbstractPage {

    @FindBy(css = "#id_gender1")
    private ExtendedWebElement mrButton;

    @FindBy(css = "#id_gender2")
    private ExtendedWebElement mrsButton;

    @FindBy(css = "#customer_firstname")
    private ExtendedWebElement firstNameField;

    @FindBy(css = "#customer_lastname")
    private ExtendedWebElement lastNameField;

    @FindBy(css = "#email")
    private ExtendedWebElement emailField;

    @FindBy(css = "#passwd")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//*[@id='days']/option[2]")
    private ExtendedWebElement daysSelectorButton;

    @FindBy(xpath = "//*[@id='months']/option[2]")
    private ExtendedWebElement monthsSelectorButton;

    @FindBy(xpath = "//*[@id='years']/option[2]")
    private ExtendedWebElement yearsSelectorButton;

    @FindBy(css = "#firstname")
    private ExtendedWebElement addressFirstNameField;

    @FindBy(css = "#lastname")
    private ExtendedWebElement addressLastNameField;

    @FindBy(css = "#company")
    private ExtendedWebElement companyField;

    @FindBy(css = "#address1")
    private ExtendedWebElement addressField;

    @FindBy(css = "#address2")
    private ExtendedWebElement address2Field;

    @FindBy(css = "#city")
    private ExtendedWebElement cityField;

    @FindBy(xpath = "//*[@id='id_state']/option[2]")
    private ExtendedWebElement stateSelectorButton;

    @FindBy(css = "#postcode")
    private ExtendedWebElement zipField;

    @FindBy(xpath = "//*[@id='id_country']/option[2]")
    private ExtendedWebElement countrySelectorButton;

    @FindBy(css = "#other")
    private ExtendedWebElement additionalInformationField;

    @FindBy(css = "#phone")
    private ExtendedWebElement homePhoneField;

    @FindBy(css = "#phone_mobile")
    private ExtendedWebElement phoneField;

    @FindBy(css = "#alias")
    private ExtendedWebElement addressAliasField;

    @FindBy(css = "#submitAccount")
    private ExtendedWebElement registerButton;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        setPageURL("index.php?controller=authentication&back=my-account#account-creation");
    }

    public void clickMrButton(){
        mrButton.click();
    }

    public void clickMrsButton(){
        mrsButton.click();
    }
    public void completeFields(){
        String randomName = StringGenerator.generateWord(8);
        String randomLastName = StringGenerator.generateWord(8);
        firstNameField.type(randomName);
        lastNameField.type(randomLastName);
        emailField.type(StringGenerator.generateEmail());
        passwordField.type(StringGenerator.generateWord(8));
        daysSelectorButton.click();
        monthsSelectorButton.click();
        yearsSelectorButton.click();
        addressFirstNameField.type(randomName);
        addressLastNameField.type(randomLastName);
        companyField.type(StringGenerator.generateWord(8));
        addressField.type(StringGenerator.generateWord(8));
        address2Field.type(StringGenerator.generateWord(8));
        cityField.type(StringGenerator.generateWord(8));
        stateSelectorButton.click();
        zipField.type(StringGenerator.generateNumeric(5));
        countrySelectorButton.click();
        additionalInformationField.type(StringGenerator.generateWord(80));
        homePhoneField.type(StringGenerator.generateNumeric(10));
        phoneField.type(StringGenerator.generateNumeric(10));
        addressAliasField.type(randomName + " home");
        registerButton.click();
    }
}
