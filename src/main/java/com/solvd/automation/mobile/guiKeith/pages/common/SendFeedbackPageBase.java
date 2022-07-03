package com.solvd.automation.mobile.guiKeith.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SendFeedbackPageBase extends AbstractPage {

    public SendFeedbackPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeMessageField(String message);

    public abstract void clickSendMessageButton();
}
