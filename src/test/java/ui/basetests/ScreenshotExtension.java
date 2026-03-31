package ui.basetests;

import io.qameta.allure.Allure; // Для метода Allure.addAttachment
import org.junit.jupiter.api.extension.ExtensionContext; // JUnit 5
import org.junit.jupiter.api.extension.TestWatcher; // JUnit 5
import org.openqa.selenium.OutputType; // Selenium
import org.openqa.selenium.TakesScreenshot; // Selenium
import ui.driver.DriverSingleton;

import java.io.ByteArrayInputStream; // Java стандарт

public class ScreenshotExtension implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        // Просто берем драйвер из синглтона
        byte[] screenshot = ((TakesScreenshot) DriverSingleton.getDriver())
                .getScreenshotAs(OutputType.BYTES);

        // Прикрепляем к отчету
        Allure.addAttachment("Screenshot on Failure", new ByteArrayInputStream(screenshot));
    }
}
