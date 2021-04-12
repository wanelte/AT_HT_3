package com.miamato.pages;
import com.miamato.PropertyManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(ProductPage.class.getSimpleName());

    @FindBy(xpath = "//input[@data-action='delete']")
    public WebElement deleteButton;

    public CartPage(WebDriver driver, PropertyManager propertyManager){
        super(driver, propertyManager);
    }

    @Step("Remove item from cart")
    public CartPage removeFromCart() {
        clickOnElement(deleteButton, logger);
        return this;
    }
}
