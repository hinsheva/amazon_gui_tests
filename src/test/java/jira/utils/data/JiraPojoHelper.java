package jira.utils.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jira.pojo.Pojo;
import jira.pojo.issue.Credentials;
import jira.pojo.issue.Fields;
import jira.pojo.issue.Issue;
import jira.utils.api.Authorization;

import java.io.IOException;

public class JiraPojoHelper {


    public static Credentials generateJSONForLogin(String userName, String password) {
        return new Credentials(Authorization.username, Authorization.password);
    }

    public static Issue generateJSONForIssue(String projectId, String summary, String issueType, String assignee) {

        Issue issuePOJO = new Issue(new Fields()
                .setProject(projectId)
                .setSummary(summary)
                .setAssignee(assignee)
                .setIssueType(issueType)
        );
        return issuePOJO;
    }

    public static String extractPOJO(Pojo pojo) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String result = null;
        try {
            result = mapper.writeValueAsString(pojo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

}
