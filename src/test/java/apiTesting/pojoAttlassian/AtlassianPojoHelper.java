package apiTesting.pojoAttlassian;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AtlassianPojoHelper {

    public static Credentials generateJsonForAuthorization(String userName, String password){
        return new Credentials(userName, password);

    }

    public static AtlassianIssue generateJsonForIssue(String projectID, String issueTypeId, String summary){
        AtlassianIssue issuePojo = new AtlassianIssue(new Fields()
                .setProject(projectID)
                .setIssueType(issueTypeId)
//                .setAssignee(assigneeName)
                .setSummary(summary));
//                .setReporter(reporterName));

        return issuePojo;
    }

    public static String extractPojo(PojoAtlassian pojoAtlassian){
        ObjectMapper mapper = new ObjectMapper();
        String result = null;

        try {
            result = mapper.writeValueAsString(pojoAtlassian);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;

    }
}
