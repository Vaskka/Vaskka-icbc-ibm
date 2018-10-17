package com.vaskka.icbcibm.car.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.vaskka.icbcibm.car.R;
import com.vaskka.icbcibm.car.entity.CarOrder;

import java.util.List;

/**
 * 拼车订单的适配器
 */
public class CarOrderAdapter extends ArrayAdapter {

    // item的R.id
    private final int resourceId;

    public CarOrderAdapter(Context context, int textViewResourceId, List<CarOrder> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CarOrder order = (CarOrder) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        TextView orderNameText = view.findViewById(R.id.car_order_item_name);
        TextView orderLocationText = view.findViewById(R.id.car_order_item_location);

        // 为item赋值
        orderNameText.setText(order.getName());
        orderLocationText.setText(order.getLocation());

        return view;
    }
}
