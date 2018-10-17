package bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class ShopGoodsEntity {
    @Id
    long id;
    int good_cover;
    String good_name;
    String good_info;
    int price_sales;
    double good_price;
    long Shop_id;
    @Generated(hash = 1566630029)
    public ShopGoodsEntity(long id, int good_cover, String good_name,
            String good_info, int price_sales, double good_price, long Shop_id) {
        this.id = id;
        this.good_cover = good_cover;
        this.good_name = good_name;
        this.good_info = good_info;
        this.price_sales = price_sales;
        this.good_price = good_price;
        this.Shop_id = Shop_id;
    }
    @Generated(hash = 183004415)
    public ShopGoodsEntity() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getGood_cover() {
        return this.good_cover;
    }
    public void setGood_cover(int good_cover) {
        this.good_cover = good_cover;
    }
    public String getGood_name() {
        return this.good_name;
    }
    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }
    public String getGood_info() {
        return this.good_info;
    }
    public void setGood_info(String good_info) {
        this.good_info = good_info;
    }
    public int getPrice_sales() {
        return this.price_sales;
    }
    public void setPrice_sales(int price_sales) {
        this.price_sales = price_sales;
    }
    public double getGood_price() {
        return this.good_price;
    }
    public void setGood_price(double good_price) {
        this.good_price = good_price;
    }
    public long getShop_id() {
        return this.Shop_id;
    }
    public void setShop_id(long Shop_id) {
        this.Shop_id = Shop_id;
    }
   

   
}
