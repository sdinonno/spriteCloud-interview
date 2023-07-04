package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import util.Helper;

import java.util.*;

import static io.restassured.RestAssured.given;

public class PetStoreStepsDef {

    private static RequestSpecification request;
    private Response response;

    private JSONObject requestBody;

    @Given("the user has a valid API Key for the {string} URI")
    public void theUserHasAValidAPIKeyForTheURI(String uri) {
        request = RestAssured.given()
                .baseUri(uri)
                .header("api_key", "special-key")
                .contentType(ContentType.JSON)
                .log().all();
    }

    @Given("the user has a body with the following attributes")
    public void theUserHasABodyWithTheFollowingAttributes(List<String> table) {
        Iterator<String> it = table.iterator();
        while(it.hasNext()){
            if(Objects.equals(it.next(), "id"))
                requestBody.put(it.next(), 2151);
            else
                requestBody.put(it.next(), Helper.generateRandomText(10));
        }
    }

    @When("the user performs a POST to the {string} endpoint")
    public void theUserPerformsAPOSTToTheEndpoint(String endpoint) {
        response = request.when()
                .body(requestBody)
                .post(endpoint)
                .prettyPeek();
    }

    @Then("the user receives a HTTP Code Status {string}")
    public void theUserReceivesAHTTPCodeStatus(String statusCode) {
        
    }

    @When("the user performs a {string} with a {string} payload to the {string} endpoint")
    public void theUserPerformsAWithAPayloadToTheEndpoint(String arg0, String arg1, String arg2) {
    }
}
