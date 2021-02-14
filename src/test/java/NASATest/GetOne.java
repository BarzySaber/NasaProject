package NASATest;

import Utilities.configurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetOne {

    @BeforeMethod
    public static void Init(){
        RestAssured.baseURI= configurationReader.getProperty("NASA_Url");
        RestAssured.basePath="/planetary/apod";
    }

    @Test
    public void test(){
        String apikey=configurationReader.getProperty("apikey");
        given()
                .queryParam("api_key",apikey)
                .log().ifValidationFails()
                .when()
                .get()
                .prettyPeek()
                .then()
                .contentType(ContentType.JSON)
                .log().ifValidationFails()
                .statusCode(is(200));
    }
}
