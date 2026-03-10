package ui.basetests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ui.driver.DriverSingleton;

public class BaseTest {

    @BeforeEach
    public void warmUp() {
    }

    @AfterEach
    public void tearDown() {
        DriverSingleton.quit();
    }

}
