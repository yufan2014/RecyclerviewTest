package com.recyclerviewtest;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.recyclerviewtest.base.BaseFragmentActivity;
import com.recyclerviewtest.fragment.AFragment;
import com.recyclerviewtest.fragment.BFragment;
import com.recyclerviewtest.fragment.CFragment;
import com.recyclerviewtest.fragment.DFragment;
import com.recyclerviewtest.view.CustomViewPager;
import com.recyclerviewtest.view.FixedSpeedScroller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseFragmentActivity implements View.OnClickListener {


    @Bind(R.id.content_vp)
    CustomViewPager contentVp;
    @Bind(R.id.tab_first)
    RadioButton tabFirst;
    @Bind(R.id.tab_second)
    RadioButton tabSecond;
    @Bind(R.id.tab_third)
    RadioButton tabThird;
    @Bind(R.id.tab_fourth)
    RadioButton tabFourth;
    private List<Fragment> mFragments = new ArrayList<Fragment>();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected int setContentViewId() {
        //initSystemBar(MainActivity.this);
        setTranslucentStatus();//沉浸模式
        setViewPagerScrollSpeed();
        return R.layout.activity_main;
    }

    @Override
    protected void initGetData() {
        initfragment();
    }

    private void initfragment() {
        mFragments.add(new AFragment());
        mFragments.add(new BFragment());
        mFragments.add(new CFragment());
        mFragments.add(new DFragment());
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    protected void initView() {
        contentVp.setScrollble(true);
        contentVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                return mFragments.get(arg0);
            }
        });

        contentVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        tabFirst.setChecked(true);
                        break;
                    case 1:
                        tabSecond.setChecked(true);
                        break;
                    case 2:
                        tabThird.setChecked(true);
                        break;
                    case 3:
                        tabFourth.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabFirst.setOnClickListener(this);
        tabSecond.setOnClickListener(this);
        tabThird.setOnClickListener(this);
        tabFourth.setOnClickListener(this);
        tabFirst.setChecked(true);
    }

    /**
     * 设置ViewPager的滑动速度
     */
    private void setViewPagerScrollSpeed() {
        try {
            Field mScroller = CustomViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            FixedSpeedScroller scroller = new FixedSpeedScroller(getApplicationContext());
            mScroller.set(CustomViewPager.class, scroller);
        } catch (NoSuchFieldException ignored) {

        } catch (IllegalArgumentException e) {

        } catch (IllegalAccessException e) {

        }
    }

    @Override
    protected void initData() {

    }

    /**
     * 设置状态栏背景状态
     */
    private void setTranslucentStatus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            winParams.flags |= bits;
            win.setAttributes(winParams);
        }
        SystemStatusManager tintManager = new SystemStatusManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintResource(R.color.color_title);//状态栏无背景
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_first:
                contentVp.setCurrentItem(0, false);
                break;
            case R.id.tab_second:
                contentVp.setCurrentItem(1, false);
                break;
            case R.id.tab_third:
                contentVp.setCurrentItem(2, false);
                break;
            case R.id.tab_fourth:
                contentVp.setCurrentItem(3, false);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.recyclerviewtest/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.recyclerviewtest/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }


// 需要setContentView之前调用
//    private void setTranslucentStatus() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            // 透明状态栏
//            getWindow().addFlags(
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            // 透明导航栏
//            getWindow().addFlags(
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            SystemStatusManager tintManager = new SystemStatusManager(this);
//            tintManager.setStatusBarTintEnabled(true);
//            // 设置状态栏的颜色
//            tintManager.setStatusBarTintResource(R.color.theme_color);
//            getWindow().getDecorView().setFitsSystemWindows(true);
//        }
//    }

//    public void initSystemBar(Activity activity) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            setTranslucentStatus(activity, true);
//        }
//        SystemBarTintManager tintManager = new SystemBarTintManager(activity);
//        tintManager.setStatusBarTintEnabled(true);
//        // 使用颜色资源
//        tintManager.setStatusBarTintResource(R.color.colorPrimaryDark);
//    }
//
//
//    @TargetApi(19)
//    private static void setTranslucentStatus(Activity activity, boolean on) {
//        Window win = activity.getWindow();
//        WindowManager.LayoutParams winParams = win.getAttributes();
//        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
//        if (on) {
//            winParams.flags |= bits;
//        } else {
//            winParams.flags &= ~bits;
//        }
//        win.setAttributes(winParams);
//    }
}
