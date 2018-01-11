package app.mvp.sample.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import app.mvp.sample.R;
import app.mvp.sample.ui.base.BaseActivity;
import app.mvp.sample.ui.login.LoginActivity;

/**
 * Created by Neha Gupta on 11/01/18.
 */

public class SplashActivity extends BaseActivity {

    private static final int DELAY_DURATION = 2000;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler()
                .postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                        finish();
                    }
                }, DELAY_DURATION);
    }
}
