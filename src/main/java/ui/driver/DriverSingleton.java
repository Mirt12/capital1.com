package ui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverSingleton {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            // Режим работы
            options.addArguments("--headless=new");

            // Стабильность в контейнерах (CI/CD)
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");

            // Параметры окна для скриншотов
            options.addArguments("--window-size=1920,1080");

            // Игнорирование проблем с сертификатами (если тестовый стенд self-signed)
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        }
        return driver;
    }

    public DriverSingleton() {
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
