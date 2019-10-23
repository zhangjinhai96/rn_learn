package com.rn_learn.bootpage;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.rn_learn.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BootPageFragment extends Fragment implements View.OnClickListener {

    private boolean isShowButton=false;
    private BootPageActivity mActivity=null;
    private int imgId;

    public BootPageFragment(BootPageActivity activity,boolean isShowButton,int resId) {
        mActivity = activity;
        this.isShowButton = isShowButton;
        imgId=resId;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.b_page,container,false);
        ImageView image = view.findViewById(R.id.boot_page_img);
        image.setImageResource(imgId);
        if(isShowButton) {
            Button button = view.findViewById(R.id.boot_bt);
            button.setVisibility(View.VISIBLE);
            button.setOnClickListener(this);
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        mActivity.toRN();
    }
}
