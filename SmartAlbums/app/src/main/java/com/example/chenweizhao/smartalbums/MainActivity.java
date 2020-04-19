package com.example.chenweizhao.smartalbums;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.chenweizhao.smartalbums.adapter.AdapterMoreItem;
import com.example.chenweizhao.smartalbums.data.DataMoreItem;
import com.example.chenweizhao.smartalbums.dialog.AddPhotoDialog;
import com.example.chenweizhao.smartalbums.tools.AddPhotoHelper;
import com.example.chenweizhao.smartalbums.tools.Constant;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    private ImageView mMore;
    private ImageView mAddPhoto;
    private Activity mActivity;

    //右上角弹出窗
    View mPopupWindowView;
    ListView mListView;
    PopupWindow mPopupWindow;
    Boolean isFirstShowPopupWindow = true;

    //添加图片选择弹窗
    Dialog mAddPhotoDialog;
    Boolean isFirstShowAddPhotoDialog = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddPhotoHelper.preLoadAllPictures(this);
        mActivity = this;
        mMore = findViewById(R.id.more);
        mAddPhoto = findViewById(R.id.add_photo);

        init();
    }

    private void init() {
        mMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopupWindow(v);
            }
        });

        mAddPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddPhotoDialog();
            }
        });
    }


    private void ShowPopupWindow(View view) {
        //第一次使用弹窗，初始化
        if (isFirstShowPopupWindow) {
            isFirstShowPopupWindow = false;
            mPopupWindowView = LayoutInflater.from(mActivity).inflate(
                    R.layout.popupwindow_more, null);
            mListView = mPopupWindowView.findViewById(R.id.more_list);
            mPopupWindow = new PopupWindow(mPopupWindowView,
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);


            mListView.setAdapter(getAdapterMoreItem());
            //弹窗点击事件
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(mActivity, "" + position, Toast.LENGTH_SHORT).show();
                    if (position == 0) {

                    } else if (position == 1) {

                    } else if (position ==2) {

                    } else {

                    }
                }
            });
        }
        mPopupWindow.showAsDropDown(view, -276, 0);
    }

    private void showAddPhotoDialog() {
        if (isFirstShowAddPhotoDialog) {
            isFirstShowAddPhotoDialog = false;
            mAddPhotoDialog = new AddPhotoDialog(mActivity);
        }
        mAddPhotoDialog.show();
    }



    private AdapterMoreItem getAdapterMoreItem() {
        Drawable drawable1 = getResources().getDrawable(R.drawable.course);
        Drawable drawable2 = getResources().getDrawable(R.drawable.setting);
        Drawable drawable3 = getResources().getDrawable(R.drawable.help);
        String content1 = getResources().getString(R.string.string_course);
        String content2 = getResources().getString(R.string.string_setting);
        String content3 = getResources().getString(R.string.string_help_and_feedback);

        DataMoreItem data1 = new DataMoreItem(drawable1, content1);
        DataMoreItem data2 = new DataMoreItem(drawable2, content2);
        DataMoreItem data3 = new DataMoreItem(drawable3, content3);

        ArrayList<DataMoreItem> datas = new ArrayList<>();
        datas.add(data1);
        datas.add(data2);
        datas.add(data3);

        AdapterMoreItem adapterMoreItem = new AdapterMoreItem(datas, mActivity);
        return adapterMoreItem;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //打开相册
        if (requestCode == Constant.OPENALBUMCODE){
            //RESULT_OK为-1,代表完成
            if (resultCode == RESULT_OK) {
                try {
                    Uri imageUri = data.getData();
                    if (imageUri != null) {
                        Bitmap bmp = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        mAddPhoto.setImageBitmap(bmp);
                    }
                } catch (Exception e) {
                    Log.e(TAG, e.toString());
                }

            } else if (resultCode == RESULT_CANCELED) { //取消

            }
        } else if (requestCode == Constant.OPENCAMERACODE) { //打开摄像头
            //RESULT_OK为-1,代表完成拍照
            if (resultCode == RESULT_OK) {
                Bitmap bmp = (Bitmap) data.getExtras().get("data");
                mAddPhoto.setImageBitmap(bmp);
            } else if (resultCode == RESULT_CANCELED) { //取消

            }
        }

    }

    /**
     * 获取权限的返回
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == Constant.REQUESTCAMERACODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                AddPhotoHelper.openCamera(mActivity, mAddPhotoDialog);

            } else {
                Toast.makeText(mActivity, "相机权限已被禁止,请在设置中打开", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == Constant.REQUESTALBUMCODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(mActivity, "相册权限申请成功", Toast.LENGTH_SHORT).show();

            } else {
                AddPhotoHelper.openAlbum(mActivity, mAddPhotoDialog);
            }
        }
    }

}
