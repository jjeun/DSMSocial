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

        User user = new User();
        user.setUser("123", "danthedad@yahoo.com", "Dan", "Jones", "1591 North Pleasant Drive", "Des Moines", "IA", "50311");

        ImageButton loginButton = (ImageButton) findViewById(R.id.enterButton);
        ImageButton guestButton = (ImageButton) findViewById(R.id.guestButton);

    }

    public void loginUser(User user)
    {
        Intent intent = new Intent(this, Checkout.class);
        inputEmail = (EditText) findViewById(R.id.emailField);
        String inputtedEmail = inputEmail.getText().toString();
        inputPassword = (EditText) findViewById(R.id.passwordField);
        String inputtedPassword = inputPassword.getText().toString();

            if(inputtedEmail == user.getEmail() && inputtedPassword == user.getPassword())
            {
                isItAUser = true;
            }
        intent.putExtra(IS_THERE_A_USER, isItAUser);
        startActivity(intent);

    }

    public void loginGuest(View view)
    {
        Intent intent = new Intent(this, Checkout.class);
        isItAUser = false;
        intent.putExtra(IS_THERE_A_USER, isItAUser);
        startActivity(intent);
    }



}