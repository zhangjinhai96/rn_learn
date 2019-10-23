package com.rn_learn.extralogin.umeng;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.rn_learn.extralogin.umeng.listener.QQListener;
import com.rn_learn.extralogin.umeng.listener.SinaListener;
import com.rn_learn.extralogin.umeng.listener.WXListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

public class UmengManager {
    private static UMShareAPI umShareAPI;
    private static Activity mActivity =null;

    public UmengManager(){}

    public static void init(Activity activity){
        mActivity=activity;
        umShareAPI = UMShareAPI.get(activity);
    }

    public static void qqLogin(){
        Log.i("qqLogin", "进入");
        umShareAPI.getPlatformInfo(mActivity, SHARE_MEDIA.QQ, new QQListener());//QQ登录

    }

    public static void wxLogin(){
        Log.i("qqLogin", "进入");
        umShareAPI.getPlatformInfo(mActivity, SHARE_MEDIA.WEIXIN, new WXListener());//QQ登录

    }

    public static void sinaLogin(){
        Log.i("qqLogin", "进入");
        umShareAPI.getPlatformInfo(mActivity, SHARE_MEDIA.SINA, new SinaListener());//QQ登录

    }

    public void logout(){
        umShareAPI.deleteOauth(mActivity, SHARE_MEDIA.QQ, null);//撤销QQ授权
    }

    public static void onActivityResult(int requestCode, int resultCode, Intent data){
        umShareAPI.onActivityResult(requestCode, resultCode, data);
    }



}
