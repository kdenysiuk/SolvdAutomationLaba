package com.solvd.automation.utilskeith;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.solvd.automation.guikeith.components.NavigateMenu;
import com.solvd.automation.guikeith.pages.HomePage;
import com.solvd.automation.guikeith.pages.SignInPage;

public class AuthService implements IDriverPool {

    public void login(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        NavigateMenu navigateMenu = homePage.getNavigateMenu();
        SignInPage signInPage = navigateMenu.clickSignInButton();
        signInPage.completeFields();
        signInPage.clickSignInButton();
    }
}
