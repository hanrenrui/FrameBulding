package com.oysd.okhttp.exception;

/**
 * *****************************************************************
 * * 文件作者：ouyangshengduo
 * * 创建时间：2017/3/26
 * * 文件描述：自定义异常类,返回ecode,emsg到业务层
 * * 修改历史：2017/3/26 11:13*************************************
 **/

public class OkHttpException extends Exception {

    private static final long serialVersionUID = 1L;

    private int ecode;//服务器返回的错误码
    private Object emsg;//服务器返回的错误信息

    public OkHttpException(int ecode,Object emsg){
        this.ecode = ecode;
        this.emsg = emsg;
    }

    public int getEcode(){
        return ecode;
    }
    public Object getEmsg(){
        return emsg;
    }


}
