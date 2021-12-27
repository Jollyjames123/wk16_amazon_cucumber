package com.amazon.cucumber.steps;

import com.amazon.pages.CartPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.ProductPage;
import com.amazon.pages.ProductsResultPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LaptopTestStepDefs {
    @When("^User search for \"([^\"]*)\" in the search bar$")
    public void userSearchForInTheSearchBar(String name) {
        new HomePage().enterNameInSearchBox(name);
    }

    @Given("^User is on amazon homepage$")
    public void userIsOnAmazonHomepage() {
    }

    @And("^User clicks on the search button$")
    public void userClicksOnTheSearchButton() {
        new HomePage().clickOnSubmitButton();
    }

    @And("^User finds and clicks on the selection \"([^\"]*)\"$")
    public void userFindsAndClicksOnTheSelection(String productName) throws InterruptedException {
        new ProductsResultPage().findProduct(productName);
    }

    @And("^selects the quantity \"([^\"]*)\"$")
    public void selectsTheQuantity(String qty) {
        new ProductPage().selectProductQty(qty);
    }

    @And("^clicks on the add to cart button$")
    public void clicksOnTheAddToCartButton() {
        new ProductPage().addProductToCart();
    }

    @Then("^User is able to verify \"([^\"]*)\" message$")
    public void userIsAbleToVerifyMessage(String expectedMessage) throws InterruptedException {
        new CartPage().verifyingAddedToCartMessage(expectedMessage);
    }
}
