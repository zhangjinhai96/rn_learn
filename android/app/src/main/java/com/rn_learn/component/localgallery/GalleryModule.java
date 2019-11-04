package com.rn_learn.component;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import androidx.annotation.NonNull;

public class GalleryModule extends ReactContextBaseJavaModule {
    public GalleryModule(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @NonNull
    @Override
    public String getName() {
        return "Gallery";
    }

    @ReactMethod
    public void getImage(Callback callback){
        Gallery.getInstance().openGallery(callback);
    }
}
