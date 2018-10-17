package user;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.windows.myapplication.R;

import base.BaseFragment;

import static android.content.ContentValues.TAG;

/**
 * 2018/10/3 刘雨欣
 * 作用：个人界面的fragment
 */

public class UserFragment extends BaseFragment {
    private TextView textView;

    private ImageView mHBack;
    private ImageView mHHead;
    private ImageView mUserLine;
    private TextView mUserName;
    private TextView mUserVal;

    private ItemView mNickName;
    private ItemView mSex;
    private ItemView mSignName;
    private ItemView mPass;
    private ItemView mPhone;
    private ItemView mAbout;





    @Override
    public View initView() {
        Log.e(TAG,"主页面的Fragment的UI被初始化了");
        View view = View.inflate(mContext, R.layout.fragment_user,null);

        mHBack = (ImageView)view.findViewById(R.id.h_back);
        mHHead = (ImageView) view.findViewById(R.id.h_head);
        mUserLine = (ImageView)view.findViewById(R.id.user_line);
        mUserName = (TextView)view.findViewById(R.id.user_name);
        mUserVal = (TextView)view.findViewById(R.id.user_val);
        //下面item控件
        mNickName = (ItemView)view.findViewById(R.id.nickName);
        mSex = (ItemView)view.findViewById(R.id.sex);
        mSignName = (ItemView)view.findViewById(R.id.signName);
        mPass = (ItemView)view.findViewById(R.id.pass);
        mPhone = (ItemView)view.findViewById(R.id.phone);
        mAbout = (ItemView)view.findViewById(R.id.about);
        return view;
    }
    @Override
    public void initData(){
        super.initData();
        Log.e(TAG,"主页面的Fragment的数据被初始化了");

    }


}
