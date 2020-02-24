package com.example.chenweizhao.smartalbums.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chenweizhao.smartalbums.R;

public class AddPhotoDialog extends Dialog {
    private View mAddPhotoByAlbum;
    private TextView mAddPhotoByCamera;
    private Context mContext;
    View mDialog;

    public AddPhotoDialog(Context context) {
        super(context, R.style.AddPhotoDialog);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDialog = LayoutInflater.from(mContext).inflate(
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
                Toast.makeText(mContext, "相册", Toast.LENGTH_SHORT).show();
            }
        });

        mAddPhotoByCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "拍照", Toast.LENGTH_SHORT).show();
            }
        });
    }




}
