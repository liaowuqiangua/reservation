package com.ycj.reservation.config;

import org.apache.http.HttpHost;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ElasticsearchBootstrap {

    @Autowired
    private Environment env;
    private static Logger log = LogManager.getLogger(ElasticsearchBootstrap.class);

    @Bean("restClient")
    public RestClient createRestClient()  {
        RestClientBuilder builder = RestClient.builder(new HttpHost(env.getProperty("elasticsearch.hostname"), Integer.parseInt(env.getProperty("elasticsearch.port")), "http"));
//        Header[] defaultHeaders = new Header[]{new BasicHeader("header", "test")};
//        builder.setDefaultHeaders(defaultHeaders);
        builder.setMaxRetryTimeoutMillis(10000); //10sec
        builder.setFailureListener(new RestClient.FailureListener(){
            public void onFailure(HttpHost httpHost){
                log.error(httpHost.toURI()+"an error occurs !");
            }
        });
        return builder.build();
    }
}
