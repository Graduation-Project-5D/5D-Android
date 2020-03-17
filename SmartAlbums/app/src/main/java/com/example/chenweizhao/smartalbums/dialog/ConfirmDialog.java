package com.example.chenweizhao.smartalbums.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.chenweizhao.smartalbums.R;

public class ConfirmDialog extends Dialog {
    private Context context;
    private TextView titleTv,contentTv;
    private View okBtn,cancelBtn;

    public ConfirmDialog(Context context, String title, String content, View.OnClickListener listener) {
        super(context);
        initalize();
        this.context = context;
        titleTv.setText(title);
        contentTv.setText(content);
        okBtn.setOnClickListener(listener);

    }

    //初始化View
    private void initalize() {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.confirm_dialog_quit, null);
        setContentView(view);
        initWindow();

        titleTv = (TextView) findViewById(R.id.title_name);
        contentTv = (TextView) findViewById(R.id.text_view);
        okBtn = findViewById(R.id.btn_ok);
        cancelBtn = findViewById(R.id.btn_cancel);

        cancelBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    /**
     *添加黑色半透明背景
     */
    private void initWindow() {
        Window dialogWindow = getWindow();
        dialogWindow.setBackgroundDrawable(new ColorDrawable(0));//设置window背景
        dialogWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);//设置输入法显示模式
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        DisplayMetrics d = context.getResources().getDisplayMetrics();//获取屏幕尺寸
        lp.width = (int) (d.widthPixels * 0.8); //宽度为屏幕80%
        lp.gravity = Gravity.CENTER;  //中央居中
        dialogWindow.setAttributes(lp);
    }
}