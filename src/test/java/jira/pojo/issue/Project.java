package jira.pojo.issue;

import jira.pojo.Pojo;

public class Project implements Pojo{
    public String id;

    public Project(String id) {
        this.id = id;
    }
}
