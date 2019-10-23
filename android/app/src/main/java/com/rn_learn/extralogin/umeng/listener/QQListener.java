package com.rn_learn.extralogin.umeng.listener;

import android.util.Log;

import com.rn_learn.extralogin.CallbackListener;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class QQListener implements UMAuthListener {

    private String name = "QQ";

    @Override
    public void onStart(SHARE_MEDIA share_media) {
        Log.i(name,"开始-----------海哥哥");
    }

    @Override
    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
        Log.i(name,"海哥哥");
        CallbackListener.notice(map.get("name"),"","");
    }

    @Override
    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
        Log.i(name,"错误-----------海哥哥");
    }

    @Override
    public void onCancel(SHARE_MEDIA share_media, int i) {
        Log.i(name,"取消-----------海哥哥");
    }
}
