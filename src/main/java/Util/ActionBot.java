package Util;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;

/**
 * Created by riziq.habiballah on 17 Dec, 2021
 */
public class ActionBot {
    Logger logger = LogManager.getLogger(getClass());
    public Response getWithNoErrors(RequestSpecification requestSpecification){
        logger.info("getting get request");
        Response response = given().spec(requestSpecification).when().log().all().get();
        logger.debug(response.asPrettyString());
        new ResponseValidator(response).AssertStatusCode(200).AssertNoError();
        return response;
    }
}
