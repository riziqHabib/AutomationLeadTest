package Util;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matchers;
import pojos.ErrorBasePojo;


import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by riziq.habiballah on 17 Dec, 2021
 */
public class ResponseValidator {
    Logger logger = LogManager.getLogger(getClass());
    Response response;

    public ResponseValidator(Response responseInput) {
        response=responseInput;
    }

    public ResponseValidator AssertNoError(){
        logger.info("Assert no error on message ");
        logger.debug(response.asPrettyString());
        ErrorBasePojo obj = response.as(ErrorBasePojo.class);
        assertThat(obj.getError(), Matchers.equalTo(null));
        return this;
    }

    public ResponseValidator AssertStatusCode(int statusCode){
        logger.info("Assert status code");
            response.then().statusCode(statusCode);
        return this;
    }
}
