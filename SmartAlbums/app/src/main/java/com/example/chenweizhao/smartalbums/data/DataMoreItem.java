package com.example.chenweizhao.smartalbums.data;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class DataMoreItem {
    private Drawable icon;
    private String content;

    public DataMoreItem(Drawable icon, String content) {
        this.icon = icon;
        this.content = content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public Drawable getIcon() {
        return icon;
    }

    public String getContent() {
        return content;
    }
}
