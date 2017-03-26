package com.oysd.okhttp.request;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Request;

/**
 * *****************************************************************
 * * 文件作者：ouyangshengduo
 * * 创建时间：2017/3/25
 * * 文件描述：接收请求参数，为我们生成request对象
 * * 修改历史：2017/3/25 21:02*************************************
 **/

public class CommonRequest {

    /**
     *
     * @param url
     * @param params
     * @return返回一个创建好的Request对象
     */
    public static Request createPostRequest(String url, RequestParams params){

        FormBody.Builder mFormBodyBuild = new FormBody.Builder();

        if(params != null){
            for(Map.Entry<String,String> entry: params.urlParams.entrySet()){
                //将请求参数遍历添加到我们的请求构件类中
                mFormBodyBuild.add(entry.getKey(),entry.getValue());
            }
        }
        //通过请求构件类的build方法获取到真正的请求体对象
        FormBody mFormBody = mFormBodyBuild.build();
        return new Request.Builder().url(url).post(mFormBody).build();
    }

    /**
     *
     * @param url
     * @param params
     * @return 通过传入的参数，返回一个创建Get类型的Request对象
     */
    public static Request createGetRequest(String url,RequestParams params){

        StringBuilder urlBuilder = new StringBuilder(url).append("?");
        if(params != null){
            for(Map.Entry<String,String> entry: params.urlParams.entrySet()){
                //将请求参数遍历添加到我们的请求构件类中
                urlBuilder.append(entry.getKey()).append("=").
                        append(entry.getValue()).append("&");
            }
        }

        return new Request.Builder().url(urlBuilder.substring(0,urlBuilder.length() - 1))
                .get().build();
    }

}
