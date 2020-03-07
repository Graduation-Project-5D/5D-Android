package com.example.chenweizhao.smartalbums.data;

import android.os.Parcelable;

import java.io.Serializable;

public class DataImageFile implements Serializable{
    private int mImageId;
    private String mImageUri;
    private String mThumbUri;
    private String mWebUri;

    public DataImageFile(int id, String imageUri, String thumbUri) {
        mImageId = id;
        mImageUri = imageUri;
        mThumbUri = thumbUri;
    }



    public void setmImageId(int mImageId) {
        this.mImageId = mImageId;
    }

    public void setmImageUri(String mImageUri) {
        this.mImageUri = mImageUri;
    }

    public void setmThumbUri(String mThumbUri) {
        this.mThumbUri = mThumbUri;
    }

    public void setmWebUri(String mWebUri) {
        this.mWebUri = mWebUri;
    }

    public int getmImageId() {
        return mImageId;
    }

    public String getmImageUri() {
        return mImageUri;
    }

    public String getmThumbUri() {
        return mThumbUri;
    }

    public String getmWebUri() {
        return mWebUri;
    }
}
