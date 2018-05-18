package jira;

import org.junit.BeforeClass;
import org.junit.Test;
import jira.pojo.issue.Issue;
import jira.utils.api.Authorization;
import jira.utils.api.JiraApiActions;
import jira.utils.data.JiraPojoHelper;


public class CreateIssue {
    String projectId = "10103";
    String issueType = "10000";

    @BeforeClass
    public static void setUp() {
        Authorization.loginToJIRA();
    }

    @Test
    public void createIssueTest() {
    /* test data and parameters */
        String summary = "Check CRM in global-ui branch";
        String assignee = "Elena Insheva";

        Issue issuePOJO = JiraPojoHelper.generateJSONForIssue(projectId, summary, issueType, assignee);


    /* create issue */
        String issueKey = JiraApiActions.createIssue(issuePOJO);

    /* get issue to confirm that it exists*/
        JiraApiActions.getIssue(issueKey);

    /* delete issue */
        JiraApiActions.deleteIssue(issueKey);

    /* confirm that you will get 404 error when you will try to get the issue */
        JiraApiActions.getNonExistingIssue(issueKey);
    }
}
