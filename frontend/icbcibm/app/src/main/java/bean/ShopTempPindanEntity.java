package bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;


/*临时拼吃记录*/

@Entity
public class ShopTempPindanEntity {
    @Id
    private long id;
    private long shopId;
    private int partner_info;//当前拼单参与人数
    private int pindan_price;//还差多少钱
    private int hour; //还剩多少小时
    private int minute; //还剩多少分钟
    private int benefit_classfication;  //满减档次
    private long userId; //拼单发起人
    @Generated(hash = 1965520288)
    public ShopTempPindanEntity(long id, long shopId, int partner_info,
            int pindan_price, int hour, int minute, int benefit_classfication,
            long userId) {
        this.id = id;
        this.shopId = shopId;
        this.partner_info = partner_info;
        this.pindan_price = pindan_price;
        this.hour = hour;
        this.minute = minute;
        this.benefit_classfication = benefit_classfication;
        this.userId = userId;
    }
    @Generated(hash = 1743615594)
    public ShopTempPindanEntity() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getShopId() {
        return this.shopId;
    }
    public void setShopId(long shopId) {
        this.shopId = shopId;
    }
    public int getPartner_info() {
        return this.partner_info;
    }
    public void setPartner_info(int partner_info) {
        this.partner_info = partner_info;
    }
    public int getPindan_price() {
        return this.pindan_price;
    }
    public void setPindan_price(int pindan_price) {
        this.pindan_price = pindan_price;
    }
    public int getHour() {
        return this.hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }
    public int getMinute() {
        return this.minute;
    }
    public void setMinute(int minute) {
        this.minute = minute;
    }
    public int getBenefit_classfication() {
        return this.benefit_classfication;
    }
    public void setBenefit_classfication(int benefit_classfication) {
        this.benefit_classfication = benefit_classfication;
    }
    public long getUserId() {
        return this.userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }

}
