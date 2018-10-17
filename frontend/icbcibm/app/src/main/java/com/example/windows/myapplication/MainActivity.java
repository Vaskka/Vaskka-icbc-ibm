package com.example.windows.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioGroup;


import java.util.ArrayList;

import base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import cart.CartFragment;
import chartRoom.ChartRoomFragment;
import home.HomeFragment;
import user.UserFragment;


public class MainActivity extends FragmentActivity {
    @BindView(R.id.frameLayout)
    FrameLayout frameLayout;
    @BindView(R.id.radiogroup_main)
    RadioGroup radioGroupMain;
    //装多个fragment的实例集合
    private ArrayList<BaseFragment> fragments;



    private int position = 0;
    private Fragment tempFragment;//缓存的上次显示的




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ButterKnife和当前Activity绑定
        ButterKnife.bind(this);
        initFragment();//初始化fragment
        initListener();//设置ainradiogroup的监听
        radioGroupMain.check(R.id.radiobuttom_home);
    }
    private void initListener(){
        radioGroupMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radiobuttom_home://主页
                        position = 0;
                        break;
                    case R.id.radiobuttom_chart://消息
                        position = 1;
                        break;
                    case R.id.radiobuttom_cart://购物车
                        position = 2;
                        break;
                    case R.id.radiobuttom_user://个人
                        position = 3;
                        break;
                    default:
                        position = 0;
                        break;
                }

                BaseFragment baseFragment = getFragment(position);
                switchFragment(tempFragment, baseFragment);//temp--上次显示的fragment ；base--正要显示的Fragment
            }
        });

        radioGroupMain.check(R.id.radiobuttom_home);


    }
    //添加是按照顺序
    private void initFragment(){
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());//No 1
        fragments.add(new ChartRoomFragment()); //No 2
        fragments.add(new CartFragment());//No 3
        fragments.add(new UserFragment());//No 4

    }

    private BaseFragment getFragment(int position){
        if(fragments != null && fragments.size()>0){
            BaseFragment baseFragment = fragments.get(position);
            return baseFragment;
        }
        return null;
    }

    /**
     * 切换fragment
     * @param fromFragment
     * @param nextFragment
     */
    private void switchFragment(Fragment fromFragment, BaseFragment nextFragment){
        if(tempFragment != nextFragment){
            tempFragment = nextFragment;
            if (nextFragment != null){
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //判断nextFragment是否添加
                if(!nextFragment.isAdded()){
                    //隐藏当前Fragment
                    if(fromFragment != null){
                        transaction.hide(fromFragment);
                    }
                    //添加下次出现的Fragment
                    transaction.add(R.id.frameLayout, nextFragment).commit();

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

}
