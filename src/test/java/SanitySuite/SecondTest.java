package SanitySuite;

import Util.ActionBot;
import handlers.TxtFileHandler;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojos.CategoriesPojo;
import pojos.JokeDataPojo;
import pojos.JokePojo;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

/**
 * Created by riziq.habiballah on 17 Dec, 2021
 */
public class SecondTest extends SanityBaseTest {

    @BeforeMethod
    public void beforeMethod(ITestContext context) {
        super.beforeMethod(context);
    }
    @Parameters({ "categoryIndex" })
    @Test
    public void randomJoke(int categoryIndex) throws IOException {
        requestSpecification.basePath("jod/categories");
        Response response = new ActionBot().getWithNoErrors(requestSpecification);

        CategoriesPojo categories = response.as(CategoriesPojo.class);
        assertThat(categories.getSuccess().getTotal(),greaterThan(categoryIndex));


        requestSpecification.basePath("jod");
        requestSpecification.queryParam("category",categories.getContents().getCategories()[categoryIndex-1].getName());

        Response jokeResponse = new ActionBot().getWithNoErrors(requestSpecification);


        JokePojo jokes = jokeResponse.as(JokePojo.class);
        JokeDataPojo joke = jokes.getContents().getJokes()[0].getJoke();

        new TxtFileHandler
                .TxtFile(joke.getId())
                .Init()
                .append("description:").appendln(jokes.getContents().getJokes()[0].getDescription())
                .append("category:").appendln(jokes.getContents().getJokes()[0].getCategory())
                .append("title:").appendln(joke.getTitle())
                .append("text:").appendln(joke.getText())
                .save();

    }
}
