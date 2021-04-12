package com.miamato.pages;
import com.miamato.PropertyManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AfterAddingToCartPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(AfterAddingToCartPage.class.getSimpleName());

    @FindBy(xpath = "//a[@id='hlb-view-cart-announce']")
    public WebElement goToCartButton;

    public AfterAddingToCartPage(WebDriver driver, PropertyManager propertyManager){
        super(driver, propertyManager);
    }

    @Step("Go to cart")
    public AfterAddingToCartPage goToCart() {
        clickOnElement(goToCartButton, logger);
        return this;
    }
}
