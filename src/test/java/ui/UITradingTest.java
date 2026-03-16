package ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.basetests.BaseTest;
import ui.steps.TradingPageSteps;
import ui.trading.TradingPage;
import ui.utils.LoadHelper;

import java.io.UnsupportedEncodingException;

public class UITradingTest extends BaseTest {

    @Test
    public void userCanOpenTradingPage() throws UnsupportedEncodingException, InterruptedException {
        TradingPageSteps tradingPageSteps = new TradingPageSteps();
        tradingPageSteps.openTradingPage();
        String actualText = LoadHelper.getTextByLocator(TradingPage.pageHeaderLocator);
        Assertions.assertEquals(TradingPage.expectedHeaderText, actualText);
    }

    @Test
    public void userSeesWaysToTradeBanner() throws UnsupportedEncodingException, InterruptedException {
        TradingPageSteps tradingPageSteps = new TradingPageSteps();
        tradingPageSteps.openTradingPage();
        String actualText = LoadHelper.getTextByLocator(TradingPage.waysToTradeHeaderLocator);
        Assertions.assertEquals(TradingPage.expectedWaysToTradeHeaderText, actualText);
    }

    @Test
    public void userSeesCreateAccountBtnOnWaysTradeBanner() throws UnsupportedEncodingException, InterruptedException {
        TradingPageSteps tradingPageSteps = new TradingPageSteps();
        tradingPageSteps.openTradingPage();
        String actualText = LoadHelper.getTextByLocator(TradingPage.createAccountBtnLocatorOfWaysToTradeBanner);
        Assertions.assertEquals(TradingPage.expectedTextOfCreateAccountBannerBtnLocator, actualText);

    }

    @Test
    public void createAccountBtnOnWaysTradeBannerWorks() throws UnsupportedEncodingException, InterruptedException {
        TradingPageSteps tradingPageSteps = new TradingPageSteps();
        tradingPageSteps.openTradingPage();
        tradingPageSteps.driver.findElement(By.xpath(TradingPage.createAccountBtnLocatorOfWaysToTradeBanner)).click();
        String actualText = LoadHelper.getTextByLocator(TradingPage.signUpHeaderLocator);
        Assertions.assertEquals(TradingPage.expectedTextOfsignUpHeader, actualText);
    }

}
