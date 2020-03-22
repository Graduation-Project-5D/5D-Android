package com.example.chenweizhao.smartalbums.data;

import java.io.Serializable;
import java.util.Map;

public class DataImageFilterResponse implements Serializable {
    private Status status;
    private ServiceCode service;
    public DataBody data;

    public DataImageFilterResponse(Status status, ServiceCode service, DataBody data) {
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
        private Map<String, String> img_filtered;

        public void setImg_filtered(Map<String, String> img_filtered) {
            this.img_filtered = img_filtered;
        }

        public Map<String, String> getImg_filtered() {
            return img_filtered;
        }
    }
}
