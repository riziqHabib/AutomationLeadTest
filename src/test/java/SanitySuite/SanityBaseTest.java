package SanitySuite;

import common.BaseTest;
import org.testng.ITestContext;

/**
 * Created by riziq.habiballah on 17 Dec, 2021
 */
public class SanityBaseTest  extends BaseTest {

    public void beforeMethod(ITestContext context){
        super.beforeMethod(context);
        String hostKey=context.getCurrentXmlTest().getParameter("hostKey");
        String hostValue=context.getCurrentXmlTest().getParameter("hostValue");
        String keyKey=context.getCurrentXmlTest().getParameter("keyKey");
        String keyValue=context.getCurrentXmlTest().getParameter("keyValue");
        requestSpecification.header(hostKey, hostValue);
        requestSpecification.header(keyKey, keyValue);
    }
}
