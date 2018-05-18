package com.rest_api_testing;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class RetrieveUtil {

    public static <T> T retrieveResourcesFromResponse(final HttpResponse response, final Class<T> clazz) throws IOException{
        final String jsonFromResponse = EntityUtils.toString(response.getEntity());
        final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(jsonFromResponse, clazz);
    }
}
