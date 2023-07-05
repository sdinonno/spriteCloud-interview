package ui.cucumber;

import ui.managers.DriverManager;
import ui.managers.PageObjectManager;

public class TestContext {

    private final DriverManager webDriverManager;
    private final PageObjectManager pageObjectManager;
    public TestContext(){
        webDriverManager = new DriverManager();
        pageObjectManager = new PageObjectManager(DriverManager.getDriver());
    }

    public DriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
}
