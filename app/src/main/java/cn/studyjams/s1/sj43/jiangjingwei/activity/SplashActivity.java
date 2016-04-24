package cn.studyjams.s1.sj43.jiangjingwei.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.studyjams.s1.sj43.jiangjingwei.R;

public class SplashActivity extends FragmentActivity {

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_splash);

        goHomeActivity();
    }

    private void goHomeActivity() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, HomeActivity
                        .class);
                startActivity(intent);
                finish();
            }

        }, 3000);
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }


}
