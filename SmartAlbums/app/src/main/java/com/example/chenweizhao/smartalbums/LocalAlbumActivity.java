package com.example.chenweizhao.smartalbums;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chenweizhao.smartalbums.adapter.AdapterLocalAlbumItem;
import com.example.chenweizhao.smartalbums.data.DataImageFile;

import java.util.ArrayList;

public class LocalAlbumActivity extends AppCompatActivity {
    private ImageView mBack;
    private TextView mFinish;
    private GridView mGridView;
    private ArrayList<DataImageFile> mImageFiles;
    private AdapterLocalAlbumItem mAdapterLocalAlbumItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_album_detail);
        initView();
        initData();
        initAction();
    }

    private void initView() {
        mBack = findViewById(R.id.local_album_back);
        mFinish = findViewById(R.id.local_album_finish);
        mGridView = findViewById(R.id.local_album_gridview);
    }

    private void initData() {
        mImageFiles = (ArrayList<DataImageFile>) getIntent().getSerializableExtra("files");
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
                Intent intent = new Intent(LocalAlbumActivity.this, HomeActivity.class);
                intent.putExtra("selectedimagefiles", selectedImageFiles);
                startActivity(intent);
                finish();
            }
        });
    }


}
