package com.application.dsmsocial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Login extends AppCompatActivity
{
    private EditText inputEmail;
    private EditText inputPassword;
    User user = new User();

    boolean isItAUser = false;

    int userNumber = 0;

    public final static String IS_THERE_A_USER = "com.application.dsmsocial.USER";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        user.setUser("123", "danthedad@yahoo.com", "Dan", "Jones", "1591 North Pleasant Drive", "Des Moines", "IA", "50311");

        inputEmail = (EditText) findViewById(R.id.emailField);
        inputPassword = (EditText) findViewById(R.id.passwordField);

        ImageButton loginButton = (ImageButton) findViewById(R.id.enterButton);
        ImageButton guestButton = (ImageButton) findViewById(R.id.guestButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser(user);
            }
        });

        guestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginGuest();
            }
        });

    }

    public void loginUser(User user)
    {
        Intent intent = new Intent(this, Checkout.class);
//        inputEmail = (EditText) findViewById(R.id.emailField);
//        String inputtedEmail = inputEmail.getText().toString();
//        inputPassword = (EditText) findViewById(R.id.passwordField);
//        String inputtedPassword = inputPassword.getText().toString();

            if(inputEmail.toString().equals(user.getEmail()) && inputPassword.toString().equals(user.getPassword()))
            {
                isItAUser = true;
                startActivity(intent);
            }

            else{
                Toast.makeText(Login.this,"Please enter a Valid Username or Password", Toast.LENGTH_SHORT).show();
            }

//        intent.putExtra(IS_THERE_A_USER, isItAUser);


    }

    public void loginGuest()
    {
        Intent intent = new Intent(this, Checkout.class);
        startActivity(intent);
    }



}