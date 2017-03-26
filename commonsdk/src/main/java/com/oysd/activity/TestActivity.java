package com.oysd.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.oysd.activity.base.BaseActivity;
import com.oysd.okhttp.CommonOkHttpClient;
import com.oysd.okhttp.listener.DisposeDataHandle;
import com.oysd.okhttp.listener.DisposeDataListener;
import com.oysd.okhttp.request.CommonRequest;
import com.oysd.okhttp.response.CommonJsonCallback;

import oysd.com.oysdlibrary.R;

/**
 * *****************************************************************
 * * 文件作者：ouyangshengduo
 * * 创建时间：2017/3/26
 * * 文件描述：
 * * 修改历史：2017/3/26 16:00*************************************
 **/

public class TestActivity extends BaseActivity implements View.OnClickListener {

    private Button btnTestOkHttp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_layout);

        initView();
    }

    /**
     * 初始化界面控件
     */
    private void initView(){
        btnTestOkHttp = (Button) findViewById(R.id.btnTestOkHttp);

        btnTestOkHttp.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btnTestOkHttp) {
            testOkHttp();

        }
    }

    /**
     * 测试OkHttp组件
     */
    private void testOkHttp(){

        CommonOkHttpClient.sendRequest(CommonRequest.createPostRequest("http://cloud.edan.com.cn:9090/AuthorizationCodeSystem/",null),new CommonJsonCallback(new DisposeDataHandle(new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {

            }

            @Override
            public void onFailure(Object responseObj) {

            }
        })));

    }
}
