package com.example.administrator.lingshimao.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.lingshimao.R;
import com.example.administrator.lingshimao.base.MCApplication;
import com.example.administrator.lingshimao.bean.LoginBean;
import com.example.administrator.lingshimao.net.OKHttpManager;
import com.example.administrator.lingshimao.net.RequestUtil;
import com.google.gson.Gson;

/**
 * Created by Administrator on 2017/5/12 0012.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mUsername;
    private EditText mPassword;
    private Button mLogin;
    private OKHttpManager okhttpManager;



    public Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.arg1){
                case 1:
                    Toast.makeText(LoginActivity.this, "网络连接错误", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(LoginActivity.this, mLoginBean.getError(), Toast.LENGTH_SHORT).show();

                    break;
                case 3:
                    Toast.makeText(LoginActivity.this,"登陆成功", Toast.LENGTH_SHORT).show();
                    MCApplication.setUser(mLoginBean.getData());
                    finish();
                    break;

            }
        }
    };
    private Gson gson;
    private LoginBean mLoginBean;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        mLogin.setOnClickListener(this);
    }

    private void initData() {
        okhttpManager = OKHttpManager.getInstance();
        gson = new Gson();

    }

    private void initView() {
        mUsername =(EditText)findViewById(R.id.login_username_et);
        mPassword =(EditText)findViewById(R.id.login_password_et);
        mLogin =(Button)findViewById(R.id.login_login);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_login:
                login();
                break;
        }
    }

    private void login() {
        String username=mUsername.getText().toString();
        String password=mPassword.getText().toString();
        String url= RequestUtil.REQUEST_HEAD+"/login"+"?username="+username+"&"+"password="+password;
        Log.i("ceshi",url);
        okhttpManager.getString(url, new OKHttpManager.HttpCallBack() {
            @Override
            public void onError(Exception e) {
                sendErrorMessage();
            }

            @Override
            public void onSuccess(String string) {

                sendSuccessMessage(string);
            }
        });
    }

    private void sendErrorMessage(){

        Message message=new Message();
        message.arg1=1;
        handler.sendMessage(message);
    }
    private void sendSuccessMessage(String string){
        mLoginBean =gson.fromJson(string,LoginBean.class);
        Message message=new Message();

        if("error".equals(mLoginBean.getResponse())){
            message.arg1=2;
        }else if("login".equals(mLoginBean.getResponse())){
            message.arg1=3;
        }

        handler.sendMessage(message);
    }
}
