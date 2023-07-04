package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import ui.cucumber.TestContext;
import ui.pages.ProgressBarPage;

public class ProgressBarStepsDef {

    TestContext testContext;
    ProgressBarPage progressBarPage;

    public ProgressBarStepsDef(TestContext context){
        testContext = context;
        progressBarPage = context.getPageObjectManager().getProgressBarPage();
    }
    @Given("the user clicks on Start")
    public void theUserClicksOnStart() {
        progressBarPage.start();
    }

    @And("the user waits for {string} percentage")
    public void theUserWaitsFor(String percentage) {
        progressBarPage.waitForPercentage(percentage);
    }

    @When("the user clicks on Stop")
    public void theUserClicksOnStop() {
        progressBarPage.stop();
    }

    @Then("the user sees Result is equal to {string}")
    public void theUserSeesResultIsEqualTo(String number) {
        String expectedMsg = "Result: ".concat(number);
        Assert.assertEquals(expectedMsg, progressBarPage.getResult());
    }
}
