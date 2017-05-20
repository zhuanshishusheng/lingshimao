package com.example.administrator.lingshimao.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.lingshimao.R;
import com.example.administrator.lingshimao.bean.TopicBean;
import com.example.administrator.lingshimao.net.OKHttpManager;
import com.example.administrator.lingshimao.net.RequestUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/15 0015.
 */

public class GoodsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private GridView mGridView;
    private GridViewAdapter mGridViewAdapter;
    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.arg1) {
                case 1:
                    Toast.makeText(GoodsActivity.this, "网络连接错误", Toast.LENGTH_SHORT).show();
                    break;
                case 2:

                    mGridView.setAdapter(mGridViewAdapter);
                    break;
                case 3:
//                    GlideCacheUtil.getInstance().clearImageMemoryCache(getActivity());
//                    mGridViewAdapter.notifyDataSetChanged();
                    break;

            }
        }
    };
    private Gson gson;
    private OKHttpManager okhttpManager;
    private List<TopicBean.DataBean> mGoodList=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);

        init();
    }

    private void init() {
        mGridView = (GridView) findViewById(R.id.topic_gridview);
        mGridViewAdapter=new GridViewAdapter(this);

        gson = new Gson();
        okhttpManager = OKHttpManager.getInstance();
        mGridView.setOnItemClickListener(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        okhttpManager.getString(RequestUtil.REQUEST_HEAD + "/topic?type=" + bundle.getString("name"), new OKHttpManager.HttpCallBack() {
            @Override
            public void onError(Exception e) {
                sendErrorMessage();
            }

            @Override
            public void onSuccess(String string) {
                Log.i("ceshi",string);

                sendSuccessMessage(string);

            }
        });

    }

    private void sendErrorMessage() {
        Message message = new Message();
        message.arg1 = 1;
        handler.sendMessage(message);
    }

    private void sendSuccessMessage(String string) {
        TopicBean topicBean=gson.fromJson(string,TopicBean.class);
        mGoodList =topicBean.getData();
        Message message=new Message();
        message.arg1=2;
        handler.sendMessage(message);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent=new Intent(this,GoodsDetialActivity.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("good",mGoodList.get(i));
        intent.putExtras(bundle);
        startActivity(intent);

    }

    class GridViewAdapter extends BaseAdapter {
        private Context mContext;

        public GridViewAdapter(Context context) {
            mContext = context;
        }

        @Override
        public int getCount() {
            return mGoodList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_topic_gridview, null);
                viewHolder = new ViewHolder();
                viewHolder.mImageView = (ImageView) convertView.findViewById(R.id.item_topic_gridview_image);
                viewHolder.mTextView = (TextView) convertView.findViewById(R.id.item_topic_gridview_describe);
                viewHolder.mPrice = (TextView) convertView.findViewById(R.id.item_topic_gridview_price);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.mTextView.setText(mGoodList.get(position).getDescribe());
            //网络加载图片
            Glide.with(mContext).load(RequestUtil.REQUEST_HEAD+mGoodList.get(position).getImageurl())
                    .into(viewHolder.mImageView);
            viewHolder.mPrice.setText("￥"+mGoodList.get(position).getPrice()+".00");

            return convertView;
        }

        class ViewHolder {
            TextView mTextView;
            ImageView mImageView;
            TextView mPrice;
        }
    }

}
