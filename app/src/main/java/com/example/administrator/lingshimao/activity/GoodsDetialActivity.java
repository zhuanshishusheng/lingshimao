package com.example.administrator.lingshimao.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.lingshimao.R;
import com.example.administrator.lingshimao.base.MCApplication;
import com.example.administrator.lingshimao.bean.TopicBean;
import com.example.administrator.lingshimao.net.OKHttpManager;
import com.example.administrator.lingshimao.net.RequestUtil;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Administrator on 2017/5/11 0011.
 */

public class GoodsDetialActivity extends AppCompatActivity implements View.OnClickListener {
    private TopicBean.DataBean mGood;
    private ImageView mDetailImage;
    private TextView mDetailPrice;
    private TextView mDetailLove;
    private TextView mDetailMonth;
    private ImageView mDetailReturn;
    private ImageView mDetailAddCar;
    private TextView mDetailDescribe;
    private OKHttpManager okHttpManager;

    public Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.arg1){
                case 1:
                    Toast.makeText(GoodsDetialActivity.this, "加入失败", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(GoodsDetialActivity.this, "加入成功", Toast.LENGTH_SHORT).show();
                    break;

            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gooddetail);
        init();
    }

    private void init() {
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        mDetailReturn.setOnClickListener(this);
        mDetailAddCar.setOnClickListener(this);

    }


    private void initData() {
        okHttpManager = OKHttpManager.getInstance();
        mGood=(TopicBean.DataBean) getIntent().getExtras().get("good");
    }

    private void initView() {
        mDetailDescribe = (TextView)findViewById(R.id.gooddetail_decribe);
        mDetailImage = (ImageView)findViewById(R.id.gooddetail_image);
        mDetailPrice = (TextView)findViewById(R.id.gooddetail_market_price);
        mDetailLove = (TextView)findViewById(R.id.gooddetail_love);
        mDetailMonth = (TextView)findViewById(R.id.gooddetail_monthsales);
        mDetailReturn =(ImageView)findViewById(R.id.sort_goodsdetial_return);
        mDetailAddCar = (ImageView)findViewById(R.id.gooddetail_add_car);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //网络加载图片
        Glide.with(this).load(RequestUtil.REQUEST_HEAD+mGood.getImageDetail())
                .into(mDetailImage);
        Log.i("ceshi",RequestUtil.REQUEST_HEAD+mGood.getImageDetail());
        mDetailPrice.setText("￥"+mGood.getPrice()+".00");
        mDetailMonth.setText("月销量"+mGood.getProceeds()+"件");
        mDetailLove.setText("喜欢"+mGood.getLove()+"人");
        mDetailDescribe.setText(mGood.getDescribe());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sort_goodsdetial_return:
                finish();
                break;
            case R.id.gooddetail_add_car:
                addCar();
                break;
        }
    }

    private void addCar() {
        if(MCApplication.getUser()!=null){

            Map<String,String> map=new HashMap<>();
            map.put("userid",MCApplication.getUser().getId()+"");
            map.put("goodid",mGood.getId()+"");
            map.put("num",1+"");
            okHttpManager.postMap(RequestUtil.REQUEST_HEAD + "/carsave", map, new OKHttpManager.HttpCallBack() {
                @Override
                public void onError(Exception e) {
                    sendErrorMessage();
                }

                @Override
                public void onSuccess(String string) {
                    sendSuccessMessage(string);
                }
            });
        }else{
            Toast.makeText(this, "请先登陆", Toast.LENGTH_SHORT).show();
        }
    }
    private void sendErrorMessage(){
        Message message=new Message();
        message.arg1=1;
        handler.sendMessage(message);
    }
    private void sendSuccessMessage(String string){

        Message message=new Message();
        message.arg1=2;
        handler.sendMessage(message);
    }

}
