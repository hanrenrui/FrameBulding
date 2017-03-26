package com.oysd.okhttp.response;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.oysd.okhttp.exception.OkHttpException;
import com.oysd.okhttp.listener.DisposeDataHandle;
import com.oysd.okhttp.listener.DisposeDataListener;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * *****************************************************************
 * * 文件作者：ouyangshengduo
 * * 创建时间：2017/3/26
 * * 文件描述：专门处理JSON的回调响应
 * * 修改历史：2017/3/26 10:53*************************************
 **/

public class CommonJsonCallback implements Callback{

    //与服务器返回的字段的一个对应关系
    protected  final String RESULT_CODE = "ecode";//有返回则对于http请求来说是成功的
    protected  final int RESULT_CODE_VALUE = 0;
    protected  final String ERROR_MSG = "emsg";
    protected  final String EMPTY_MSG = "";

    /**
     * 自定义了一些我们常见的一些异常类型
     */
    protected final int NETWORK_ERROR = -1;//网络错误
    protected final int JSON_ERROR = -2;//json解析错误
    protected final int OTHER_ERROR = -3;//其他错误

    private Class<?> mClass;
    private Handler mDeliveryHandler;//进行消息的转发，将子线程的数据转发到UI线程
    private DisposeDataListener mListener;

    public CommonJsonCallback(DisposeDataHandle handle){
        this.mClass = handle.mClass;
        this.mListener = handle.mListener;
        this.mDeliveryHandler = new Handler(Looper.getMainLooper());
    }

    //请求失败处理
    @Override
    public void onFailure(final Call call,final IOException e) {

        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {

                mListener.onFailure(new OkHttpException(NETWORK_ERROR,e));
            }
        });
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {

        final String result = response.body().toString();
        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                handleResponse(result);
            }
        });
    }

    /**
     * 处理服务器返回的数据
     * @param responseObj
     */
    private void handleResponse(Object responseObj){

        //为了保证代码的健壮性
        if(responseObj == null && responseObj.toString().trim().equals("")){

            mListener.onFailure(new OkHttpException(NETWORK_ERROR,EMPTY_MSG));
            return;
        }

        try{
            JSONObject result = new JSONObject(responseObj.toString());
            //开始尝试解析json
            if(result.has(RESULT_CODE)){

                //从json对象中取出我们的响应码,若为0（与服务器一致），则是正常的响应
                if(result.getInt(RESULT_CODE) == RESULT_CODE_VALUE){

                    if(mClass == null){
                        mListener.onSuccess(responseObj);
                    }else{
                        //即，需要我们将json对象转化为实体对象
                        Gson gson = new Gson();
                        Object obj = gson.fromJson(responseObj.toString(),mClass);
                        //标明正确的转化为了实体对象
                        if(obj != null){
                            mListener.onSuccess(obj);
                        }else{
                            //返回的不是合法的json
                            mListener.onFailure(new OkHttpException(JSON_ERROR,EMPTY_MSG));
                        }
                    }
                }else{
                    //将服务器返回给我们的异常回调到应用层去处理
                    mListener.onFailure(new OkHttpException(OTHER_ERROR,result.get(RESULT_CODE)));
                }
            }

        }catch(Exception e){
            mListener.onFailure(new OkHttpException(OTHER_ERROR,e.getMessage()));
        }

    }
}
