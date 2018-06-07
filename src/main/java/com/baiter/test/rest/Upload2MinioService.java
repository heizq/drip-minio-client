package com.baiter.test.rest;

import com.alibaba.fastjson.JSON;
import com.baiter.test.model.ResultVo;
import com.google.common.base.Strings;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by lenovo on 2018/6/5.
 */
public class Upload2MinioService {

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse httpResponse = null;
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(200000).setSocketTimeout(200000000).build();
        HttpPost httpPost = new HttpPost("http://localhost:8089/drip-minio/file/upload");
        httpPost.setConfig(requestConfig);
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        //multipartEntityBuilder.setCharset(Charset.forName("UTF-8"));

        File file = new File("C:\\Users\\lenovo\\Desktop\\picture\\QQ截图20171205122602.png");

        multipartEntityBuilder.addBinaryBody("file",file);
        HttpEntity httpEntity = multipartEntityBuilder.build();
        httpPost.setEntity(httpEntity);

        httpResponse = httpClient.execute(httpPost);
        HttpEntity responseEntity = httpResponse.getEntity();
        int statusCode= httpResponse.getStatusLine().getStatusCode();
        if(statusCode == 200){
            BufferedReader reader = new BufferedReader(new InputStreamReader(responseEntity.getContent()));
            StringBuffer buffer = new StringBuffer();
            String str = "";
            while(!Strings.isNullOrEmpty(str = reader.readLine())) {
                buffer.append(str);
            }

            System.out.println(buffer.toString());
            ResultVo respon = JSON.parseObject(buffer.toString(), ResultVo.class);
            String result = String.valueOf(respon.getResult());
            System.out.println(result);
        }

        httpClient.close();
        if(httpResponse!=null){
            httpResponse.close();
        }


    }
}
