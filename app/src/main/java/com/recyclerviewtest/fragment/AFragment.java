package com.recyclerviewtest.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.recyclerviewtest.R;
import com.recyclerviewtest.adapter.RecyclerViewAdapter;
import com.recyclerviewtest.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：RecyclerviewTest
 * 类描述：
 * 创建人：Administrator
 * 包名：${PACKAGE_NAME}
 * 创建时间：2016/3/10 下午10:17
 * 修改备注：
 */
public class AFragment extends BaseFragment {


    RecyclerView listA;
    private List<String> mDatas;
    private TextView item_txt;

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_a;
    }

    @Override
    protected void initView() {
        listA = (RecyclerView)findViewById(R.id.list_a);
        LinearLayoutManager llManager =  new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        listA.setLayoutManager(llManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(),mDatas);
        listA.setAdapter(adapter);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
//        listA.setHasFixedSize(true);
//        item_txt = (TextView)findViewById(R.id.item_txt);
    }

    @Override
    protected void initData() {
//        item_txt.setText("cnaicjaicjia");
    }

    @Override
    protected void initGetData() {
        mDatas = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++)
        {
            mDatas.add("" + (char) i);
        }
    }

}
