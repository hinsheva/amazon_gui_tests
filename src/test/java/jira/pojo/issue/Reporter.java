package jira.pojo.issue;

import jira.pojo.Pojo;

public class Reporter implements Pojo{
    public String name;

    public Reporter(String name) {
        this.name = name;
    }
}
