package ui.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import ui.driver.DriverSingleton;
import ui.trading.TradingPage;
import ui.utils.LoadHelper;

public class TradingPageSteps {

    public WebDriver driver;

    public TradingPageSteps() {
        this.driver = DriverSingleton.getDriver();
    }

    public void openTradingPage() {
        TradingPage page = new TradingPage();
        Wait<WebDriver> wait = LoadHelper.wait10seconds();
        page.getTradingURL()
                .closeCookieModal(wait);
    }

    public void openWebPlatform() {
        TradingPage page = new TradingPage();
        Wait<WebDriver> wait = LoadHelper.wait10seconds();
        page.getWebPlatformURL()
                .closeCookieModal(wait);
    }
}
