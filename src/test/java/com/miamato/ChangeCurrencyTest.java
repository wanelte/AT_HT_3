package com.miamato;
import org.testng.annotations.Test;
import org.testng.Assert;

public class ChangeCurrencyTest extends BaseTest {

    @Test
    public void changeCurrencyToEuroTest() {
        homePage.open().clickOnElement(homePage.flagIcon, assertLogger);
        currencySettingPage.unfoldList()
                .chooseEurCurrency()
                .saveChanges();
        homePage.clickOnElement(homePage.flagIcon, assertLogger);
        Assert.assertTrue(currencySettingPage.eurCurrencyList.isDisplayed());
    }
}
