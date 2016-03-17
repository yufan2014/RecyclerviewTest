package com.recyclerviewtest.http;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 项目名称：RecyclerviewTest
 * 类描述：
 * 创建人：handongyu
 * 包名：com.recyclerviewtest.http
 * 创建时间：16/3/16 下午9:42
 * 修改备注：
 */
public class BaseHttp {

    private static OkHttpClient mOkHttpClient;

    private OkHttpClient getClient() {
        if (mOkHttpClient == null) {
            mOkHttpClient = new OkHttpClient();
            mOkHttpClient.newBuilder().connectTimeout(10, TimeUnit.SECONDS);
            mOkHttpClient.newBuilder().writeTimeout(10, TimeUnit.SECONDS);
            mOkHttpClient.newBuilder().readTimeout(30, TimeUnit.SECONDS);
            mOkHttpClient.newBuilder().cache(new Cache(new File(""), 10 * 1024 * 1024));
        }
        return mOkHttpClient;
    }


    private void senGet(final String url, final HttpCallBack callBack, JSONObject json, final int token) {
        final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        Request request = new Request.Builder().url(url).put(RequestBody.create(JSON, json.toString())).build();
        try {
            Response response = getClient().newCall(request).execute();
            HttpResult result = new HttpResult();
            if (response.isSuccessful()) {
                JSONObject jsonObject = new JSONObject(response.body().string());
                if (jsonObject.has("code")) {
                    result.code = jsonObject.optString("code");
                }
                if (jsonObject.has("msg")) {
                    result.msg = jsonObject.optString("msg");
                }
                if (jsonObject.has("result")) {
                    result.dataStr = jsonObject.optString("result");
                }
                callBack.onSuccess(result, token);
            } else {
                callBack.onFailure(new Exception("" + response), token);
            }
        } catch (IOException e) {
            callBack.onFailure(e, token);
            e.printStackTrace();
        } catch (JSONException e) {
            callBack.onFailure(e, token);
            e.printStackTrace();
        }
    }
}
