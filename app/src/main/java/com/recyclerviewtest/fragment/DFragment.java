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
import com.recyclerviewtest.view.recyclerview.EndlessRecyclerOnScrollListener;
import com.recyclerviewtest.view.recyclerview.HeaderAndFooterRecyclerViewAdapter;
import com.recyclerviewtest.view.recyclerview.LoadingFooter;
import com.recyclerviewtest.view.recyclerview.RecyclerViewStateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/10.
 */
public class DFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{


    private RecyclerView listD;
    private List<String> mDatas;
    private HeaderAndFooterRecyclerViewAdapter mHeaderAndFooterRecyclerViewAdapter;
    private int REQUEST_COUNT = 10;
    private SwipeRefreshLayout refresh;

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_d;
    }

    @Override
    protected void initView() {
        listD = (RecyclerView)findViewById(R.id.list_d);
        LinearLayoutManager llManager =  new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        listD.setLayoutManager(llManager);
        final RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(),mDatas);
        mHeaderAndFooterRecyclerViewAdapter = new HeaderAndFooterRecyclerViewAdapter(adapter);
        listD.setAdapter(mHeaderAndFooterRecyclerViewAdapter);
        listD.addItemDecoration(new RecycleViewDivider(getActivity(),LinearLayoutManager.VERTICAL));
        listD.addOnScrollListener(new EndlessRecyclerOnScrollListener(){
            @Override
            public void onLoadNextPage(View view) {
                LoadingFooter.State state = RecyclerViewStateUtils.getFooterViewState(listD);
                if(state == LoadingFooter.State.Loading) {
                    Log.d("@Cundong", "the state is Loading, just wait..");
                    return;
                }

//                if (mCurrentCounter < TOTAL_COUNTER) {
                    // loading more
                    RecyclerViewStateUtils.setFooterViewState(getActivity(), listD, REQUEST_COUNT, LoadingFooter.State.Loading, null);
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
        for (int i = 'A'; i < 'Z'; i++)
        {
            mDatas.add("" + (char) i);
        }
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 2500);
    }
    public void onLoadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 2500);
    }
}
