package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.LaptopAndNotebooks;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaptopsAndNotebooksTest extends BaseTest {
    LaptopAndNotebooks laptopAndNotebooks = new LaptopAndNotebooks();

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully () {

        laptopAndNotebooks.clickOnLaptopLink();
        laptopAndNotebooks.clickOnAllLaptopAndNotebooksLink();
        laptopAndNotebooks.shortPriceLowToHigh();
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully () {
        laptopAndNotebooks.changeCurrency();
        laptopAndNotebooks.clickOnLaptopLink();
        laptopAndNotebooks.clickOnAllLaptopAndNotebooksLink();
        laptopAndNotebooks.sortByPriceHighToLowFromDropdown();
        laptopAndNotebooks.clickOnMacbookLink();
        Assert.assertEquals(laptopAndNotebooks.getVerifyMacbook(), "MacBook", "Error Message not displayed");
        laptopAndNotebooks.clickOnAddToCart();
        Assert.assertEquals(laptopAndNotebooks.getVerifySuccess(), "Success: You have added MacBook to your shopping cart!\n" +
                "×", "Error Message not displayed");
        laptopAndNotebooks.clickOnShoppingCart();
        Assert.assertEquals(laptopAndNotebooks.getVerifyCart(), "shopping cart", "Error Message not displayed");
        Assert.assertEquals(laptopAndNotebooks.getVerifyProductMacbook(), "MacBook", "Error Message not displayed");

        Actions actions1 = new Actions(driver);
        WebElement quantity = driver.findElement(By.xpath("//input[contains(@name, 'quantity')]"));
        quantity.clear();

        sendTextToElement(By.xpath("//input[contains(@name, 'quantity')]"), "2");
        laptopAndNotebooks.clickOnUpdateCart();

        Assert.assertEquals(laptopAndNotebooks.getVerifyCarttext(), "Success: You have added MacBook to your shopping cart!\n" +
                "×", "Error Message not displayed");
        Assert.assertEquals(laptopAndNotebooks.getVerifyTotal(), "2 item(s) - £737.45", "Error Message not displayed");

        laptopAndNotebooks.clickOnCheckoutCart();
        laptopAndNotebooks.clickOnFinalCheckout();

        Assert.assertEquals(laptopAndNotebooks.getVerifyCheckout(), "Checkout", "Error Message not displayed");
        Assert.assertEquals(laptopAndNotebooks.getVerifyNewCustomer(), "New Customer", "Error Message not displayed");

        laptopAndNotebooks.clickOnGuestCheckout();
        laptopAndNotebooks.clickOnContinueTab();
        laptopAndNotebooks.enterName("Prime");
        laptopAndNotebooks.enterLastName("testing");
        laptopAndNotebooks.enterEmail("prime1246@gmail.com");
        laptopAndNotebooks.enterTelephone("123456789012");
        laptopAndNotebooks.enterAddress("selenium");
        laptopAndNotebooks.enterCity("adtala");
        laptopAndNotebooks.enterPostcode("365430");
        laptopAndNotebooks.enterCountry("India");
        laptopAndNotebooks.enterState("Gujarat");

        laptopAndNotebooks.clickOnCheckout();
        laptopAndNotebooks.enterText("thanks");

        laptopAndNotebooks.clickOnTerms();
        laptopAndNotebooks.clickContinue();

        Assert.assertEquals(laptopAndNotebooks.getVerifyWarningMsg(), "Warning: Payment method required!\n" +
                "×", "Error Message not displayed");

    }
}
