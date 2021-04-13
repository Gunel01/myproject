package api.stepDefinitions;


	import com.jayway.jsonpath.JsonPath;
	import io.cucumber.java.en.And;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.restassured.RestAssured;
	import io.restassured.response.Response;

	import static io.restassured.RestAssured.given;
	import static org.junit.Assert.assertEquals;
	import static org.junit.Assert.assertTrue;

	public class SWSteps {
	    Response response;
	    String requestData;

	    @Given("user submits GET request for a list of all the Star Wars characters and receive response")
	    public void SW_Characters_GETRequest() {
	        RestAssured.baseURI="https://swapi.dev/api/";
	        response= given()
	                .header("Content-Type","application/json")
	                .body(requestData)
	                .relaxedHTTPSValidation()
	                .when()
	                .post();
	        response.prettyPrint();

	    }

	    @And("user retrieves Star Wars character IDs from response and add them to a List")
	    public void Retrieve_IDs() {
	    String id =response.getSessionId();
	    }

	    @Then("user validates status code is {int}")
	    public void Validates_StatusCode(int statusCode) {
	        assertEquals(statusCode, response.getStatusCode());

	    }

	    @And("user validates if value of {string} in response are same as required.")
	    public void Validate_IfValue(String errorMessage) {
	        String actualError= JsonPath.read(response.asString(),"$.error.validationErrors[*].message").toString();
	        System.out.println("ERROR MESSAGE: "+actualError);
	        assertTrue(actualError.contains(errorMessage));
	    }
	}


