package DAO;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import bean.ShopGoodsEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SHOP_GOODS_ENTITY".
*/
public class ShopGoodsEntityDao extends AbstractDao<ShopGoodsEntity, Long> {

    public static final String TABLENAME = "SHOP_GOODS_ENTITY";

    /**
     * Properties of entity ShopGoodsEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property Good_cover = new Property(1, int.class, "good_cover", false, "GOOD_COVER");
        public final static Property Good_name = new Property(2, String.class, "good_name", false, "GOOD_NAME");
        public final static Property Good_info = new Property(3, String.class, "good_info", false, "GOOD_INFO");
        public final static Property Price_sales = new Property(4, int.class, "price_sales", false, "PRICE_SALES");
        public final static Property Good_price = new Property(5, double.class, "good_price", false, "GOOD_PRICE");
        public final static Property Shop_id = new Property(6, long.class, "Shop_id", false, "SHOP_ID");
    }


    public ShopGoodsEntityDao(DaoConfig config) {
        super(config);
    }
    
    public ShopGoodsEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SHOP_GOODS_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "\"GOOD_COVER\" INTEGER NOT NULL ," + // 1: good_cover
                "\"GOOD_NAME\" TEXT," + // 2: good_name
                "\"GOOD_INFO\" TEXT," + // 3: good_info
                "\"PRICE_SALES\" INTEGER NOT NULL ," + // 4: price_sales
                "\"GOOD_PRICE\" REAL NOT NULL ," + // 5: good_price
                "\"SHOP_ID\" INTEGER NOT NULL );"); // 6: Shop_id
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SHOP_GOODS_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ShopGoodsEntity entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindLong(2, entity.getGood_cover());
 
        String good_name = entity.getGood_name();
        if (good_name != null) {
            stmt.bindString(3, good_name);
        }
 
        String good_info = entity.getGood_info();
        if (good_info != null) {
            stmt.bindString(4, good_info);
        }
        stmt.bindLong(5, entity.getPrice_sales());
        stmt.bindDouble(6, entity.getGood_price());
        stmt.bindLong(7, entity.getShop_id());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ShopGoodsEntity entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindLong(2, entity.getGood_cover());
 
        String good_name = entity.getGood_name();
        if (good_name != null) {
            stmt.bindString(3, good_name);
        }
 
        String good_info = entity.getGood_info();
        if (good_info != null) {
            stmt.bindString(4, good_info);
        }
        stmt.bindLong(5, entity.getPrice_sales());
        stmt.bindDouble(6, entity.getGood_price());
        stmt.bindLong(7, entity.getShop_id());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public ShopGoodsEntity readEntity(Cursor cursor, int offset) {
        ShopGoodsEntity entity = new ShopGoodsEntity( //
            cursor.getLong(offset + 0), // id
            cursor.getInt(offset + 1), // good_cover
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // good_name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // good_info
            cursor.getInt(offset + 4), // price_sales
            cursor.getDouble(offset + 5), // good_price
            cursor.getLong(offset + 6) // Shop_id
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ShopGoodsEntity entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setGood_cover(cursor.getInt(offset + 1));
        entity.setGood_name(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setGood_info(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPrice_sales(cursor.getInt(offset + 4));
        entity.setGood_price(cursor.getDouble(offset + 5));
        entity.setShop_id(cursor.getLong(offset + 6));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(ShopGoodsEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(ShopGoodsEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(ShopGoodsEntity entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
