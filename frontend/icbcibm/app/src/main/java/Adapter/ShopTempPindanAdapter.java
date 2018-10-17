package Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.windows.myapplication.R;

import java.util.List;

import bean.ShopTempPindanEntity;

public class ShopTempPindanAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<ShopTempPindanEntity> mData; //定义数据源

    public ShopTempPindanAdapter(Context context,List<ShopTempPindanEntity> data){
        this.mContext=context;
        this.mData=data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.pingdan_view_layout,viewGroup,false);
        /*  View view = LayoutInflater.from(mContext).inflate(R.layout.shop_view_layout, null);*/
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MyViewHolder holder2 = (MyViewHolder) viewHolder;
        ShopTempPindanEntity shopTempPindanEntity=mData.get(i);
        int number=i+1;
        holder2.pindan_name.setText("拼单No."+number);
        holder2.partner_info.setText("已参与人数:" +shopTempPindanEntity.getPartner_info()+"人");
        holder2.pindan_price.setText("¥"+shopTempPindanEntity.getPindan_price());
        if(shopTempPindanEntity.getBenefit_classfication()==1){
            holder2.price_discount.setText("满40减15");
        }else if(shopTempPindanEntity.getBenefit_classfication()==2){
            holder2.price_discount.setText("满60减25");
        }else if(shopTempPindanEntity.getBenefit_classfication()==3){
            holder2.price_discount.setText("满80减35");
        }else if(shopTempPindanEntity.getBenefit_classfication()==4){
            holder2.price_discount.setText("满100减50");
        }
        holder2.pindan_time.setText(shopTempPindanEntity.getHour()+"h "+shopTempPindanEntity.getMinute()+"min");
        holder2.itemView.setTag(i);
    }

    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView pindan_name;
        public TextView partner_info;
        public TextView price_discount;
        public TextView pindan_price;
        public TextView pindan_time;

        public MyViewHolder(View itemView) {
            super(itemView);
            pindan_name=(TextView)itemView.findViewById(R.id.pindan_name);
            partner_info=(TextView)itemView.findViewById(R.id.partner_info);
            price_discount=(TextView)itemView.findViewById(R.id.price_discount);
            pindan_price=(TextView)itemView.findViewById(R.id.pindan_price);
            pindan_time=(TextView) itemView.findViewById(R.id.pindan_time);


        }
    }
}
