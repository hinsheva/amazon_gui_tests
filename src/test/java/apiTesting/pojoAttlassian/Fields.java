package apiTesting.pojoAttlassian;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fields implements PojoAtlassian {
    @JsonProperty("project")
    Project project;

    @JsonProperty("issuetype")
    IssueType issueType;


//    @JsonProperty("reporter")
//    Reporter reporter;
//
//    @JsonProperty("assignee")
//    Assignee assignee;
//
    @JsonProperty("summary")
    String summary;

    public Fields() {
    }

    public Fields setProject(String project) {
        this.project = new Project(project);
        return this;
    }

    public Fields setSummary(String name) {
        this.summary = name;
        return this;
    }

    public Fields setIssueType(String issuetype) {
        this.issueType = new IssueType(issuetype);
        return this;
    }
//
//    public Fields setReporter(String reporterName) {
//        this.reporter = new Reporter(reporterName);
//        return this;
//    }
//
//    public Fields setAssignee(String assigneeName) {
//        this.assignee = new Assignee(assigneeName);
//        return this;
//    }
}
