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
	    List<Object>SWCharacters;

	    @Given("User submits GET request for a list of all the Star Wars characters and receive response")
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
	    @And("User should be able to return a list of all the Star Wars characters")
		public void user_retrieves_Star_Wars_characters_from_response_and_add_them_to_a_List() {
			
			SWCharacters=JsonPath.read(response.asString(),"$.results[*]");
			System.out.println("*****************************************");
			System.out.println(SWCharacters.size());
			System.out.println("*****************************************");
	    }

	    @Then("User validates if status code is {int}")
		public void user_validates_if_status_code_is(int statusCode) {
			System.out.println("*****************************************");
			assertEquals(statusCode, response.getStatusCode());
			System.out.println("*****************************************");
		}
		@And("User validates if the count of the characters in response is the same as required.")
		public void user_validates_if_the_count_of_the_characters_in_response_is_the_same_as_required() {
			
			int actualResult = SWCharacters.size();
			int expectedResult = 10;
			assertEquals(actualResult, expectedResult);
			
			
			
			
	    }

	   
	}


