package com.miamato.pages;
import com.miamato.PropertyManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends BasePage {

    private static final Logger logger = LogManager.getLogger(HomePage.class.getSimpleName());
    private final String HOME_PAGE_URL = propertyManager.getProperty("homepage.url");
    public final String PAGE_TITLE = propertyManager.getProperty("homepage.title");

    public HomePage(WebDriver driver, PropertyManager propertyManager){
        super(driver, propertyManager);
    }

    @Step("Open application home page")
    public HomePage open(){
        logger.info("Trying to open application home page");
        driver.navigate().to(HOME_PAGE_URL);
        return this;
    }

    @Step("Search for a product with name: {itemName}")
    public HomePage searchByName(String itemName){
        logger.info("Performing search for product with name: " + itemName);
        searchField.sendKeys(itemName);
        clickOnElement(searchButton, logger);
        return this;
    }
}
