package home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.example.windows.myapplication.R;
import com.example.windows.myapplication.ShopDetailActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import Adapter.ShopAdapter;
import DAO.DBManager;
import DAO.DaoMaster;
import DAO.ShopEntityDao;
import RecyclerViewListener.OnRecyclerviewItemClickListener;
import base.BaseFragment;
import bean.ShopEntity;

import okhttp3.Call;

import static android.content.ContentValues.TAG;

/**
 * 2018/10/3 刘雨欣
 * 作用：拼吃界面的fragment
 */

public class EatFragment extends BaseFragment {

    private final static String TAG = EatFragment.class.getSimpleName();
    private TextView textView;
    private RecyclerView mRecyclerView;
    private ShopAdapter shopAdapter;
    private List<ShopEntity> shopEntityList;
    private List<ShopEntity> selectedShopEntityList;
    private Spinner shop_sort;
    private Spinner shop_filter;


    @Override
    public View initView() {
        Log.e(TAG,"主页面的Fragment的UI被初始化了");
        DBManager.init(getActivity());
        View view = View.inflate(mContext, R.layout.fragment_eat,null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        shop_sort=(Spinner)view.findViewById(R.id.shop_sort);
        shop_filter=(Spinner)view.findViewById(R.id.shop_filter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        return view;
    }

    @Override
    public void initData(){
        super.initData();
        shopEntityList=new ArrayList<>() ;
        selectedShopEntityList=new ArrayList<>();
       /*ShopEntity shopEntity1=new ShopEntity(1,R.drawable.mcdonald ,"麦当劳（江安川大店）",5.0,2.44,0,9,3,
                1999,3,38,"","","","","",R.drawable.star_five);
        ShopEntity shopEntity2=new ShopEntity(2,R.drawable.liangpin, "良品铺子（双流文星镇店）",4.9,2.08,20,3.5,2,
                384,2,23,"","","","","",R.drawable.star_five);
        ShopEntity shopEntity3=new ShopEntity(3,R.drawable.coco,"CoCo都可（成都空港华联店）",5.0,3.90,15,4,1,
                344,3,25,"","","","","",R.drawable.star_five);
        ShopEntity shopEntity4=new ShopEntity(4,R.drawable.fish, "潼南太安鱼",4.3,3.90,15,4.5,0,
                577,1,27,"","","","","",R.drawable.star_four);
        ShopEntity shopEntity5=new ShopEntity(5,R.drawable.jigongbao,"重庆鸡公煲",4.6,0.84,20,3,2,
                297,1,18,"","","","","",R.drawable.star_four);
        ShopEntity shopEntity6=new ShopEntity(6,R.drawable.shaokao, "天天烧烤",4.0,1.35,15,3,1,
                1635,3,21,"","","","","",R.drawable.star_four);
        ShopEntity shopEntity7=new ShopEntity(7,R.drawable.hongqi, "红旗超市（川大江安南门）",4.8,0.68,10,3,3,
                5903,2,15,"","","","","",R.drawable.star_five);
        ShopEntity shopEntity8=new ShopEntity(8,R.drawable.liji, "黎记冰粉",4.9,0.72,8,3.5,2,
                722,3,15,"","","","","",R.drawable.star_five);
        ShopEntity shopEntity9=new ShopEntity(9,R.drawable.xie, "菜市老李生鲜",3.3,2.82,15,2,0,
                39,4,38,"","","","","",R.drawable.star_threefive);
        ShopEntity shopEntity10=new ShopEntity(10,R.drawable.rou,"刘氏宰猪",3.0,2.31,15,3,0,
                77,4,27,"","","","","",R.drawable.star_three);
*/       /*shopEntityList.add(shopEntity1);
        shopEntityList.add(shopEntity2);
        shopEntityList.add(shopEntity3);
        shopEntityList.add(shopEntity4);
        shopEntityList.add(shopEntity5);
        shopEntityList.add(shopEntity6);
        shopEntityList.add(shopEntity7);
        shopEntityList.add(shopEntity8);
        shopEntityList.add(shopEntity9);
        shopEntityList.add(shopEntity10);*/

        ShopEntityDao shopEntityDao = DBManager.getmInstance().getSession().getShopEntityDao();
        /*shopEntityDao.insert(shopEntity1);
        shopEntityDao.insert(shopEntity2);
        shopEntityDao.insert(shopEntity3);
        shopEntityDao.insert(shopEntity4);
        shopEntityDao.insert(shopEntity5);
        shopEntityDao.insert(shopEntity6);
        shopEntityDao.insert(shopEntity7);
        shopEntityDao.insert(shopEntity8);
        shopEntityDao.insert(shopEntity9);
        shopEntityDao.insert(shopEntity10);*/
        QueryBuilder<ShopEntity> qb = shopEntityDao.queryBuilder();
        shopEntityList = qb.list();
        for(ShopEntity shopEntity:shopEntityList){
            Log.e(TAG,shopEntity.toString());
        }

        //深拷贝list
        for(ShopEntity shopEntity:shopEntityList){
            selectedShopEntityList.add((ShopEntity) shopEntity.clone());
        }
        shopAdapter=new ShopAdapter(getActivity(),selectedShopEntityList,onRecyclerviewItemClickListener);
        mRecyclerView.setAdapter(shopAdapter);
        Log.e(TAG,"主页面的Fragment的数据被初始化了");
        /*getDataFromNet();*/
        //排序点击事件
        shop_sort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               /* String data = (String)shop_sort.getItemAtPosition(position);//从spinner中获取被选择的数据
                Toast.makeText(getActivity(), data, Toast.LENGTH_SHORT).show();*/
                switch(position){
                    case 0:
                        Collections.sort(selectedShopEntityList, new Comparator<ShopEntity>(){
                            public int compare(ShopEntity p1, ShopEntity p2) {
                                if(p1.getId() > p2.getId()){
                                    return 1;
                                }
                                if(p1.getId() == p2.getId()){
                                    return 0;
                                }
                                return -1;
                            }
                        });
                        break;
                    case 1:
                        Collections.sort(selectedShopEntityList, new Comparator<ShopEntity>(){
                            public int compare(ShopEntity p1, ShopEntity p2) {
                                if(p1.getDistance_desc() > p2.getDistance_desc()){
                                    return 1;
                                }
                                if(p1.getDistance_desc() == p2.getDistance_desc()){
                                    return 0;
                                }
                                return -1;
                            }
                        });
                        break;
                    case 2:
                        Collections.sort(selectedShopEntityList, new Comparator<ShopEntity>(){
                            public int compare(ShopEntity p1, ShopEntity p2) {
                                if(p1.getSale_number() > p2.getSale_number()){
                                    return -1;
                                }
                                if(p1.getSale_number() == p2.getSale_number()){
                                    return 0;
                                }
                                return 1;
                            }
                        });
                        break;
                    case 3:
                        Collections.sort(selectedShopEntityList, new Comparator<ShopEntity>(){
                            public int compare(ShopEntity p1, ShopEntity p2) {
                                if(p1.getPrice_trans_desc() > p2.getPrice_trans_desc()){
                                    return 1;
                                }
                                if(p1.getPrice_trans_desc() == p2.getPrice_trans_desc()){
                                    return 0;
                                }
                                return -1;
                            }
                        });
                        break;
                    case 4:
                        Collections.sort(selectedShopEntityList, new Comparator<ShopEntity>(){
                            public int compare(ShopEntity p1, ShopEntity p2) {
                                if(p1.getShop_score() > p2.getShop_score()){
                                    return -1;
                                }
                                if(p1.getShop_score() == p2.getShop_score()){
                                    return 0;
                                }
                                return 1;
                            }
                        });
                        break;
                }
                shopAdapter=new ShopAdapter(getActivity(),selectedShopEntityList,onRecyclerviewItemClickListener);
                mRecyclerView.setAdapter(shopAdapter);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //选择点击事件
       shop_filter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               /*String data = (String)shop_filter.getItemAtPosition(position);//从spinner中获取被选择的数据
               Toast.makeText(getActivity(), data, Toast.LENGTH_SHORT).show();*/
                   selectedShopEntityList.clear();
                   for(ShopEntity shopEntity:shopEntityList){
                       selectedShopEntityList.add((ShopEntity) shopEntity.clone());
                   }
              if(position!=0){
                  Iterator<ShopEntity> iterator = selectedShopEntityList.iterator();
                  while (iterator.hasNext()){
                      ShopEntity next = iterator.next();
                      if(next.getClassification()!=position){
                          iterator.remove();
                  }
              }
              }
              shopAdapter=new ShopAdapter(getActivity(),selectedShopEntityList,onRecyclerviewItemClickListener);
               mRecyclerView.setAdapter(shopAdapter);
           }
           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });
}
    private OnRecyclerviewItemClickListener onRecyclerviewItemClickListener = new OnRecyclerviewItemClickListener() {
        @Override
        public void onItemClickListener(View v, int position) {
            /*Toast.makeText(getActivity(), selectedShopEntityList.get(position).getShop_name(), Toast.LENGTH_SHORT).show();*/
            Intent intent=new Intent(getActivity(),ShopDetailActivity.class);
            Bundle b=new Bundle();
            b.putDouble("shop_score",selectedShopEntityList.get(position).getShop_score());
            b.putInt("shop_cover",selectedShopEntityList.get(position).getImageId());
            b.putLong("shop_id",selectedShopEntityList.get(position).getId());
            b.putString("address",selectedShopEntityList.get(position).getAddress());
            b.putString("benefit",selectedShopEntityList.get(position).getBenefit());
            b.putString("BusinessTime",selectedShopEntityList.get(position).getBusinessTime());
            b.putString("phone",selectedShopEntityList.get(position).getPhoneNumber());
            b.putString("shop_name",selectedShopEntityList.get(position).getShop_name());
            b.putInt("Classification",selectedShopEntityList.get(position).getClassification());
            intent.putExtras(b);
            startActivity(intent);
        }
    };

  /*  private void getDataFromNet(){
        String url="http://10.0.2.2:8080/laipinV2/findAllShopServlet";
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG,"首页请求失败=="+e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e(TAG,"首页请求成功=="+response);
                        proccessData(response);
                    }
                });
    }
    private void proccessData(String json) {
        Gson gson=new Gson();
        List<ShopEntityEntity> list= gson.fromJson(json, new TypeToken<List<ShopEntityEntity>>() {}.getType());
        for (ShopEntityEntity shopEntityEntity : list) {
            Log.e(TAG,shopEntityEntity.toString());
        }
    }*/

}
