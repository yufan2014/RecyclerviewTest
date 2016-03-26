package com.recyclerviewtest.util;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import com.recyclerviewtest.App;

/**
 * Created by Administrator on 2016/3/25.
 */
public class ToastUtil {

    /**
     * 将最长使用的显示方法单独提出来，方便使用。
     * 屏幕中心位置短时间显示Toast。
     *
     * App.context
     * @param message
     */
    public static void show( String message) {
        ToastShortCenter(App.context,message);
    }

    /**
     * 屏幕底部中间位置显示短时间Toast
     *
     * App.context
     * @param message
     */
    public static void ToastShortBottomCenter( String message) {
        if (App.context != null) {
            Toast.makeText(App.context, message, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 屏幕底部左边位置短时间显示Toast
     *
     * @param message
     */
    public static void ToastShortBottomLeft( String message) {
        if (App.context != null) {

            Toast toast = Toast.makeText(App.context, message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM | Gravity.LEFT, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕底部右边位置短时间显示Toast
     *
     * @param message
     */
    public static void ToastShortBottomRight( String message) {

        if (App.context != null) {

            Toast toast = Toast.makeText(App.context, message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM | Gravity.RIGHT, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕中心位置短时间显示Toast
     * @param context
     * @param message
     */
    public static void ToastShortCenter(Context context, String message) {
        if (App.context != null) {

            Toast toast = Toast.makeText(App.context, message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕中心左边位置短时间显示Toast
     *
     * @param message
     */
    public static void ToastShortCenterLeft( String message) {
        if (App.context != null) {

            Toast toast = Toast.makeText(App.context, message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER | Gravity.LEFT, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕中心右边位置短时间显示Toast
     *
     * @param message
     */
    public static void ToastShortCenterRight( String message) {
        if (App.context != null) {

            Toast toast = Toast.makeText(App.context, message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER | Gravity.RIGHT, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕顶部中心位置短时间显示Toast
     *
     * @param message
     */
    public static void ToastShortTopCenter( String message) {
        if (App.context != null) {

            Toast toast = Toast.makeText(App.context, message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕顶部左边位置短时间显示Toast
     *
     * @param message
     */
    public static void ToastShortTopLeft( String message) {
        if (App.context != null) {

            Toast toast = Toast.makeText(App.context, message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕顶部右边位置短时间显示Toast
     *
     * @param message
     */
    public static void ToastShortTopRight( String message) {
        if (App.context != null) {

            Toast toast = Toast.makeText(App.context, message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP | Gravity.RIGHT, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕底部中间位置显示长时间Toast
     *
     * @param message
     */
    public static void ToastLongBottomCenter( String message) {
        if (App.context != null) {

            Toast.makeText(App.context, message, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 屏幕底部左边位置长时间显示Toast
     * @param message
     */
    public static void ToastLongBottomLeft( String message) {
        if (App.context != null) {

            Toast toast = Toast.makeText(App.context, message, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM | Gravity.LEFT, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕底部右边位置长时间显示Toast
     *
     * @param message
     */
    public static void ToastLongBottomRight( String message) {
        if (App.context != null) {

            Toast toast = Toast.makeText(App.context, message, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM | Gravity.RIGHT, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕中心位置长时间显示Toast
     *
     * @param message
     */
    public static void ToastLongCenter( String message) {
        if (App.context != null) {

            Toast toast = Toast.makeText(App.context, message, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕中心左边位置长时间显示Toast
     *
     * @param message
     */
    public static void ToastLongCenterLeft( String message) {
        if (App.context != null) {

            Toast toast = Toast.makeText(App.context, message, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER | Gravity.LEFT, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕中心右边位置短时间显示Toast
     *
     * @param message
     */
    public static void ToastLongCenterRight( String message) {
        if (App.context != null) {

            Toast toast = Toast.makeText(App.context, message, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER | Gravity.RIGHT, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕顶部中心位置长时间显示Toast
     *
     * @param message
     */
    public static void ToastLongTopCenter( String message) {
        if (App.context != null) {

            Toast toast = Toast.makeText(App.context, message, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕顶部左边位置长时间显示Toast
     *
     * @param message
     */
    public static void ToastLongTopLeft( String message) {
        if (App.context != null) {

            Toast toast = Toast.makeText(App.context, message, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
            toast.show();
        }
    }

    /**
     * 屏幕顶部右边位置长时间显示Toast
     *
     * @param message
     */
    public static void ToastLongTopRight( String message) {
        if (App.context != null) {

            Toast toast = Toast.makeText(App.context, message, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP | Gravity.RIGHT, 0, 0);
            toast.show();
        }
    }

}
