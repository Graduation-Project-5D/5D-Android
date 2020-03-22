package com.example.chenweizhao.smartalbums.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;


//图片上传响应
public class DataUploadImageResponse implements Serializable {
    private Status status;
    private ImageData data;

    public DataUploadImageResponse(Status status, ImageData data) {
        this.status = status;
        this.data = data;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setData(ImageData data) {
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public ImageData getData() {
        return data;
    }

    public class ImageData {
        Map<String, String> img_list;
        public ImageData(Map<String, String> img_list) {
            this.img_list = img_list;
        }

        public void setImg_list(Map<String, String> img_list) {
            this.img_list = img_list;
        }

        public Map<String, String> getImg_list() {
            return img_list;
        }
    }
}
