package com.recyclerviewtest.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.recyclerviewtest.R;
import com.recyclerviewtest.adapter.RecyclerViewAdapter;
import com.recyclerviewtest.base.BaseFragment;
import com.recyclerviewtest.util.RecycleViewDivider;

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


    private RecyclerView listA;
    private List<String> mDatas;

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
        listA.addItemDecoration(new RecycleViewDivider(getActivity(),LinearLayoutManager.VERTICAL));
//        listA.addItemDecoration(new RecycleViewDivider(getActivity(), LinearLayoutManager.VERTICAL, R.drawable.divider_mileage));
//        listA.addItemDecoration(new RecycleViewDivider(getActivity(), LinearLayoutManager.VERTICAL, 10, getResources().getColor(R.color.divide_gray_color)));
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
//        listA.setHasFixedSize(true);
    }

    @Override
    protected void initData() {
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
