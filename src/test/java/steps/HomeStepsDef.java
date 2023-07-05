package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.testng.Assert;
import ui.cucumber.TestContext;
import ui.pages.HomePage;

public class HomeStepsDef {

    TestContext testContext;
    HomePage homePage;

    public HomeStepsDef(TestContext context){
        testContext = context;
        homePage = context.getPageObjectManager().getHomePage();
    }
    @Given("the user is in UITAP Home")
    public void theUserIsInUITAPHome() {
        Assert.assertEquals(homePage.getTitle(), "UI Test Automation Playground");
    }

    @And("the user opens {string} page")
    public void theUserOpensPage(String option) {
        homePage.openPage(option);
    }
}
