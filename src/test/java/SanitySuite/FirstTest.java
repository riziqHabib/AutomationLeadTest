package SanitySuite;

import Util.ActionBot;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Created by riziq.habiballah on 16 Dec, 2021
 */
public class FirstTest extends SanityBaseTest {

    @BeforeMethod
    public void beforeMethod(ITestContext context) {
        super.beforeMethod(context);
        requestSpecification.basePath("jod/tests");
    }
    @Test
    public void wrongEndPoint(){
        //logger.info("First Test Start");

        new ActionBot().getWithNoErrors(requestSpecification);
       // logger.info("First Test END");

    }
}

