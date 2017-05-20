package com.example.administrator.lingshimao.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.lingshimao.R;
import com.example.administrator.lingshimao.activity.CarActivity;
import com.example.administrator.lingshimao.activity.LoginActivity;
import com.example.administrator.lingshimao.base.MCApplication;
import com.example.administrator.lingshimao.util.CommonUtil;
import com.example.administrator.lingshimao.view.CustomImageView;


/**
 * Created by liueg on 2017/2/4.
 */

public class CatFragment extends Fragment implements View.OnClickListener {

    private static CatFragment sInstance;
    private View mView;
    private CustomImageView mLogin;
    private TextView mUsername;
    private ImageView mCar;


    public static CatFragment getInstance() {
        if (sInstance == null) {
            sInstance = new CatFragment();
        }
        return sInstance;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_cat,null);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    @Override
    public void onResume() {
        super.onResume();
        if(MCApplication.getUser()!=null){
            mUsername.setText(MCApplication.getUser().getUsername());
        }
    }

    private void init() {
        mLogin =(CustomImageView)mView.findViewById(R.id.cat_login);
        mLogin.setOnClickListener(this);
        mUsername =(TextView)mView.findViewById(R.id.cat_username);
        mCar =(ImageView)mView.findViewById(R.id.cat_car);
        mCar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cat_login:
                CommonUtil.startActivity(getActivity(), LoginActivity.class);
                break;
            case R.id.cat_car:
                enterCar();
                break;
        }
    }
    private void enterCar() {
        if(MCApplication.getUser()!=null){
            CommonUtil.startActivity(getActivity(),CarActivity.class);
        }else {
            Toast.makeText(getActivity(), "用户未登录", Toast.LENGTH_SHORT).show();
        }
    }
}
