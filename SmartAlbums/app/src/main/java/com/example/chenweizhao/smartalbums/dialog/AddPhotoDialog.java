package com.example.chenweizhao.smartalbums.dialog;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chenweizhao.smartalbums.R;
import com.example.chenweizhao.smartalbums.tools.AddPhotoHelper;
import com.example.chenweizhao.smartalbums.tools.Constant;

import java.io.File;

public class AddPhotoDialog extends Dialog {
    private View mAddPhotoByAlbum;
    private TextView mAddPhotoByCamera;
    private Activity mActivity;
    View mDialog;

    public AddPhotoDialog(Activity activity) {
        super(activity, R.style.AddPhotoDialog);
        mActivity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDialog = LayoutInflater.from(mActivity).inflate(
                R.layout.dialog_add_photo_type, null);
        setContentView(mDialog);
        init();
    }

    @Override
    public void show() {
        super.show();
    }

    private void init() {
        mAddPhotoByAlbum = mDialog.findViewById(R.id.add_photo_by_album);
        mAddPhotoByCamera = mDialog.findViewById(R.id.add_photo_by_camera);

        mAddPhotoByAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPhotoByAlbum();
            }
        });

        mAddPhotoByCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPhotoByCamera();
            }
        });
    }


    //申请权限并打开相机
    private void addPhotoByCamera() {
        if (ContextCompat.checkSelfPermission(mActivity, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.CAMERA}, Constant.REQUESTCAMERACODE);
        } else {
            AddPhotoHelper.openCamera(mActivity);
        }
    }


    //申请权限并打开相册
    private void addPhotoByAlbum() {
        if (ContextCompat.checkSelfPermission(mActivity, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, Constant.REQUESTALBUMCODE);
        } else {
            AddPhotoHelper.openAlbum(mActivity);
        }
    }









}
