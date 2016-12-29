package com.youzai.appdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.youth.banner.Banner;
import com.youzai.appdemo.base.BaseActivity;
import com.youzai.appdemo.utils.BaseImgLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    @BindView(R.id.translucent_status)
    View view;

    @BindView(R.id.banner)
    Banner banner;

    List<Integer> images = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        images.add(R.mipmap.b1);
        images.add(R.mipmap.b2);
        images.add(R.mipmap.b3);
        //设置图片集合
        banner.setImageLoader(new BaseImgLoader());
        banner.setImages(images);
        //设置轮播时间
        banner.setDelayTime(3500);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected View getInitView() {
        return view;
    }
}
