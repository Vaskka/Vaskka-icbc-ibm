package base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 2018/10/3 v1刘雨欣
 * 作用：基类Fragment
 * 子类：-首页HomeFragment -消息ChartRoomFragment -购物车CartFragment -个人UserFragment
 */

public abstract class BaseFragment extends Fragment {
   protected Context mContext;

    /**
     * 该类被系统创建时回调
     * @param saveInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }

    /**
     * 抽象类由子类实现不同效果
     * @return
     */
    public abstract View initView();

    /**
     * 当Activity被创建了的时候回调这个方法
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    /**
     * 当子类需要联网请求数据的时候，可以重写该方法
     */
    public void initData(){

    }
}
