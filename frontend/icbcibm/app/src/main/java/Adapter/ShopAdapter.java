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

import RecyclerViewListener.OnRecyclerviewItemClickListener;
import bean.ShopEntity;

public class ShopAdapter extends RecyclerView.Adapter implements View.OnClickListener{

    private Context mContext;
    private List<ShopEntity> mData; //定义数据源
    //声明自定义的监听接口
    private OnRecyclerviewItemClickListener mOnRecyclerviewItemClickListener = null;

    public ShopAdapter(Context context,List<ShopEntity> data,OnRecyclerviewItemClickListener mOnRecyclerviewItemClickListener){
        this.mContext=context;
        this.mData=data;
        this.mOnRecyclerviewItemClickListener = mOnRecyclerviewItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.shop_view_layout,viewGroup,false);
      /*  View view = LayoutInflater.from(mContext).inflate(R.layout.shop_view_layout, null);*/
        view.setOnClickListener(this);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MyViewHolder holder2 = (MyViewHolder) viewHolder;
        ShopEntity shopEntity=mData.get(i);
        holder2.shop_cover.setImageResource(shopEntity.getImageId());
        holder2.price_trans_desc.setText("起送价 "+shopEntity.getPrice_trans_desc()+"元");
        holder2.price_limit_desc.setText("配送费 "+shopEntity.getPrice_limit_desc()+"元");
        holder2.shop_name.setText(shopEntity.getShop_name());
        holder2.distance_desc.setText(shopEntity.getDistance_desc()+"km");
        holder2.time_desc.setText(shopEntity.getArrival_time()+"min");
        holder2.shop_score.setText( String.valueOf(shopEntity.getShop_score()));
        holder2.shop_star.setImageResource(shopEntity.getShop_star_imagineId());
        if(shopEntity.getShop_pinNumber()!=0){
            holder2.shop_pinNumber.setText(shopEntity.getShop_pinNumber()+" 个拼单进行中");
        }else{
            holder2.shop_pinNumber.setText("暂无进行中拼单");
        }

        holder2.itemView.setTag(i);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onClick(View v) {
        mOnRecyclerviewItemClickListener.onItemClickListener(v, ((int) v.getTag()));
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView shop_cover;
        public TextView shop_name;
        public TextView distance_desc;
        public TextView time_desc;
        public TextView price_limit_desc;
        public TextView price_trans_desc;
        public TextView shop_pinNumber;
        public TextView shop_score;
        public ImageView shop_star;


        public MyViewHolder(View itemView) {
            super(itemView);
            shop_cover=(ImageView)itemView.findViewById(R.id.shop_cover);
            shop_name=(TextView)itemView.findViewById(R.id.shop_name);
            distance_desc=(TextView)itemView.findViewById(R.id.distance_desc);
            time_desc=(TextView)itemView.findViewById(R.id.time_desc);
            price_limit_desc=(TextView)itemView.findViewById(R.id.price_limit_desc);
            price_trans_desc=(TextView)itemView.findViewById(R.id.price_trans_desc);
            shop_pinNumber=(TextView)itemView.findViewById(R.id.shop_pinNumber);
            shop_score=(TextView)itemView.findViewById(R.id.shop_score);
            shop_star=(ImageView)itemView.findViewById(R.id.shop_star);
        }
    }
}
