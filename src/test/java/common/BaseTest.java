package common;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;

/**
 * Created by riziq.habiballah on 16 Dec, 2021
 */
public class BaseTest {
   public  RequestSpecification requestSpecification;
    @BeforeClass
    public void beforeMethod(ITestContext context) {
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(context.getCurrentXmlTest().getParameter("BaseURI"));
    }
}
