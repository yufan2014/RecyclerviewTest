package com.recyclerviewtest.util;

import android.content.Context;

/**
 * Created by Administrator on 2016/3/25.
 */
public class CommonUtil {

    public  static String printErrorMessage(Context context, String methodName , String errorMessage){
        return "\n############################errorMessage start ##############################\n"+MobileUtil.printMobileInfo(context)+MobileUtil.printSystemInfo()+"\n错误信息："+errorMessage+"\n方法名："+methodName+"\n当前app版本号："+VersionUtil.getVersion(context)+"\n############################errorMessage end##############################";
    }
}
