package com.example.kitchenorderticket;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import control.Hide;
import control.IntentControl;
import model.CreateToast;
import model.UserModel;
import sqlhelper.CustomSqlHelper;

public class LoginActivity extends AppCompatActivity {


    Spinner cmbUserTypeL;
    EditText txtUsername, txtPassword;
    Button btnLogin;
    TextView tvSignup;
    String username, password, type;
    IntentControl intentControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Hide.hideActionAndNotificationBar(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        init();
        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAll();

                intentControl.START_ACTIVITY(LoginActivity.this, RegisterActivity.class);
//              Intent intent = new Intent(LoginActivity.this, RegisterActivity.class)
//              startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkLogin();

            }
        });

    }

    private void clearAll() {
        txtUsername.setText("");
        txtPassword.setText("");
    }

    private void checkLogin() {
        try {
            username = txtUsername.getText().toString();
            password = txtPassword.getText().toString();
            type = cmbUserTypeL.getSelectedItem().toString();
            if (!validate()) {

                final CustomSqlHelper myHelper = new CustomSqlHelper(this);
                final SQLiteDatabase sqld = myHelper.getWritableDatabase();
                if (myHelper.checkLoginUser(username, password, type, sqld)) {
                    if(CustomSqlHelper.ADMIN_FLAG){
                        intentControl.START_ACTIVITY(LoginActivity.this, AdminDashboardActivity.class);//
                        CreateToast.create_Toast(this, "ADMIN Successfully loged in");
                        clearAll();
                    }else {
                        intentControl.START_ACTIVITY(LoginActivity.this, DashboardActivity.class);//
                        CreateToast.create_Toast(this, "User Successfully loged in");
                        clearAll();
                    }

                } else {
                    CreateToast.create_Toast(this, "User not loged in");
                }
            } else {
                CreateToast.create_Toast(this, "Field are empty");

            }


        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public boolean validate() {
        if (TextUtils.isEmpty(username)) {
            txtUsername.setError("Enter username");
            txtUsername.requestFocus();
            return true;
        } else if (TextUtils.isEmpty(password)) {
            txtPassword.setError("Enter password");
            txtPassword.requestFocus();
            return true;

        } else return false;
    }

    private void init() {
        btnLogin = findViewById(R.id.btnLogin);
        txtUsername = findViewById(R.id.txtUsernameL);
        txtPassword = findViewById(R.id.txtPasswordL);
        tvSignup = findViewById(R.id.tvSignUp);
        cmbUserTypeL = findViewById(R.id.cmbUserTypeL);
        cmbUserTypeL.setAdapter(UserModel.SET_USERTYPE_ARRAYADAPTER(this));
        intentControl = new IntentControl();
    }
}
