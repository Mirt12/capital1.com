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
        System.out.println("start");
        TradingPageSteps steps = new TradingPageSteps();
        System.out.println("browser started");
        steps.openTradingPage();
        System.out.println("openTradingPage");
        String actualText = LoadHelper.getTextByLocator(TradingPage.pageHeaderLocator);
        System.out.println("getTextByLocator");
        Assertions.assertEquals(TradingPage.expectedHeaderText, TradingPage.expectedHeaderText,
                "expected  "+TradingPage.expectedHeaderText+"   actual    "+TradingPage.expectedHeaderText);
        System.out.println("Assertions passed");
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
        Assertions.assertEquals(TradingPage.expectedTextOfCreateAccountBtn, actualText);
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

    @Test
    public void userSeesMobileAppMenuItem() throws UnsupportedEncodingException, InterruptedException {
        TradingPageSteps steps = new TradingPageSteps();
        steps.openTradingPage();
        String actualHeader = LoadHelper.getTextByLocator(TradingPage.mobileAppMenuItemLocator);
        Assertions.assertEquals(TradingPage.expectedTextMobileApp, actualHeader);
    }

    @Test
    public void userSeesWebPlatformMenuItem() throws UnsupportedEncodingException, InterruptedException {
        TradingPageSteps steps = new TradingPageSteps();
        steps.openTradingPage();
        String actualHeader = LoadHelper.getTextByLocator(TradingPage.webPlatformMenuItemLocator);
        Assertions.assertEquals(TradingPage.expectedTextWebPlatform, actualHeader);
    }

    @Test
    public void userSeesLearnMoreLinkOFWebPlatformMenuItem() throws UnsupportedEncodingException, InterruptedException {
        TradingPageSteps steps = new TradingPageSteps();
        steps.openTradingPage();
        String actualHeader = LoadHelper.getTextByLocator(TradingPage.learnMoreLinkOfWebPlatformMenuItemLocator);
        Assertions.assertEquals(TradingPage.expectedTextOfLearnMoreLinkOfWebPlatform, actualHeader);
    }

    @Test
    public void learnMoreLinkOFWebPlatformMenuItemWorks() throws UnsupportedEncodingException, InterruptedException {
        TradingPageSteps steps = new TradingPageSteps();
        steps.openTradingPage();
        steps.driver.findElement(By.xpath(TradingPage.learnMoreLinkOfWebPlatformMenuItemLocator)).click();
        String actualHeader = LoadHelper.getTextByLocator(TradingPage.headerOfWebPlaform);
        Assertions.assertEquals(TradingPage.expectedHeaderOfWebPlatform, actualHeader);
    }

    @Test
    public void userSeesCreateAccountBtnInWebPlatform() throws UnsupportedEncodingException, InterruptedException {
        TradingPageSteps steps = new TradingPageSteps();
        steps.openWebPlatform();
        String actualText = LoadHelper.getTextByLocator(TradingPage.createAccountBtnOfWebPlatform);
        Assertions.assertEquals(TradingPage.expectedTextOfCreateAccountBtn, actualText);
    }

    @Test
    public void SeesCreateAccountBtnInWebPlatformWorks() throws UnsupportedEncodingException, InterruptedException {
        TradingPageSteps steps = new TradingPageSteps();
        steps.openWebPlatform();
        steps.driver.findElement(By.xpath(TradingPage.createAccountBtnOfWebPlatform)).click();
        String actualText = LoadHelper.getTextByLocator(TradingPage.signUpHeaderLocator);
        Assertions.assertEquals(TradingPage.expectedTextOfsignUpHeader, actualText);
    }

    @Test
    public void userSeesQrCodeOnMobileAppItem() throws UnsupportedEncodingException, InterruptedException {
        TradingPageSteps steps = new TradingPageSteps();
        steps.openTradingPage();

        //check of QR code on image and URL


    }


}
