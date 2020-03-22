package com.example.chenweizhao.smartalbums.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;


//上传图片请求body
public class DataUploadImageRequest implements Serializable {
    private Boolean is_cover;
    private String access_token;
    private Map<String, String> img_list;

    public DataUploadImageRequest(Boolean is_cover, String access_token, Map<String, String> img_list) {
        this.is_cover = is_cover;
        this.access_token = access_token;
        this.img_list = img_list;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setImg_list(Map<String, String> img_list) {
        this.img_list = img_list;
    }

    public void setIs_cover(Boolean is_cover) {
        this.is_cover = is_cover;
    }

    public String getAccess_token() {
        return access_token;
    }

    public Map<String, String> getImg_list() {
        return img_list;
    }

    public Boolean getIs_cover() {
        return is_cover;
    }
}
