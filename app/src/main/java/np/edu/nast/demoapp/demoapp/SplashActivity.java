package np.edu.nast.demoapp.demoapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.Space;

public class SplashActivity extends AppCompatActivity {
    Button btnRegister;
    Button btnLogin;
    private SharedPreferenceManager preferenceManager;

/*

    public static void start(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        context.startActivity(intent);
    }
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);
        preferenceManager = new SharedPreferenceManager(this);
        if (preferenceManager.getBoolValues(AppContracts.Preferences.IS_LOGGED_IN)) {
            //ServiceHelper.startService(this);
            finish();
            HomeActivity.start(SplashActivity.this);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        } else {
            finish();
//            SplashActivity.start(SplashActivity.this);
//            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginActivity.start(SplashActivity.this);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterActivity.start(SplashActivity.this);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        super.onBackPressed();
    }

}
