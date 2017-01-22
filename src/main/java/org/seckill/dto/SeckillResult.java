package org.seckill.dto;

/**
 * Created by shou on 2017/1/5.
 */
//封装json
public class SeckillResult<T> {
    private boolean success;
    private T Data;
    private String error;

    public SeckillResult(boolean success, T Data) {
        this.success = success;
        this.Data = Data;
    }

    public SeckillResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return Data;
    }

    public void setData(T Data) {
        Data = Data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
