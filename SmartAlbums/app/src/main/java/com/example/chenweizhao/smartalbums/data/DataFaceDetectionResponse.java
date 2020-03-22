package com.example.chenweizhao.smartalbums.data;

import java.io.Serializable;
import java.util.ArrayList;

public class DataFaceDetectionResponse implements Serializable {
    private Status status;
    private ServiceCode service;
    private DataBody data;






    public class DataBody implements Serializable{
        private Boolean isFace;
        private String msg;
        private ArrayList<String> face_list;

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public void setFace(Boolean face) {
            isFace = face;
        }

        public void setFace_list(ArrayList<String> face_list) {
            this.face_list = face_list;
        }

        public String getMsg() {
            return msg;
        }

        public ArrayList<String> getFace_list() {
            return face_list;
        }

        public Boolean getFace() {
            return isFace;
        }
    }

}
