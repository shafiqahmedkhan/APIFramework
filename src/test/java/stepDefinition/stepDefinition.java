package stepDefinition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.addPlace;
import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class stepDefinition extends Utils {
    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    TestDataBuild data = new TestDataBuild();

    @Given("Add Place Payload with {string} {string} {string}")
    public void addPlacePayloadWith(String name, String language, String address) throws IOException {
        res = given()
                .log().all()
                .spec(requestSpecification()).body(data.addPlacePayload(name, language, address));
    }

    @When("user calls {string} with {string} http request")
    public void userCallsWithHttpRequest(String resource, String method) {

        APIResources resourceAPI = APIResources.valueOf(resource);

        resspec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();

        if (method.equalsIgnoreCase("POST")){
            response = res
                    .when()
                    .post(resourceAPI.getResource());
        } else if (method.equalsIgnoreCase("GET")) {
            response = res
                    .when()
                    .get(resourceAPI.getResource());
        }
//                .then()
//                .spec(resspec)
//                .log().all()
//                .extract()
//                .response();
    }
    @Then("the API call is success with status code {int}")
    public void the_api_call_is_success_with_status_code(int statusCode) {
        assertEquals(response.getStatusCode(), statusCode);
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String Expectedvalue) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        assertEquals(js.get(keyValue).toString(), Expectedvalue);

    }
}
