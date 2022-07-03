package com.solvd.automation;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.automation.guikeith.components.NavigateMenu;
import com.solvd.automation.guikeith.components.ProductPopUp;
import com.solvd.automation.guikeith.pages.*;
import com.solvd.automation.utilskeith.AuthService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebKeithTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "Keith_Denysiuk")
    public void testSignIn(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "The page is not opened");
        NavigateMenu navigateMenu = homePage.getNavigateMenu();
        SignInPage signInPage = navigateMenu.clickSignInButton();
        Assert.assertTrue(signInPage.isPageOpened(), "The page is not opened");
        signInPage.completeFields();
        signInPage.clickSignInButton();
        Assert.assertTrue(navigateMenu.isItSignedIn(), "User not logged");
    }

    @Test()
    @MethodOwner(owner = "Keith_Denysiuk")
    public void testSignUp(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "The page is not opened");
        NavigateMenu navigateMenu = homePage.getNavigateMenu();
        SignInPage signInPage = navigateMenu.clickSignInButton();
        Assert.assertTrue(signInPage.isPageOpened(), "The page is not opened");
        CreateAccountPage createAccountPage = signInPage.createAnAccount();
        Assert.assertTrue(createAccountPage.isPageOpened(), "The page is not opened");
        createAccountPage.completeFields();
        Assert.assertTrue(navigateMenu.isItSignedIn(), "User not logged");
    }

    @Test(dataProvider = "DataProvider")
    @MethodOwner(owner = "Keith_Denysiuk")
    @XlsDataSourceParameters(path = "xls/keithtest.xlsx", sheet = "WebTest", dsUid = "TUID", dsArgs = "title,description,price", testRailColumn = "title")
    public void testCheckProduct(String title, String description, String price){
        new AuthService().login();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "The page is not opened");
        ProductPage productPage = homePage.clickPopularProduct(title);
        Assert.assertTrue(productPage.isPageOpened(), "The page is not opened");
        Assert.assertEquals(productPage.getProductTitle(), title, "Invalid title");
        Assert.assertEquals(productPage.getProductDescription(), description, "Invalid description");
        Assert.assertEquals(productPage.getProductPrice(), price, "Invalid title");
        ProductPopUp productPopUp = productPage.clickAddToCartButton();
        Assert.assertEquals(productPopUp.getProductTitle(title), title, "Invalid title");
        Assert.assertEquals(productPopUp.getProductPrice(), price, "Invalid title");
        CartPage cartPage = productPopUp.clickProceedToCheckoutButton();
        Assert.assertTrue(cartPage.isPageOpened(), "The page is not opened");
        ConfirmAddressPage confirmAddressPage = cartPage.clickProceedToCheckoutButton();
        Assert.assertTrue(confirmAddressPage.isPageOpened(), "The page is not opened");
        ShippingPage shippingPage = confirmAddressPage.clickProceedToCheckoutButton();
        Assert.assertTrue(confirmAddressPage.isPageOpened(), "The page is not opened");
        shippingPage.clickCheckbox();
        PaymentPage paymentPage = shippingPage.clickProceedToCheckoutButton();
        Assert.assertTrue(paymentPage.isPageOpened(), "The page is not opened");
        paymentPage.clickPayByBankWireButton();
        paymentPage.clickIConfirmMyOrderButton();
        Assert.assertTrue(paymentPage.isOrderConfirmed(), "The order is not confirmed");
    }

    @Test()
    @MethodOwner(owner = "Keith_Denysiuk")
    public void testContactUs(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "The page is not opened");
        NavigateMenu navigateMenu = homePage.getNavigateMenu();
        ContactUsPage contactUsPage = navigateMenu.clickContactUsButton();
        Assert.assertTrue(contactUsPage.isPageOpened(), "The page is not opened");
        contactUsPage.completeFields();
        Assert.assertTrue(contactUsPage.isMessageSent(), "The message was not sent");
    }

    @Test()
    @MethodOwner(owner = "Keith_Denysiuk")
    public void testSignOut(){
        new AuthService().login();
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "The page is not opened");
        NavigateMenu navigateMenu = homePage.getNavigateMenu();
        navigateMenu.clickSignOutButton();
        Assert.assertFalse(navigateMenu.isItSignedIn(), "User still logged");
    }
}
