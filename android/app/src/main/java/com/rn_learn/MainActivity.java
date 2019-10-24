package com.rn_learn;

import android.os.Bundle;

import com.facebook.react.ReactActivity;
import com.rn_learn.extralogin.umeng.UmengManager;

public class MainActivity extends ReactActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    UmengManager.init(this);
  }

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  @Override
  protected String getMainComponentName() {
    return "rn_learn";
  }
}
