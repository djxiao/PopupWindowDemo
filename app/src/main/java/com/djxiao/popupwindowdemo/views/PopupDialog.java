package com.djxiao.popupwindowdemo.views;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.djxiao.popupwindowdemo.R;

/**
 * @author djxiao
 * @create 2016/8/1 09:28
 * @DESC  这里是一个弹框样式
 */
public class PopupDialog {

    private PopupWindow popupWindow;
    private LayoutInflater inflater;

    private Context context;

    private View contentView;//整个的View
    private TextView tvTitle;//标题  如：温馨提示
    private TextView tvContent;//提示内容
    private Button btnCancle;//取消按钮
    private Button btnOk;//确定按钮

    public PopupDialog(Context context){

        this.context = context;
        inflater = LayoutInflater.from(context);

        initViews();
    }

    /**
     * 初始化控件
     */
    private void initViews(){

        contentView = inflater.inflate(R.layout.popup_dialog,null);
        tvTitle = (TextView) contentView.findViewById(R.id.tv_title);
        tvContent = (TextView) contentView.findViewById(R.id.tv_content);
        btnCancle = (Button) contentView.findViewById(R.id.btn_cancle);
        btnOk = (Button) contentView.findViewById(R.id.btn_ok);
    }

    /**
     * 设置标题内容
     * @param title
     * @return
     */
    public PopupDialog setTitle(String title){
        tvTitle.setText(title);
        return this;
    }

    /**
     * 设置标题内容
     * @param title
     * @return
     */
    public PopupDialog setTitle(CharSequence title){
        tvTitle.setText(title);
        return this;
    }

    /**
     * 设置需要展示的文本内容
     * @param content
     * @return
     */
    public PopupDialog setContent(String content){
        tvContent.setText(content);
        return this;
    }

    /**
     * 设置需要展示的文本内容
     * @param content
     * @return
     */
    public PopupDialog setContent(CharSequence content){
        tvContent.setText(content);
        return this;
    }

    /**
     * 确定方法
     * @param lable  设置确定按钮的文本内容
     * @param listener  设置点击确定事件的监听器
     * @return
     */
    public PopupDialog setPositiveListener(String lable, final OnDialogClickListener listener){
        btnOk.setText(lable);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                close();
                if(listener != null){
                    listener.onClick(view);
                }
            }
        });

        return this;
    }

    /**
     * 取消方法
     * @param lable  设置按钮文本内容
     * @param listener  设置点击事件的监听器
     * @return
     */
    public PopupDialog setNagetiveListener(String lable, final OnDialogClickListener listener){
        btnCancle.setText(lable);
        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                close();
                if(listener != null){
                    listener.onClick(view);
                }
            }
        });
        return this;
    }

    /**
     * 关闭弹框
     */
    public void close(){
        if(popupWindow != null && popupWindow.isShowing()){
            popupWindow.dismiss();
        }
    }

    /**
     *   显示弹框
     * @param view  弹框显示相对view的位置
     * @param width  弹框的宽度
     * @param height  弹框的高度
     * @param x  x轴的偏移量
     * @param y  y轴的偏移量
     * @param gravity  位置
     */
    public void show(View view,int width,int height,int x,int y ,int gravity){

        if(popupWindow == null){
            popupWindow = new PopupWindow(contentView,width,height);
        }
        if(!popupWindow.isShowing()){
            popupWindow.showAtLocation(view,gravity,x,y);
        }
    }

    /**
     *   显示弹框
     * @param view  弹框显示相对view的位置
     * @param width  弹框的宽度
     * @param height  弹框的高度
     * @param gravity  位置
     */
    public void show(View view,int width,int height,int gravity){

        if(popupWindow == null){
            popupWindow = new PopupWindow(contentView,width,height);
        }

        if(!popupWindow.isShowing()){
            popupWindow.showAtLocation(view,gravity,0,0);
        }
    }

    /**
     *   显示弹框
     * @param view  弹框显示相对view的位置
     * @param width  弹框的宽度
     * @param height  弹框的高度
     */
    public void show(View view,int width,int height){

        if(popupWindow == null){
            popupWindow = new PopupWindow(contentView,width,height,true);
        }
        if(!popupWindow.isShowing()){
            popupWindow.showAtLocation(view, Gravity.CENTER,0,0);
        }
    }

    /**
     * 监听事件
     */
    public interface OnDialogClickListener{
        void onClick(View v);
    }


}
