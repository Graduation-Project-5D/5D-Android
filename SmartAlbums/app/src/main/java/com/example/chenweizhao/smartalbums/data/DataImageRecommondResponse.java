package com.example.chenweizhao.smartalbums.data;

import java.io.Serializable;
import java.util.Map;

public class DataImageRecommondResponse implements Serializable {
    private Status status;
    private ServiceCode service;
    private DataBody data;

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
        private Map<String, String> img_recommended;

        public void setImg_recommended(Map<String, String> img_recommended) {
            this.img_recommended = img_recommended;
        }

        public Map<String, String> getImg_recommended() {
            return img_recommended;
        }

    }
}
