package com.recyclerviewtest.util;

import android.content.Context;
import android.text.TextUtils;

/**
 * Created by Administrator on 2016/3/25.
 */
public class AppIntroUtil {

    public static final int LMODE_NEW_INSTALL = 1; //再次启动
    public static final int LMODE_UPDATE = 2;//更新后第一次启动
    public static final int LMODE_AGAIN = 3;//首次安装启动
    public static final String SHARENAME= "lastVersion";
    private boolean isOpenMarked = false;
    private int launchMode = LMODE_AGAIN; //启动-模式
    private static AppIntroUtil instance;
    public static AppIntroUtil getThis() {
        if (instance == null)
            instance = new AppIntroUtil();
        return instance;
    }

    /**
     * 标记-打开app,用于产生-是否首次打开
     * @param context
     */
    public void markOpenApp(Context context) {
        // 防止-重复调用
        if (isOpenMarked)
            return;
        isOpenMarked = true;
        String lastVersion = SpUtil.getString(context,SHARENAME,SHARENAME);
        String thisVersion = VersionUtil.getVersion(context);
        // 首次启动
        if (TextUtils.isEmpty(lastVersion)) {
            launchMode = LMODE_NEW_INSTALL;
            SpUtil.setString(context,SHARENAME,SHARENAME,thisVersion);
        }
        // 更新
        else if (VersionUtil.compareVersion(lastVersion,thisVersion)) {
            launchMode = LMODE_UPDATE;
            SpUtil.setString(context, SHARENAME, SHARENAME, thisVersion);
        }
        // 二次启动(版本未变)
        else
            launchMode = LMODE_AGAIN;
    }
    public int getLaunchMode() {
        return launchMode;
    }
    /**
     * 首次打开,新安装、覆盖(版本号不同)
     * @return
     */
    public boolean isFirstOpen() {
        return launchMode != LMODE_AGAIN;
    }
}
