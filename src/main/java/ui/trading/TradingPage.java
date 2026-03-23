package ui.trading;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import ui.driver.DriverSingleton;

import java.util.function.Function;

public class TradingPage {
    public WebDriver driver;
    private String baseUrl = "https://capital.com";
    private String tradingUrlEn = "https://capital.com/en-eu/ways-to-trade";
    private String rejectCookieBtnLocator = "//button[@id='onetrust-reject-all-handler']";
    public static final String pageHeaderLocator = "//h2[text()='Key differences']";
    public static final String expectedHeaderText = "Key differences";
    public static final String waysToTradeHeaderLocator = "//h1[text()='Ways to trade']";
    public static final String expectedWaysToTradeHeaderText = "Ways to trade";
    public static final String createAccountBtnLocatorOfWaysToTradeBanner = "//button[@data-type='background_banner_block_btn1_signup']";
    public static final String expectedTextOfCreateAccountBannerBtnLocator = "Create account";
    public static final String signUpHeaderLocator = "//span[text()='Sign up']";
    public static final String expectedTextOfsignUpHeader = "Sign up";
    public static final String loginFormLocator = "//div [@class='EshS']//button[@data-type='btn_header_login']";
    public static final String emailInputLocator = "//input[@aria-label='email']";
    public static final String passwordInputLocator = "//input[@aria-label='password']";
    public static final String submitLoginBtnLocator = "//button[@type='submit']";
    public static final String loginGreetingsLocator = "//trade-topbar//div[@class=\"col market\"]";
    public static final String loginGreetingsText = "Market";
    public static final String capitalLogoLocator = "//a[@class='logo direction-ltr logo--capital']";
    public static final String tradingLinkLocator = "//a[@class='js-analyticsClick AMZV' and contains(text(),'Trading')]";
    public static final String goToLocalSiteLBtnLocator = "//button[@data-type='wrong_location_apply']";
    public static final String tryDemoAccountBtnLocator = "//button[@data-type='background_banner_block_btn2_demo']";
    public static final String expectedTextOfTryDemoAccountBtn = "Try demo account";
    public static final String mobileAppMenuItemLocator = "//h2[@class='wdEe IeiA' and contains(text(),'Mobile app')]";
    public static final String webPlatformMenuItemLocator = "//h2[@class='wdEe IeiA' and contains(text(),'Web platform')]";
    public static final String expectedTextMobileApp = "Mobile app";
    public static final String expectedTextWebPlatform = "Web platform";
    public static final String learnMoreLinkOfWebPlatformMenuItemLocator = "//a[@data-type='cross_promo_block_btn1' and contains(text(),'Learn more')]";
    public static final String expectedTextOfLearnMoreLinkOfWebPlatform = "Learn more";


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

    public TradingPage clickAuthorizationLink(Wait wait) {
        WebElement authorizationLink = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(loginFormLocator));
            }
        });
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", authorizationLink);
        return this;
    }

    public TradingPage fillInputFieldEmail(Wait wait, String email) {
        WebElement inputEmail = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(emailInputLocator));
            }
        });
        inputEmail.sendKeys(email);
        return this;
    }

    public TradingPage fillInputFieldPassword(String password) {
        WebElement inputPassword = driver.findElement(By.xpath(passwordInputLocator));
        inputPassword.sendKeys(password);
        return this;
    }

    public TradingPage clickSubmitButtonOfLoginForm() {
        WebElement btn = driver.findElement(By.xpath(submitLoginBtnLocator));
        btn.click();
        return this;
    }

    public TradingPage clickLogo(Wait wait) {
        WebElement logoLink = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(capitalLogoLocator));
            }
        });
        logoLink.click();
        return this;
    }

    public TradingPage clickTradingLink(Wait wait) {
        WebElement tradingLink = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(tradingLinkLocator));
            }
        });
        tradingLink.click();
        return this;
    }


    public TradingPage closeLocationModal(Wait wait) {
        WebElement btn = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(goToLocalSiteLBtnLocator));
            }
        });
        btn.click();
        return this;
    }

    public TradingPage clickTryDemoAccountBtn(Wait wait) {
        WebElement btn = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(tryDemoAccountBtnLocator));
            }
        });
        btn.click();
        return this;
    }

}






