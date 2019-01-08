package com.ycj.reservation.test;

import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ElasticSearchDemo {
    @Autowired
    @Qualifier("restClient")
    private RestClient restClient;

    public String helloWorld() throws IOException {
        Response response = restClient.performRequest("GET", "/");
        String responseBody = EntityUtils.toString(response.getEntity());
        System.out.println(responseBody);
        return responseBody;
    }
}
