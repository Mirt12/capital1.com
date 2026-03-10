package ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import ui.basetests.BaseTest;
import ui.steps.TradingPageSteps;
import ui.trading.TradingPage;
import ui.utils.LoadHelper;

import java.io.UnsupportedEncodingException;
import java.time.Duration;
import java.util.function.Function;

public class UITradingTest extends BaseTest {

    @Test
    public void userCanOpenTradingPage() throws UnsupportedEncodingException, InterruptedException {
        TradingPageSteps tradingPageSteps = new TradingPageSteps();
        tradingPageSteps.openTradingPage();
        String actualText = LoadHelper.getTextByLocator(TradingPage.pageHeaderLocator);
        Assertions.assertEquals(TradingPage.expectedHeaderText, actualText);
    }


}
