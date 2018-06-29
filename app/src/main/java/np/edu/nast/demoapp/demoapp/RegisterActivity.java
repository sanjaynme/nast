package np.edu.nast.demoapp.demoapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class RegisterActivity extends AppCompatActivity {
    EditText etFirstName;
    EditText etLastName;
    EditText etPassword;
    EditText etEmail;
    ImageButton btnShowHidePassword;
    Button btnRegister;
    Context context;
    Spinner spinnerChooseSalary;
    RegisterModel registerModel;

    public static void start(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etFirstName = findViewById(R.id.et_firstname);
        etLastName = findViewById(R.id.et_lastname);
        etPassword = findViewById(R.id.et_sign_up_password);
        etEmail = findViewById(R.id.et_email);
        btnRegister = findViewById(R.id.submit_view_registeration);
        ViewUtils.setupUI(findViewById(R.id.activity_register), this);
        btnShowHidePassword = findViewById(R.id.btn_show_hide_register_password);
        btnShowHidePassword.setImageResource(R.drawable.ic_eye);
        spinnerChooseSalary = findViewById(R.id.spinner_salary);

        context = getApplicationContext();
        registerModel = new RegisterModel();


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

        ArrayList<String> salaryTypes = new ArrayList<>(Arrays.asList("All salaries", "Annual", "Hourly"));
        final SpinnerAdapter salaryAdapter = new SpinnerAdapter(context, R.layout.item_spinner, salaryTypes);
        salaryAdapter.setDropDownViewResource(R.layout.item_spinner);
        spinnerChooseSalary.setAdapter(salaryAdapter);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = etFirstName.getText().toString().trim();
                String lastName = etLastName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();

                registerModel.setFirstName(firstName);
                registerModel.setLastName(lastName);
                registerModel.setEmail(email);

                if (spinnerChooseSalary.getSelectedItemPosition() > 0) {
                    String selectedItem = spinnerChooseSalary.getSelectedItem().toString();
                    registerModel.setSalary(selectedItem);
                }
            }
        });


        setAndGetSharedPrefs();


    }

    private void setAndGetSharedPrefs() {
        SharedPreferences pref = context.getSharedPreferences("MyPref", MODE_PRIVATE); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();

        editor.putBoolean("boolValue", true); // Storing boolean - true/false
        editor.putString("name", "Sanjay"); // Storing string
        editor.putInt("rollno", 1); // Storing integer
        editor.apply(); // commit changes

        String name = pref.getString("name", ""); // getting String
        int value = pref.getInt("rollno", 0); // getting Integer

        Toast.makeText(this, "name" + name + "value" + value, Toast.LENGTH_SHORT).show();
    }
}
