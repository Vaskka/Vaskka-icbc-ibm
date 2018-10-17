package home;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.windows.myapplication.R;

import base.BaseFragment;

import static android.content.ContentValues.TAG;

/**
 * 2018/10/3 刘雨欣
 * 作用：拼车界面的fragment
 */

public class TransFragment extends BaseFragment {
    private TextView textView;
    @Override
    public View initView() {
        Log.e(TAG,"主页面的Fragment的UI被初始化了");
        View view = View.inflate(mContext, R.layout.fragment_trans,null);
        return view;
    }
    @Override
    public void initData(){
        super.initData();
        Log.e(TAG,"主页面的Fragment的数据被初始化了");

    }
}
