package com.example.chenweizhao.smartalbums.data;

public class ServiceCode {
    private String main_service;
    private String sub_service;

    public ServiceCode(String main_service, String sub_service) {
        this.main_service = main_service;
        this.sub_service = sub_service;
    }

    public void setMain_service(String main_service) {
        this.main_service = main_service;
    }

    public void setSub_service(String sub_service) {
        this.sub_service = sub_service;
    }

    public String getMain_service() {
        return main_service;
    }

    public String getSub_service() {
        return sub_service;
    }
}
