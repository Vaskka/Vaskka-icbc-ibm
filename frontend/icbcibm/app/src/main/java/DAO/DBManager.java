package DAO;

import android.content.Context;

public class DBManager {

    private static DaoMaster mDaoMaster;
    private static DaoSession mDaoSession;
    private static DBManager mInstance;
    private DaoMaster.DevOpenHelper openHelper;

    private DBManager() {
    }

    public static DBManager init (Context mContext) {

        if (mInstance == null) {
            DaoMaster.DevOpenHelper devOpenHelper = new
                    DaoMaster.DevOpenHelper(mContext, "haohao.db", null);//此处为自己需要处理的表
            mDaoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
            mDaoSession = mDaoMaster.newSession();

        }

        if (mInstance == null) {
            //保证异步处理安全操作
            synchronized (DBManager.class) {
                if (mInstance == null) {
                    mInstance = new DBManager();
                }
            }
        }
        return mInstance;
    }


    public static DBManager getmInstance() {
        return mInstance;
    }
    public DaoMaster getMaster() {
        return mDaoMaster;
    }

    public DaoSession getSession() {
        return mDaoSession;
    }

    public DaoSession getNewSession() {
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;
    }

}