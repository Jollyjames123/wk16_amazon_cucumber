package com.amazon.pages;

import com.amazon.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy (xpath = "//input[@id='twotabsearchtextbox']")
    WebElement searchBox;
    @CacheLookup
    @FindBy (xpath = "//input[@id='nav-search-submit-button']")
    WebElement submitButton;

    public void enterNameInSearchBox(String name){
        pmSendTextToElement(searchBox,name);
        log.info("Entering data in the search box :" + name + "<br>");
    }

    public void clickOnSubmitButton(){
        pmClickOnElement(submitButton);
        log.info("Clicking on the button :" + submitButton.toString() + "<br>");
    }
}
