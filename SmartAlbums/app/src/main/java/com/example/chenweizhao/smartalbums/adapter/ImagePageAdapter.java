package com.example.chenweizhao.smartalbums.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.chenweizhao.smartalbums.R;

import java.util.ArrayList;

public class ImagePageAdapter extends PagerAdapter {
    private Context mContext;
    private ArrayList<View> viewLists;

    public ImagePageAdapter(Context context, ArrayList<View> viewLists) {
        super();
        this.viewLists = viewLists;
        mContext = context;
    }

    @Override
    public int getCount() {
        return viewLists.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewLists.get(position));
        return viewLists.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewLists.get(position));
    }


}
