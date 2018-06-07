package com.baiter.test.rest;

import com.alibaba.fastjson.JSON;
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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by lenovo on 2018/3/12.
 */
public class ProbelmRandomGen {

    public static final String URL = "http://192.168.53.26/rest/services/rescue_system/event";

    public static final String Test_URL = "http://192.168.34.105/rest/services/rescue_system/event";


    public static boolean post(String json){
        boolean result = false;
        CloseableHttpClient httpclient = HttpClients.createDefault();

        CloseableHttpResponse response = null;
        try {
            // 将JSON进行UTF-8编码,以便传输中文
            String encoderJson = URLEncoder.encode(json, "UTF-8");


            HttpPost httpPost = new HttpPost(Test_URL);
            httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json;charset=utf-8");
            httpPost.addHeader("token",new StringBuilder("0eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI2NDU0OTE0NDIwNzYwOTAzNjkiLCJpc3MiOiJzZXNpc3AtYWRtaW4iLCJpYXQiOjE1MjA4NDI1MzF9.0qyhZAIoOkD999SVTrqZU9vFfwDkU38kfD6tBgxmzv0").toString());

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




    public static void main(String[] args) {
        Random random = new Random();

        for(int i = 0 ;i<1000;i++){
            Map map = new HashMap();
            String[] keys = elevMap.keySet().toArray(new String[0]);
            String randomKey = keys[random.nextInt(keys.length)];
            System.out.println(randomKey);
            map.put("useRegCode",randomKey);
            map.put("identifiCode",elevMap.get(randomKey));
            map.put("eventType",""+(random.nextInt(3) + 1));
            map.put("source","1");
            map.put("reporter","test");
            map.put("reportPhone","18002125566");
            map.put("reportContent","电梯故障，加快处理。");
            post(JSON.toJSONString(map));
            try {

                Thread.sleep(1000*6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        //post(JSON.toJSONString(map));


    }


    public static final HashMap<String, String> elevMap  = new HashMap<String,String>(){{
        put("31106101112018039999","1000001");
        put("31106101022018039999","1111111");
        put("31206101022018039999","2222222");
        put("31306101022018039999","3333333");


    }};

}
