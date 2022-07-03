package com.solvd.automation.mobile.guiKeith.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.solvd.automation.mobile.guiKeith.pages.common.SendFeedbackPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SendFeedbackPageBase.class)
public class SendFeedbackPage extends SendFeedbackPageBase {

    public SendFeedbackPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeMessageField(String message) {
        System.out.println("not implemented in iOS");
    }

    @Override
    public void clickSendMessageButton() {
        System.out.println("not implemented in iOS");
    }
}
