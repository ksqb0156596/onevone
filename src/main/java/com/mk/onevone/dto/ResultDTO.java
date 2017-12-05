package com.mk.onevone.dto;

/**
 * Created by 01436296 on 2017/10/12.
 */
public class ResultDTO<T> {
    private int status = 1;//0失败 1成功 9登录超时
    private String message;
    private T result;

    public ResultDTO(){}
    public ResultDTO(int status){
        this.status = status;
    }
    public ResultDTO(int status,String message){
        this.status = status;
        this.message = message;
    }
    public ResultDTO(int status,T t){
        this.status = status;
        this.result = t;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
