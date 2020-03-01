package com.example.chenweizhao.smartalbums.tools;

import android.app.Activity;
import android.content.Intent;
import android.provider.MediaStore;



//添加图片的帮助类，可选择拍照或从相册中选取
public class AddPhotoHelper {
    public static void openAlbum(Activity activity) {
        Intent albumIntent = new Intent(Intent.ACTION_PICK, null);
        albumIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        activity.startActivityForResult(albumIntent, Constant.OPENALBUMCODE);
    }

    public static void openCamera(Activity activity) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        activity.startActivityForResult(intent, Constant.OPENCAMERACODE);

    }
}
