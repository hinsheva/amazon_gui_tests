package jira.pojo.issue;

import jira.pojo.Pojo;

public class IssueType implements Pojo{
    public String id;

    public IssueType(String id) {
        this.id = id;
    }
}
