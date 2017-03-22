/*
 * *
 *  * *******************************************************
 *  *
 *  * @文件名称：BaseFragment.java
 *  * @文件作者：ouyangshengduo Copyright(c) 2017. All rights reserved.
 *  * @创建时间：17-3-21 下午10:10
 *  * @文件描述：
 *  * @修改历史：Last modified 17-3-21 下午10:10 ********************************************************
 *
 */

package oysd.com.framebulding.view.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

/**
 * *****************************************************************
 * * 文件作者：ouyangshengduo
 * * 创建时间：2017/3/21
 * * 文件描述：为我们所有的fragment提供公共的行为或事件
 * * 修改历史：2017/3/21 22:10*************************************
 **/

public class BaseFragment extends Fragment {


    protected Activity mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
