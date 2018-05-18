package jira.utils.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import jira.pojo.issue.Credentials;
import jira.utils.data.JiraPojoHelper;

import static io.restassured.RestAssured.given;

public class Authorization {

    public static String JSESSIONID;
    public static String BASE_URI = "https://jira.pitchbookdata.com/";
    public static String username = "helen.insheva";
    public static String password = "London91102";

    public static void loginToJIRA() {
        RestAssured.baseURI = BASE_URI;

        Credentials loginJson = JiraPojoHelper.generateJSONForLogin(username, password);
        JSESSIONID =
                given()
                        .header("Content-Type", ContentType.JSON).
                        body(loginJson).
                        when().
                        post(APIPathes.login).
                        then().
                        statusCode(200).contentType(ContentType.JSON).
                        extract().
                        path("session.value");

        System.out.println(JSESSIONID);

    }
}