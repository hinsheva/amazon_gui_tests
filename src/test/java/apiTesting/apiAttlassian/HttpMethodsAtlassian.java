package apiTesting.apiAttlassian;

import apiTesting.pojoAttlassian.PojoAtlassian;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;

public class HttpMethodsAtlassian {

    static final Logger logger = LoggerFactory.getLogger(HttpMethodsAtlassian.class);

    public static ValidatableResponse get(String url) {
        ValidatableResponse response = given()
                .header("Content-Type", ContentType.JSON)
                .header("Authorization", "Basic " + "YWRtaW46TG9uZG9uOTExMDI=")
                .when()
                .get(url)
                .then();

        String responseBody = response.extract().asString();
        logger.info("RESPONSE BODY: " + responseBody);

        return response;
    }

    public static ValidatableResponse post(String url, PojoAtlassian body) {
        ValidatableResponse response = given()
                .header("Content-Type", ContentType.JSON)
                .header("Authorization", "Basic " + "YWRtaW46TG9uZG9uOTExMDI=")
                .body(body)
                .when()
                .post(url)
                .then();

        String responseBody = response.extract().asString();
        logger.info("RESPONSE BODY: " + responseBody);

        return response;
    }

    public static ValidatableResponse delete(String url){
        ValidatableResponse response = null;

        try {
             response = given()
                    .header("Content-Type", ContentType.JSON)
                    .header("Authorization", "Basic " + "YWRtaW46TG9uZG9uOTExMDI=")
                    .when()
                    .delete(url)
                    .then();

            String responseBody = response.extract().asString();
            logger.info("RESPONSE BODY: " + responseBody);


        }
        catch (Exception e){
            System.out.println(e);
            logger.info("Error raised while deleting an issue" + e);
        }

        return response;
    }
}
