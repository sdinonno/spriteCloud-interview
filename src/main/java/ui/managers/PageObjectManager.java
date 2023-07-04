package ui.managers;

import org.openqa.selenium.WebDriver;
import ui.pages.HomePage;
import ui.pages.SampleAppPage;

public class PageObjectManager {
    private WebDriver driver;
    private HomePage homePage;
    private SampleAppPage sampleAppPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage(){
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public SampleAppPage getSampleAppPage() {
        return (sampleAppPage == null) ? sampleAppPage = new SampleAppPage(driver) : sampleAppPage; }

}
