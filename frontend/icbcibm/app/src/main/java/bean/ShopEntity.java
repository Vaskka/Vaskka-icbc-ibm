package bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class ShopEntity implements Cloneable,Serializable {

    private static final long serialVersionUID = -7156129056887465351L;
    @Id
    long id;
    int imageId;
    String shop_name;       //商店名称
    double shop_score;        //商店评分
    double distance_desc;  //距离
    double price_limit_desc;  //起送价
    double  price_trans_desc; //配送费
    int shop_pinNumber;    //当前拼单数量
    int sale_number;    //销售量
    int classification; //分类
    int arrival_time;
    String address;        //地址
    String phoneNumber;     //电话号码
    String businessTime;    //营业时间
    String briefIntroduction;   //简介
    String benefit;
    int shop_star_imagineId;



    @Generated(hash = 702204088)
    public ShopEntity(long id, int imageId, String shop_name, double shop_score,
            double distance_desc, double price_limit_desc, double price_trans_desc,
            int shop_pinNumber, int sale_number, int classification,
            int arrival_time, String address, String phoneNumber,
            String businessTime, String briefIntroduction, String benefit,
            int shop_star_imagineId) {
        this.id = id;
        this.imageId = imageId;
        this.shop_name = shop_name;
        this.shop_score = shop_score;
        this.distance_desc = distance_desc;
        this.price_limit_desc = price_limit_desc;
        this.price_trans_desc = price_trans_desc;
        this.shop_pinNumber = shop_pinNumber;
        this.sale_number = sale_number;
        this.classification = classification;
        this.arrival_time = arrival_time;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.businessTime = businessTime;
        this.briefIntroduction = briefIntroduction;
        this.benefit = benefit;
        this.shop_star_imagineId = shop_star_imagineId;
    }

    @Generated(hash = 253351364)
    public ShopEntity() {
    }

    @Override
    public String toString() {
        return "ShopEntity{" +
                "id=" + id +
                ", imageId=" + imageId +
                ", shop_name='" + shop_name + '\'' +
                ", shop_score=" + shop_score +
                ", distance_desc=" + distance_desc +
                ", price_limit_desc=" + price_limit_desc +
                ", price_trans_desc=" + price_trans_desc +
                ", shop_pinNumber=" + shop_pinNumber +
                ", sale_number=" + sale_number +
                ", classification=" + classification +
                ", arrival_time=" + arrival_time +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", businessTime='" + businessTime + '\'' +
                ", briefIntroduction='" + briefIntroduction + '\'' +
                ", benefit='" + benefit + '\'' +
                ", shop_star_imagineId=" + shop_star_imagineId +
                '}';
    }

    @Override
    public ShopEntity clone() {
        ShopEntity shopEntity = null;
        try {
            shopEntity = (ShopEntity) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return shopEntity;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getImageId() {
        return this.imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getShop_name() {
        return this.shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public double getShop_score() {
        return this.shop_score;
    }

    public void setShop_score(double shop_score) {
        this.shop_score = shop_score;
    }

    public double getDistance_desc() {
        return this.distance_desc;
    }

    public void setDistance_desc(double distance_desc) {
        this.distance_desc = distance_desc;
    }

    public double getPrice_limit_desc() {
        return this.price_limit_desc;
    }

    public void setPrice_limit_desc(double price_limit_desc) {
        this.price_limit_desc = price_limit_desc;
    }

    public double getPrice_trans_desc() {
        return this.price_trans_desc;
    }

    public void setPrice_trans_desc(double price_trans_desc) {
        this.price_trans_desc = price_trans_desc;
    }

    public int getShop_pinNumber() {
        return this.shop_pinNumber;
    }

    public void setShop_pinNumber(int shop_pinNumber) {
        this.shop_pinNumber = shop_pinNumber;
    }

    public int getSale_number() {
        return this.sale_number;
    }

    public void setSale_number(int sale_number) {
        this.sale_number = sale_number;
    }

    public int getClassification() {
        return this.classification;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }

    public int getArrival_time() {
        return this.arrival_time;
    }

    public void setArrival_time(int arrival_time) {
        this.arrival_time = arrival_time;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBusinessTime() {
        return this.businessTime;
    }

    public void setBusinessTime(String businessTime) {
        this.businessTime = businessTime;
    }

    public String getBriefIntroduction() {
        return this.briefIntroduction;
    }

    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }

    public String getBenefit() {
        return this.benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    public int getShop_star_imagineId() {
        return this.shop_star_imagineId;
    }

    public void setShop_star_imagineId(int shop_star_imagineId) {
        this.shop_star_imagineId = shop_star_imagineId;
    }
    
}
