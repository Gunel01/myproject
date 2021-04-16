package api.stepDefinitions;
import com.jayway.jsonpath.JsonPath;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import java.util.List;

	public class SWSteps {
	 	Response response;
	    String requestData;
	    List<Object>SWCharacters;
	
	    Scenario scenario;
		
		@Before
		public void keepScenario(Scenario scenario) {
			this.scenario = scenario;
		}
	   
	@Given("User submits GET request for a list of all the Star Wars characters")
	public void user_submits_GET_request_for_a_list_of_all_the_Star_Wars_characters() {
		
		        RestAssured.baseURI="https://swapi.dev/api/people";
		        response=given()
		        		.header("Content-Type","application/json")
		                .relaxedHTTPSValidation()
		                .when()
		                .get();
		        response.prettyPrint();
		       
		        scenario.write("Response: " + response.prettyPrint());
		       
		        scenario.embed(response.asString().getBytes(), "application/json");
		       
		       
		    }
	
	@Given("User retrieves Star Wars characters from response and add them to a List")
	public void user_retrieves_Star_Wars_characters_from_response_and_add_them_to_a_List() {
		
		SWCharacters=JsonPath.read(response.asString(),"$.results[*]");
		System.out.println("*****************************************");
		System.out.println(SWCharacters.size());
		System.out.println("*****************************************");
		
		
		scenario.write("Characters: " + SWCharacters);
    }
	  
	@Then("user validates if status code is {int}")
	public void user_validates_if_status_code_is(int statusCode) {
		System.out.println("*****************************************");
		assertEquals(statusCode, response.getStatusCode());
		System.out.println("*****************************************");
		
		scenario.write("Status Code: " + statusCode);
	}
	@Then("user validates if the count of the characters in response is the same as required.")
	public void user_validates_if_the_count_of_the_characters_in_response_is_the_same_as_required() {
		
		int actualResult = SWCharacters.size();
		int expectedResult = 10;
		
		assertEquals(actualResult, expectedResult);
		
		scenario.write("Assertion actualResult" + actualResult);
		scenario.write("Assertion expectedResult" + expectedResult);
	    }

	   
	}
