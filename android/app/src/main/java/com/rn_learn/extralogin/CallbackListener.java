package com.rn_learn.extralogin;

import com.facebook.react.bridge.Callback;

public class CallbackListener {
    private static Callback observer=null;
    public static void add(Callback callback){
        observer=callback;
    }
    public static void notice(String name,String gender,String icon){
        observer.invoke(name,gender,icon);
    }
}
