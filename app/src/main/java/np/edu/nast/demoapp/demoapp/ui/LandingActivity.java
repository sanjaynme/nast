package np.edu.nast.demoapp.demoapp.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

import np.edu.nast.demoapp.demoapp.R;
import np.edu.nast.demoapp.demoapp.contracts.AppContract;
import np.edu.nast.demoapp.demoapp.data.ApiObject;
import np.edu.nast.demoapp.demoapp.data.ApiService;
import np.edu.nast.demoapp.demoapp.data.local.SharedPreferenceManager;
import np.edu.nast.demoapp.demoapp.home.HomeActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LandingActivity extends AppCompatActivity {
    Button btnRegister;
    Button btnLogin;
    SharedPreferenceManager sharedPreferenceManager;

    public static void start(Context context) {
        Intent intent = new Intent(context, LandingActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);
        sharedPreferenceManager = new SharedPreferenceManager(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginActivity.start(LandingActivity.this);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterActivity.start(LandingActivity.this);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        ApiService.getServiceClass().getAllPost().enqueue(new Callback<List<ApiObject>>() {
            @Override
            public void onResponse(Call<List<ApiObject>> call, Response<List<ApiObject>> response) {
                if (response.isSuccessful()) {
                }
            }

            @Override
            public void onFailure(Call<List<ApiObject>> call, Throwable t) {
                Log.d("", "Error msg is :::" + t.getMessage());
            }
        });

    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        super.onBackPressed();
    }
}
