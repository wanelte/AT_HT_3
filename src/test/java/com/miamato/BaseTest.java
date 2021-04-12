package com.miamato;

import com.miamato.listeners.TestReporter;
import com.miamato.listeners.TestResultsListener;
import com.miamato.pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

@Listeners({TestResultsListener.class, TestReporter.class})
public abstract class BaseTest {

    public static final Logger assertLogger = LogManager.getLogger("Assert");
    static final String CHROME_DRIVER_PATH = "drivers/windows/chromedriver.exe";
    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected HomePage homePage;
    protected SearchResultsPage searchResultsPage;
    protected CartPage cartPage;
    protected AfterAddingToCartPage afterAddingToCartPage;
    protected CurrencySettingPage currencySettingPage;
    protected ProductPage productPage;
    protected PropertyManager propertyManager;

    public WebElement waitForElementToBePresent(WebElement webElement, long seconds) {
        return new WebDriverWait(driver, seconds)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public WebElement waitForElementToBePresentFluent(WebElement webElement, long timeoutSeconds, long intervalSeconds) {
        return new WebDriverWait(driver, timeoutSeconds, intervalSeconds * 1000)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    @Parameters({"testDataFileName"})
    @BeforeClass
    public void setup(@Optional("default.properties") String testDataFileName) {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=9225");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        propertyManager = new PropertyManager(testDataFileName);
        softAssert = new SoftAssert();

        homePage = new HomePage(driver, propertyManager);
        searchResultsPage = new SearchResultsPage(driver, propertyManager);
        afterAddingToCartPage = new AfterAddingToCartPage(driver, propertyManager);
        cartPage = new CartPage(driver, propertyManager);
        currencySettingPage = new CurrencySettingPage(driver, propertyManager);
        productPage = new ProductPage(driver, propertyManager);
    }

    @AfterMethod
    public void browserReset() {
        driver.manage().deleteAllCookies();

    }

    @AfterClass
    public void cleanUp() {
        driver.quit();
    }
}
