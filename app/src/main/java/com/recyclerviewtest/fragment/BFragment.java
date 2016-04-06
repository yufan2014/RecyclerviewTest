package com.recyclerviewtest.fragment;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.recyclerviewtest.R;
import com.recyclerviewtest.adapter.RecyclerViewAdapter;
import com.recyclerviewtest.base.BaseFragment;
import com.recyclerviewtest.view.RecycleViewDivider;
import com.recyclerviewtest.view.recyclerview.HeaderAndFooterRecyclerViewAdapter;
import com.recyclerviewtest.view.recyclerview.HeaderSpanSizeLookup;
import com.recyclerviewtest.view.recyclerview.LoadingFooter;
import com.recyclerviewtest.view.recyclerview.RecyclerOnScrollListener;
import com.recyclerviewtest.view.recyclerview.RecyclerViewStateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/10.
 */
public class BFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{

    private RecyclerView listB;
    private List<String> mDatas;
    private HeaderAndFooterRecyclerViewAdapter mHeaderAndFooterRecyclerViewAdapter;
    private SwipeRefreshLayout refresh;
    private int REQUEST_COUNT = 10;

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_b;
    }

    @Override
    protected void initView() {
        listB = (RecyclerView)findViewById(R.id.list_b);
        listB.addItemDecoration(new RecycleViewDivider(getActivity(), LinearLayoutManager.VERTICAL));

        //setAdapter
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(),mDatas);
        mHeaderAndFooterRecyclerViewAdapter = new HeaderAndFooterRecyclerViewAdapter(adapter);
        listB.setAdapter(mHeaderAndFooterRecyclerViewAdapter);

        //setLayoutManager
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        manager.setSpanSizeLookup(new HeaderSpanSizeLookup((HeaderAndFooterRecyclerViewAdapter) listB.getAdapter(), manager.getSpanCount()));
        listB.setLayoutManager(manager);

        listB.addOnScrollListener(new RecyclerOnScrollListener(){
            @Override
            public void onLoadNextPage(View view) {
                super.onLoadNextPage(view);
                LoadingFooter.State state = RecyclerViewStateUtils.getFooterViewState(listB);
                if(state == LoadingFooter.State.Loading) {
                    Log.d("@Cundong", "the state is Loading, just wait..");
                    return;
                }
                RecyclerViewStateUtils.setFooterViewState(getActivity(), listB, REQUEST_COUNT, LoadingFooter.State.Loading, null);
                onLoadMore();

            }
        });


        refresh = (SwipeRefreshLayout)findViewById(R.id.refresh);
        refresh.setColorSchemeResources(R.color.color_00d446, R.color.color_0dbdbb, R.color.color_0aa4e7);
        refresh.setProgressViewOffset(true, 10, 120);
        refresh.setOnRefreshListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initGetData() {
        mDatas = new ArrayList<>();
        for (int i = 'A'; i <= 'Z'; i++)
        {
            mDatas.add("" + (char) i);
        }
    }


    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                RecyclerViewStateUtils.setFooterViewState(listB,LoadingFooter.State.TheEnd);
                refresh.setRefreshing(false);
            }
        }, 2500);
    }
    public void onLoadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                refresh.setRefreshing(false);
                RecyclerViewStateUtils.setFooterViewState(listB,LoadingFooter.State.TheEnd);
            }
        }, 2500);
    }


}
