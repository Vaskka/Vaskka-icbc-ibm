package com.vaskka.icbcibm.car.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.codbking.widget.DatePickDialog;
import com.codbking.widget.OnChangeLisener;
import com.codbking.widget.OnSureLisener;
import com.codbking.widget.bean.DateType;
import com.vaskka.icbcibm.car.R;
import com.vaskka.icbcibm.car.entity.CarOrder;
import com.vaskka.icbcibm.car.utils.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateCarPool extends AppCompatActivity {

    /**
     * 起点
     */
    private String location;

    /**
     * 目的地
     */
    private String destination;

    /**
     * 出发时间
     */
    private Date time;

    /**
     * 发起者姓名
     */
    private String name;

    /**
     * 联系方式
     */
    private String tel;


    private EditText inputDestination;
    private EditText inputLocation;
    private EditText inputName;
    private EditText inputTel;

    private Button selectTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_car_pool);

        // 绑定控件
        selectTime = findViewById(R.id.car_order_input_time_btn);
        Button commit = findViewById(R.id.car_order_input_commit_btn);
        Button cancel = findViewById(R.id.car_order_input_back_btn);
        inputDestination = findViewById(R.id.car_order_input_destination);
        inputLocation = findViewById(R.id.car_order_input_location);
        inputName = findViewById(R.id.car_order_input_name);
        inputTel = findViewById(R.id.car_order_input_tel);

        // 绑定监听事件
        selectTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTimeHandle();
            }
        });

        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commitHandle();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelHandle();
            }
        });
    }


    /**
     * 选择时间
     */
    private void selectTimeHandle() {
        DatePickDialog dialog = new DatePickDialog(this);
        //设置上下年分限制
        dialog.setYearLimt(5);
        //设置标题
        dialog.setTitle("选择出发时间");
        //设置类型
        dialog.setType(DateType.TYPE_ALL);
        //设置消息体的显示格式，日期格式
        dialog.setMessageFormat("yyyy-MM-dd HH:mm");
        //设置选择回调
        dialog.setOnChangeLisener(new OnChangeLisener() {
            @Override
            public void onChanged(Date date) {

            }
        });
        //设置点击确定按钮回调
        dialog.setOnSureLisener(new OnSureLisener() {
            @Override
            public void onSure(Date date) {
                CreateCarPool.this.time = date;
                SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                selectTime.setText(f.format(time));

            }
        });
        dialog.show();
    }

    /**
     * 处理提交
     */
    private void commitHandle() {
        location    = inputLocation.getText().toString();
        destination = inputDestination.getText().toString();
        name        = inputName.getText().toString();
        tel         = inputTel.getText().toString();

        if (checkInput()) {
            // 构造订单对象（默认等待时间5min）
            CarOrder newOrder = new CarOrder(Util.getOrderId(), location, name, time, 5, destination, tel);

            /*-------+网络请求(同步操作)+---------*/
            /////////////// 待完善 ///////////////
            /*-------+网络请求(同步操作)+---------*/

            // 跳转到订单详情
            Intent intent = new Intent(this, CarOrderDetail.class);
            startActivity(intent);
        }
    }

    /**
     * 处理取消
     */
    private void cancelHandle() {
        finish();
        onDestroy();
    }

    /**
     * 检查全部输入框都有有效值
     * @return boolean
     */
    private boolean checkInput() {
        if (location == null ||
                destination == null ||
                time == null ||
                name == null ||
                tel == null) {
            return false;
        }

        if (location.equals("") ||
                destination.equals("") ||
                name.equals("") ||
                tel.equals("")) {
            return false;
        }

        return  true;
    }
}
