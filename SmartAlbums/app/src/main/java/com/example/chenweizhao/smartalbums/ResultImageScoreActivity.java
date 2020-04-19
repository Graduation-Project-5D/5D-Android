package com.example.chenweizhao.smartalbums;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.example.chenweizhao.smartalbums.adapter.AdapterImageScoreItem;
import com.example.chenweizhao.smartalbums.adapter.AdapterLocalAlbumItem;
import com.example.chenweizhao.smartalbums.data.DataImageFile;

import java.util.ArrayList;

public class ResultImageScoreActivity extends AppCompatActivity {

    private ArrayList<DataImageFile> allFiles;
    private GridView mGridView;
    private AdapterImageScoreItem mDapterImageScoreItem;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_image_score);
        allFiles = (ArrayList<DataImageFile>) getIntent().getSerializableExtra("files");

        mGridView = findViewById(R.id.local_album_gridview);

        mDapterImageScoreItem = new AdapterImageScoreItem(this, allFiles);
        mGridView.setAdapter(mDapterImageScoreItem);

    }
}
