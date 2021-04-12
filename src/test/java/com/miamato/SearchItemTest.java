package com.miamato;

import org.testng.annotations.Test;

public class SearchItemTest extends BaseTest {
    static final String SEARCH_TERM = "bible";

    @Test
    public void searchItem() {
        homePage.open()
                .searchByName(SEARCH_TERM);
        softAssert.assertTrue(waitForElementToBePresent(
                searchResultsPage.searchedProductResultBar, 20).isDisplayed());
        softAssert.assertAll();
    }
}
