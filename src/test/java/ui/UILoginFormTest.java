package ui;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class UILoginFormTest {

    ChromeOptions options = new ChromeOptions();

    @Test
    public void isHomePageLoaded(){
        options.addArguments("--incognito");
        options.addArguments("--disable-cache");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://capital.com");
        //fluent Wait- Set up:
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoring(NoSuchElementException.class);
    }
}
