package np.edu.nast.demoapp.demoapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DatabaseExample extends AppCompatActivity {
    EditText etName, etPassword, etUpdateOld, etUpdateNew, etDelete;
    MyDbAdapter helper;
    Button btnAddUser, btnDelUser, btnUpdateUser, btnViewData;

    public static void start(Context context) {
        Intent intent = new Intent(context, DatabaseExample.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_example);
        etName = findViewById(R.id.et_name);
        etPassword = (EditText) findViewById(R.id.et_password);
        etUpdateOld = (EditText) findViewById(R.id.et_current_user);
        etUpdateNew = (EditText) findViewById(R.id.et_new_user);
        etDelete = (EditText) findViewById(R.id.et_del_user);
        helper = new MyDbAdapter(this);
        btnAddUser = findViewById(R.id.btn_add_user);
        btnUpdateUser = findViewById(R.id.btn_update);
        btnDelUser = findViewById(R.id.btn_del);
        btnViewData = findViewById(R.id.btn_view_data);

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });

        btnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewData();
            }
        });
        btnUpdateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUser();
            }
        });

        btnDelUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delUser();
            }

            private void delUser() {
                String userName = etDelete.getText().toString();
                if (userName.isEmpty()) {
                    Message.message(getApplicationContext(), "Enter Data");
                } else {
                    int a = helper.deleteUser(userName);
                    if (a <= 0) {
                        Message.message(getApplicationContext(), "Enter Data");
                        etDelete.setText("");
                    } else {
                        Message.message(getApplicationContext(), "DELETED");
                        etDelete.setText("");
                    }
                }
            }
        });

    }

    private void updateUser() {
        String updateOld = etUpdateOld.getText().toString();
        String updateNew = etUpdateNew.getText().toString();
        if (updateOld.isEmpty() || updateNew.isEmpty()) {
            Message.message(getApplicationContext(), "Enter Data");
        } else {
            int a = helper.updateName(updateOld, updateNew);
            if (a <= 0) {
                Message.message(getApplicationContext(), "Unsuccessful");
                etUpdateOld.setText("");
                etUpdateNew.setText("");
            } else {
                Message.message(getApplicationContext(), "Updated");
                etUpdateOld.setText("");
                etUpdateNew.setText("");
            }
        }
    }

    private void viewData() {

        String data = helper.getData();
        Message.message(this, data);
    }

    private void addUser() {
        String name = etName.getText().toString();
        String password = etPassword.getText().toString();
        if (name.isEmpty() || password.isEmpty()) {
            Message.message(getApplicationContext(), "Enter Both Name and Password");
        } else {
            long id = helper.insertData(name, password);
            if (id <= 0) {
                Message.message(getApplicationContext(), "Insertion Unsuccessful");
                etName.setText("");
                etPassword.setText("");
            } else {
                Message.message(getApplicationContext(), "Insertion Successful");
                etName.setText("");
                etPassword.setText("");
            }
        }
    }

}
