package apiTesting.apiAttlassian;

import apiTesting.pojoAttlassian.AtlassianIssue;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AtlassianApiActions {

    public static String createAtlassianIssue(AtlassianIssue issuePojo){
        ValidatableResponse response = HttpMethodsAtlassian.post(ApiPathesAtlassian.issue, issuePojo);
        assertEquals(201, response.extract().statusCode());
        assertTrue(response.extract().contentType().contains(ContentType.JSON.toString()));

        return response.extract().path("key");
    }

    public static String getAtlassianIssue(String issueKey){
        ValidatableResponse response = HttpMethodsAtlassian.get(ApiPathesAtlassian.issue + issueKey);
        assertEquals(200, response.extract().statusCode());
        assertTrue(response.extract().contentType().contains(ContentType.JSON.toString()));

        return response.extract().asString();
    }

    public static String getIssueMetaData(){
        ValidatableResponse response = HttpMethodsAtlassian.get(ApiPathesAtlassian.issue + "createmeta ");
        assertEquals(200, response.extract().statusCode());

        return response.extract().asString();
    }

    public static String getNotExistingAtlassianIssue(String issueKey){
        ValidatableResponse response = HttpMethodsAtlassian.get(ApiPathesAtlassian.issue + issueKey);
        assertEquals(404, response.extract().statusCode());
        assertTrue(response.extract().contentType().contains(ContentType.JSON.toString()));

        return response.extract().asString();
    }

    public static void deleteAtlassianIssue(String issueKey){
        ValidatableResponse response = HttpMethodsAtlassian.delete(ApiPathesAtlassian.issueLinkType + issueKey);
        assertEquals(204, response.extract().statusCode());
        assertTrue(response.extract().contentType().contains(ContentType.JSON.toString()));
    }

    public static void deleteAtlassianProjectRole(String projectId, String roleId){
        ValidatableResponse response = HttpMethodsAtlassian.delete(ApiPathesAtlassian.projectId + projectId + ApiPathesAtlassian.role + roleId);
        assertEquals(204, response.extract().statusCode());
        assertTrue(response.extract().contentType().contains(ContentType.JSON.toString()));
    }
}
