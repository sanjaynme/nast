package np.edu.nast.demoapp.demoapp.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import np.edu.nast.demoapp.demoapp.DatabaseExample;
import np.edu.nast.demoapp.demoapp.R;
import np.edu.nast.demoapp.demoapp.contracts.AppContract;
import np.edu.nast.demoapp.demoapp.data.local.SharedPreferenceManager;
import np.edu.nast.demoapp.demoapp.home.HomeActivity;

public class SplashActivity extends AppCompatActivity {
    SharedPreferenceManager sharedPreferenceManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sharedPreferenceManager = new SharedPreferenceManager(this);
        if (sharedPreferenceManager.getBoolValues(AppContract.Preferences.IS_LOGGED_IN)) {
            finish();
            DatabaseExample.start(this);
        } else {
            finish();
            LandingActivity.start(this);
        }
    }
}
