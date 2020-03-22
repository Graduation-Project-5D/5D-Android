package com.example.chenweizhao.smartalbums.data;

import java.io.Serializable;
import java.util.Map;

public class DataImageFilterRequest implements Serializable {
    private String access_token;
    private Map<String, String> filter_img;
    private String filters_tmp;

    public DataImageFilterRequest(String access_token, Map<String, String> filter_img,
                                  String filters_tmp) {
        this.access_token = access_token;
        this.filter_img = filter_img;
        this.filters_tmp = filters_tmp;
    }

    public void setFilters_tmp(String filters_tmp) {
        this.filters_tmp = filters_tmp;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setFilter_img(Map<String, String> filter_img) {
        this.filter_img = filter_img;
    }

    public String getFilters_tmp() {
        return filters_tmp;
    }

    public String getAccess_token() {
        return access_token;
    }

    public Map<String, String> getFilter_img() {
        return filter_img;
    }
}
