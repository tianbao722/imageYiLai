package com.example.createyilai;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView mTvDiaozhuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTvDiaozhuan = (TextView) findViewById(R.id.tv_diaozhuan);
        ArrayList<String> image = new ArrayList<>();
        image.add("http://i1.hdslb.com/bfs/archive/d9f81222ddbd9729d6ef848bcff41f323b0909d5.png");
        image.add("https://hbimg.huabanimg.com/60ea058c02a619500b92f97226e375711b76231f10870-TjO2dI_fw658");
        image.add("http://5b0988e595225.cdn.sohucs.com/images/20191102/d1bdee163629467b819ace8a4c31e815.jpeg");
        image.add("http://5b0988e595225.cdn.sohucs.com/images/20191102/ed3f6924e4e94c7e8e3880df5a8559bc.jpeg");
        image.add("https://p0.ssl.qhimgs1.com/sdr/400__/t01b2cba6e32cefa62a.jpg");
        mTvDiaozhuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("bigimage");
                intent.putExtra("position", 1);
                intent.putStringArrayListExtra("list",image);
                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
        }
    }
}