package com.recyclerviewtest.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/3/10.
 */
public abstract class BaseFragmentActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentViewId());
        ButterKnife.bind(this);

        initGetData();
        initView();
        initData();
    }

    /**
     * 初始化视图
     */
    protected abstract int setContentViewId();

    /**
     * 获取上一个界面传送过来的数据
     */
    protected abstract void initGetData();

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
