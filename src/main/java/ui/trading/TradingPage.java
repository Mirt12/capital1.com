package ui.trading;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import ui.driver.DriverSingleton;

import java.util.function.Function;

public class TradingPage {
    private WebDriver driver;
    private String baseUrl = "https://capital.com";
    private String tradingUrlEn = "https://capital.com/en-eu/ways-to-trade";
    private String createAccountBtnLocator = "//button[@data-type='background_banner_block_btn1_signup']";
    private String tryDemoAccountBtnLocator = "//button[@data-type='background_banner_block_btn2_demo']";
    private String rejectCookieBtnLocator = "//button[@id='onetrust-reject-all-handler']";
    public static final String pageHeaderLocator ="//h2[text()='Key differences']";
    public static final String expectedHeaderText = "Key differences";
    public static final String waysToTradeHeaderLocator ="//h1[text()='Ways to trade']";
    public static final String expectedWaysToTradeHeaderText = "Ways to trade";
    public static final String createAccountBtnLocatorOfWaysToTradeBanner ="//button[text()='Create account']";
    public static final String expectedTextOfCreateAccountBannerBtnLocator = "Create account";

    public static final String signUpHeaderLocator ="//span[text()='Sign up']";
    public static final String expectedTextOfsignUpHeader = "Sign up";


    public TradingPage() {
        this.driver = DriverSingleton.getDriver();
    }

    public TradingPage getBaseURL() {
        driver.get(baseUrl);
        return this;
    }

    public TradingPage getTradingURL() {
        driver.get(tradingUrlEn);
        return this;
    }

    public TradingPage closeCookieModal(Wait wait) {
        WebElement btn = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(rejectCookieBtnLocator));
            }
        });
        btn.click();
        return this;
    }


}




