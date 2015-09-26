package com.application.dsmsocial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


public class Login extends AppCompatActivity
{

    private ImageButton loginButton;
    private ImageButton guestButton;

    private EditText inputEmail;
    private EditText inputPassword;
    private TextView loginError;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view)
    {
        //Intent intent = new Intent(this, checkout.class);
    }

}