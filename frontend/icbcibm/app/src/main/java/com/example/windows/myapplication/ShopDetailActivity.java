package com.example.windows.myapplication;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import home.PinDanFragment;

/*拼吃商户详细界面*/

public class ShopDetailActivity extends AppCompatActivity {

    private PinDanFragment pinDanFragment;

    private ImageView shop_cover;
    private TextView shop_title;
    private TextView shop_opentime;
    private TextView shop_score;
    private TextView shop_type;
    private TextView shop_adress;
    private TextView shop_phone;
    long shop_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        initView();
        //实例化pindanfragment
        pinDanFragment=PinDanFragment.newInstance("我是PinDanFragment");

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.rv_shop_content, pinDanFragment, "a").commitAllowingStateLoss();

        //获取上个活动传来的参数
        Intent i =getIntent();
        Bundle data=i.getExtras();
        shop_id=data.getLong("shop_id");
        shop_cover.setImageResource(data.getInt("shop_cover"));
        shop_title.setText(data.getString("shop_name"));
        shop_opentime.setText("营业时间："+data.getString("BusinessTime"));
        shop_score.setText("评分："+data.getDouble("shop_score"));
        shop_adress.setText("地址："+data.getString("address"));
        shop_phone.setText("电话："+data.getString("phone"));

        if(data.getInt("Classification")==1){
            shop_type.setText("类型：餐馆");
        }
        else if(data.getInt("Classification")==2){
            shop_type.setText("类型：超市");
        }
        else if(data.getInt("Classification")==3){
            shop_type.setText("类型：小吃饮品");
        }
        else if(data.getInt("Classification")==4){
            shop_type.setText("类型：生鲜食材");
        }
    }

    private void initView() {
        shop_cover=(ImageView)findViewById(R.id.shop_cover_detail);
        shop_title=(TextView)findViewById(R.id.shop_title_detail);
        shop_opentime=(TextView)findViewById(R.id.shop_opentime_detail);
        shop_score=(TextView)findViewById(R.id.shop_score_detail);
        shop_type=(TextView)findViewById(R.id.shop_type_detail);
        shop_adress=(TextView)findViewById(R.id.shop_address_detail);
        shop_phone=(TextView)findViewById(R.id.shop_phone_detail);

    }

    public long getShopId(){
        return shop_id;
    }

}
