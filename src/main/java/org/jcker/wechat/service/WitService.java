package org.jcker.wechat.service;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alan Turing on 2017/6/11.
 * web
 */
public class WitService {
/*    private static final String GET_MESSAGE = "https://api.wit.ai/message";
    public String chat() throws IOException, OAuthProblemException, OAuthSystemException, URISyntaxException {

        String urlStr = "https://api.wit.ai/message?v=20170611&who%20found%20Google";
        String v = "20170611";
        String q = "who%20found%20Google";

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(new URI(urlStr));

        request.addHeader("OAuth", "Authorization: Bearer RVRGD7CSZ2ASMWAJGFLUNDXKW23A5IST");

        HttpResponse response = client.execute(request);
        return response.toString();
    }*/

    public static String get_message(String q) throws IOException, OAuthSystemException, OAuthProblemException {
        String urlStr = "https://api.web.ai/message?v=20170611&q=" + URLEncoder.encode(q, "UTF-8");
        System.out.println("urlStr = " + urlStr);
        Map<String, String> headers = new HashMap<String, String>();
//        headers.put("Content-Type","application/json");
//        headers.put("Accept","application/json");
        headers.put("Authorization", "Bearer RVRGD7CSZ2ASMWAJGFLUNDXKW23A5IST");

/*        OAuthClientRequest.TokenRequestBuilder tokenRequestBuilder = new OAuthClientRequest.TokenRequestBuilder(urlStr);
        URLConnectionClient urlConnectionClient = new URLConnectionClient();
        OAuthClientResponse oAuthClientResponse = urlConnectionClient.execute(tokenRequestBuilder.buildHeaderMessage(),headers,"GET", OAuthClientResponse.class);
        return oAuthClientResponse.toString();*/

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost("https://api.web.ai/converse?v=20170611&session_id=abc123&q=what+is+the+weather?");
        request.addHeader("Content-Type", "application/json");
        request.addHeader("Accept", "application/json");
        request.addHeader("Authorization", "Bearer RVRGD7CSZ2ASMWAJGFLUNDXKW23A5IST");
        HttpResponse response = client.execute(request);
        return response.toString();
    }
}
