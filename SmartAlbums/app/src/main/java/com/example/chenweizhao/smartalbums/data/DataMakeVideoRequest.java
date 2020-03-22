package com.example.chenweizhao.smartalbums.data;

import java.io.Serializable;
import java.util.Map;

public class DataMakeVideoRequest implements Serializable {
    private String access_token;
    private Map<String, String> vid_list;
    private String filters_tmp;
    private String closeup_tmp;

    public DataMakeVideoRequest(String access_token, Map<String, String> vid_list,
                                String filters_tmp, String closeup_tmp) {
        this.access_token = access_token;
        this.vid_list = vid_list;
        this.filters_tmp = filters_tmp;
        this.closeup_tmp = closeup_tmp;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setCloseup_tmp(String closeup_tmp) {
        this.closeup_tmp = closeup_tmp;
    }

    public void setFilters_tmp(String filters_tmp) {
        this.filters_tmp = filters_tmp;
    }

    public void setVid_list(Map<String, String> vid_list) {
        this.vid_list = vid_list;
    }

    public String getAccess_token() {
        return access_token;
    }

    public Map<String, String> getVid_list() {
        return vid_list;
    }

    public String getCloseup_tmp() {
        return closeup_tmp;
    }

    public String getFilters_tmp() {
        return filters_tmp;
    }
}
