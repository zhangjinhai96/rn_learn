package com.rn_learn;

import android.content.Intent;
import android.os.Bundle;

import com.facebook.react.ReactActivity;
import com.rn_learn.component.localgallery.Gallery;
import com.rn_learn.extralogin.umeng.UmengManager;

public class MainActivity extends ReactActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    UmengManager.init(this);
    Gallery.createInstance(this);
  }

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  @Override
  protected String getMainComponentName() {
    return "rn_learn";
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    Gallery.getInstance().onActivityResult(requestCode, resultCode, data);
  }
}
