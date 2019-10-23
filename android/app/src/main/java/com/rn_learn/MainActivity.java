package com.rn_learn;

import android.os.Bundle;

import com.facebook.react.ReactActivity;
import com.rn_learn.extralogin.umeng.UmengManager;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

import static com.rn_learn.extralogin.KeyAndSecret.QQ_ID;
import static com.rn_learn.extralogin.KeyAndSecret.QQ_KEY;
import static com.rn_learn.extralogin.KeyAndSecret.SINA_CALLBACK;
import static com.rn_learn.extralogin.KeyAndSecret.SINA_KEY;
import static com.rn_learn.extralogin.KeyAndSecret.SINA_SECRET;
import static com.rn_learn.extralogin.KeyAndSecret.UM_KEY;
import static com.rn_learn.extralogin.KeyAndSecret.WX_ID;
import static com.rn_learn.extralogin.KeyAndSecret.WX_SECRET;

public class MainActivity extends ReactActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initUmeng();

  }

  private void initUmeng() {
    UMConfigure.init(this,UM_KEY,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");
    PlatformConfig.setWeixin(WX_ID,WX_SECRET);
    PlatformConfig.setQQZone(QQ_ID, QQ_KEY);
    PlatformConfig.setSinaWeibo(SINA_KEY, SINA_SECRET, SINA_CALLBACK);
    UMConfigure.setLogEnabled(true);
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
