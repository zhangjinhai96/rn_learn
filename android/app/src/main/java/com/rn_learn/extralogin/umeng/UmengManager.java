package com.rn_learn.extralogin.umeng;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.rn_learn.extralogin.umeng.listener.QQListener;
import com.rn_learn.extralogin.umeng.listener.SinaListener;
import com.rn_learn.extralogin.umeng.listener.WXListener;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import static com.rn_learn.extralogin.KeyAndSecret.QQ_ID;
import static com.rn_learn.extralogin.KeyAndSecret.QQ_KEY;
import static com.rn_learn.extralogin.KeyAndSecret.SINA_CALLBACK;
import static com.rn_learn.extralogin.KeyAndSecret.SINA_KEY;
import static com.rn_learn.extralogin.KeyAndSecret.SINA_SECRET;
import static com.rn_learn.extralogin.KeyAndSecret.UM_KEY;
import static com.rn_learn.extralogin.KeyAndSecret.WX_ID;
import static com.rn_learn.extralogin.KeyAndSecret.WX_SECRET;

public class UmengManager {
    private static UMShareAPI umShareAPI;
    private static Activity mActivity =null;

    public UmengManager(){}

    public static void init(Activity activity){
        mActivity=activity;
        umShareAPI = UMShareAPI.get(activity);
        UMConfigure.init(mActivity,UM_KEY,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");
        PlatformConfig.setWeixin(WX_ID,WX_SECRET);
        PlatformConfig.setQQZone(QQ_ID, QQ_KEY);
        PlatformConfig.setSinaWeibo(SINA_KEY, SINA_SECRET, SINA_CALLBACK);
        UMConfigure.setLogEnabled(true);
    }

    public static void qqLogin(){
        umShareAPI.getPlatformInfo(mActivity, SHARE_MEDIA.QQ, new QQListener());//QQ登录

    }

    public static void wxLogin(){
        umShareAPI.getPlatformInfo(mActivity, SHARE_MEDIA.WEIXIN, new WXListener());//QQ登录

    }

    public static void sinaLogin(){
        umShareAPI.getPlatformInfo(mActivity, SHARE_MEDIA.SINA, new SinaListener());//QQ登录

    }

    public void logout(){
        umShareAPI.deleteOauth(mActivity, SHARE_MEDIA.QQ, null);//撤销QQ授权
    }

    public static void onActivityResult(int requestCode, int resultCode, Intent data){
        umShareAPI.onActivityResult(requestCode, resultCode, data);
    }

}
