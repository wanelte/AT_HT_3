package com.miamato.pages;
import com.miamato.PropertyManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(SearchResultsPage.class.getSimpleName());

    @FindBy(xpath = "//span[@data-component-id='2']//a")
    public WebElement searchedProductOnSecondPosition;

    @FindBy(xpath = "//span[@class='a-color-state a-text-bold']")
    public WebElement searchedProductResultBar;

    public SearchResultsPage(WebDriver driver, PropertyManager propertyManager){
        super(driver, propertyManager);
    }
}
