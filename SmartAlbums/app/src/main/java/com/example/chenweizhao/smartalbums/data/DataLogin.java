package com.example.chenweizhao.smartalbums.data;

import java.io.Serializable;

//登录请求包

public class DataLogin implements Serializable {
    private String uid;
    private String refresh_token;
    private String access_token;

    public DataLogin(String uid, String refresh_token, String access_token) {
        this.uid = uid;
        this.refresh_token = refresh_token;
        this.access_token = access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public String getUid() {
        return uid;
    }
}
