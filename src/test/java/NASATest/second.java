package NASATest;

import POJO.Nasa;
import Utilities.configurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class second {
    @BeforeMethod
    public static void Init(){
        RestAssured.baseURI= configurationReader.getProperty("NASA_Url");
        RestAssured.basePath="/planetary/apod";
    }

    @Test
    public void test(){
        String apikey=configurationReader.getProperty("apikey");

       Response response= given()
                .queryParam("api_key",apikey)
                .log().ifValidationFails()
                .when()
                .get()
                ;
       String date=response.path("date");
        System.out.println("date is: "+date);
        int status=response.statusCode();


        JsonPath jp=response.jsonPath();
        Map<String,Object>mapAll=jp.getMap("");
        System.out.println(mapAll);
        System.out.println(mapAll.get("url"));
    }


}
