package com.example.chenweizhao.smartalbums.data;

import java.util.Map;

public class DataSpecialImageResponse {
    private Status status;
    private ServiceCode service;
    public DataBody data;

    public DataSpecialImageResponse(Status status, ServiceCode service, DataBody data) {
        this.service = service;
        this.status = status;
        this.data = data;
    }

    public void setData(DataBody data) {
        this.data = data;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setService(ServiceCode service) {
        this.service = service;
    }

    public Status getStatus() {
        return status;
    }

    public DataBody getData() {
        return data;
    }

    public ServiceCode getService() {
        return service;
    }



    public class DataBody {
        private Map<String, String> img_closeuped;

        public void setImg_closeuped(Map<String, String> img_closeuped) {
            this.img_closeuped = img_closeuped;
        }

        public Map<String, String> getImg_closeuped() {
            return img_closeuped;
        }
    }
}
