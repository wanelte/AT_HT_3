package com.miamato;

import org.testng.annotations.Test;

public class AmazonTitleTest extends BaseTest {
    public final String PAGE_TITLE = propertyManager.getProperty("homepage.title");

    @Test
    public void verifyAmazonPageTitle() {
        homePage.open().checkPageTitle(PAGE_TITLE, assertLogger);
    }
}
