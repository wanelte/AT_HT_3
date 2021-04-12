package com.miamato.pages;
import com.miamato.PropertyManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurrencySettingPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(CurrencySettingPage.class.getSimpleName());

    @FindBy(xpath = "//span[@data-action='a-dropdown-button']")
    public WebElement currencyList;

    @FindBy(xpath = "//a[contains(@data-value,'EUR')]")
    public WebElement eurCurrencyButton;

    @FindBy(xpath = "//span[contains(text(),'EUR') and @class='a-button-text a-declarative']")
    public WebElement eurCurrencyList;

    @FindBy(xpath = "//input[@class='a-button-input']")
    public WebElement saveChangesButton;

    public CurrencySettingPage(WebDriver driver, PropertyManager propertyManager){
        super(driver, propertyManager);
    }
    @Step("Unfold dropdown currency list")
    public CurrencySettingPage unfoldList() {
        clickOnElement(currencyList, logger);
        return this;
    }
    @Step("Choose EUR currency from list")
    public CurrencySettingPage chooseEurCurrency() {
        try {
            clickOnElement(eurCurrencyButton, logger);
        } catch (Exception e) {
            logger.error("Option cannot be selected from dropdown");
            throw e;}
        return this;
    }
    @Step("Confirm changes")
    public CurrencySettingPage saveChanges() {
        clickOnElement(saveChangesButton, logger);
        return this;
    }
}
