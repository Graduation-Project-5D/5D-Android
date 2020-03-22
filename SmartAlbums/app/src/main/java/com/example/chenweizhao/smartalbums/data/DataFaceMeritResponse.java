package com.example.chenweizhao.smartalbums.data;

import java.io.Serializable;
import java.util.ArrayList;

public class DataFaceMeritResponse implements Serializable {
    private Status status;
    private ServiceCode service;
    private DataFaceDetectionResponse.DataBody data;

    public class DataBody implements Serializable{
        private ArrayList<String> best_img;

        public void setFace_list(ArrayList<String> face_list) {
            this.best_img = face_list;
        }

        public ArrayList<String> getFace_list() {
            return best_img;
        }
    }
}
