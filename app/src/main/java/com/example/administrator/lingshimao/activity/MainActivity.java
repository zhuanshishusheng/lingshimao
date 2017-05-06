package com.example.administrator.lingshimao.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.example.administrator.lingshimao.R;
import com.example.administrator.lingshimao.fragment.CatFragment;
import com.example.administrator.lingshimao.fragment.HomeFragment;
import com.example.administrator.lingshimao.fragment.HotFragment;
import com.example.administrator.lingshimao.fragment.TopicFragment;

/**
 * Created by Administrator on 2017/5/6 0006.
 */

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup mMainRgBottom;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mMainRgBottom = (RadioGroup)findViewById(R.id.main_rg_bottom);


        mFragmentManager = getFragmentManager();
        replaceFragment(R.id.main_frame_content, HomeFragment.getInstance());

        mMainRgBottom.setOnCheckedChangeListener(this);
    }
    public void replaceFragment(int i,Fragment fragment) {
        mFragmentManager.beginTransaction()
                .replace(i,fragment)
                .commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        switch (i){
            case R.id.main_rb_home:
                replaceFragment(R.id.main_frame_content, HomeFragment.getInstance());
                break;
            case R.id.main_rb_hot:
                replaceFragment(R.id.main_frame_content, HotFragment.getInstance());
                break;
            case R.id.main_rb_topic:
                replaceFragment(R.id.main_frame_content, TopicFragment.getInstance());
                break;
            case R.id.main_rb_cat:
                replaceFragment(R.id.main_frame_content, CatFragment.getInstance());
                break;

        }
    }
}
