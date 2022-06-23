package com.solvd.automation;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.automation.guikeith.components.NavigateMenu;
import com.solvd.automation.guikeith.pages.HomePage;
import com.solvd.automation.guikeith.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebKeithTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "Keith_Denysiuk")
    public void testSignIn(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isHomePagePresent(), "Home Page is not open");
        NavigateMenu navigateMenu = homePage.getNavigateMenu();
        SignInPage signInPage = navigateMenu.clickSignInButton();
        Assert.assertTrue(signInPage.isSignInPagePresent(), "Sign In Page is not open");
        signInPage.fillEmailField(R.TESTDATA.get("user_email"));
        signInPage.fillPasswordField(R.TESTDATA.get("user_pass"));
        signInPage.clickSignInButton();
        Assert.assertTrue(navigateMenu.isItSignedIn(), "There is no a signed in account");
    }
}
