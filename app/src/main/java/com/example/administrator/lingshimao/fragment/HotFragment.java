package com.example.administrator.lingshimao.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.lingshimao.R;


/**
 * Created by liueg on 2017/2/4.
 */

public class HotFragment extends Fragment{

    private static HotFragment sInstance;
    private View mView;


    public static HotFragment getInstance() {
        if (sInstance == null) {
            sInstance = new HotFragment();
        }
        return sInstance;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_hot,null);
        return mView;
    }
}
