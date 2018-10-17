package bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class ShoppingCartEntity {
    @Id
    long id;
    long user_id;
    long shopGood_id;
    int number;
    @Generated(hash = 123388333)
    public ShoppingCartEntity(long id, long user_id, long shopGood_id, int number) {
        this.id = id;
        this.user_id = user_id;
        this.shopGood_id = shopGood_id;
        this.number = number;
    }
    @Generated(hash = 1030367678)
    public ShoppingCartEntity() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getUser_id() {
        return this.user_id;
    }
    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
    public long getShopGood_id() {
        return this.shopGood_id;
    }
    public void setShopGood_id(long shopGood_id) {
        this.shopGood_id = shopGood_id;
    }
    public int getNumber() {
        return this.number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

}
