package apiTesting.apiAttlassian;

import apiTesting.pojoAttlassian.AtlassianPojoHelper;
import apiTesting.pojoAttlassian.Credentials;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;

public class AuthorizationAtlassian {

    public static String JSESSIONID;
    public static String BASE_URL = "https://hinsheva.atlassian.net";
    public static String userName = "admin";
    public static String password = "London91102";
    private static final Logger logger = LoggerFactory.getLogger(AuthorizationAtlassian.class);

    public static void loginAtlassianAccount(){
        RestAssured.baseURI = BASE_URL;
        Credentials loginJson = AtlassianPojoHelper.generateJsonForAuthorization(userName, password);

        ValidatableResponse response = given()
                .header("Content-Type",  ContentType.JSON)
                .header("Authorization", "Basic " + "YWRtaW46TG9uZG9uOTExMDI=")
                .body(loginJson)
                .when()
                .post(ApiPathesAtlassian.login)
                .then()
                .statusCode(200).contentType(ContentType.JSON);

        logger.info("RESPONSE BODY: " + response.extract().asString());

        JSESSIONID = response.extract().path("session.value");
        logger.info("nAUTHORIZATION TOKEN: " + AuthorizationAtlassian.JSESSIONID);

    }
}
