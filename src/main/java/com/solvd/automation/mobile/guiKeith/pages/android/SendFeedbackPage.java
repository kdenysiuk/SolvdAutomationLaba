package com.solvd.automation.mobile.guiKeith.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.automation.mobile.guiKeith.pages.common.SendFeedbackPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SendFeedbackPageBase.class)
public class SendFeedbackPage extends SendFeedbackPageBase {

    @FindBy(xpath = "//*[contains(@resource-id, 'id/gf_issue_description')]")
    private ExtendedWebElement messageField;

    @FindBy(xpath = "//*[contains(@resource-id, 'id/common_send')]")
    private ExtendedWebElement sendButton;

    public SendFeedbackPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(){
        return sendButton.isElementPresent();
    }
    @Override
    public void typeMessageField(String message) {
        messageField.click();
        messageField.type(message);
    }

    @Override
    public void clickSendMessageButton() {
        sendButton.click();
    }
}
