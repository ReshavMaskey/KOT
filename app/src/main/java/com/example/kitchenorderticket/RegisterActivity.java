package com.example.kitchenorderticket;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import control.Hide;
import model.CreateToast;
import model.UserModel;
import sqlhelper.CustomSqlHelper;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtUsernameR,txtPasswordR,txtConfirmPasswordR;
    Spinner cmbUserTypeR;
    Button btnRegister;



    String username,password,type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Hide.hideActionAndNotificationBar(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);
        init();
        btnRegister.setOnClickListener(this);

    }

    private void init() {
        txtUsernameR = findViewById(R.id.txtUsernameR);
        txtPasswordR = findViewById(R.id.txtPasswordR);
        txtConfirmPasswordR = findViewById(R.id.txtCpasswordR);

        cmbUserTypeR = findViewById(R.id.cmbUserTypeR);
        btnRegister = findViewById(R.id.btnRegister);

//        ArrayAdapter adapter= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,UserModel.USER_TYPE_DATA);
        cmbUserTypeR.setAdapter(UserModel.SET_USERTYPE_ARRAYADAPTER(this));

    }

    @Override
    public void onClick(View v) {

      try {
          username = txtUsernameR.getText().toString();
          password = txtPasswordR.getText().toString();
          type = cmbUserTypeR.getSelectedItem().toString();
          UserModel usermodel = new UserModel(0,username,password,type);
          final CustomSqlHelper myHelper = new CustomSqlHelper(this);
          final SQLiteDatabase sqld = myHelper.getWritableDatabase();
          long id = myHelper.insertUser(usermodel, sqld);
          if (id > 0) {
              clear();
              CreateToast.create_Toast(this,"User Inserted");
          } else {
              CreateToast.create_Toast(this,"User not inserted");
          }
      }catch (Exception e){
          e.printStackTrace();

      }

    }

    private void clear() {
        txtPasswordR.setText("");
        txtConfirmPasswordR.setText("");

    }
}
