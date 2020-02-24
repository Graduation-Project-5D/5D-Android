package com.example.chenweizhao.smartalbums;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImageView mMore;
    private ImageView mAddPhoto;
    private Context mContext;

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

        mContext = this;
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
            mPopupWindowView = LayoutInflater.from(mContext).inflate(
                    R.layout.popupwindow_more, null);
            mListView = mPopupWindowView.findViewById(R.id.more_list);
            mPopupWindow = new PopupWindow(mPopupWindowView,
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);


            mListView.setAdapter(getAdapterMoreItem());
            //弹窗点击事件
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(mContext, "" + position, Toast.LENGTH_SHORT).show();
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
            mAddPhotoDialog = new AddPhotoDialog(mContext);
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

        AdapterMoreItem adapterMoreItem = new AdapterMoreItem(datas, mContext);
        return adapterMoreItem;

    }

}
