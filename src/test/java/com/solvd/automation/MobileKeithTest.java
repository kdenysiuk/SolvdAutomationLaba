package com.solvd.automation;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.automation.mobile.guiKeith.pages.common.CalculatorPageBase;
import com.solvd.automation.mobile.guiKeith.pages.common.SendFeedbackPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileKeithTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "Keith_Denysiuk")
    public void testAdditionOperation(){
        CalculatorPageBase calculatorPage = initPage(CalculatorPageBase.class);
        Assert.assertTrue(calculatorPage.isPageOpened(), "The page is not opened");
        calculatorPage.clickEightButton();
        calculatorPage.clickAdditionButton();
        calculatorPage.clickEightButton();
        calculatorPage.clickEqualButton();
        Assert.assertEquals(calculatorPage.getFinalResult(), R.TESTDATA.get("final_result"));
    }

    @Test()
    @MethodOwner(owner = "Keith_Denysiuk")
    public void testSendFeedback(){
        CalculatorPageBase calculatorPage = initPage(CalculatorPageBase.class);
        Assert.assertTrue(calculatorPage.isPageOpened(), "The page is not opened");
        calculatorPage.clickMoreOptionsButton();
        SendFeedbackPageBase sendFeedbackPage = calculatorPage.clickSendFeedbackButton();
        Assert.assertTrue(sendFeedbackPage.isPageOpened(), "The page is not opened");
        sendFeedbackPage.typeMessageField(R.TESTDATA.get("feedback_message"));
        sendFeedbackPage.clickSendMessageButton();
        Assert.assertTrue(calculatorPage.isPageOpened(), "The page is not opened");
    }
}
