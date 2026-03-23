package ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ui.basetests.BaseTest;
import ui.steps.AutorizedSteps;
import ui.steps.TradingPageSteps;
import ui.trading.TradingPage;
import ui.utils.LoadHelper;

import java.io.UnsupportedEncodingException;

public class UITradingTest extends BaseTest {

    @Test
    public void userCanOpenTradingPage() throws UnsupportedEncodingException, InterruptedException {
        TradingPageSteps steps = new TradingPageSteps();
        steps.openTradingPage();
        String actualText = LoadHelper.getTextByLocator(TradingPage.pageHeaderLocator);
        Assertions.assertEquals(TradingPage.expectedHeaderText, actualText);
    }

    @Test
    public void userSeesWaysToTradeBanner() throws UnsupportedEncodingException, InterruptedException {
        TradingPageSteps steps = new TradingPageSteps();
        steps.openTradingPage();
        String actualText = LoadHelper.getTextByLocator(TradingPage.waysToTradeHeaderLocator);
        Assertions.assertEquals(TradingPage.expectedWaysToTradeHeaderText, actualText);
    }

    @Test
    public void userSeesCreateAccountBtnOnWaysTradeBanner() throws UnsupportedEncodingException, InterruptedException {
        TradingPageSteps steps = new TradingPageSteps();
        steps.openTradingPage();
        String actualText = LoadHelper.getTextByLocator(TradingPage.createAccountBtnLocatorOfWaysToTradeBanner);
        Assertions.assertEquals(TradingPage.expectedTextOfCreateAccountBannerBtnLocator, actualText);
    }

    @Test
    public void createAccountBtnOnWaysTradeBannerWorks() throws UnsupportedEncodingException, InterruptedException {
        TradingPageSteps steps = new TradingPageSteps();
        steps.openTradingPage();
        steps.driver.findElement(By.xpath(TradingPage.createAccountBtnLocatorOfWaysToTradeBanner)).click();
        String actualText = LoadHelper.getTextByLocator(TradingPage.signUpHeaderLocator);
        Assertions.assertEquals(TradingPage.expectedTextOfsignUpHeader, actualText);
    }

    @Test
    public void userCanLoginFromHomePage() throws UnsupportedEncodingException, InterruptedException {
        AutorizedSteps steps = new AutorizedSteps();
        steps.fillLoginFormAndSubmit("tbalashevich@bk.ru", "PostinG@2579!");
        String actualText = LoadHelper.getTextByLocator(TradingPage.loginGreetingsLocator);
        Assertions.assertEquals(TradingPage.loginGreetingsText, actualText);
    }

//    @Test
//    public void createAccountBtnOnWaysTradeBannerWorksForAuthorizedUser() throws UnsupportedEncodingException, InterruptedException {
//        AutorizedSteps steps = new AutorizedSteps();
//        steps.fillLoginFormAndSubmit("tbalashevich@bk.ru", "PostinG@2579!");
//        //opens unAutorized page (??)
//        TradingPageSteps steps = new TradingPageSteps();
//        steps.openTradingPage();
//        steps.driver.findElement(By.xpath(TradingPage.createAccountBtnLocatorOfWaysToTradeBanner)).click();
//        String actualText = LoadHelper.getTextByLocator(TradingPage.loginGreetingsLocator);
//        Assertions.assertEquals(TradingPage.loginGreetingsText, actualText);
//    }

    @Test
    public void userSeesTryDemoAccountBtn() throws UnsupportedEncodingException, InterruptedException {
        TradingPageSteps steps = new TradingPageSteps();
        steps.openTradingPage();
        String actualBtnText = LoadHelper.getTextByLocator(TradingPage.tryDemoAccountBtnLocator);
        Assertions.assertEquals(TradingPage.expectedTextOfTryDemoAccountBtn, actualBtnText);
    }

    @Test
    public void tryDemoBtnWorks() throws UnsupportedEncodingException, InterruptedException {
        TradingPageSteps steps = new TradingPageSteps();
        steps.openTradingPage();
        steps.driver.findElement(By.xpath(TradingPage.createAccountBtnLocatorOfWaysToTradeBanner)).click();
        String actualText = LoadHelper.getTextByLocator(TradingPage.signUpHeaderLocator);
        Assertions.assertEquals(TradingPage.expectedTextOfsignUpHeader, actualText);
    }



}
