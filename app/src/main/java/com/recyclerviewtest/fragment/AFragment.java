package com.recyclerviewtest.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.recyclerviewtest.R;
import com.recyclerviewtest.adapter.RecyclerViewAdapter;
import com.recyclerviewtest.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/3/10.
 */
public class AFragment extends BaseFragment {


    RecyclerView listA;
    private ArrayList<String> mDatas;

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_a;
    }

    @Override
    protected void initView() {
        listA = (RecyclerView)findViewById(R.id.list_a);
        RecyclerView.LayoutManager  llManager =  new LinearLayoutManager(getActivity());
        listA.setLayoutManager(llManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mDatas);
        listA.setAdapter(adapter);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
//        listA.setHasFixedSize(true);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initGetData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++)
        {
            mDatas.add("" + (char) i);
        }
    }

}
