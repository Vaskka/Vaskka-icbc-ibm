package home;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.windows.myapplication.R;
import com.example.windows.myapplication.ShopDetailActivity;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import Adapter.ShopTempPindanAdapter;
import DAO.DBManager;
import DAO.ShopTempPindanEntityDao;
import base.BaseFragment;
import bean.ShopTempPindanEntity;

import static android.content.ContentValues.TAG;

public class PinDanFragment extends BaseFragment {

    private Button btn_quik_eat;
    private Button btn_add_new_pindan;
    private GoodsFragment goodsFragment;

    private RecyclerView mRecyclerView;
    private ShopTempPindanAdapter shopTempPindanAdapter;
    private List<ShopTempPindanEntity> shopTempPindanEntityList;

    private long shopId;



    public static PinDanFragment newInstance(String title){
        PinDanFragment fragement=new PinDanFragment();
        Bundle bundle=new Bundle();
        bundle.putString("title",title);
        fragement.setArguments(bundle);
        return fragement;
    }
    @Override
    public View initView() {
        Log.e(TAG,"拼单详情页面的Fragment的UI被初始化了");
        View view = View.inflate(mContext, R.layout.fragment_pindan,null);
        DBManager.init(getActivity());
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_shop_content_roll);
        btn_quik_eat=(Button)view.findViewById(R.id.btn_quik_eat);
        btn_add_new_pindan=(Button)view.findViewById(R.id.btn_add_new_pindan);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        return view;
    }
    @Override
    public void initData(){
        super.initData();
        Log.e(TAG,"拼单详情页面的Fragment的数据被初始化了");
        shopTempPindanEntityList=new ArrayList<>() ;
       /* ShopTempPindanEntity shopTempPindanEntity1=new ShopTempPindanEntity(1,1,4,22,1,13,4,1);
        ShopTempPindanEntity shopTempPindanEntity2=new ShopTempPindanEntity(2,1,3,30,0,30,3,1);
        ShopTempPindanEntity shopTempPindanEntity3=new ShopTempPindanEntity(3,2,2,12,1,22,2,1);
*/
        ShopTempPindanEntityDao shopTempPindanEntityDao = DBManager.getmInstance().getSession().getShopTempPindanEntityDao();
        /*shopTempPindanEntityDao.insert(shopTempPindanEntity1);
        shopTempPindanEntityDao.insert(shopTempPindanEntity2);
        shopTempPindanEntityDao.insert(shopTempPindanEntity3);*/
        QueryBuilder<ShopTempPindanEntity> qb = shopTempPindanEntityDao.queryBuilder().where(ShopTempPindanEntityDao.Properties.ShopId.eq(shopId));
        shopTempPindanEntityList = qb.list();

        shopTempPindanAdapter=new ShopTempPindanAdapter(getActivity(),shopTempPindanEntityList);
        mRecyclerView.setAdapter(shopTempPindanAdapter);

        btn_quik_eat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(goodsFragment==null){
                    goodsFragment=new GoodsFragment();
                }
                Fragment fragment=getFragmentManager().findFragmentByTag("a");
                if(fragment!=null){
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.rv_shop_content,goodsFragment).addToBackStack(null).commitAllowingStateLoss();
                }else{
                    getFragmentManager().beginTransaction().replace(R.id.rv_shop_content,goodsFragment).addToBackStack(null).commitAllowingStateLoss();
                }
            }
        });
        btn_add_new_pindan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddNewPindanDailog();
            }
        });


    }

    private void showAddNewPindanDailog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final AlertDialog dialog = builder.create();

        View view = View.inflate(getActivity(), R.layout.set_pindan_dailog, null);
        // dialog.setView(view);// 将自定义的布局文件设置给dialog
        dialog.setView(view, 0, 0, 0, 0);// 设置边距为0,保证在2.x的版本上运行没问题

        final EditText hour = (EditText) view
                .findViewById(R.id.hour);
        final EditText minute = (EditText) view
                .findViewById(R.id.minute);

        Button btnOK = (Button) view.findViewById(R.id.btn_ok);
        Button btnCancel = (Button) view.findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.dismiss();// 隐藏dialog
            }
        });
       btnOK.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) { 
               /*Toast.makeText(getActivity(), "hour:"+hour.getText().toString()+" Minute:"+minute.getText().toString(),
                       Toast.LENGTH_SHORT).show();*/
           }
       });
        dialog.show();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        shopId=((ShopDetailActivity)context).getShopId();
    }

}
