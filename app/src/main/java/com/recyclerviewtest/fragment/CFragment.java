package com.recyclerviewtest.fragment;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.recyclerviewtest.R;
import com.recyclerviewtest.adapter.RecyclerViewAdapter;
import com.recyclerviewtest.base.BaseFragment;
import com.recyclerviewtest.view.recyclerview.ExStaggeredGridLayoutManager;
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
public class CFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{

    private RecyclerView listC;
    private List<String> mDatas;
    private HeaderAndFooterRecyclerViewAdapter mHeaderAndFooterRecyclerViewAdapter;
    private int REQUEST_COUNT = 10;
    private SwipeRefreshLayout refresh;

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_c;
    }

    @Override
    protected void initView() {
        listC = (RecyclerView)findViewById(R.id.list_c);

        //setAdapter
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(),mDatas);
        mHeaderAndFooterRecyclerViewAdapter = new HeaderAndFooterRecyclerViewAdapter(adapter);
        listC.setAdapter(mHeaderAndFooterRecyclerViewAdapter);

        //setLayoutManager
        ExStaggeredGridLayoutManager manager = new ExStaggeredGridLayoutManager (2, StaggeredGridLayoutManager.VERTICAL);
        manager.setSpanSizeLookup(new HeaderSpanSizeLookup((HeaderAndFooterRecyclerViewAdapter) listC.getAdapter(), manager.getSpanCount()));
        listC.setLayoutManager(manager);
//        listC.addItemDecoration(new RecycleViewDivider(getActivity(), LinearLayoutManager.VERTICAL));

//        SpacesItemDecoration decoration=new SpacesItemDecoration(16);
//        listC.addItemDecoration(decoration);

        listC.addOnScrollListener(new RecyclerOnScrollListener(){
            @Override
            public void onLoadNextPage(View view) {
                super.onLoadNextPage(view);
                LoadingFooter.State state = RecyclerViewStateUtils.getFooterViewState(listC);
                if(state == LoadingFooter.State.Loading) {
                    Log.d("@Cundong", "the state is Loading, just wait..");
                    return;
                }
                RecyclerViewStateUtils.setFooterViewState(getActivity(), listC, REQUEST_COUNT, LoadingFooter.State.Loading, null);
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
                RecyclerViewStateUtils.setFooterViewState(listC,LoadingFooter.State.TheEnd);
                refresh.setRefreshing(false);
            }
        }, 2500);
    }
    public void onLoadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                refresh.setRefreshing(false);
                RecyclerViewStateUtils.setFooterViewState(listC,LoadingFooter.State.TheEnd);
            }
        }, 2500);
    }
}
