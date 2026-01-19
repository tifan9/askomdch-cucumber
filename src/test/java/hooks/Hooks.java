package hooks;

import factory.DriverFactory;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private WebDriver driver;
    @Before
    public void before(){
        driver = DriverFactory.getDriver();
    }
    @After
    public void after(){
        driver = DriverFactory.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}

