package np.edu.nast.demoapp.demoapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import np.edu.nast.demoapp.demoapp.R;

public class SplashActivity extends AppCompatActivity {
    Button btnRegister;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);

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
