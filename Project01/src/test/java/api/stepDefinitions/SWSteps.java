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

import java.util.List;

	public class SWSteps {
	    Response response;
	    String requestData;

	    @Given("user submits GET request for a list of all the Star Wars characters and receive response")
	    public void SW_Characters_GETRequest() {
	        RestAssured.baseURI="https://swapi.dev/api/people/1/";
	        response= given()
	                .header("Content-Type","application/json")
	                .body(requestData)
	                .relaxedHTTPSValidation()
	                .when()
	                .post();
	        response.prettyPrint();

	    }

	    @And("user retrieves Star Wars characters from response and add them to a List")
	    public void store_characters_in_list() {
	    	
	    	
	      //  List<String> characters =response.a;
	    }

	    @Then("user validates status code is {int}")
	    public void Validates_StatusCode(int statusCode) {
	        assertEquals(statusCode, response.getStatusCode());

	    }

	   
	}


