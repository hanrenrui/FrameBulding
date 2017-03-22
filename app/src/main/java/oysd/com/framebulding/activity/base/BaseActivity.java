/*
 * *
 *  * *******************************************************
 *  *
 *  * @文件名称：BaseActivity.java
 *  * @文件作者：ouyangshengduo Copyright(c) 2017. All rights reserved.
 *  * @创建时间：17-3-21 下午10:04
 *  * @文件描述：
 *  * @修改历史：Last modified 17-3-21 下午10:04 ********************************************************
 *
 */

package oysd.com.framebulding.activity.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * *****************************************************************
 * * 文件作者：ouyangshengduo
 * * 创建时间：2017/3/21
 * * 文件描述：
 * * 修改历史：2017/3/21 22:04*************************************
 **/

public class BaseActivity extends AppCompatActivity {

    public String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getComponentName().getShortClassName();
    }

    @Override
    protected void onResume() {
        super.onResume();
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
    protected void onDestroy() {
        super.onDestroy();
    }
}
