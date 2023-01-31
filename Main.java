package org.example;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) {
        try {
            callJokeApi();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void callJokeApi() throws URISyntaxException, IOException {
        URIBuilder builder =  new URIBuilder("https://api.weatherbit.io/v2.0/current?key=fb487812029d434b9f576e6d761c2ba9&city=Raleigh");

        HttpGet getdata = new HttpGet(builder.build());

        CloseableHttpClient httpClient = HttpClients.createDefault();

        CloseableHttpResponse response = httpClient.execute(getdata);

        HttpEntity res = response.getEntity();

        String result = EntityUtils.toString(res);

        System.out.println(result);

        httpClient.close();



    }

}