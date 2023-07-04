package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import ui.managers.DriverManager;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    private WebDriver driver;

    @Before("@ui")
    public void setUpUi() {
        driver = DriverManager.createDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.navigate().to("http://www.uitestingplayground.com");
    }

    @After("@ui")
    public void tearsDown() {
        DriverManager.quitDriver();
    }
}
