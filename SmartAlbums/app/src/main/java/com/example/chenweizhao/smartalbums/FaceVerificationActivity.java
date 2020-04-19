package com.example.chenweizhao.smartalbums;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chenweizhao.smartalbums.data.DataImageFile;
import com.example.chenweizhao.smartalbums.view.SimpleRoundProgress;

import java.util.ArrayList;

public class FaceVerificationActivity extends AppCompatActivity {

    ArrayList<DataImageFile> selectedImageFiles;
    ImageView image1;
    ImageView image2;
    SimpleRoundProgress progress;
    TextView textView;
    private Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_verification);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        progress = findViewById(R.id.progress);
        textView = findViewById(R.id.progress_number);

        selectedImageFiles = (ArrayList<DataImageFile>)getIntent().getSerializableExtra("files");
        if (selectedImageFiles != null) {
            String iamgeurl1 = selectedImageFiles.get(0).getmThumbUri();
            String iamgeurl2 = selectedImageFiles.get(1).getmThumbUri();
            image1.setImageURI(Uri.parse((String) iamgeurl1));
            image2.setImageURI(Uri.parse((String) iamgeurl2));

        }
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 0:
                        progress.setProgress(msg.arg1);
                        textView.setText(msg.arg1 + "");
                        break;
                }
            }

        };
        refresh();
    }

    private void refresh() {
        final int percent = 94;
        new Thread(new Runnable() {
            Message msg = null;

            @Override
            public void run() {
                int start = 0;
                while (start <= percent) {
                    msg = new Message();
                    msg.what = 0;
                    msg.arg1 = start;
                    handler.sendMessage(msg);
                    start++;
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();
    }
}
