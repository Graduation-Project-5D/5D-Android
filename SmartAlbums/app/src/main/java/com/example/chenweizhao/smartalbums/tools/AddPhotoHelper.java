package com.example.chenweizhao.smartalbums.tools;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import com.example.chenweizhao.smartalbums.LocalAlbumActivity;
import com.example.chenweizhao.smartalbums.R;
import com.example.chenweizhao.smartalbums.data.DataImageFile;
import com.example.chenweizhao.smartalbums.dialog.LoadingDialog;

import java.util.ArrayList;
import java.util.HashMap;


//添加图片的帮助类，可选择拍照或从相册中选取
public class AddPhotoHelper {

    private static Object sLock = new Object();

    private static ArrayList<DataImageFile> sAllPictures;

    private static final String[] STORE_IMAGES = {
            MediaStore.Images.Media._ID,
            MediaStore.Images.Media.DATA,
            MediaStore.Images.Media.ORIENTATION
    };
    //小图遍历字段
    private static final String[] THUMBNAIL_STORE_IMAGE = {
            MediaStore.Images.Thumbnails._ID,
            MediaStore.Images.Thumbnails.DATA
    };

    public static void openAlbum(final Activity activity, Dialog dialog) {
        dialog.dismiss();
        final Dialog loadingDialog = new LoadingDialog(activity, R.style.LoadingDialog);
        loadingDialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                final ArrayList<DataImageFile> files = getAllPictures();
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        loadingDialog.dismiss();
                        if (files != null && files.size() > 0) {
                            Intent intent = new Intent(activity, LocalAlbumActivity.class);
                            intent.putExtra("files", files);
                            activity.startActivityForResult(intent, Constant.OPENALBUMCODE);
                        } else {
                            Toast.makeText(activity, "相册为空", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }).start();
    }

    public static void openCamera(Activity activity, Dialog dialog) {
        dialog.dismiss();
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        activity.startActivityForResult(intent, Constant.OPENCAMERACODE);

    }

    public static void preLoadAllPictures(final Activity activity) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (sLock) {
                    ArrayList<DataImageFile> imageFiles = new ArrayList<>();
                    //获取大图的游标
                    Cursor cursor = activity.getContentResolver().query(
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,  // 大图URI
                            STORE_IMAGES,   // 字段
                            null,         // No where clause
                            null,         // No where clause
                            MediaStore.Images.Media.DATE_TAKEN + " DESC"); //根据时间升序
                    if (cursor == null)
                        return;
                    while (cursor.moveToNext()) {
                        int id = cursor.getInt(0);//大图ID
                        String path = cursor.getString(1);//大图路径
                        String thumbUri = getThumbnail(id, activity);
                        String imageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon().
                                appendPath(Integer.toString(id)).build().toString();
                        if (imageUri.isEmpty()) {
                            continue;
                        }
                        if (thumbUri == null || thumbUri.isEmpty()) {
                            thumbUri = imageUri;
                        }
                        DataImageFile dataImageFile = new DataImageFile(id, imageUri, thumbUri);
                        imageFiles.add(dataImageFile);
                    }
                    cursor.close();
                    sAllPictures =  imageFiles;
                }
            }
        }).start();
    }

    /**
     * 得到本地图片文件
     * @return
     */
    public static ArrayList<DataImageFile> getAllPictures() {
        synchronized (sLock) {
            return sAllPictures;
        }

    }

    //获取大图对应的缩略图
    private static String getThumbnail(int id, Activity activity) {
        Cursor cursor = activity.getContentResolver().query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI,
                THUMBNAIL_STORE_IMAGE,
                MediaStore.Images.Thumbnails.IMAGE_ID + " = ?",
                new String[]{id + ""},
                null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            int thumId = cursor.getInt(0);
            String uri = MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI.buildUpon().
                    appendPath(Integer.toString(thumId)).build().toString();
            cursor.close();
            return uri;
        }
        cursor.close();
        return null;
    }
}
