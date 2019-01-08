package demo;

import com.ycj.reservation.config.ElasticsearchBootstrap;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class elasticSearchDemo {
    private static ElasticsearchBootstrap elasticsearchBootstrap = new ElasticsearchBootstrap();;
    public static void main(String []args) throws IOException {
        RestClient restClient= elasticsearchBootstrap.createRestClient();
        Response response = restClient.performRequest("GET", "/");
        String responseBody = EntityUtils.toString(response.getEntity());
        String header = response.getHeader("header");
        System.out.println(responseBody);
    }
}
