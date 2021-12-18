package Util;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

/**
 * Created by riziq.habiballah on 17 Dec, 2021
 */
public class ActionBot {

    public Response getWithNoErrors(RequestSpecification requestSpecification){
        Response response = given().spec(requestSpecification).when().get();
        new ResponseValidator(response).AssertStatusCode(200).AssertNoError();
        return response;
    }
}
