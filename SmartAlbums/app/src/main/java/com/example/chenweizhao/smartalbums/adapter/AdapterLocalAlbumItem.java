package com.example.chenweizhao.smartalbums.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.chenweizhao.smartalbums.AppContext;
import com.example.chenweizhao.smartalbums.R;
import com.example.chenweizhao.smartalbums.data.DataImageFile;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.ArrayList;
import java.util.List;



public class AdapterLocalAlbumItem extends BaseAdapter {
    private Context mContext;
    private DisplayImageOptions options;
    private ArrayList<DataImageFile> mImageFiles;
    private ArrayList<CheckBox> mAllCheckBoxes;
    public ArrayList<DataImageFile> mSelectedImageFiles;

    public AdapterLocalAlbumItem(Context context, ArrayList<DataImageFile> imageFiles) {
        mContext = context;
        mImageFiles = imageFiles;
        mSelectedImageFiles = new ArrayList<>();
        mAllCheckBoxes = new ArrayList<>();
        options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(false)
                .showImageForEmptyUri(R.drawable.error)
                .showImageOnFail(R.drawable.error)
                .showImageOnLoading(R.drawable.error)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .displayer(new SimpleBitmapDisplayer()).build();
    }

    @Override
    public int getCount() {
        return mImageFiles.size();
    }

    @Override
    public DataImageFile getItem(int i) {
        return mImageFiles.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder();
        final DataImageFile imageFile = mImageFiles.get(i);
        if (convertView == null || convertView.getTag() == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_local_album, null);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            viewHolder.checkBox = (CheckBox) convertView.findViewById(R.id.checkbox);
            mAllCheckBoxes.add(viewHolder.checkBox);
            viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        mSelectedImageFiles.add(imageFile);
                    } else {
                        mSelectedImageFiles.remove(imageFile);
                    }
                }
            });
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ImageLoader.getInstance().displayImage(imageFile.getmThumbUri(), viewHolder.imageView, options,
                loadingListener, null);
        return convertView;
    }

    private class ViewHolder {
        ImageView imageView;
        CheckBox checkBox;
    }

    public void selectAllImage() {
        mSelectedImageFiles.clear();
        for (int i = 0; i < mAllCheckBoxes.size(); i++) {
            if (!mAllCheckBoxes.get(i).isChecked()) {
                mAllCheckBoxes.get(i).setChecked(true);
            }
        }
    }


    SimpleImageLoadingListener loadingListener = new   SimpleImageLoadingListener() {
        @Override
        public void onLoadingComplete(String imageUri, View view, final Bitmap bm) {
            if (TextUtils.isEmpty(imageUri)) {
                return;
            }
            //由于很多图片是白色背景，在此处加一个#eeeeee的滤镜，防止checkbox看不清
            try {
                ((ImageView) view).getDrawable().setColorFilter(Color.argb(0xff, 0xee, 0xee, 0xee), PorterDuff.Mode.MULTIPLY);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
}
