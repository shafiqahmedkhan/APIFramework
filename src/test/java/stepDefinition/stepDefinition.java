package stepDefinition;
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
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class stepDefinition {
    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;

    @Given("Add Place Payload")
    public void add_place_payload() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        addPlace p = new addPlace();

        List<String> myList = new ArrayList<String>();
        myList.add("shoe park");
        myList.add("shop");

        Location l = new Location();
        l.setLat(-38.383494);
        l.setLan(33.427362);

        p.setLocation(l);
        p.setAccuracy(50);
        p.setName("Frontline house");
        p.setPhone_number("(+91) 983 893 3937");
        p.setAddress("29, side layout, cohen 09");
        p.setTypes(myList);
        p.setWebsite("https://rahulshettyacademy.com");
        p.setLanguage("French-IN");

        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("key", "qaclick123")
                .setContentType(ContentType.JSON)
                .build();

         resspec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();

        res = given().spec(req).body(p);
    }
    @When("user calls {string} with Post http request")
    public void user_calls_with_post_http_request(String string) {
        response = res
                .when()
                .post("/maps/api/place/add/json")
                .then()
                .spec(resspec)
                .log().all()
                .extract()
                .response();
    }
    @Then("the API call is success with status code {int}")
    public void the_api_call_is_success_with_status_code(Integer int1) {
        assertEquals(response.getStatusCode(), 200);
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String Expectedvalue) {
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        System.out.println(bodyAsString);
        System.out.println("HelloWorld!");
        //String resp = response.getBody().;
//        JsonPath js = new JsonPath(resp);
//        assertEquals(js.get(keyValue).toString(), Expectedvalue);
    }
}
