package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.User;
import org.json.simple.JSONObject;
import util.Helper;

import java.io.File;
import java.util.*;

import static io.restassured.RestAssured.given;

public class PetStoreStepsDef {

    private static RequestSpecification request;
    private Response response;

    private User user;
    private String payloadsFolder = "src/test/resources/payloads/";
    private Random random;

    @Given("the user has a valid API Key for the {string} URI")
    public void theUserHasAValidAPIKeyForTheURI(String uri) {
        request = given()
                .baseUri(uri)
                .header("api_key", "special-key")
                .contentType(ContentType.JSON)
                .log().all();
    }

    @Given("the user has information about an User")
    public void theUserHasValidInformationAboutAnUser() {
        user = new User();
    }

    @When("the user performs a POST to the {string} endpoint")
    public void performAPOSTToTheEndpoint(String endpoint) {
        response = request.when()
                .body(user)
                .post(endpoint)
                .prettyPeek();
    }

    @Then("the user receives a HTTP Code Status {int}")
    public void theUserReceivesAHTTPCodeStatus(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    @When("the user performs a POST with a {string} payload to the {string} endpoint")
    public void theUserPerformsAWithAPayloadToTheEndpoint(String payload, String endpoint) {
        File requestBody = new File( payloadsFolder + payload +".json");
        response = request.when()
                .body(requestBody)
                .post(endpoint)
                .prettyPeek();
    }

    @When("the user performs a DELETE to {string} endpoint with value {string}")
    public void performADELETEToEndpoint(String endpoint, String value) {
        response = request.when()
                .delete(endpoint + value)
                .prettyPeek();
    }
}
