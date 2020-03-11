package com.example.chenweizhao.smartalbums;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.example.chenweizhao.smartalbums.adapter.ImagePageAdapter;
import com.example.chenweizhao.smartalbums.data.DataImageFile;

import java.net.URI;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private ImageView mBack;
    private ImageView mMore;
    private ImageView mSelected_image;
    private ViewPager mViewPage;
    private RadioGroup mRadioGroup;
    private ArrayList<DataImageFile> mSelectedImageFiles;
    private LinearLayout linearLayout;

    //mImageViewIndex维护当前被点击imageview的下标
    private int mImageViewIndex;
    //viewpage里所有imageview的集合
    private ArrayList<ImageView> mImageViews;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mSelectedImageFiles = (ArrayList<DataImageFile>) getIntent().getSerializableExtra("selectedimagefiles");

        initView();

        initData();


        initAction();
    }

    private void initView() {
        mBack = findViewById(R.id.home_back);
        mMore = findViewById(R.id.home_more);
        mSelected_image = findViewById(R.id.selected_image);
        mViewPage = findViewById(R.id.viewpage);
        mRadioGroup = findViewById(R.id.radioGroup);
        linearLayout = findViewById(R.id.container);
    }

    private void initData() {
        mImageViews = new ArrayList<>();
        mImageViewIndex = 0;
        if (mSelectedImageFiles != null) {
            ArrayList<View> views = new ArrayList<>();
            for (int i = 0; i < mSelectedImageFiles.size(); i++) {
                View view = LayoutInflater.from(this).inflate(R.layout.item_image_viewpage, null);
                final ImageView imageView = view.findViewById(R.id.item_image);
                mImageViews.add(imageView);
                imageView.setImageURI(Uri.parse(mSelectedImageFiles.get(i).getmThumbUri()));
                if (i == 0) {
                    mSelected_image.setImageURI(Uri.parse(mSelectedImageFiles.get(i).getmImageUri()));
                    upImageView(imageView);
                    mImageViewIndex = 0;
                }
                final int position = i;
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mImageViewIndex != position) {
                            mSelected_image.setImageURI(Uri.parse(mSelectedImageFiles.get(position).getmImageUri()));
                            //上升点击的imageview位置,同时降低原先被选中imageview的高度
                            upImageView(imageView);
                            downImageView(mImageViews.get(mImageViewIndex));
                            mImageViewIndex = position;
                        }


                    }
                });
                views.add(view);
            }
            ImagePageAdapter imagePageAdapter = new ImagePageAdapter(this, views);
            // 1.设置幕后item的缓存数目
            mViewPage.setOffscreenPageLimit(5);
            // 2.设置页与页之间的间距  
            mViewPage.setPageMargin(0);
            mViewPage.setAdapter(imagePageAdapter);

            mViewPage.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int i, float v, int i1) {

                }

                @Override
                public void onPageSelected(int i) {
                    //滑动时被选中的页面下标
                    if (i > mImageViewIndex) {
                        downImageView(mImageViews.get(mImageViewIndex));
                        upImageView(mImageViews.get(i));
                        mSelected_image.setImageURI(Uri.parse(mSelectedImageFiles.get(i).getmImageUri()));
                        mImageViewIndex = i;
                    }
                }

                @Override
                public void onPageScrollStateChanged(int i) {

                }
            });
        }
    }

    private void initAction() {
        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return mViewPage.dispatchTouchEvent(event);
            }
        });

    }
    private int dpTopx(float dpValue){
        final float scale= getResources().getDisplayMetrics().density;
        return (int)(dpValue*scale+0.5f);
    }

    //imageview上移
    private void upImageView(ImageView imageView) {
        ViewGroup.MarginLayoutParams margin = new ViewGroup.MarginLayoutParams(imageView.getLayoutParams());
        margin.setMargins(0, 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(margin);
        imageView.setLayoutParams(layoutParams);
    }


    //imageview下移
    private void downImageView(ImageView imageView) {
        ViewGroup.MarginLayoutParams margin = new ViewGroup.MarginLayoutParams(imageView.getLayoutParams());
        margin.setMargins(0, dpTopx(10), 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(margin);
        imageView.setLayoutParams(layoutParams);
    }

}
