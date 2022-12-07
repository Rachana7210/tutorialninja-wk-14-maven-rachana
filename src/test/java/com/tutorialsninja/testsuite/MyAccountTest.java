package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.MyAccount;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTest extends BaseTest {
    MyAccount myAccount = new MyAccount();

    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Register");
        Assert.assertEquals(myAccount.getVerifyRegister(), "Register Account", "Error Message not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Login");
        Assert.assertEquals(myAccount.getVerifyReturning(), "Returning Customer", "Error Message not displayed");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Register");

        myAccount.enterFirstName("prime");
        myAccount.enterLastName("testing");
        myAccount.enterEmailAdd("selenium555@gmail.com");
        myAccount.enterPhone("12345678965");
        myAccount.enterPassword("123456");
        myAccount.enterConfirmPass("123456");

        myAccount.clickYesOnNewsLetter();
        myAccount.clickOnPrivacy();
        myAccount.clickFinalContinue();

        Assert.assertEquals(myAccount.getVerifyMessage(), "Your Account Has Been Created!", "Error Message not displayed");
        myAccount.clickOnContinueButton();

        myAccount.clickOnMyAccountTab();
        myAccount.selectMyAccountOptions("Logout");
        Assert.assertEquals(myAccount.getVerifyLogout(), "Account Logout", "Error Message not displayed");
        myAccount.clickOnContinueTab();
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        myAccount.clickOnMyAccount();
        myAccount.selectMyAccountOptions("Login");

        myAccount.enterEmailAdd("selenium55@gmail.com");
        myAccount.enterPassword("123456");


        myAccount.clickOnMyAccountTab();
        myAccount.selectMyAccountOptions("Logout");
        Assert.assertEquals(myAccount.getVerifyLogout(), "Account Logout", "Error Message not displayed");
        myAccount.clickOnContinueTab();
    }
}
