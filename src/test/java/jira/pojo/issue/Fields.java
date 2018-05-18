package jira.pojo.issue;

import com.fasterxml.jackson.annotation.JsonProperty;
import jira.pojo.Pojo;

public class Fields implements Pojo{
     Project project;
     String summary;
    @JsonProperty("issueType")
     IssueType issueType;
     Assignee assignee;

    public Fields() {
    }

    public Fields setProject(String projectId) {
        this.project = new Project(projectId);
        return this;
    }

    public Fields setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public Fields setIssueType(String issueType) {
        this.issueType = new IssueType(issueType);
        return this;
    }

    public Fields setAssignee(String assignee) {
        this.assignee = new Assignee(assignee);
        return this;
    }
}