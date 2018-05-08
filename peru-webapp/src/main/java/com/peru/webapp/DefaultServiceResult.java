package com.peru.webapp;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by roger.lu on 2018/1/11.
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DefaultServiceResult {

    private boolean isSuccess;
    private String error;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private Object data;

    public DefaultServiceResult(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }


    public DefaultServiceResult(Object data) {
        this.isSuccess = true;
        this.data = data;
    }

    public DefaultServiceResult(boolean isSuccess, String error) {
        this.isSuccess = isSuccess;
        this.error = error;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
