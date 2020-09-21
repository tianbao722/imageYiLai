package com.example.bigimage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageActivity extends AppCompatActivity {
    ViewPager vpPop;
    TextView tvPop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        vpPop = findViewById(R.id.vp_pop);
        tvPop = findViewById(R.id.tv_pop);
        Intent intent = getIntent();
        int postion1 = intent.getIntExtra("position", 0);
        final ArrayList<String> list = intent.getStringArrayListExtra("list");
        ImageMagnifyAdapter imgVpAda = new ImageMagnifyAdapter(this, list);
        vpPop.setAdapter(imgVpAda);
        tvPop.setText(postion1 + 1 + "/" + list.size());
        vpPop.setCurrentItem(postion1);
        imgVpAda.setCallBack(new ImageMagnifyAdapter.onCallBack() {
            @Override
            public void onItemClick() {
                finish();
            }
        });
        vpPop.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                tvPop.setText(position + 1 + "/" + list.size());
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}