package jira.pojo.issue;

import jira.pojo.Pojo;

public class Issue implements Pojo{
    public Fields fields;

    public Issue(Fields fields) {
        this.fields = fields;
    }
}
