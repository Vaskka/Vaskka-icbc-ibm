package com.vaskka.icbcibm.car.activity;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.vaskka.icbcibm.car.R;
import com.vaskka.icbcibm.car.entity.CarOrder;
import com.vaskka.icbcibm.car.utils.Util;

import org.w3c.dom.Text;

import java.util.Date;

import static java.lang.Thread.sleep;

public class CarOrderDetail extends AppCompatActivity {
    //////////// 页面正常字段 ///////////////
    private TextView nowLocation;
    private TextView nowDestination;
    private TextView nowTel;
    private TextView nowTime;
    private TextView nowPeopleNumber;

    private Button cancelButton;
    private Button shareButton;

    //////////// 轮询逻辑字段 //////////////
    // 轮询标志
    private boolean isStarting = false;

    // 轮询时间间隔
    private static final int POLLING_GAP = 1000;

    // 承载轮询实时请求的订单信息
    private CarOrder nowOrder;

    // Handler 用于实时更新UI
    private final Handler updateUIHandler = new Handler();


    // 轮询线程
    private final Runnable pollingThread = new Runnable() {
        @Override
        public void run() {
            if (isStarting) {
                /*-------+网络请求(同步操作)+---------*/
                /////////////// 待完善 ///////////////
                /*-------+网络请求(同步操作)+---------*/

                // 格式化网络请求到Java对象
                nowOrder = getValueFromServer("json response...");

                // 更新UI
                changeUIFromCarOrderObject(nowOrder);

                // 重复任务
                updateUIHandler.postDelayed(pollingThread, POLLING_GAP);
            }
        }
    };

    /**
     * （待完善） 格式化当前订单信息 json --> CarOrder
     * @param json 返回的原生json
     * @return CarOrder对象
     */
    private CarOrder getValueFromServer(String json) {
        //*** 当前为测试数据, 需要与网络请求一同完善 ***//
        CarOrder testDate =  new CarOrder(Util.getOrderId(), "location" + Util.getRandomNumber(2), "name" + Util.getRandomNumber(2), new Date(), 5, "destination" + Util.getRandomNumber(2), Util.getRandomNumber(8));
        testDate.setCurrentPeople(Integer.valueOf(Util.getRandomNumber(1)));

        return testDate;
    }


    /**
     * 从carOrder对象信息更改UI
     * @param carOrder CarOrder Object
     */
    private void changeUIFromCarOrderObject(CarOrder carOrder) {
        nowTime.setText(carOrder.getStartTime("yyyy-MM-dd HH:mm:ss"));
        nowTel.setText(carOrder.getTel());

        String peopleStr = String.valueOf(carOrder.getCurrentPeople()) + "人";
        nowPeopleNumber.setText(peopleStr);

        nowLocation.setText(carOrder.getLocation());
        nowDestination.setText(carOrder.getDestination());

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_order_detail);

        // 初始化控件
        initView();

        // 绑定事件
        initEvent();

        // 开启轮询
        isStarting = true;
        updateUIHandler.postDelayed(pollingThread, POLLING_GAP);

    }

    @Override
    protected void onStart() {
        // 开启轮询
        isStarting = true;
        super.onStart();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        nowDestination  = findViewById(R.id.car_order_detail_destination);
        nowLocation     = findViewById(R.id.car_order_detail_location);
        nowPeopleNumber = findViewById(R.id.car_order_detail_people);
        nowTel          = findViewById(R.id.car_order_detail_tel);
        nowTime         = findViewById(R.id.car_order_detail_time);

        cancelButton    = findViewById(R.id.car_order_detail_cancel_btn);
        shareButton     = findViewById(R.id.car_order_detail_share_btn);
    }


    /**
     * 初始化事件绑定
     */
    private void initEvent() {
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isStarting = false;
                finish();

            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*-----------分享请求----------*/
                //////////////待完善////////////
                /*-----------分享请求----------*/

            }
        });
    }

    @Override
    protected void onStop() {
        // 停止轮询
        this.isStarting = false;
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        // 停止轮询
        this.isStarting = false;
        super.onDestroy();
    }
}
