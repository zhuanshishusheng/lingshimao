package com.example.administrator.lingshimao.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.lingshimao.R;
import com.example.administrator.lingshimao.activity.CarActivity;
import com.example.administrator.lingshimao.activity.LoginRegisterActivity;
import com.example.administrator.lingshimao.activity.OrderActivity;
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
    private RelativeLayout mOrder;
    private TextView mDaifukuan;
    private TextView mDaifahuo;
    private TextView mDaishouhuo;
    private TextView mDaipingjia;
    private RelativeLayout mCall;


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
        mOrder =(RelativeLayout)mView.findViewById(R.id.cat_order);
        mOrder.setOnClickListener(this);

        mDaifukuan =(TextView)mView.findViewById(R.id.cat_order_daifukuan);
        mDaifahuo =(TextView)mView.findViewById(R.id.cat_order_daifahuo);
        mDaishouhuo =(TextView)mView.findViewById(R.id.cat_order_daishouhuo);
        mDaipingjia =(TextView)mView.findViewById(R.id.cat_order_daipingjia);
        mDaifukuan.setOnClickListener(this);
        mDaifahuo.setOnClickListener(this);
        mDaishouhuo.setOnClickListener(this);
        mDaipingjia.setOnClickListener(this);

        mCall =(RelativeLayout)mView.findViewById(R.id.cat_call);
        mCall.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cat_login:
                CommonUtil.startActivity(getActivity(), LoginRegisterActivity.class);
                break;
            case R.id.cat_car:
                enterCar();
                break;
            case R.id.cat_order:
                enterOrder(0);
                break;
            case R.id.cat_order_daifukuan:
                enterOrder(1);
                break;
            case R.id.cat_order_daifahuo:
                enterOrder(2);
                break;
            case R.id.cat_order_daishouhuo:
                enterOrder(3);
                break;
            case R.id.cat_order_daipingjia:
                enterOrder(4);
                break;
            case R.id.cat_call:
                call();
                break;
        }
    }

    private void call() {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"
                + "10086"));
        startActivity(intent);

    }

    private void enterOrder(int type) {
        if(MCApplication.getUser()!=null){
            Intent intent=new Intent(getActivity(), OrderActivity.class);
            Bundle bundle=new Bundle();
            bundle.putInt("type",type);
            intent.putExtras(bundle);
            startActivity(intent);
        }else {
            Toast.makeText(getActivity(), "用户未登录", Toast.LENGTH_SHORT).show();
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
