package cart;

import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.windows.myapplication.R;

import base.BaseFragment;

import static android.content.ContentValues.TAG;

/**
 * 2018/10/3 刘雨欣
 * 作用：购物车界面的fragment
 */

public class CartFragment extends BaseFragment implements View.OnClickListener {
    private TextView textView;

    private LinearLayout rootView;
    private ImageButton ibShopcartBack;
    private TextView tvShopcartEdit;
    private AppCompatTextView recyclerview;
    private LinearLayout llCheckAll;
    private CheckBox checkboxAll;
    private TextView tvShopcartTotal;
    private Button btnCheckOut;
    private LinearLayout llDelete;
    private CheckBox cbAll;
    private Button btnDelete;
    private Button btnCollection;




    @Override
    public View initView() {
        Log.e(TAG,"主页面的Fragment的UI被初始化了");
        View view = View.inflate(mContext, R.layout.fragment_cart,null);
        rootView = (LinearLayout)view.findViewById( 0 );
        ibShopcartBack = (ImageButton)view.findViewById( R.id.ib_shopcart_back );
        tvShopcartEdit = (TextView)view.findViewById( R.id.tv_shopcart_edit );
        recyclerview = (AppCompatTextView)view.findViewById( R.id.recyclerview );
        llCheckAll = (LinearLayout)view.findViewById( R.id.ll_check_all );
        checkboxAll = (CheckBox)view.findViewById( R.id.checkbox_all );
        tvShopcartTotal = (TextView)view.findViewById( R.id.tv_shopcart_total );
        btnCheckOut = (Button)view.findViewById( R.id.btn_check_out );
        llDelete = (LinearLayout)view.findViewById( R.id.ll_delete );
        cbAll = (CheckBox)view.findViewById( R.id.cb_all );
        btnDelete = (Button)view.findViewById( R.id.btn_delete );
        btnCollection = (Button)view.findViewById( R.id.btn_collection );

        ibShopcartBack.setOnClickListener( this );
        btnCheckOut.setOnClickListener( this );
        btnDelete.setOnClickListener( this );
        btnCollection.setOnClickListener( this );
        return view;
    }
    @Override
    public void onClick(View v) {
        if ( v == ibShopcartBack ) {
            // Handle clicks for ibShopcartBack
        } else if ( v == btnCheckOut ) {
            // Handle clicks for btnCheckOut
        } else if ( v == btnDelete ) {
            // Handle clicks for btnDelete
        } else if ( v == btnCollection ) {
            // Handle clicks for btnCollection
        }
    }
    @Override
    public void initData(){
        super.initData();
        Log.e(TAG,"主页面的Fragment的数据被初始化了");

    }
}
