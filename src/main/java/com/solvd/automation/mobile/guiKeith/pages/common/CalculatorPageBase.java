package com.solvd.automation.mobile.guiKeith.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CalculatorPageBase extends AbstractPage {

    public CalculatorPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickEightButton();

    public abstract void clickAdditionButton();

    public abstract void clickEqualButton();

    public abstract void clickMoreOptionsButton();

    public abstract SendFeedbackPageBase clickSendFeedbackButton();

    public abstract String getFinalResult();
}
