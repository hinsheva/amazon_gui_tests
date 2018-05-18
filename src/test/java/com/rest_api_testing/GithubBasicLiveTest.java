package com.rest_api_testing;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GithubBasicLiveTest {

    @Test
    public void testUserIsNotExist() throws IOException {
        final String name = randomAlphabetic(8);
        final HttpUriRequest request = new HttpGet("https://api.github.com/users" + name);
        System.out.println(name);

        final HttpResponse response = HttpClientBuilder.create().build().execute(request);

        assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_NOT_FOUND));
    }

    @Test
    public void testResponseContent() throws IOException {
        final String jsonMimeType = "application/json";
        final HttpUriRequest request = new HttpGet("https://api.github.com/users/eugenp");

        final HttpResponse response = HttpClientBuilder.create().build().execute(request);

        final String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
        assertEquals(jsonMimeType, mimeType);
    }

    @Test
    public void testUserCreation() throws IOException {
        final HttpUriRequest request = new HttpPost("https://api.github.com/users");

        final HttpResponse response = HttpClientBuilder.create().build().execute(request);

        assertThat(response.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_NOT_FOUND));
    }



    @Test
    public void testUserIsExists() throws IOException {
        final HttpUriRequest request = new HttpGet("https://api.github.com/users/eugenp");

        final HttpResponse response = HttpClientBuilder.create().build().execute(request);
        System.out.println(request);
        System.out.println(response);

        final GitHubUser user = RetrieveUtil.retrieveResourcesFromResponse(response, GitHubUser.class);
        assertThat("eugenp", CoreMatchers.is(user.getLogin()));
    }
}
