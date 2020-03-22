package com.example.chenweizhao.smartalbums.data;

import java.io.Serializable;

public class Status implements Serializable {
    private int code;
    private String msg;

    public Status(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
