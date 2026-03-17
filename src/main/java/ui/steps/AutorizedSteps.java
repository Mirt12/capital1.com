package ui.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import ui.driver.DriverSingleton;
import ui.trading.TradingPage;
import ui.utils.LoadHelper;

public class AutorizedSteps {
    public WebDriver driver;

    public AutorizedSteps() {
        this.driver = DriverSingleton.getDriver();
    }

    public void fillLoginFormAndSubmit(String email, String password) {
        TradingPage page = new TradingPage();
        Wait<WebDriver> wait = LoadHelper.wait30seconds();
        page.getBaseURL()
                .closeCookieModal(wait)
                .clickAuthorizationLink(wait)
                .fillInputFieldEmail(wait, email)
                .fillInputFieldPassword(password)
                .clickSubmitButtonOfLoginForm();
    }

    public void authorizedUserGoesToTradingPage(String email, String password) {
        TradingPage page = new TradingPage();
        Wait<WebDriver> wait = LoadHelper.wait30seconds();
        page.getBaseURL()
                .closeCookieModal(wait)
                .clickAuthorizationLink(wait)
                .fillInputFieldEmail(wait, email)
                .fillInputFieldPassword(password)
                .clickSubmitButtonOfLoginForm()
                .clickLogo()
                .clickTradingLink(wait);
    }

}
