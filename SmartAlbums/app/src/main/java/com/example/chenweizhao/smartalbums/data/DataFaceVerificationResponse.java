package com.example.chenweizhao.smartalbums.data;

import java.io.Serializable;

public class DataFaceVerificationResponse implements Serializable {
    private Status status;
    private ServiceCode service;
    public DataBody data;

    public DataFaceVerificationResponse(Status status, ServiceCode service, DataBody data) {
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
        private Boolean is_face;
        private String msg;
        private float similarity_degree;

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public void setIs_face(Boolean is_face) {
            this.is_face = is_face;
        }

        public void setSimilarity_degree(float similarity_degree) {
            this.similarity_degree = similarity_degree;
        }

        public String getMsg() {
            return msg;
        }

        public Boolean getIs_face() {
            return is_face;
        }

        public float getSimilarity_degree() {
            return similarity_degree;
        }
    }
}
