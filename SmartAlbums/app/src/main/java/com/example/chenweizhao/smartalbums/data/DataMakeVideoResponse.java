package com.example.chenweizhao.smartalbums.data;

import java.io.Serializable;

public class DataMakeVideoResponse implements Serializable {
    private Status status;
    private ServiceCode service;
    private DataBody data;

    public void setService(ServiceCode service) {
        this.service = service;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ServiceCode getService() {
        return service;
    }

    public DataBody getData() {
        return data;
    }

    public Status getStatus() {
        return status;
    }

    public void setData(DataBody data) {
        this.data = data;
    }

    public class DataBody {
        private String video_add;

        public void setVideo_add(String video_add) {
            this.video_add = video_add;
        }

        public String getVideo_add() {
            return video_add;
        }
    }

}
