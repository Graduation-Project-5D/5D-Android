package com.example.chenweizhao.smartalbums.data;

import java.io.Serializable;
import java.util.Map;

public class DataFaceVerificationRequest implements Serializable {
    private String access_token;
    private Map<String, String> face_imgs;

    public DataFaceVerificationRequest(String access_token, Map<String, String> face_img) {
        this.access_token = access_token;
        this.face_imgs = face_img;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setFace_img(Map<String, String> face_img) {
        this.face_imgs = face_img;
    }

    public String getAccess_token() {
        return access_token;
    }
}
