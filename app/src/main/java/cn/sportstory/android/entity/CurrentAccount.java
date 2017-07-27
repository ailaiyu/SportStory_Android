package cn.sportstory.android.entity;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import cn.sportstory.android.util.SPUtil;

/**
 * Created by Tamas on 2017/7/27.
 */

public class CurrentAccount extends Account {
    private static final String CURRENT_ACOUNT_SHARE_PREFERANCE_PATH="sp_current_acount";
    private static final String KEY_ACCOUNT="account";
    private Context mContext;
    private SPUtil mSpUtil;
    private boolean mIsValid;

    private Account mAccount;

    private static CurrentAccount sCurrentAccount;
    private CurrentAccount(Context ctx){
        mContext=ctx;
        mSpUtil=SPUtil.getInstance(mContext);
        init();

    }
    public static CurrentAccount getInstance(Context ctx){
        if(sCurrentAccount==null){
            synchronized (CurrentAccount.class){
                if(sCurrentAccount==null){
                    sCurrentAccount=new CurrentAccount(ctx);
                }
            }
        }
        return sCurrentAccount;
    }
    private void init(){
        String accountJsonStr=mSpUtil.getString(KEY_ACCOUNT,"");
        mAccount=new Gson().fromJson(accountJsonStr,Account.class);
        if(mAccount==null)mIsValid=false;
        else mIsValid=true;
    }

    public void reset(Account account){
        mAccount=account;
        mSpUtil.putString(KEY_ACCOUNT,new Gson().toJson(mAccount));
        mIsValid=true;
    }

    public boolean isValid(){
        return mIsValid;
    }

    public String getToken(){
        String token=mAccount.getToken();
        if(token==null)token="";
        return token;
    }

}
