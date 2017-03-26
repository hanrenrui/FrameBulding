package com.oysd.okhttp.listener;

/**
 * *****************************************************************
 * * 文件作者：ouyangshengduo
 * * 创建时间：2017/3/26
 * * 文件描述：json对象到实体对象的一个讲话
 * * 修改历史：2017/3/26 10:42*************************************
 **/

public class DisposeDataHandle {

    public DisposeDataListener mListener;
    public Class<?> mClass = null;//字节码

    /**
     * 数据原封不动
     * @param listener
     */
    public DisposeDataHandle(DisposeDataListener listener){
        this.mListener = listener;
    }

    /**
     * json对象到实体对象的转化
     * @param listener
     * @param clazz
     */
    public DisposeDataHandle(DisposeDataListener listener,Class<?> clazz){
        this.mListener = listener;
        this.mClass = clazz;
    }
}
