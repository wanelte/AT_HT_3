package com.miamato;

import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {
    static final String SEARCH_TERM = "bible";

    @Test
    public void addToCartTest() {
        homePage.open()
                .searchByName(SEARCH_TERM);
        waitForElementToBePresentFluent(searchResultsPage.searchedProductOnSecondPosition, 15, 1).click();
        waitForElementToBePresentFluent(productPage.addToCartButton, 20, 1);
        productPage.addToCart();
        softAssert.assertTrue(afterAddingToCartPage.cartIconWithOneItem.isDisplayed());
        softAssert.assertAll();
    }
}
