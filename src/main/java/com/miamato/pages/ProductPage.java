package com.miamato.pages;
import com.miamato.PropertyManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(ProductPage.class.getSimpleName());

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    public WebElement addToCartButton;

    public ProductPage(WebDriver driver, PropertyManager propertyManager){
        super(driver, propertyManager);
    }
    @Step("Add product to cart")
    public ProductPage addToCart() {
        clickOnElement(addToCartButton, logger);
        return this;
    }

}
