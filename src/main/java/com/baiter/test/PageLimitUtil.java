package com.baiter.test;

/**
 * Created by lenovo on 2017/12/22.
 */
public class PageLimitUtil {
    public static boolean hasNext(int total,int rowNum, int currentPage){
        boolean flag = false;
        if(currentPage > 0 && rowNum > 0){
            flag = total > (currentPage * rowNum);
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(hasNext(47,5,10));
    }
}
