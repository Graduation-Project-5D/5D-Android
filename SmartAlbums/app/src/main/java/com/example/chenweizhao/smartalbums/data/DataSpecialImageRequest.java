package com.example.chenweizhao.smartalbums.data;

import java.io.Serializable;
import java.util.Map;

public class DataSpecialImageRequest implements Serializable {
    private String access_token;
    private Map<String, String> closeup_img;

    public DataSpecialImageRequest(String access_token, Map<String, String> closeup_img) {
        this.access_token = access_token;
        this.closeup_img = closeup_img;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setCloseup_img(Map<String, String> closeup_img) {
        this.closeup_img = closeup_img;
    }

    public String getAccess_token() {
        return access_token;
    }

    public Map<String, String> getCloseup_img() {
        return closeup_img;
    }
}
