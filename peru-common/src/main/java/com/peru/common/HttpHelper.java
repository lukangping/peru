package com.peru.common;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

/**
 * Created by roger.lu on 16/3/7.
 */
public class HttpHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpHelper.class);

    /**
     * get request
     *
     * @param url
     * @param params
     * @return
     * @throws IOException
     */
    public String get(String url, Map<String, String> params) {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        String getUrl = this.buildUrl(url, params);
        HttpGet httpGet = new HttpGet(getUrl);

        CloseableHttpResponse httpResponse = null;
        String responseBody = null;
        try {
            httpResponse = httpClient.execute(httpGet);
            responseBody = EntityUtils.toString(httpResponse.getEntity());
        } catch (IOException e) {
            LOGGER.error("HttpGet request failed with url [{}].", getUrl, e);
        } finally {
            try {
                if (null != httpResponse) {
                    httpResponse.close();
                }
                httpClient.close();
            } catch (IOException e) {
                LOGGER.error("Close httpGet client failed with url [{}].", getUrl, e);
            }
        }

        return responseBody;
    }

    public String buildUrl(String url, Map<String, String> params) {
        url += "?";
        if(null != params){
            for (Map.Entry entry : params.entrySet()) {
                url += entry.getKey() + "=" + entry.getValue() + "&";
            }
        }
        return url.substring(0, url.length() - 1);
    }
}
