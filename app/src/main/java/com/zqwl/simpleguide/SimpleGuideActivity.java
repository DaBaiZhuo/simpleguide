package com.zqwl.simpleguide;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.zqwl.mylibrary.GuideView;


/**
 * author : lihzuo@ule.com
 * date   : 2022/10/17 9:53
 * Dec    :
 */
public class SimpleGuideActivity extends FragmentActivity {


//
    GuideView guideView;
    private Context mContext;
    private TextView tv_test;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_guide);
        tv_test =findViewById(R.id.test_tv);
        mContext=this;
        setGuide();
    }

    private void setGuide() {
        ImageView iv = new ImageView(mContext);
        iv.setImageResource(R.drawable.guide_personal_center_banner);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        iv.setLayoutParams(params);
        iv.setOnClickListener(view -> {
            guideView.hide();
        });
        guideView = GuideView.Builder
                .newInstance(mContext)
                .setTargetView(tv_test)//设置目标
                .setCustomGuideView(iv)
                .setRadius(30)
                .setOffset(0, -100)
                .setDirction(GuideView.Direction.TOP)
                .setShape(GuideView.MyShape.RECTANGULAR)   // 设置圆形显示区域，
                .setBgColor(getResources().getColor(R.color.shadow))
                .build();
        guideView.show();

    }


}
