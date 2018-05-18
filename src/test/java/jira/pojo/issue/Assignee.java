package jira.pojo.issue;

import jira.pojo.Pojo;

public class Assignee implements Pojo {
    public String name;

    public Assignee(String id) {
        this.name = id;
    }
}
