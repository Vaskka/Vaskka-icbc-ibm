package home;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.windows.myapplication.R;
import com.example.windows.myapplication.ShopDetailActivity;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import Adapter.ShopGoodAdapter;
import DAO.DBManager;
import DAO.ShopGoodsEntityDao;
import base.BaseFragment;
import bean.ShopGoodsEntity;


public class GoodsFragment extends BaseFragment {
    private final static String TAG = GoodsFragment.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private ShopGoodAdapter shopGoodAdapter;
    private List<ShopGoodsEntity> shopGoodsEntityList;
    private long shopId;
    @Override
    public View initView() {
        Log.e(TAG,"商品详情页面的Fragment的UI被初始化了");
        View view = View.inflate(mContext, R.layout.fragment_goods,null);
        DBManager.init(getActivity());
        mRecyclerView=(RecyclerView)view .findViewById(R.id.rv_goods);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        return view;
    }
    @Override
    public void initData(){
        super.initData();
        shopGoodsEntityList=new ArrayList<>();
      /* ShopGoodsEntity shopGoodsEntity=new ShopGoodsEntity(1,R.drawable.good_swing,"麦辣鸡翅",
                "好吃的炸鸡",0,5,1);*/
        ShopGoodsEntityDao shopGoodsEntityDao = DBManager.getmInstance().getSession().getShopGoodsEntityDao();
     /*  shopGoodsEntityDao.insert(shopGoodsEntity);*/
        QueryBuilder<ShopGoodsEntity> qb = shopGoodsEntityDao.queryBuilder().where(ShopGoodsEntityDao.Properties.Shop_id.eq(shopId));
        shopGoodsEntityList = qb.list();
        shopGoodAdapter=new ShopGoodAdapter(getActivity(),shopGoodsEntityList);
        mRecyclerView.setAdapter(shopGoodAdapter);
        Log.e(TAG,"商品详情页面的Fragment的数据被初始化了");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        shopId=((ShopDetailActivity)context).getShopId();
    }
}