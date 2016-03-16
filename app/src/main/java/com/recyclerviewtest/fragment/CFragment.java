package com.recyclerviewtest.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.recyclerviewtest.R;
import com.recyclerviewtest.adapter.RecyclerViewAdapter;
import com.recyclerviewtest.base.BaseFragment;
import com.recyclerviewtest.util.RecycleViewDivider;
import com.recyclerviewtest.util.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/10.
 */
public class CFragment extends BaseFragment {

    private RecyclerView listC;
    private List<String> mDatas;
    @Override
    protected int setContentViewId() {
        return R.layout.fragment_c;
    }

    @Override
    protected void initView() {
        listC = (RecyclerView)findViewById(R.id.list_c);
        StaggeredGridLayoutManager llManager =  new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        listC.setLayoutManager(llManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(),mDatas);
        listC.setAdapter(adapter);
        listC.addItemDecoration(new RecycleViewDivider(getActivity(), LinearLayoutManager.VERTICAL));

        SpacesItemDecoration decoration=new SpacesItemDecoration(16);
        listC.addItemDecoration(decoration);
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
