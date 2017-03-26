package com.oysd.okhttp;

import com.oysd.okhttp.https.HttpsUtils;
import com.oysd.okhttp.response.CommonJsonCallback;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * *****************************************************************
 * * 文件作者：ouyangshengduo
 * * 创建时间：2017/3/25
 * * 文件描述：请求的发送，请求参数的配置，https的支持
 * * 修改历史：2017/3/25 21:21*************************************
 **/

public class CommonOkHttpClient {

    private static final int TIME_OUT = 30;//超时参数
    private static OkHttpClient mOkHttpClient;

    //为我们的client去配置参数
    static{

        //创建我们client对象的构建者
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient().newBuilder();
        //为构建者填充超时时间
        okHttpBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpBuilder.readTimeout(TIME_OUT,TimeUnit.SECONDS);
        okHttpBuilder.writeTimeout(TIME_OUT,TimeUnit.SECONDS);

        //确保支持重定向
        okHttpBuilder.followRedirects(true);

        //https支持
        okHttpBuilder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });
        okHttpBuilder.sslSocketFactory(HttpsUtils.getSslSocketFactory());
        //生成我们client对象
        mOkHttpClient = okHttpBuilder.build();
    }


    /**
     *
     * @param request
     * @param commonCallback
     * @return返回Call实例
     */
    public static Call sendRequest(Request request, CommonJsonCallback commonCallback){

        Call call = mOkHttpClient.newCall(request);
        call.enqueue(commonCallback);
        return call;
    }


}
