package np.edu.nast.demoapp.demoapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    SharedPreferenceManager sharedPreferenceManager;
    Button btnLogOut;

    public static void start(Context context) {
        Intent homeIntent = new Intent();
        homeIntent.setClass(context, HomeActivity.class);
        context.startActivity(homeIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnLogOut = findViewById(R.id.btn_logout);
        sharedPreferenceManager = new SharedPreferenceManager(this);

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferenceManager.setKeyValues(AppContracts.Preferences.IS_LOGGED_IN, false);
//                startSplashActivity();
            }
        });
    }

   /* private void startSplashActivity() {
        SplashActivity.start(HomeActivity.this);
    }
*/
}
