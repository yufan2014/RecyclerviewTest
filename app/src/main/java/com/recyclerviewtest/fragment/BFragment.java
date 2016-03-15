package com.recyclerviewtest.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.recyclerviewtest.R;
import com.recyclerviewtest.adapter.RecyclerViewAdapter;
import com.recyclerviewtest.base.BaseFragment;
import com.recyclerviewtest.util.RecycleViewDivider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/10.
 */
public class BFragment extends BaseFragment {

    private RecyclerView listB;
    private List<String> mDatas;

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_b;
    }

    @Override
    protected void initView() {
        listB = (RecyclerView)findViewById(R.id.list_b);
        GridLayoutManager llManager =  new GridLayoutManager(getActivity(),3);
        listB.setLayoutManager(llManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(),mDatas);
        listB.setAdapter(adapter);
        listB.addItemDecoration(new RecycleViewDivider(getActivity(), LinearLayoutManager.VERTICAL));
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
