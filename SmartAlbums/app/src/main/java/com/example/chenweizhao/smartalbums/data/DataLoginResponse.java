package com.example.chenweizhao.smartalbums.data;

import java.io.Serializable;

//登录请求响应包

public class DataLoginResponse implements Serializable {
    private Status status;
    private DataToken data;


    public void setData(DataToken data) {
        this.data = data;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public DataToken getData() {
        return data;
    }

    public Status getStatus() {
        return status;
    }
}
