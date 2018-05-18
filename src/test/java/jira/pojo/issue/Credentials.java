package jira.pojo.issue;

import com.fasterxml.jackson.annotation.JsonProperty;
import jira.pojo.Pojo;

public class Credentials implements Pojo {

    @JsonProperty("username")
    public String userName;
    public String password;

    public Credentials(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
