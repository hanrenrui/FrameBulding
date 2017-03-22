/*
 * *
 *  * *******************************************************
 *  *
 *  * @文件名称：HomeFragment.java
 *  * @文件作者：ouyangshengduo Copyright(c) 2017. All rights reserved.
 *  * @创建时间：17-3-21 下午10:11
 *  * @文件描述：
 *  * @修改历史：Last modified 17-3-21 下午10:11 ********************************************************
 *
 */

package oysd.com.framebulding.view.fragment.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import oysd.com.framebulding.R;
import oysd.com.framebulding.view.fragment.BaseFragment;

/**
 * HomeFragment
 */
public class HomeFragment extends BaseFragment {


    private View mContentView;

    public HomeFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mContext = getActivity();
        mContentView = inflater.inflate(R.layout.fragment_home_layout, container, false);
        return mContentView;
    }
}
