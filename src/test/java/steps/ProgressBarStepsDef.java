package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgressBarStepsDef {

    public ProgressBarStepsDef(){

    }
    @Given("the user clicks on Start")
    public void theUserClicksOnStart() {
    }

    @And("the user waits for {string} percentage")
    public void theUserWaitsFor(String percentage) {

    }

    @When("the user clicks on Stop")
    public void theUserClicksOnStop() {

    }

    @Then("the user sees Result is equal to {string}")
    public void theUserSeesResultIsEqualTo(String arg0) {
    }
}
