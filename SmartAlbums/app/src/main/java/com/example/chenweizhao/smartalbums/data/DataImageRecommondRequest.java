package com.example.chenweizhao.smartalbums.data;

import java.io.Serializable;
import java.util.Map;

public class DataImageRecommondRequest implements Serializable {
    private String access_token;
    private Map<String, String> recom_img;

    public DataImageRecommondRequest(String access_token, Map<String, String> recom_img) {
        this.access_token = access_token;
        this.recom_img = recom_img;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setRecom_img(Map<String, String> recom_img) {
        this.recom_img = recom_img;
    }

    public Map<String, String> getRecom_img() {
        return recom_img;
    }

    public String getAccess_token() {
        return access_token;
    }
}
