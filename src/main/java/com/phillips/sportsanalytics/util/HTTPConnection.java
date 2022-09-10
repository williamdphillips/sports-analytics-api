package com.phillips.sportsanalytics.util;

import java.io.IOException;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.*;

public class HTTPConnection {
    private static OkHttpClient client;
    private static ObjectMapper mapper;

    public static void init() {
        client = new OkHttpClient();
        mapper = new ObjectMapper();
    }

    // code request code here
    public static Map<String,Object> get(String url) throws IOException {
        System.out.println("Doing GET Request: " + url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();
        return mapper.readValue(responseBody, Map.class);
    }

}
