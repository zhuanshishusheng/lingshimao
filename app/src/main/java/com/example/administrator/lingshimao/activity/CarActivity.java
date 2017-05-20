package com.example.administrator.lingshimao.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.lingshimao.R;
import com.example.administrator.lingshimao.base.MCApplication;
import com.example.administrator.lingshimao.bean.CarBean;
import com.example.administrator.lingshimao.net.OKHttpManager;
import com.example.administrator.lingshimao.net.RequestUtil;
import com.google.gson.Gson;


/**
 * Created by Administrator on 2017/5/13 0013.
 */

public class CarActivity extends AppCompatActivity implements View.OnClickListener {

    private int allPrice;

    private OKHttpManager okhttpManager;
    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.arg1) {
                case 1:
                    Toast.makeText(CarActivity.this, "网络连接错误", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    adapter = new CarListAdapter();
                    mCarList.setAdapter(adapter);
                    for(CarBean.DataBean bean:mCarBean.getData()){
                        allPrice+=bean.getPrice();
                    }
                    mAllPrice.setText("合计:￥"+allPrice+".00");
                    break;
                case 3:
                    Toast.makeText(CarActivity.this, "已结算", Toast.LENGTH_SHORT).show();
                    CarActivity.this.finish();
                    break;

            }
        }
    };
    private Gson gson;
    private CarBean mCarBean;
    private ListView mCarList;
    private CarListAdapter adapter;
    private TextView mAllPrice;
    private Button mCarBalance;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    private void init() {
        initView();
        mCarList =(ListView)findViewById(R.id.me_car_list);
        mAllPrice =(TextView)findViewById(R.id.me_car_allprice);
        initData();
        initListener();
    }
    private void initView() {
        mCarBalance =(Button)findViewById(R.id.me_car_balance);

    }
    private void initListener() {
        mCarBalance.setOnClickListener(this);
    }

    private void initData() {
        gson = new Gson();
        okhttpManager = OKHttpManager.getInstance();
        String url = RequestUtil.REQUEST_HEAD + "/carlist" + "?userid=" + MCApplication.getUser().getId();
        okhttpManager.getString(url, new OKHttpManager.HttpCallBack() {
            @Override
            public void onError(Exception e) {
                   sendErrorMessage();
            }

            @Override
            public void onSuccess(String string) {
                Log.i("ceshi",string);
              sendSuccessMessage(string,2);
            }
        });
    }

    private void sendErrorMessage() {

        Message message = new Message();
        message.arg1 = 1;
        handler.sendMessage(message);
    }

    private void sendSuccessMessage(String string,int type) {
        mCarBean = gson.fromJson(string, CarBean.class);
        Message message = new Message();

        message.arg1 = type;
        handler.sendMessage(message);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.me_car_balance:
                if(mCarBean.getData()==null||mCarBean.getData().size()==0){
                    Toast.makeText(this, "购物车没有商品", Toast.LENGTH_SHORT).show();
                }else{
                    //balanceGoods();
                }
                break;
        }
    }




    class CarListAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mCarBean.getData().size();
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            ViewHolder holder=null;
            if(view==null){
                view= LayoutInflater.from(CarActivity.this).inflate(R.layout.item_car_list,null);
                holder=new ViewHolder();
                holder.mImageView=(ImageView) view.findViewById(R.id.item_car_list_img);
                holder.mDescribe=(TextView)view.findViewById(R.id.item_car_list_describe);
                holder.mPrice=(TextView)view.findViewById(R.id.item_car_list_price);
                view.setTag(holder);
            }
            holder= (ViewHolder) view.getTag();
            //网络加载图片
            Glide.with(CarActivity.this).load(RequestUtil.REQUEST_HEAD+mCarBean.getData().get(i).getImageDetail())
                    .into(holder.mImageView);

            holder.mDescribe.setText(mCarBean.getData().get(i).getDescribe());

            holder.mPrice.setText("￥ "+mCarBean.getData().get(i).getPrice()+".00");

            return view;
        }

        class ViewHolder{
            ImageView mImageView;
            TextView mDescribe;
            TextView mPrice;
        }
    }
}
