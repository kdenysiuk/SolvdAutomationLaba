package com.solvd.automation.mobile.guiKeith.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.automation.mobile.guiKeith.pages.common.CalculatorPageBase;
import com.solvd.automation.mobile.guiKeith.pages.common.SendFeedbackPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CalculatorPageBase.class)
public class CalculatorPage extends CalculatorPageBase {

//    @FindBy(xpath = "")
//    private ExtendedWebElement wholeScreen;

    @FindBy(xpath = "//*[@content-desc='More options']")
    private ExtendedWebElement moreOptionsButton;

    @FindBy(xpath = "//*[@text = 'Send feedback']")
    private ExtendedWebElement sendFeedbackButton;

    @FindBy(xpath = "//*[contains(@resource-id, 'id/digit_8')]")
    private ExtendedWebElement eightButton;

    @FindBy(xpath = "//*[contains(@resource-id, 'id/op_add')]")
    private ExtendedWebElement additionButton;

    @FindBy(xpath = "//*[contains(@resource-id, 'id/eq')]")
    private ExtendedWebElement equalButton;

    @FindBy(xpath = "//*[contains(@resource-id, 'id/result_final')]")
    private ExtendedWebElement finalResult;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(){
        return moreOptionsButton.isElementPresent();
    }

    @Override
    public void clickEightButton() {
        eightButton.click();
    }

    @Override
    public void clickAdditionButton() {
        additionButton.click();
    }

    @Override
    public void clickEqualButton() {
        equalButton.click();
    }

    @Override
    public void clickMoreOptionsButton() {
        moreOptionsButton.click();
    }

    @Override
    public SendFeedbackPageBase clickSendFeedbackButton() {
        sendFeedbackButton.click();
        return initPage(SendFeedbackPageBase.class);
    }

    @Override
    public String getFinalResult() {
        return finalResult.getText();
    }
}
