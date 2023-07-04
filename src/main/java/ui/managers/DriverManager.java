package ui.managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null) driver = createDriver();
        return driver;
    }

    private static ChromeOptions setBasicChromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.managed_default_content_settings.ads", 1);
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--whitelisted-ips");
        chromeOptions.addArguments("--user-agent='Mozilla/5.0 (X11; Linux x86_64) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36");
        return chromeOptions;
    }

    private static WebDriver setChromeDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = setBasicChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--window-size=1920,1080");
        return new ChromeDriver(chromeOptions);
    }

    public static WebDriver createDriver() {
        return driver = setChromeDriver();
    }

    public static void quitDriver() {
        driver.close();
        driver.quit();
    }
}
