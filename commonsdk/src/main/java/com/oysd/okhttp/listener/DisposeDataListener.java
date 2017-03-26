package com.oysd.okhttp.listener;

/**
 * *****************************************************************
 * * 文件作者：ouyangshengduo
 * * 创建时间：2017/3/26
 * * 文件描述：自定义事件监听
 * * 修改历史：2017/3/26 10:22*************************************
 **/

public interface DisposeDataListener {

    /**
     * 请求成功回调事件处理
     * @param responseObj
     */
    public void onSuccess(Object responseObj);

    /**
     * 请求失败回调事件处理
     * @param responseObj
     */
    public void onFailure(Object responseObj);
}
