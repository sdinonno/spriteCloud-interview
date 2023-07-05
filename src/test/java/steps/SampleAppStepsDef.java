package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.hu.Ha;
import org.testng.Assert;
import ui.cucumber.TestContext;
import ui.pages.SampleAppPage;
import util.Helper;

import java.util.HashMap;

public class SampleAppStepsDef {
    TestContext testContext;
    private final SampleAppPage sampleAppPage;
    private final HashMap<String, String> credentials = new HashMap<String, String>();

    public SampleAppStepsDef(TestContext context){
        testContext = context;
        sampleAppPage = context.getPageObjectManager().getSampleAppPage();
    }
    @Given("the user has valid credentials")
    public void theUserHasValidCredentials() {
        credentials.put("userName", Helper.generateRandomText(5));
        credentials.put("password", "pwd");
    }

    @Given("the user has invalid credentials")
    public void theUserHasInvalidCredentials() {
        credentials.put("userName", Helper.generateRandomText(5));
        credentials.put("password", Helper.generateRandomText(4));
    }

    @When("the user performs a log in with their credentials")
    public void theUserPerfomsALogInWithTheirCredentials() {
        sampleAppPage.logIn(credentials.get("userName"), credentials.get("password"));
    }

    @When("the user logs out")
    public void theUserLogsOut() {
        sampleAppPage.logOut();
    }

    @Then("the user sees a successfully login message")
    public void theUserSeesASuccessfullyLoginMessage() {
        String expectedMessage = "Welcome, " + credentials.get("userName") + "!";
        Assert.assertEquals(sampleAppPage.getLoginStatusMessage(),
                expectedMessage);
    }

    @Then("the user sees a login error message")
    public void theUserSeesALoginErrorMessage() {
        Assert.assertEquals(sampleAppPage.getLoginStatusMessage(), "Invalid username/password");
    }

    @Then("the user sees a successfully log out message")
    public void theUserSeesASuccessfullyLogOutMessage() {
        Assert.assertEquals(sampleAppPage.getLoginStatusMessage(), "User logged out.");
    }

    @And("the user sees Log In button enabled")
    public void theUserSeesLogInButtonEnabled() {
        Assert.assertEquals(sampleAppPage.getLogInButtonText(), "Log In");
    }
}
