package com.miamato.pages;

import com.miamato.PropertyManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v89.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BasePage extends Page {

    protected WebDriver driver;
    protected PropertyManager propertyManager;

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    public WebElement searchField;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    public WebElement searchButton;

    @FindBy(xpath = "//span[@id='nav-cart-count' and text()=1]")
    public WebElement cartIconWithOneItem;

    @FindBy(xpath = "//span[@id='nav-cart-count' and text()=0]")
    public WebElement cartIconWithNoItem;

    @FindBy(xpath = "//span[contains(@class,'icp-nav-flag')]")
    public WebElement flagIcon;

    public BasePage(WebDriver driver, PropertyManager propertyManager){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.propertyManager = propertyManager;
    }

    public void checkPageTitle(String title, Logger logger){
        logger.info("Verifying if page title is equal to: " + title);
        Assert.assertEquals(driver.getTitle(), title);
        logger.info("Page title is correct: \"" + title + "\"");
    }

    public int checkCartIconCount(Logger logger){
        logger.info("Checking numbers of items in cart");
        if (cartIconWithOneItem.isDisplayed()) {
            logger.info("One item in cart");
            return 1;
        }
        else if (cartIconWithNoItem.isDisplayed()) {
            logger.info("Cart is empty");
            return 0;
        }
        else {
            logger.info("Something weird happen");
            return -1;
        }
    }

    public void clickOnElement(WebElement element, Logger logger){
        logger.info("Clicking on element: " + element);
        Actions actions = new Actions(driver);
        actions.click(element).perform();
    }

}
