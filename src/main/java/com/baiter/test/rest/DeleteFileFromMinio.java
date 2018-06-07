package com.baiter.test.rest;

import com.alibaba.fastjson.JSON;
import com.baiter.test.model.ResultVo;
import com.google.common.base.Strings;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by lenovo on 2018/6/6.
 */
public class DeleteFileFromMinio {

    public static void main(String[] args) throws IOException{
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse httpResponse = null;
        HttpDelete httpdelete = new HttpDelete("http://localhost:8089/drip-minio/file/object//elevpic/201806/QQ20171205122602_1528189452854.png");

        httpResponse = httpClient.execute(httpdelete);
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
            ResultVo resultVo = JSON.parseObject(buffer.toString(), ResultVo.class);
            boolean result = resultVo.isSuccess();
            System.out.println(result);
        }

        httpClient.close();
        if(httpResponse!=null){
            httpResponse.close();
        }

    }
}
