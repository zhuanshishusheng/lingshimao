package com.example.administrator.lingshimao.base;

import android.app.Application;

import com.example.administrator.lingshimao.bean.LoginBean;

/**
 * Created by liueg on 2017/2/3.
 */

public class MCApplication extends Application {
    public static LoginBean.DataBean getUser() {
        return user;
    }

    public static void setUser(LoginBean.DataBean user) {
        MCApplication.user = user;
    }

    private static LoginBean.DataBean user;

    private static MCApplication mApplication;

    public static MCApplication getApplication() {
        return mApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }
}
