package com.miamato;

import org.testng.annotations.Test;

public class RemoveItemFromCartTest extends BaseTest {
    static final String SEARCH_TERM = "bible";

    @Test
    public void removeFromCartTest() {
        homePage.open()
                .searchByName(SEARCH_TERM);
        waitForElementToBePresentFluent(searchResultsPage.searchedProductOnSecondPosition, 15, 1).click();
        waitForElementToBePresentFluent(productPage.addToCartButton, 20, 1);
        productPage.addToCart();
        softAssert.assertTrue(afterAddingToCartPage.cartIconWithOneItem.isDisplayed());
        waitForElementToBePresentFluent(afterAddingToCartPage.goToCartButton, 15, 1).click();
        waitForElementToBePresentFluent(cartPage.deleteButton, 15, 1).click();
        softAssert.assertEquals(cartPage.checkCartIconCount(assertLogger), 0);
        softAssert.assertAll();
    }
}
