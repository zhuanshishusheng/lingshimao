package com.example.administrator.lingshimao.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.lingshimao.R;
import com.example.administrator.lingshimao.activity.GoodsActivity;


/**
 * Created by liueg on 2017/2/4.
 */

public class TopicFragment extends Fragment implements View.OnClickListener {

    private static TopicFragment sInstance;
    private View mView;
    private ImageView mBanGong;


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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    private void init() {
        mBanGong =(ImageView)mView.findViewById(R.id.topic_bangonglingzui);
        mBanGong.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.topic_bangonglingzui:
                Intent intent=new Intent();
                intent.setClass(getActivity(),GoodsActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("name","办公零嘴");
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }
    }
}
