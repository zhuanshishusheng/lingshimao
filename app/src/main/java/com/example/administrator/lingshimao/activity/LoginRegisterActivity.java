package com.example.administrator.lingshimao.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.lingshimao.R;
import com.example.administrator.lingshimao.util.CommonUtil;

/**
 * Created by Administrator on 2017/5/22 0022.
 */

public class LoginRegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mLogin;
    private Button mRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginregister);

        init();
    }

    private void init() {
        mLogin =(Button)findViewById(R.id.loginregister_login);
        mRegister =(Button)findViewById(R.id.loginregister_register);

        mLogin.setOnClickListener(this);
        mRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.loginregister_login:
                login();
                break;
            case R.id.loginregister_register:
                register();
                break;
        }
    }

    private void register() {
        CommonUtil.startActivity(this,RegisterActivity.class);

    }

    private void login() {
        CommonUtil.startActivity(this,LoginActivity.class);
        finish();
    }
}
