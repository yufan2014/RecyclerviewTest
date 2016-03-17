package com.recyclerviewtest.http;

/**
 * 项目名称：RecyclerviewTest
 * 类描述：
 * 创建人：handongyu
 * 包名：com.recyclerviewtest.http
 * 创建时间：16/3/16 下午9:56
 * 修改备注：
 */
public interface HttpCallBack {
    /**
     * 请求缓存成功
     */
    void onCacheSuccess(HttpResult result,int token);

    /**
     *  请求缓存失败
     */
    void onCacheFail(int token);

    /**
     * 请求成功返回的对象
     * @param result
     */
    void onSuccess(HttpResult result,int token);

    /**
     * 失败返回的错误
     * @param exception
     */
    void onFailure(Exception exception, int token);



}
