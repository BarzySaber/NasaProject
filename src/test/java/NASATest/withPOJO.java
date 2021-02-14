package NASATest;

import POJO.Nasa;
import Utilities.configurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class withPOJO {



    @BeforeMethod
    public static void Init(){
        RestAssured.baseURI= configurationReader.getProperty("NASA_Url");
        RestAssured.basePath="/planetary/apod";

    }

    @Test
    public void test2(){
        String apikey=configurationReader.getProperty("apikey");
        Response response=given()
                .queryParam("api_key",apikey)
                .accept(ContentType.JSON)
                .when()
                .get()
                ;

       int actualStatus=response.statusCode();
      assertThat(actualStatus,is(equalTo(200)));

      Nasa ns=response.as(Nasa.class);
        System.out.println(ns);

        String date=ns.getDate();
        LocalDate today=LocalDate.now();
        assertThat(date,is(equalTo(today+"")));

    }
}
