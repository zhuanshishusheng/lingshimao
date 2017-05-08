package com.example.administrator.lingshimao.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.lingshimao.R;
import com.example.administrator.lingshimao.util.CommonUtil;

/**
 * Created by Administrator on 2017/5/6 0006.
 */

public class IndexActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startMainActivity();
    }

    private void startMainActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                CommonUtil.startActivity(IndexActivity.this, MainActivity.class);
                finish();
            }
        }, 3000);
    }
}
