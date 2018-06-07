package com.baiter.test.rest;


import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by lenovo on 2018/3/2.
 */
public class JpushClient {

    public static void main(String[] args) {
        Map map = new HashMap();
        Map alias = new HashMap();
        String[] arr = {"2891","2890"};
        alias.put("alias",arr);
        map.put("platform","android");
        map.put("audience",alias);
        Map notification =  new HashMap();
        Map android =  new HashMap();
        Map extras = new HashMap();
        extras.put("useRegCode","31106101112018029987");
        extras.put("area","西安市灞桥区世园大道紫竹小区3-1");
        android.put("title","西安特监信息平台");
        android.put("alert","电梯【31106101122015113010】故障");
        android.put("extras",extras);

        notification.put("android",android);
        map.put("notification",notification);

        JpushClientUtils.pushMsg(JSON.toJSONString(map));
    }


}
