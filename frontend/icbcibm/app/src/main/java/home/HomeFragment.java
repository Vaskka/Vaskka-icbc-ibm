package home;

import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.windows.myapplication.R;

import java.util.ArrayList;

import base.BaseFragment;
import butterknife.BindView;
import cart.CartFragment;
import chartRoom.ChartRoomFragment;
import user.UserFragment;

import static android.content.ContentValues.TAG;

/**
 * 2018/10/3 刘雨欣
 * 作用：主页的fragment
 */

public class HomeFragment extends BaseFragment {
    //private ResultBean resultBean;

    //private RecyclerView rvHome;
    private ImageView ib_top;
    //private HomeRecycleAdapter adapter;
    private TextView tv_search_home;
    private TextView tv_search_done_home;
    private Fragment tempFragment;

    private int pos = 0;
    @BindView(R.id.rl_home)
    RelativeLayout relativeLayout;
    @BindView(R.id.rg_home)
    RadioGroup radioGroupLeft;

    private ArrayList<BaseFragment> fragmentsSmall;


    @Override
    public View initView() {
        Log.e(TAG,"主页面的Fragment的UI被初始化了");
        View view = View.inflate(mContext, R.layout.fragment_home, null);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_home);
        tv_search_home = (TextView) view.findViewById(R.id.tv_search_home);
        tv_search_done_home = (TextView) view.findViewById(R.id.tv_search_done_home);
        radioGroupLeft = (RadioGroup)view.findViewById(R.id.rg_home);
        initFragment();
        initListener();
        return view;
    }
    @Override
    public void initData(){
        super.initData();
        Log.e(TAG,"主页面的Fragment的数据被初始化了");

    }
    private void initListener() {
           radioGroupLeft.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_eat://拼吃
                        pos = 0;
                        break;
                    case R.id.rb_transport://拼车
                        pos = 1;
                        break;
                    case R.id.rb_live://拼行
                        pos = 2;
                        break;
                    default:
                        pos = 0;
                        break;
                }

                BaseFragment baseFragment = getFragment(pos);
                switchFragmentSmall(tempFragment, baseFragment);//temp--上次显示的fragment ；base--正要显示的Fragment
            }
        });

        radioGroupLeft.check(R.id.rb_eat);

        //搜素的监听
        tv_search_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "搜索", Toast.LENGTH_SHORT).show();
            }
        });

        //消息的监听
        tv_search_done_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
    private BaseFragment getFragment(int position){
        if(fragmentsSmall != null && fragmentsSmall.size()>0){
            BaseFragment baseFragment = fragmentsSmall.get(position);
            return baseFragment;
        }
        return null;
    }

     private void switchFragmentSmall(Fragment fromFragment, BaseFragment nextFragment){
        if(tempFragment != nextFragment){
            tempFragment = nextFragment;
            if (nextFragment != null){
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                //判断nextFragment是否添加
                if(!nextFragment.isAdded()){
                    //隐藏当前Fragment
                    if(fromFragment != null){
                        transaction.hide(fromFragment);
                    }
                    //添加下次出现的Fragment
                    transaction.add(R.id.rl_home, nextFragment).commit();

                }else{
                    //隐藏当前 Fragment
                    if(fromFragment != null){
                        transaction.hide(fromFragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        }
    }
    private void initFragment(){

        fragmentsSmall = new ArrayList<>();
        fragmentsSmall.add(new EatFragment());//No 1
        fragmentsSmall.add(new TransFragment()); //No 2
        fragmentsSmall.add(new LiveFragment());//No 3

    }


}
