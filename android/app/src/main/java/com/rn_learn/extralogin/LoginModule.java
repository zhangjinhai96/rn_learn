package com.rn_learn.extralogin;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.rn_learn.extralogin.umeng.UmengManager;

import androidx.annotation.NonNull;

public class LoginModule extends ReactContextBaseJavaModule {
    public LoginModule(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @NonNull
    @Override
    public String getName() {
        return "Login";
    }

    @ReactMethod
    public void qqLogin(Callback callback){
        CallbackListener.add(callback);
        UmengManager.qqLogin();
    }

    @ReactMethod
    public void wxLogin(Callback callback){
        CallbackListener.add(callback);
        UmengManager.wxLogin();
    }

    @ReactMethod
    public void sinaLogin(Callback callback){
        CallbackListener.add(callback);
        UmengManager.sinaLogin();
    }
}
