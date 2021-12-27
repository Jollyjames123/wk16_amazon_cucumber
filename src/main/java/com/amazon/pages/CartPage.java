package com.amazon.pages;

import com.amazon.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CartPage extends Utility {
    private static final Logger log = LogManager.getLogger(CartPage.class.getName());

    public CartPage(){
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Added to Cart')]")
    WebElement addedToCartMessage;

    public void verifyingAddedToCartMessage(String expectedMessage) throws InterruptedException {
        String actualMessage = pmGetTextFromElement(addedToCartMessage);
        Thread.sleep(2000);
        pmVerifyElements("Incorrect message", expectedMessage, addedToCartMessage);
        Thread.sleep(5000);
        log.info("Verifying the Message :" + expectedMessage);
    }
}
