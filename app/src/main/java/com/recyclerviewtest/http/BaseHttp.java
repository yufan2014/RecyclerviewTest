package com.recyclerviewtest.http;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
public class BaseHttp{

    private static OkHttpClient mOkHttpClient;

    private OkHttpClient getClient() {
        if (mOkHttpClient == null) {
            mOkHttpClient = new OkHttpClient();
            mOkHttpClient.newBuilder().connectTimeout(10, TimeUnit.SECONDS);
            mOkHttpClient.newBuilder().writeTimeout(10, TimeUnit.SECONDS);
            mOkHttpClient.newBuilder().readTimeout(30, TimeUnit.SECONDS);
        }
        return mOkHttpClient;
    }


    private void senGet(final String url, final HttpCallBack callBack, JSONObject json,final int token){
        final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        Request request = new Request.Builder().url(url).put(RequestBody.create(JSON,json.toString())).build();
        try {
            Response response = mOkHttpClient.newCall(request).execute();
            HttpResult result = new HttpResult();
            if(response.isSuccessful()){
                    JSONObject jsonObject = new JSONObject(response.body().string());
                    if (jsonObject.has("code")) {
                        result.code = jsonObject.optString("code");
                    }
                    if (jsonObject.has("msg")) {
                        result.msg = jsonObject.optString("msg");
                    }
                    if (jsonObject.has("result")) {
                        result.dataStr  = jsonObject.optString("result");
                    }
            }else{
                result.code="201";
                result.msg = "";
                result.dataStr = "";
            }
            callBack.onSuccess(result,token);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



}
