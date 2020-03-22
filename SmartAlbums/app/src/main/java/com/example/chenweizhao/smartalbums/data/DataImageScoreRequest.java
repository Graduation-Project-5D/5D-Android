package com.example.chenweizhao.smartalbums.data;

import java.io.Serializable;
import java.util.Map;

public class DataImageScoreRequest implements Serializable {
    private String access_token;
    private Map<String, String> choiceimg_list;

    public DataImageScoreRequest(String access_token, Map<String, String> choiceimg_list) {
        this.access_token = access_token;
        this.choiceimg_list = choiceimg_list;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setChoiceimg_list(Map<String, String> choiceimg_list) {
        this.choiceimg_list = choiceimg_list;
    }

    public String getAccess_token() {
        return access_token;
    }

    public Map<String, String> getChoiceimg_list() {
        return choiceimg_list;
    }
}
