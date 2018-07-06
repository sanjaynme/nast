package np.edu.nast.demoapp.demoapp.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import np.edu.nast.demoapp.demoapp.DatabaseExample;
import np.edu.nast.demoapp.demoapp.R;
import np.edu.nast.demoapp.demoapp.contracts.AppContract;
import np.edu.nast.demoapp.demoapp.data.ApiService;
import np.edu.nast.demoapp.demoapp.data.local.SharedPreferenceManager;
import np.edu.nast.demoapp.demoapp.helpers.ViewUtils;
import np.edu.nast.demoapp.demoapp.home.HomeActivity;

public class LoginActivity extends AppCompatActivity {
    EditText etEmail;
    String url;
    EditText etPassword;
    Button btnLogin;
    ApiService apiService;
    SharedPreferenceManager sharedPreferenceManager;
    ImageButton btnShowHidePassword;

    public static void start(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btn_login);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        sharedPreferenceManager = new SharedPreferenceManager(this);
        ViewUtils.setupUI(findViewById(R.id.activity_login), this);
        btnShowHidePassword = findViewById(R.id.btn_show_hide_login_password);
        btnShowHidePassword.setImageResource(R.drawable.ic_eye);
        btnShowHidePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etPassword.getTransformationMethod() == PasswordTransformationMethod.getInstance()) {
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    btnShowHidePassword.setImageResource(R.drawable.ic_eye_slash);
                } else if (etPassword.getTransformationMethod() == HideReturnsTransformationMethod.getInstance()) {
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    btnShowHidePassword.setImageResource(R.drawable.ic_eye);
                }
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                if (isValid(email, password)) {
                    if (email.equalsIgnoreCase("sanjay@gmail.com") && password.equalsIgnoreCase("sanjay123")) {
                        sharedPreferenceManager.setKeyValues(AppContract.Preferences.IS_LOGGED_IN, true);
                        sharedPreferenceManager.setKeyValues(AppContract.Preferences.EMAIL, email);
//                        startHomeActivity();
                        startDatabaseActivity();
                    } else {
                        showAlertDialog(R.string.error_occured);
                    }
                }
            }
        });


    }

    private void startHomeActivity() {
        HomeActivity.start(LoginActivity.this);
        finish();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    private void startDatabaseActivity() {
        DatabaseExample.start(LoginActivity.this);
        finish();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    private boolean isValid(String username, String password) {
        if (username.isEmpty()) {
            showAlertDialog(R.string.err_email_empty);
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
            showAlertDialog(R.string.err_email_invalid);
            return false;
        } else if (password.isEmpty()) {
            showAlertDialog(R.string.err_password);
            return false;
        } /*else if (password.length() < 8) {
            showAlertDialog(R.string.err_password_invalid);
            return false;
        } else if (password.equals(password.toLowerCase())) {
            showAlertDialog(R.string.err_password_capital);
            return false;
        } */ else {
            return true;
        }
    }

    private void showAlertDialog(int message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setTitle(getString(R.string.app_name));
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
