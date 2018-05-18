package jira.utils.api;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import jira.pojo.issue.Issue;


public class JiraApiActions {

    public static String createIssue(Issue issuePOJO) {
        ValidatableResponse response = HttpMethods.post(APIPathes.issue, issuePOJO);
        Assert.assertEquals(response.extract().statusCode(), 201);
        Assert.assertTrue(response.extract().contentType().contains(ContentType.JSON.toString()));
        return response.extract().path("key");
    }

    public static String getIssue(String issueKey) {
        ValidatableResponse response = HttpMethods.get(APIPathes.issue + issueKey);
        Assert.assertEquals(response.extract().statusCode(), 200);
        Assert.assertTrue(response.extract().contentType().contains(ContentType.JSON.toString()));
        return response.extract().asString();
    }

    public static String getNonExistingIssue(String issueKey) {
        ValidatableResponse response = HttpMethods.get(APIPathes.issue + issueKey);
        Assert.assertEquals(response.extract().statusCode(), 404);
        Assert.assertTrue(response.extract().contentType().contains(ContentType.JSON.toString()));
        return response.extract().asString();
    }

    public static void deleteIssue(String issueKey) {
        ValidatableResponse response = HttpMethods.delete(APIPathes.issue + issueKey);
        Assert.assertEquals(response.extract().statusCode(), 204);
        Assert.assertTrue(response.extract().contentType().contains(ContentType.JSON.toString()));
    }
}