package com.solvd.automation.mobile.guiKeith.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.solvd.automation.mobile.guiKeith.pages.common.CalculatorPageBase;
import com.solvd.automation.mobile.guiKeith.pages.common.SendFeedbackPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CalculatorPageBase.class)
public class CalculatorPage extends CalculatorPageBase {

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickEightButton() {
        System.out.println("not implemented in iOS");
    }

    @Override
    public void clickAdditionButton() {
        System.out.println("not implemented in iOS");
    }

    @Override
    public void clickEqualButton() {
        System.out.println("not implemented in iOS");
    }

    @Override
    public void clickMoreOptionsButton() {
        System.out.println("not implemented in iOS");
    }

    @Override
    public SendFeedbackPageBase clickSendFeedbackButton() {
        System.out.println("not implemented in iOS");
        return null;
    }

    @Override
    public String getFinalResult() {
        System.out.println("not implemented in iOS");
        return null;
    }
}
