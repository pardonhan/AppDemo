package com.youzai.appdemo.base;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.youzai.appdemo.R;

import butterknife.ButterKnife;

/**
 * Created by HanFL on 2016/12/29.
 * <p>
 * BaseActivity
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//竖屏

        Window window = getWindow();
        window.requestFeature(Window.FEATURE_NO_TITLE);//没有titlebar
        //透明状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // Translucent status bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        //5.0版本及以上
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                   /* | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION */ | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            // 以上注释 View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION 在有底部虚拟导航按键的手机上并不能很好的起作用，反而遮挡住了底部的UI，故注释掉
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
            ButterKnife.bind(this);
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                View view = findViewById(R.id.translucent_status);
                if (view != null)
                    view.setVisibility(View.GONE);
            }
        }
    }

    protected int getLayoutId() {
        return 0;
    }

    protected View getInitView() {
        return null;
    }

}
