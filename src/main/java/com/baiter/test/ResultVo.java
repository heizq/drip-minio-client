package com.baiter.test;

import java.io.Serializable;

/**
 * Created by lenovo on 2017/12/22.
 */
public class ResultVo implements Serializable{

    private boolean success;

    private String message;

    private Object result;

    private boolean hasNext;

    public ResultVo() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }
}
