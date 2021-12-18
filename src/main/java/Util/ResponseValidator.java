package Util;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import pojos.ErrorBasePojo;


import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by riziq.habiballah on 17 Dec, 2021
 */
public class ResponseValidator {

    Response response;

    public ResponseValidator(Response responseInput) {
        response=responseInput;
    }

    public ResponseValidator AssertNoError(){
        ErrorBasePojo obj = response.as(ErrorBasePojo.class);
        assertThat(obj.getError(), Matchers.equalTo(null));
        return this;
    }

    public ResponseValidator AssertStatusCode(int statusCode){
            response.then().statusCode(statusCode);
        return this;
    }
}
