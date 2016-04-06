package com.recyclerviewtest.fragment;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.recyclerviewtest.R;
import com.recyclerviewtest.adapter.RecyclerViewAdapter;
import com.recyclerviewtest.base.BaseFragment;
import com.recyclerviewtest.view.RecycleViewDivider;
import com.recyclerviewtest.view.recyclerview.HeaderAndFooterRecyclerViewAdapter;
import com.recyclerviewtest.view.recyclerview.LoadingFooter;
import com.recyclerviewtest.view.recyclerview.RecyclerOnScrollListener;
import com.recyclerviewtest.view.recyclerview.RecyclerViewStateUtils;

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
public class AFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{


    private RecyclerView listA;
    private List<String> mDatas;
    private HeaderAndFooterRecyclerViewAdapter mHeaderAndFooterRecyclerViewAdapter;
    private int REQUEST_COUNT = 10;
    private SwipeRefreshLayout refresh;

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_a;
    }

    @Override
    protected void initView() {
        listA = (RecyclerView)findViewById(R.id.list_a);
        listA.addItemDecoration(new RecycleViewDivider(getActivity(),LinearLayoutManager.VERTICAL));

        //setLayoutManager
        LinearLayoutManager llManager =  new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        listA.setLayoutManager(llManager);

        //setAdapter
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(),mDatas);
        mHeaderAndFooterRecyclerViewAdapter = new HeaderAndFooterRecyclerViewAdapter(adapter);
        listA.setAdapter(mHeaderAndFooterRecyclerViewAdapter);
//        listA.addItemDecoration(new RecycleViewDivider(getActivity(), LinearLayoutManager.VERTICAL, R.drawable.divider_mileage));
//        listA.addItemDecoration(new RecycleViewDivider(getActivity(), LinearLayoutManager.VERTICAL, 10, getResources().getColor(R.color.divide_gray_color)));
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
//        listA.setHasFixedSize(true);
        listA.addOnScrollListener(new RecyclerOnScrollListener(){
            @Override
            public void onLoadNextPage(View view) {
                LoadingFooter.State state = RecyclerViewStateUtils.getFooterViewState(listA);
                if(state == LoadingFooter.State.Loading) {
                    Log.d("@Cundong", "the state is Loading, just wait..");
                    return;
                }

//                if (mCurrentCounter < TOTAL_COUNTER) {
                // loading more
                RecyclerViewStateUtils.setFooterViewState(getActivity(), listA, REQUEST_COUNT, LoadingFooter.State.Loading, null);
                onLoadMore();
//                } else {
//                    //the end
//                    RecyclerViewStateUtils.setFooterViewState(EndlessLinearLayoutActivity.this, mRecyclerView, REQUEST_COUNT, LoadingFooter.State.TheEnd, null);
//                }
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
                RecyclerViewStateUtils.setFooterViewState(listA,LoadingFooter.State.TheEnd);
                refresh.setRefreshing(false);
            }
        }, 2500);
    }
    public void onLoadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                refresh.setRefreshing(false);
                RecyclerViewStateUtils.setFooterViewState(listA,LoadingFooter.State.TheEnd);
            }
        }, 2500);
    }

}
