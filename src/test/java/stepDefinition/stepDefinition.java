package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinition {

    @Given("Add Place Payload")
    public void add_place_payload() {
        System.out.println("Hello World");
    }
    @When("user calls {string} with Post http request")
    public void user_calls_with_post_http_request(String string) {
        System.out.println("Hello World");
    }
    @Then("the API call is success with status code {int}")
    public void the_api_call_is_success_with_status_code(Integer int1) {
        System.out.println("Hello World");
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String string, String string2) {
        System.out.println("Hello World");
    }

}
