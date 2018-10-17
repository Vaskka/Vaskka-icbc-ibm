package Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.windows.myapplication.R;

import java.util.List;

import bean.ShopGoodsEntity;

public class ShopGoodAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<ShopGoodsEntity> mData; //定义数据源

    public ShopGoodAdapter(Context context,List<ShopGoodsEntity> data){
        this.mContext=context;
        this.mData=data;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.good_view_layout,viewGroup,false);
        /*  View view = LayoutInflater.from(mContext).inflate(R.layout.shop_view_layout, null);*/
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MyViewHolder holder2 = (MyViewHolder) viewHolder;
        ShopGoodsEntity shopGoodsEntity=mData.get(i);
        holder2.good_cover.setImageResource(shopGoodsEntity.getGood_cover());
        holder2.good_price.setText("￥"+shopGoodsEntity.getGood_price());
        holder2.good_name.setText(shopGoodsEntity.getGood_name());
        holder2.good_info.setText(shopGoodsEntity.getGood_info());
        holder2.price_sales.setText("月销售量"+shopGoodsEntity.getPrice_sales()+"份");
        holder2.itemView.setTag(i);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView good_cover;
        public TextView good_info;
        public TextView good_name;
        public TextView price_sales;
        public TextView good_price;


        public MyViewHolder(View itemView) {
            super(itemView);
            good_cover=(ImageView)itemView.findViewById(R.id.good_cover);
            good_info=(TextView)itemView.findViewById(R.id.good_info);
            good_name=(TextView)itemView.findViewById(R.id.good_name);
            price_sales=(TextView)itemView.findViewById(R.id.price_sales);
            good_price=(TextView)itemView.findViewById(R.id.good_price);

        }
    }
}
