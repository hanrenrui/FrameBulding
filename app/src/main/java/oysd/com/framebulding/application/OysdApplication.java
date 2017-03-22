/*
 * *
 *  * *******************************************************
 *  *
 *  * @文件名称：OysdApplication.java
 *  * @文件作者：ouyangshengduo Copyright(c) 2017. All rights reserved.
 *  * @创建时间：17-3-21 下午10:01
 *  * @文件描述：
 *  * @修改历史：Last modified 17-3-21 下午10:01 ********************************************************
 *
 */

package oysd.com.framebulding.application;

import android.app.Application;

/**
 * *****************************************************************
 * * 文件作者：ouyangshengduo
 * * 创建时间：2017/3/21
 * * 文件描述：App容器，使用单例模式
 * * 修改历史：2017/3/21 22:01*************************************
 **/

public class OysdApplication extends Application {

    private static OysdApplication mApplication = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }
    public static OysdApplication getInstance(){
        return mApplication;
    }
}
