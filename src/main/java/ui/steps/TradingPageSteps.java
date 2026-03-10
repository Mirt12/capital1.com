package ui.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import ui.driver.DriverSingleton;
import ui.trading.TradingPage;
import ui.utils.LoadHelper;

public class TradingPageSteps {

    WebDriver driver;

    public TradingPageSteps() {
        this.driver = DriverSingleton.getDriver();
    }

    public void openTradingPage() {
        TradingPage page = new TradingPage();
        Wait<WebDriver> wait = LoadHelper.wait30seconds();
        page.getTradingURL()
                .closeCookieModal(wait);
    }


}
