package com.rn_learn.bootpage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.rn_learn.MainActivity;
import com.rn_learn.R;
import com.rn_learn.splashscreen.SplashScreen;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class BootPageActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private ViewPager bootViewpager=null;
    private List<Fragment> fragments=new ArrayList<>(3);
    private ImageView point=null;
    private int[] bootImages = {R.mipmap.boot_1,R.mipmap.boot_2,R.mipmap.boot_3};

    private Timer timer=new Timer();
    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            SplashScreen.hide(getParent());
            timer.cancel();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        SplashScreen.show(this, R.style.SplashScreenTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bootpage);
        timer.schedule(task,1000);
        init();
    }

    private void init() {
        point = findViewById(R.id.boot_point);
        bootViewpager = findViewById(R.id.boot_vp);
        fragments.add(new BootPageFragment(null,false,bootImages[0]));
        fragments.add(new BootPageFragment(null,false,bootImages[1]));
        fragments.add(new BootPageFragment(this,true,bootImages[2]));
        BootAdapter adapter=new BootAdapter(getSupportFragmentManager(),fragments);
        bootViewpager.setAdapter(adapter);
        bootViewpager.addOnPageChangeListener(this);
    }

    public void toRN() {
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                point.setImageResource(R.mipmap.point_1);
                break;
            case 1:
                point.setImageResource(R.mipmap.point_2);
                break;
            case 2:
                point.setImageResource(R.mipmap.point_3);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
