package com.amazon.pages;

import com.amazon.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends Utility {
    private static final Logger log = LogManager.getLogger(ProductPage.class.getName());

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//select[@id='quantity']")
    WebElement productQty;
    @CacheLookup
    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    WebElement addToCartButton;

    public void selectProductQty(String qty) {
        pmSelectByVisibleTextFromDropDown(productQty, qty);
        log.info("Selecting the quantity: " + qty);

    }

    public void addProductToCart() {
        pmClickOnElement(addToCartButton);
        log.info("Clicking on add to cart button: " + addToCartButton.toString());
    }

}
