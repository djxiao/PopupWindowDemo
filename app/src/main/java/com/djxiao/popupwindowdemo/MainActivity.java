package com.djxiao.popupwindowdemo;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.djxiao.popupwindowdemo.views.PopupDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews(){
        Button btnShowPopup = (Button) findViewById(R.id.btn_show_popup);
        btnShowPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupDialog();
            }
        });

        Button btnShowPopupFromBottom = (Button) findViewById(R.id.btn_show_popup_from_bottom);
        btnShowPopupFromBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupFromBottom();
            }
        });
    }

    private void showPopupDialog(){
        PopupDialog dialog = new PopupDialog(this);
        dialog.setTitle("温馨提示");
        dialog.setContent("这里是弹框内容");
        dialog.setPositiveListener("确定内容", new PopupDialog.OnDialogClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击了确定按钮", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setNagetiveListener("取消按钮", new PopupDialog.OnDialogClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击了取消按钮", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show(findViewById(R.id.btn_show_popup), LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
    }

    private void showPopupFromBottom(){
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.popup_dialog_from_buttom,null);
        PopupWindow window = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        window.setFocusable(true);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        window.setBackgroundDrawable(dw);

        window.setAnimationStyle(R.style.popup_window_style);
        window.showAtLocation(findViewById(R.id.btn_show_popup_from_bottom), Gravity.BOTTOM,0,0);
    }

}
