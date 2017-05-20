package com.example.administrator.lingshimao.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.lingshimao.R;
import com.example.administrator.lingshimao.util.GlideImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by liueg on 2017/2/4.
 */

public class HomeFragment extends Fragment{

    private static HomeFragment sInstance;
    private View mView;
    private Banner mBanner;
    private List<Integer> images;


    public static HomeFragment getInstance() {
        if (sInstance == null) {
            sInstance = new HomeFragment();
        }
        return sInstance;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_home,null);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init() {
        mBanner = (Banner)mView.findViewById(R.id.home_banner_view);
        images = new ArrayList<>();
        images.add(R.mipmap.home_banner1);
        images.add(R.mipmap.home_banner2);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(images);
        //开始
        mBanner.start();
    }

}
