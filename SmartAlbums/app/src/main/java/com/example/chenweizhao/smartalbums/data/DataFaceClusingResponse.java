package com.example.chenweizhao.smartalbums.data;

import java.io.Serializable;
import java.util.Map;

public class DataFaceClusingResponse implements Serializable {
    private Status status;
    private ServiceCode service;
    DataBody data;

    public void setService(ServiceCode service) {
        this.service = service;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setData(DataBody data) {
        this.data = data;
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


    public class DataBody {
        private int class_num;
        private Map<Integer , Map<String, String>> class_result;

        public void setClass_num(int class_num) {
            this.class_num = class_num;
        }

        public void setClass_result(Map<Integer, Map<String, String>> class_result) {
            this.class_result = class_result;
        }

        public int getClass_num() {
            return class_num;
        }

        public Map<Integer, Map<String, String>> getClass_result() {
            return class_result;
        }
    }
}
