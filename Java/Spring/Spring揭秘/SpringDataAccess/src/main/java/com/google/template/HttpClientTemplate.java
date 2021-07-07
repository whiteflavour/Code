package com.google.template;

import com.google.callback.HttpClientCallBack;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * 自己实现的 HttpClientTemplate 封装类
 *
 * @author Liao
 * @date 2021-6-27
 */
public class HttpClientTemplate {
    private String resource;
    private CloseableHttpResponse response;

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public CloseableHttpResponse getResponse() {
        return response;
    }

    public void setResponse(CloseableHttpResponse response) {
        this.response = response;
    }

    public void execute(HttpClientCallBack callBack) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(resource);
        response = httpClient.execute(httpGet);
        try {
            System.out.println(response.getStatusLine());
            callBack.processHttpRequest();
        } finally {
            response.close();
        }
    }
}
