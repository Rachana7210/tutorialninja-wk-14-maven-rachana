package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Desktops extends Utility {

    By currencyLink = By.xpath("//span[contains(text(),'Currency')]");
    // Click on £ Pound Sterling
    By clickOnShowAllDeskTop = By.xpath("//a[contains(text(),'Show All Desktops')]");
    By sortByNameZtoA = By.id("input-sort");
    By clickOnHpLp3065 = By.xpath("//a[contains(text(),'HP LP3065')]");
    By verifyText = By.xpath("//h1[contains(text(),'HP LP3065')]");
    // By deliveryDate = By.xpath("//div[@class = 'input-group date']//button");
    By selectQuantity = By.name("quantity");
    By addToCart = By.xpath("//button[@id='button-cart']");
    By verifyTextHplp3065 = By.xpath("//h1[contains(text(),'HP LP3065')]");

    By clickShoppingCart = By.xpath("//button[@id='button-cart']");
    By verifyShoppingCart = By.xpath("//div[@id='content']//h1");
    By verifyHPlp3065 = By.xpath("//h1[contains(text(),'HP LP3065')]");
    By verifyDate = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]");
    By verifyModel = By.xpath("//li[contains(text(),'Product Code: Product 21')]");


    public void clickOnCurrencyLink() {
       clickOnElement(currencyLink);
    }
    public void clickOnAllDesktop() {
        clickOnElement(clickOnShowAllDeskTop);
    }
    public void SortByNameZtoAFromDropdown() {
        sendTextToElement(sortByNameZtoA, "Name (Z - A)");
    }
    public void clickOnHPlp3065() {
        clickOnElement(clickOnHpLp3065);
    }

    public String getVerifyText() {
        return getTextFromElement(verifyText);
    }

    //public void selectDeliveryDate() {
    //clickOnElement(deliveryDate);

    public void changeQuantity(String quantity) {
        sendTextToElement(selectQuantity, quantity);
    }
    public void clickOnAdToCart() {
        clickOnElement(addToCart);
    }
    public String getVerifyTextHp() {
        return getTextFromElement(verifyTextHplp3065);
    }
    //SelectDate
    public void selectDeliveryDate(){
        //select delivery date
        String year = "2022";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        //desktops.selectDeliveryDate();
        //clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnShoppingCart() {
        clickOnElement(clickShoppingCart);
    }

    public String getVerifyShoppingCart() {
        return getTextFromElement(verifyShoppingCart);
    }

    public String getVerifyProductName() {
        return getTextFromElement(verifyHPlp3065);
    }

    public String getVerifyDeliveryDate() {
        return getTextFromElement(verifyDate);
    }

    public String getVerifyModel() {
        return getTextFromElement(verifyModel);
    }
    By verifyTotal = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");
    public String getVerifyTotal() {
        return getTextFromElement(verifyTotal);
    }
    public void verifyZtoAForDropDown(){
        // Get all the products name and stored into array list
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
        // Select sort by Name Z - A
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");
        // After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);
        //Assert.assertEquals("Product not sorted into Z to A order",
        //  originalProductsName, afterSortByZToAProductsName);
    }
}
