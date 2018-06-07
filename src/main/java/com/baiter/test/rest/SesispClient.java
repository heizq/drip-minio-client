package com.baiter.test.rest;

import com.alibaba.fastjson.JSON;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2018/2/2.
 */
public class SesispClient {

    public static final MediaType APPLICATION_JSON  = MediaType.parse("application/json; charset=utf-8");

    public static final MediaType MutilPart_Form_Data  = MediaType.parse("multipart/form-data; charset=utf-8");

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        File file1 = new File("C:\\Users\\lenovo\\Desktop\\picture\\1.png");
        File file2 = new File("C:\\Users\\lenovo\\Desktop\\picture\\CallanishSS.jpg");
        //File file3 = new File("");
        //File file4 = new File("");
        //File file5 = new File("");
        RequestBody body1 = RequestBody.create(MutilPart_Form_Data,file1);
        RequestBody body2 = RequestBody.create(MutilPart_Form_Data,file2);

        Map map = new HashMap();
        //map.put("useRegCode","33106101112018019999");
        //map.put("elevId","235");
        map.put("name","张三飞机额外");
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file",file1.getName(),body1)
                //.addFormDataPart("wellholeImg",file2.getName(),body2)
                .addFormDataPart("keyVo", JSON.toJSONString(map))
                .build();
        Request request = new Request.Builder()
                .url("http://192.168.53.22:8089/drip-minio/file/upload")
                .post(requestBody)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            String str = response.body().string();
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
