package apiTesting;

import apiTesting.apiAttlassian.AtlassianApiActions;
import apiTesting.apiAttlassian.AuthorizationAtlassian;
import apiTesting.pojoAttlassian.AtlassianIssue;
import apiTesting.pojoAttlassian.AtlassianPojoHelper;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestAtlassianIssueCreation {

    @BeforeClass

    public static void setUp() {
        AuthorizationAtlassian.loginAtlassianAccount();
    }

    @Test
    public void testIssueCreation() {
        String project = "10000";
        String issueTypeId = "10004";
        String summary = "Test";
//        String role = "10102";

        AtlassianIssue issue = AtlassianPojoHelper.generateJsonForIssue(project, issueTypeId, summary);
        String issueKey = AtlassianApiActions.createAtlassianIssue(issue);
        AtlassianApiActions.getAtlassianIssue(issueKey);

//        AtlassianApiActions.deleteAtlassianProjectRole(project, role);
//        AtlassianApiActions.deleteAtlassianIssue(issueKey);
//        AtlassianApiActions.getNotExistingAtlassianIssue(issueKey);
    }
}
