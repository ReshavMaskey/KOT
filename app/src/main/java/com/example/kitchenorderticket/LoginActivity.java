package com.example.kitchenorderticket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import control.Hide;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Hide.hideActionAndNotificationBar(this);
        setContentView(R.layout.activity_login);

    }
}
