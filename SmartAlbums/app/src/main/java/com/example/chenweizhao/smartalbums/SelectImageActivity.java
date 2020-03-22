package com.example.chenweizhao.smartalbums;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chenweizhao.smartalbums.adapter.AdapterLocalAlbumItem;
import com.example.chenweizhao.smartalbums.data.DataImageFile;

import java.util.ArrayList;

public class SelectImageActivity extends AppCompatActivity {
    private ImageView mBack;
    private TextView mFinish;
    private TextView mSelectAll;
    private GridView mGridView;
    private ArrayList<DataImageFile> mImageFiles;
    private AdapterLocalAlbumItem mAdapterLocalAlbumItem;

    //表示来源并且跳转选择完图片的跳转对象
    //1为人脸检测（1张图片），2为人脸验证（2张图片），3为精彩视频，4为滤镜照片，5为镜头特写，6为只能推荐（图片大于等于1）
    private int mSelectCountsType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_image);
        initView();
        initData();
        initAction();
    }

    private void initView() {
        mBack = findViewById(R.id.local_album_back);
        mFinish = findViewById(R.id.local_album_finish);
        mSelectAll = findViewById(R.id.select_all_image);
        mGridView = findViewById(R.id.local_album_gridview);
    }

    private void initData() {
        mImageFiles = (ArrayList<DataImageFile>) getIntent().getSerializableExtra("files");
        mSelectCountsType = getIntent().getIntExtra("selectcountstype", -1);
        mAdapterLocalAlbumItem = new AdapterLocalAlbumItem(this, mImageFiles);
        mGridView.setAdapter(mAdapterLocalAlbumItem);
    }

    private void initAction() {
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<DataImageFile> selectedImageFiles = mAdapterLocalAlbumItem.mSelectedImageFiles;
                if (selectedImageFiles == null || selectedImageFiles.size() == 0) {
                    Toast.makeText(SelectImageActivity.this, "未选择图片", Toast.LENGTH_SHORT).show();
                    return;
                }
                //人脸检测
                if (mSelectCountsType == 1 || mSelectCountsType == 2) {
                    if (selectedImageFiles.size() > mSelectCountsType) {
                        Toast.makeText(SelectImageActivity.this, "最多只能选择" + mSelectCountsType + "照片", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                //mSelectCountsType为1是人脸检测（1张图片），2为人脸验证（2张图片），3为精彩视频，4为滤镜照片，5为镜头特写，6为智能推荐（图片大于等于1）
                switch (mSelectCountsType) {
                    case 1:
                        Intent intent1 = new Intent(SelectImageActivity.this, FaceDetectionActivity.class);
                        intent1.putExtra("files", selectedImageFiles);
                        startActivity(intent1);
                        finish();
                        break;
                    case 2:
                        Intent intent2 = new Intent(SelectImageActivity.this, FaceVerificationActivity.class);
                        intent2.putExtra("files", selectedImageFiles);
                        startActivity(intent2);
                        finish();
                        break;
                    case 3:

                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    default:
                        break;
                }

//                ArrayList<DataImageFile> selectedImageFiles = mAdapterLocalAlbumItem.mSelectedImageFiles;
//                Intent intent = new Intent(SelectImageActivity.this, HomeActivity.class);
//                intent.putExtra("selectedimagefiles", selectedImageFiles);
//                startActivity(intent);
//                finish();
            }
        });

        mSelectAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapterLocalAlbumItem.selectAllImage();
            }
        });
    }


}
