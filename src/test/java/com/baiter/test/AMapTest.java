package com.baiter.test;

import com.baiter.test.map.AMapUtils;
import com.baiter.test.map.LngLat;
import org.junit.Test;

/**
 * Created by lenovo on 2018/1/24.
 */
public class AMapTest {
    @Test
    public void Test()
    {
        LngLat start = new LngLat(109.057716,34.325419);
        LngLat end = new LngLat(109.058059,34.331515);
        System.err.println(AMapUtils.calculateLineDistance(start, end));
    }
}
