package com.example.chenweizhao.smartalbums.data;

import java.io.Serializable;
import java.util.Map;


public class DataFaceClusingRequest implements Serializable {
    private String access_token;
    private Map<String, String> human_list;

    public DataFaceClusingRequest(String access_token, Map<String, String> face_img) {
        this.access_token = access_token;
        this.human_list = face_img;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setFace_img(Map<String, String> face_img) {
        this.human_list = face_img;
    }

    public String getAccess_token() {
        return access_token;
    }
}

