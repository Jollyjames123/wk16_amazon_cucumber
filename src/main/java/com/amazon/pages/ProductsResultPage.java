package com.amazon.pages;

import com.amazon.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsResultPage extends Utility {
    private static final Logger log = LogManager.getLogger(ProductsResultPage.class.getName());

    public ProductsResultPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
    List<WebElement> productsList;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Next']")
    WebElement nextButton;

    public boolean findProduct(String productName) throws InterruptedException {
        boolean myBreak = true;
        boolean selection = false;
        while (myBreak) {
            for (WebElement e : productsList) {
                if (e.getText().equalsIgnoreCase(productName)) {
                    System.out.println(e.getText());
                    pmClickOnElement(e);
                    selection = true;
                    myBreak = false;
                    break;
                }
            }
            if (myBreak) {
                if (!driver.getCurrentUrl().contains("page=20")) {
                    pmWaitUntilVisibilityOfElementLocated(By.xpath("//a[normalize-space()='Next']"), 100).click();
                } else {
                    selection = false;
                    myBreak = false;
                }
                PageFactory.initElements(driver, this);
                Thread.sleep(5000);
            }
        }
        log.info("Clicking on the product :" + productName);
        return selection;

    }

}
