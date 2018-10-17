package com.vaskka.icbcibm.car.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.vaskka.icbcibm.car.R;
import com.vaskka.icbcibm.car.adapter.CarOrderAdapter;
import com.vaskka.icbcibm.car.entity.CarOrder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainCar extends AppCompatActivity {

    // 可用拼车列表
    private List<CarOrder> carOrderList = new ArrayList<>();

    private Button createCarPoll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_car);
        // 初始化List数据
        initData();

        CarOrderAdapter adapter  = new CarOrderAdapter(MainCar.this, R.layout.car_order_item, carOrderList);
        ListView listView = findViewById(R.id.car_show_list_view);
        listView.setAdapter(adapter);

        // 初始化控件
        createCarPoll = findViewById(R.id.create_car_pool);
        createCarPoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intoCreateCarPoll();
            }
        });

    }


    /**
     * 进入创建拼车页面
     */
    private  void intoCreateCarPoll() {
        Intent intent = new Intent(this, CreateCarPool.class);
        startActivity(intent);
    }


    /**
     * 设置可用的拼车数据
     */
    private void initData() {
        // 初始化数据

        CarOrder o1 = new CarOrder("1234", "location1", "哈哈哈", new Date(), 5, "destination1", "123456");
        CarOrder o2 = new CarOrder("123456", "location2", "哈哈咖", new Date(), 5, "destination2", "12345667");
        carOrderList.add(o1);
        carOrderList.add(o2);
    }
}
