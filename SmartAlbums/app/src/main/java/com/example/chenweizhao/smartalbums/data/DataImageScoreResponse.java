package com.example.chenweizhao.smartalbums.data;

import java.util.Map;

public class DataImageScoreResponse {
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
        private Map<String, Integer> score;

        public void setScore(Map<String, Integer> score) {
            this.score = score;
        }

        public Map<String, Integer> getScore() {
            return score;
        }
    }
}
