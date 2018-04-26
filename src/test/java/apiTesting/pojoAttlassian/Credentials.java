package apiTesting.pojoAttlassian;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Credentials implements PojoAtlassian {

    @JsonProperty("username")
    public String userName;
    @JsonProperty("password")
    public String userPassword;

    public Credentials(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }
}
