package com.baiter.test.rest;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by lenovo on 2018/3/2.
 */
public class JpushClientUtils {

    public static final String URL = "https://bjapi.push.jiguang.cn/v3/push";

    public static final String APP_KEY = "61de8ff807a830d4da267474";

    public static final String MASTER_SECRET = "be54ed7b0dbe5f22eb9d75b8";

    public static boolean pushMsg(String json){
        boolean result = false;
        CloseableHttpClient httpclient = HttpClients.createDefault();

        CloseableHttpResponse response = null;
        try {
            // 将JSON进行UTF-8编码,以便传输中文
            String encoderJson = URLEncoder.encode(json, "UTF-8");
            //List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            //nvps.add(new BasicNameValuePair("username", "vip"));
            //nvps.add(new BasicNameValuePair("password", "secret"));

            HttpPost httpPost = new HttpPost(URL);
            httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json;charset=utf-8");
            httpPost.addHeader("Authorization",new StringBuilder("Basic ").append(getAuthStr()).toString());

            //httpPost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
            StringEntity se = new StringEntity(json, Consts.UTF_8);
            se.setContentType( "text/json");
            se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json;charset=utf-8"));
            httpPost.setEntity(se);
            response = httpclient.execute(httpPost);
            System.out.println("----------------------------------------");
            System.out.println(response.getStatusLine());

            // Get hold of the response entity
            HttpEntity entity = response.getEntity();

            // do something useful with the response body
            // and ensure it is fully consumed
            String message = EntityUtils.toString(entity, "utf-8");
            //System.out.println(message);
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    private static String getAuthStr(){
        String s = new StringBuilder(APP_KEY).append(":").append(MASTER_SECRET).toString();
        return Base64.encodeBase64String(s.getBytes());
    }
}
