/*
 * *
 *  * *******************************************************
 *  *
 *  * @文件名称：MessageFragment.java
 *  * @文件作者：ouyangshengduo Copyright(c) 2017. All rights reserved.
 *  * @创建时间：17-3-21 下午10:12
 *  * @文件描述：
 *  * @修改历史：Last modified 17-3-21 下午10:12 ********************************************************
 *
 */

package oysd.com.framebulding.view.fragment.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import oysd.com.framebulding.R;
import oysd.com.framebulding.view.fragment.BaseFragment;

/**
 * MessageFragment
 */
public class MessageFragment extends BaseFragment implements View.OnClickListener {

    private View mContentView;

    private Button btnOkHttp;
    public MessageFragment() {

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
        if(mContentView == null) {
            mContentView = inflater.inflate(R.layout.fragment_message_layout, container, false);
        }
        initView();
        return mContentView;
    }

    /**
     * 初始化界面控件
     */
    private void initView(){
        btnOkHttp = (Button) mContentView.findViewById(R.id.btnOkHttp);

        btnOkHttp.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnOkHttp:
                testOkHttp();
                break;
        }
    }

    private void testOkHttp(){

       // CommonOkHttpClient.
    }
}
