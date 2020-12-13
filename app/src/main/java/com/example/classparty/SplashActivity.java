package com.example.classparty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity implements HelperInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if(getHelper().isLogin(this)){
            startActivity(new Intent(SplashActivity.this,HomeActivity.class));
            finish();
        }else {
            startActivity(new Intent(SplashActivity.this,SignInActivity.class));
            finish();
        }
    }

    @Override
    public ApplicationHelper getHelper() {
        return ApplicationHelper.getInstance();
    }
}
