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

public class TopicFragment extends Fragment{

    private static TopicFragment sInstance;
    private View mView;


    public static TopicFragment getInstance() {
        if (sInstance == null) {
            sInstance = new TopicFragment();
        }
        return sInstance;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_topic,null);
        return mView;
    }
}
